package com.webperside.courseerpbackend.services.role;

import com.webperside.courseerpbackend.models.mybatis.role.Role;
import org.springframework.stereotype.Service;

public interface RoleService {

    Role getDefaultRole();

}