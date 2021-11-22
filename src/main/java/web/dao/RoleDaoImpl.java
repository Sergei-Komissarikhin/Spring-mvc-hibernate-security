package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.Set;

@Repository
public class RoleDaoImpl implements RoleDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void addRole(Role role) {
        entityManager.persist(role);
    }

    @Override
    public Role getRoleByName(String name){
        return (Role) entityManager.createQuery("SELECT role from Role role where role.role = :name")
                .setParameter("name", name)
                .getSingleResult();

    }

    @Override
    public Set<Role> getRoles() {
        return new HashSet<>(entityManager.createQuery("SELECT roles FROM Role roles",Role.class).getResultList());
    }
}
