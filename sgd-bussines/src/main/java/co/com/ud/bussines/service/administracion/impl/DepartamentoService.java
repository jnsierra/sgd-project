package co.com.ud.bussines.service.administracion.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ud.bussines.service.administracion.IDepartamentoService;
import co.com.ud.repo.entity.administracion.DepartamentoEntity;
import co.com.ud.repo.repository.administracion.IDepartamentoRepository;

@Service
public class DepartamentoService implements IDepartamentoService {
	
	@Autowired
	IDepartamentoRepository departamentoRepository;

	@Override
	public List<DepartamentoEntity> getAllDepartamentosByPais(Long id) {
		return departamentoRepository.findDepartamentoByPais(id);
	}

	@Override
	public Optional<DepartamentoEntity> getDepartamentoById(Long id) {
		return departamentoRepository.findDepartamentoById(id);
	}	

}
