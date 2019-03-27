package co.com.ud.bussines.service.administracion.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ud.bussines.service.administracion.IPaisService;
import co.com.ud.repo.entity.administracion.PaisEntity;
import co.com.ud.repo.repository.administracion.IPaisRepository;

@Service
public class PaisService implements IPaisService{
	
	@Autowired
	IPaisRepository paisRepository;

	@Override
	public List<PaisEntity> getAllPaises() {
		return paisRepository.findAll();
	}

	@Override
	public Optional<PaisEntity> getPaisById(Long id) {
		return paisRepository.findPaisById(id);
	}

}
