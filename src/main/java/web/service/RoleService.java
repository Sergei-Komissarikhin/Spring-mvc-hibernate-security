package web.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import web.model.Role;

import java.util.Set;

public interface RoleService {

    void addRole(Role role);

    Role getRoleByName(String name);

    Set<Role> getRoles();
}
