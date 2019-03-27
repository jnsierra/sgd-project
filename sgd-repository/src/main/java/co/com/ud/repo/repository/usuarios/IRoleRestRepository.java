package co.com.ud.repo.repository.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.ud.repo.entity.usuarios.RoleRestEntity;

@Repository
public interface IRoleRestRepository extends JpaRepository<RoleRestEntity, Long>, CrudRepository<RoleRestEntity, Long>, IRoleRestRepositoryCustom{

}