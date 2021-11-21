package web.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import web.model.Role;

public interface RoleService {

    void addRole(Role role);

    Role getRoleByName(String name);


}
