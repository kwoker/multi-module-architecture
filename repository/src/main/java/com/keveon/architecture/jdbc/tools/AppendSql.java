package com.keveon.architecture.jdbc.tools;

import lombok.experimental.UtilityClass;
import org.springframework.util.Assert;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.nonNull;
import static org.springframework.util.StringUtils.hasText;

/**
 * Created by Keveon on 2017/3/2.
 * 动态生成Update语句及相关参数
 */
@UtilityClass
public class AppendSql {

	/**
	 * 通过要修改的对象的实体, 动态生成sql语句及参数列表
	 *
	 * @param entity 实体类
	 * @param <T>    泛型类型定义
	 * @return 返回一个键值对, 其中包含两条数据:
	 * 一条Key为sql, Value为对应的sql语句.
	 * 另一条Key为params, Value为对应的参数数组
	 */
	public <T> Map<String, Object> appendSql(T entity) {
		return appendSql(entity, false);
	}

	/**
	 * 通过要修改的对象的实体, 动态生成sql语句及参数列表
	 *
	 * @param entity   实体类
	 * @param isInLine 是否使用匿名参数的方式, 若为true, 则直接把字段对应的值写入sql语句中,
	 *                 不建议使用, 容易被sql注入.
	 * @param <T>      泛型类型定义
	 * @return 返回一个键值对, 其中包含两条数据:
	 * 一条Key为sql, Value为对应的sql语句.
	 * 另一条Key为params, Value为对应的参数数组, 若isInline为true时, 不会返回params.
	 */
	public <T> Map<String, Object> appendSql(T entity, Boolean isInLine) {
		Map<String, Object> sqlAndParams = new HashMap<>();
		List<Object> params = new ArrayList<>();
		String name;
		Object value;

		StringBuilder sb = new StringBuilder("UPDATE ");
		sb.append(getName(entity));
		sb.append(" SET ");

		Field[] fields = entity.getClass().getDeclaredFields();
		Field idField = null;
		for (Field field : fields) {
			if ("serialVersionUID".equalsIgnoreCase(field.getName()))
				continue;
			if (nonNull(field.getAnnotation(Id.class))) {
				idField = field;
				continue;
			}

			value = getValue(field, entity);
			if (nonNull(value)) {
				name = getName(field, field.getName());
				sb = appendValue(name, value, sb, isInLine);
				params.add(value);
			}
		}

		sb = trimSql(sb);

		Assert.notNull(idField, "实体类必须有且只能有一个属性标记 \"@ID\"");
		sb.append(" WHERE ");

		name = getName(idField, idField.getName());
		value = getValue(idField, entity);
		Assert.notNull(value, "更新操作, ID不能为null");
		sb = appendValue(name, value, sb, isInLine);
		params.add(value);

		sb = trimSql(sb);

		sqlAndParams.put("sql", sb.toString());

		if (!isInLine)
			sqlAndParams.put("params", params.toArray(new Object[params.size()]));
		return sqlAndParams;
	}

	/**
	 * 通过实体获取数据库表名, 优先使用 {@link Table#name()} 的值,
	 * 若没有, 默认使用表名.
	 *
	 * @param entity 实体类
	 * @param <T>    泛型类型定义
	 * @return 返回数据库表名
	 */
	private <T> String getName(T entity) {
		return getName(entity, entity.getClass().getSimpleName());
	}

	/**
	 * 获取数据库字段名, 优先使用 {@link Column#name()} 的值.
	 *
	 * @param obj         类型支持{@link Object} 或 {@link Field}
	 * @param defaultName 如果没有注解, 或注解没有设置相关参数, 要使用的默认值
	 * @return 字段名
	 */
	private String getName(Object obj, String defaultName) {
		String name;
		try {
			if (obj instanceof Field)
				name = ((Field) obj).getDeclaredAnnotation(Column.class).name();
			else
				name = obj.getClass().getDeclaredAnnotation(Table.class).name();
		} catch (Exception e) {
			name = defaultName;
		}
		return hasText(name) ? name : defaultName;
	}

	/**
	 * 获取字段对应的值
	 *
	 * @param field  实体属性, 与数据库字段对应
	 * @param object 实体
	 * @return 字段的值
	 */
	private Object getValue(Field field, Object object) {
		Object obj = null;
		try {
			boolean access = field.isAccessible();
			field.setAccessible(true);
			obj = field.get(object);
			field.setAccessible(access);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return obj;
	}

	/**
	 * 拼接字符串的子工具, 根据参数确定是否需要把参数值直接写入到sql语句
	 *
	 * @param name          字段名
	 * @param value         字段值
	 * @param stringBuilder sql语句
	 * @param isInLine      是否直接把参数值写入sql语句
	 * @return sql语句
	 */
	private StringBuilder appendValue(String name, Object value, StringBuilder stringBuilder, Boolean isInLine) {
		stringBuilder.append(name);
		if (!isInLine)
			stringBuilder.append(" = ?, ");
		else {
			stringBuilder.append(" = '");
			stringBuilder.append(value);
			stringBuilder.append("', ");
		}
		return stringBuilder;
	}

	/**
	 * 检查sql语句, 若最后一位字符为",", 则去掉
	 *
	 * @param stringBuilder sql语句
	 * @return 修剪后的sql语句
	 */
	private StringBuilder trimSql(StringBuilder stringBuilder) {
		if (stringBuilder.toString().endsWith(", "))
			stringBuilder = new StringBuilder(stringBuilder.substring(0, stringBuilder.length() - 2));
		return stringBuilder;
	}
}