package com.keveon.architecture.repository;

import com.keveon.architecture.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.web.PageableDefault;

/**
 * Created by Keveon on 2017/2/26.
 * User com.keveon.architecture.repository
 */
@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    /**
     * 通过用户名关键字模糊查询用户信息
     *
     * @param nameKeyword 用户名
     * @param pageable    分页请求
     * @return 符合条件的信息
     */
    Page<User> findByNameLike(@Param("name") String nameKeyword, @PageableDefault Pageable pageable);
}
