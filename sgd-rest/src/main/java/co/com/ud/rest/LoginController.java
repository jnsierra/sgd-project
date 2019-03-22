package co.com.ud.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.ud.util.dto.LoginDto;
import co.com.ud.util.error.dto.ResponseRestService;
import co.com.ud.repo.entity.RoleRestEntity;
import co.com.ud.bussines.service.IRoleRestService;
import co.com.ud.bussines.service.ITokenService;
import co.com.ud.bussines.service.IUsuarioService;

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
		Optional<List<RoleRestEntity>> roles = roleRestService.findRolesByUser(loginDto.getUsuario());
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