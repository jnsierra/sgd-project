package co.com.ud.bussines.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ud.bussines.service.IUsuarioService;
import co.com.ud.repo.entity.usuarios.UsuarioEntity;
import co.com.ud.repo.repository.IUsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService {
	
	@Autowired
	IUsuarioRepository usuarioRepository;

	@Override
	public UsuarioEntity save(UsuarioEntity usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public List<UsuarioEntity> getAll() {
		return usuarioRepository.getAllUsers();
	}

	@Override
	public Boolean validateAuth(String usuario, String contra) {
		return usuarioRepository.authenticateUser(usuario, contra).isPresent();
	}
}
