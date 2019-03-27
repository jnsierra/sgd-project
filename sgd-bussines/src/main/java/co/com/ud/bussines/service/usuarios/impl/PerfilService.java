package co.com.ud.bussines.service.usuarios.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ud.bussines.service.usuarios.IPerfilService;
import co.com.ud.repo.entity.usuarios.PerfilEntity;
import co.com.ud.repo.repository.usuarios.IPerfilRepository;

@Service
public class PerfilService implements IPerfilService {
	
	@Autowired
	IPerfilRepository perfilRepository;

	@Override
	public PerfilEntity save(PerfilEntity perfil) {
		return perfilRepository.save(perfil);
	}

	@Override
	public Optional<PerfilEntity> update(PerfilEntity perfil) {
		return perfilRepository.updatePerfil(perfil);
	}

	@Override
	public List<PerfilEntity> findAllPerfil() {
		return perfilRepository.findAll();
	}

	@Override
	public Boolean deletePerfilById(Long id) {
		perfilRepository.deleteById(id);
		return Boolean.TRUE;
	}

}
