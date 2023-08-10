package com.webperside.courseerpbackend.repository;

import com.webperside.courseerpbackend.models.mybatis.role.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface RoleRepository {

    Optional<Role> findByName(@Param("name") String name);

}
