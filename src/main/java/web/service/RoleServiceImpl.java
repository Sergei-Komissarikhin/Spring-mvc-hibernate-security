package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.RoleDao;
import web.model.Role;

import java.util.Set;


@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public void addRole(Role role) {
        roleDao.addRole(role);
    }

    @Override
    public Role getRoleByName(String name){
        return roleDao.getRoleByName(name);
    }

    @Override
    public Set<Role> getRoles() {
        return roleDao.getRoles();
    }
}
