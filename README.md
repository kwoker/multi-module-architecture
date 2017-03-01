# Spring Boot 多模块架构

## 项目简介

- 本项目的开发目的是定义一个通用的、便捷的、多模块的脚手架, 在未来会慢慢扩充. 
- 本项目采用 [SpringBoot](http://projects.spring.io/spring-boot/)
  当前最新的 `1.5.1.RELEASE` 做基础架构支撑, 参考本项目建议有一定的 [SpringBoot](http://projects.spring.io/spring-boot/) 基础及经验.
- 项目中Bean全部采用 [lombok](https://projectlombok.org/) 进行精简, 需要配合IDE插件使用, 在此项目不进行讨论, 如需了解更多, 参考以下链接: 
  - 官方文档地址：<https://projectlombok.org/features/index.html>
  - 官方下载地址：<https://projectlombok.org/download.html>
  - 第三方英文文档：<http://jnb.ociweb.com/jnb/jnbJan2010.html>
  - 第三方中文文档：<http://blog.csdn.net/u011719271/article/details/53842420>
  - lombok-intellij-plugin：<https://github.com/mplushnikov/lombok-intellij-plugin>
- 目前在不定时进行调整和补充, 需要关注更新的请Watch、Star、Fork.
- 地址：<http://github.com/keveon/multi-module-architecture>

## 正式开始

#### 准备工作

>在开始提到, 本项目采用SpringBoot做基础架构支撑, 请参阅我们使用 [Maven](https://spring.io/guides/gs/maven/) 构建的入门指南.

#### 项目结构 ( Modules 介绍 )
> 最外层的 `pom.xml` 是整个项目的parent定义, 在此文件内配置了本项目使用的 `SpringBoot` 的版本、 dependencies、 插件配置、 环境设置等信息.

###### 目录介绍
- [commons](commons): 用来放公共工具类的等.
- [model](model): 存放 `Entity`.
- [repository](repository): 数据持久层, 其下有三个package, 分别为:
  - [repository](repository/src/main/java/com/keveon/architecture/repository): 存放 `spring-data-jpa` 的 `Repositories`.
  - [mapper](repository/src/main/java/com/keveon/architecture/mapper): 存放 `MyBatis` 的 `Mappers`.
- [service](service): 业务逻辑层.
- [web](web): 提供控制器及REST接口:
  - [rest](web/src/main/java/com/keveon/architecture/rest): 直接对外提供 `RESTful` 接口.
  - [controller](web/src/main/java/com/keveon/architecture/controller): 提供 `SpringMVC` 的 `Controllers`.

###### 注: 数据库连接、容器配置等都放在 `web` 层 [src/main/resources](web/src/main/resources) 目录下.

## 附录A：Github 常用按钮说明

- Watch：关注该项目, 作者有更新的时候, 会在你的 Github 主页有通知消息.
- Star：收藏该项目, 在你的头像上有一个 "Your stars" 链接, 可以看到你的收藏列表, 以方便下次进来.
- Fork：复制一份项目到自己的 Github 空间上, 你可以自己开发自己的这个地址项目, 然后 Pull Request 给项目原主人.

## 附录B：Spring Data JPA 常用功能讲解
>* [spring-data-jpa-demo](https://github.com/Keveon/spring-data-jpa-demo): 本项目是一个SpringDataJpa的demo项目, 旨在演示大部分常用的使用方法.
>* [spring-security-demo](https://github.com/Keveon/spring-security-demo): 本项目是一个SpringSecurity的demo项目, 旨在演示部分使用方法。
## 联系方式

- Github: <https://github.com/Keveon>
- OscGit: <https://git.oschina.net/keveon>
- Email：<Keveon@Keveon.com>
- QQ：   <a target="_blank" href="http://sighttp.qq.com/authd?IDKEY=545fca7ee732f622e810ce019d5a38bf6454649d43075ddf">
            <img border="0" src="http://wpa.qq.com/imgd?IDKEY=545fca7ee732f622e810ce019d5a38bf6454649d43075ddf&pic=51" alt="点击这里给我发消息" title="点击这里给我发消息"/>
         </a>

- QQ群：<a target="_blank" href="//shang.qq.com/wpa/qunwpa?idkey=4815a95af723fdbdf03a6f231cfca537bbbf0bec5d892d27657a8ed408466aff">
            <img border="0" src="http://pub.idqqimg.com/wpa/images/group.png" alt="一步一步学好java" title="一步一步学好java">
        </a>

## 结束语

- 真心感谢这些志同道合的人, 这个真的很重要, 也希望你能一起参与！
- 同时感谢那些通过私聊或其他方式指出一些错误地方的朋友, 使得该教程能得以更加完善, 真心感谢！