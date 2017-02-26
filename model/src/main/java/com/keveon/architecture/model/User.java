package com.keveon.architecture.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Keveon on 2017/2/26.
 * User info
 */
@Entity
@Table(name = "m_user")
@Data
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class User implements Serializable {
    private static final long serialVersionUID = 6509353949207930413L;
    /**
     * 用户名
     */
    @Column(name = "user_name", length = 20, nullable = false, unique = true)
    final String name;
    /**
     * 密码
     */
    @Column(name = "user_password", length = 50, nullable = false)
//    @Length(min = 6, max = 50, message = "长度必须为1-5")
    final String password;
    /**
     * 用户编号
     */
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    Long id;

    public User() {
        this(null, null);
    }
}