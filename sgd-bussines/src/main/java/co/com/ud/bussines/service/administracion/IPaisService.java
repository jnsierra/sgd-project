package co.com.ud.bussines.service.administracion;

import java.util.List;
import java.util.Optional;

import co.com.ud.repo.entity.administracion.PaisEntity;

public interface IPaisService {
	/**
	 * Metodo con el cual se obtienen todos paises parametrisados en el sistema
	 * @return
	 */
	List<PaisEntity> getAllPaises();
	/**
	 * Metodo con el cual obtengo un pais por medio de su id
	 * @param id
	 * @return
	 */
	Optional<PaisEntity> getPaisById(Long id);

}
