package co.com.ud.bussines.service;

import java.util.List;
import java.util.Optional;

import co.com.ud.repo.entity.usuarios.PerfilEntity;

public interface IPerfilService {
	/**
	 * Metodo con el cual inserto un perfil
	 * @param perfil
	 * @return
	 */
	PerfilEntity save(PerfilEntity perfil);
	/**
	 * Metodo con el cual actualizo un perfil
	 * @param perfil
	 * @return
	 */
	Optional<PerfilEntity> update(PerfilEntity perfil);
	/**
	 * Metodo con el cual obtengo todos los perfiles parametrizados
	 * @return
	 */
	List<PerfilEntity> findAllPerfil();
	/**
	 * Metodo con el cual elimino un perfil
	 * @param id
	 * @return
	 */
	Boolean deletePerfilById(Long id);
}
