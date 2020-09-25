package com.xh.mapper;


import com.xh.entity.Role;

import java.util.List;

public interface RoleMapper {
    List<Role> getRoleList();
    void addRole(Role role);
}
