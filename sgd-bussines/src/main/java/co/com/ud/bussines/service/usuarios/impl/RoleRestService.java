package co.com.ud.bussines.service.usuarios.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ud.bussines.service.usuarios.IRoleRestService;
import co.com.ud.repo.entity.usuarios.RoleRestEntity;
import co.com.ud.repo.entity.usuarios.UsuarioEntity;
import co.com.ud.repo.repository.usuarios.IRoleRestRepository;
import co.com.ud.repo.repository.usuarios.IUsuarioRepository;

@Service
public class RoleRestService implements IRoleRestService {
	@Autowired
	IUsuarioRepository usuarioRepository;
	
	@Autowired
	IRoleRestRepository roleRestRepository;

	@Override
	public RoleRestEntity save(RoleRestEntity entity) {
		return roleRestRepository.save(entity);
	}

	@Override
	public Optional<Set<RoleRestEntity>> findRolesByUser(String usuario) {
		Optional<UsuarioEntity> userEntity = usuarioRepository.findByUsuario(usuario);
		if(userEntity.isPresent()) {
			return Optional.of(userEntity.get().getRolesRest());
		}else {
			return Optional.empty();
		}
	}

	@Override
	public Optional<Boolean> modifyRoleRestByUser(Long idUser, List<RoleRestEntity> idRoleRest) {
		if(!roleRestRepository.deleteRoleRestByUser(idUser)) {
			return Optional.of(Boolean.FALSE);
		}
		if(!roleRestRepository.saveRolesRestByUser(idUser, idRoleRest)) {
			return Optional.of(Boolean.FALSE);
		}
		return Optional.of(Boolean.TRUE);
	}

}