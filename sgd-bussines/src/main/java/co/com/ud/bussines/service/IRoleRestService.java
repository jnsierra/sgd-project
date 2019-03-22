package co.com.ud.bussines.service;

import java.util.List;
import java.util.Optional;

import co.com.ud.repo.entity.RoleRestEntity;

public interface IRoleRestService {
	
	/**
	 * Metodo con el cual guardo un role rest 
	 * @param entity
	 * @return
	 */
	RoleRestEntity save(RoleRestEntity entity);
	/**
	 * Metodo con el cual por medio del usuario se buscan los roles 
	 * @return
	 */
	Optional<List<RoleRestEntity>> findRolesByUser(String usuario);
	
	/**
	 * Metodo con el cual modifico los roles rest de un usuario de un usuario 
	 * @param idUser
	 * @return
	 */
	Optional<Boolean> modifyRoleRestByUser(Long idUser, List<RoleRestEntity> idRoleRest);
	
}
