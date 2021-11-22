package web.dao;

import web.model.Role;

import java.util.Set;

public interface RoleDao {
    void addRole(Role role);
    Role getRoleByName(String name);
    Set<Role> getRoles();
}
