package co.com.ud.bussines.service.administracion;

import java.util.List;
import java.util.Optional;

import co.com.ud.repo.entity.administracion.DepartamentoEntity;

public interface IDepartamentoService {

	List<DepartamentoEntity> getAllDepartamentosByPais(Long id);
	
	Optional<DepartamentoEntity> getDepartamentoById(Long id);
	
}
