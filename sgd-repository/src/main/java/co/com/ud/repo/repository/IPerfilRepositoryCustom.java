package co.com.ud.repo.repository;

import java.util.Optional;

import co.com.ud.repo.entity.usuarios.PerfilEntity;

public interface IPerfilRepositoryCustom {
	/**
	 * Metodo con el cual actualizo un perfil en la base de datos
	 * @return
	 */
	 Optional<PerfilEntity> updatePerfil(PerfilEntity perfilEntity);

}
