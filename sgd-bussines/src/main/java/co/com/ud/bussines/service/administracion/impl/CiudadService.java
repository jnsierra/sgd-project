package co.com.ud.bussines.service.administracion.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ud.bussines.service.administracion.ICiudadService;
import co.com.ud.repo.entity.administracion.CiudadEntity;
import co.com.ud.repo.repository.administracion.ICiudadRepository;

@Service
public class CiudadService implements ICiudadService {
	
	@Autowired
	ICiudadRepository ciudadRepository;

	@Override
	public List<CiudadEntity> getAllCiudades() {
		return ciudadRepository.findAll();
	}

	@Override
	public Optional<CiudadEntity> getCiudadById(Long id) {
		return ciudadRepository.findById(id);
	}

	@Override
	public CiudadEntity save(CiudadEntity ciudad) {
		return ciudadRepository.save(ciudad);
	}

	@Override
	public Boolean deleteById(Long id) {
		ciudadRepository.deleteById(id);
		return Boolean.TRUE;
	}

}
