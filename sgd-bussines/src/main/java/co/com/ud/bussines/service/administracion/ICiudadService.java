package co.com.ud.bussines.service.administracion;

import java.util.List;
import java.util.Optional;

import co.com.ud.repo.entity.administracion.CiudadEntity;

public interface ICiudadService {
	/**
	 * Metodo con el cual obtengo todas las ciudades parametrizadas
	 * @return
	 */
	List<CiudadEntity> getAllCiudades();
	/**
	 * Metodo con el cual obtengo una ciudad por medio de su id
	 * @param id
	 * @return
	 */
	Optional<CiudadEntity> getCiudadById(Long id);
	/**
	 * Metodo con el cual persisto una entidad
	 * @return
	 */
	CiudadEntity save(CiudadEntity ciudad);
	/**
	 * Metodo con el cual borro una entidad por medio de su id
	 * @param id
	 * @return
	 */
	Boolean deleteById(Long id);
}
