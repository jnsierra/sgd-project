package co.com.ud.security.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.ud.util.dto.usuarios.LoginDto;
import co.com.ud.util.error.dto.ResponseRestService;
import co.com.ud.security.service.ITokenService;
import co.com.ud.bussines.service.usuarios.IRoleRestService;
import co.com.ud.bussines.service.usuarios.IUsuarioService;
import co.com.ud.repo.entity.usuarios.RoleRestEntity;

@RestController
public class LoginController {

	@Autowired
	ITokenService tokenService;

	@Autowired
	IUsuarioService usuarioService;

	@Autowired
	IRoleRestService roleRestService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<ResponseRestService<String>> login(@RequestBody LoginDto loginDto) {
		if (!usuarioService.validateAuth(loginDto.getUsuario(), loginDto.getContrasena())) {
			return new ResponseEntity<>(new ResponseRestService<>("Credenciales Invalidas"), HttpStatus.UNAUTHORIZED);
		}
		Optional<Set<RoleRestEntity>> roles = roleRestService.findRolesByUser(loginDto.getUsuario());
		if (!roles.isPresent()) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		String rolesStr = roles.get().stream().parallel().map(item -> item.getNombre()).reduce((x, y) -> x + "," + y)
				.orElse("");
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(rolesStr);

		return new ResponseEntity<>(
				new ResponseRestService<>("Bearer " + tokenService.generateToken(loginDto.getUsuario(), grantedAuthorities)),
				HttpStatus.OK);
	}

}