package co.com.ud.rest.usuarios;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.ud.util.dto.usuarios.UsuarioDto;
import co.com.ud.util.error.dto.ResponseRestService;
import co.com.ud.bussines.service.usuarios.IRoleRestService;
import co.com.ud.bussines.service.usuarios.IUsuarioService;
import co.com.ud.repo.entity.usuarios.UsuarioEntity;

@RestController
@RequestMapping("/v.1/usuario")
public class UsuarioController {

	@Autowired
	IUsuarioService usuarioService;

	@Autowired
	IRoleRestService roleRestService;

	@Autowired
	@Qualifier("mapperConsUsuario")
	ModelMapper mapperConsulta;
	
	@Autowired
	ModelMapper mapper;

	@RequestMapping(method = RequestMethod.POST, value = "/")
	public ResponseEntity<ResponseRestService<UsuarioDto>> save(@RequestBody UsuarioDto usuario) {
		return new ResponseEntity<>(
				new ResponseRestService<>(
						mapper.map(usuarioService.save(mapper.map(usuario, UsuarioEntity.class)), UsuarioDto.class)),
				HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public ResponseEntity<ResponseRestService<UsuarioDto[]>> getAll() {
		return new ResponseEntity<ResponseRestService<UsuarioDto[]>>(
				new ResponseRestService<UsuarioDto[]>(mapperConsulta.map(usuarioService.getAll(), UsuarioDto[].class)),
				HttpStatus.OK);
	}

//	@RequestMapping(method = RequestMethod.PUT, value = "/rolerest/")
//	public ResponseEntity<ResponseRestService<Boolean>> modifyRolesRestByUser(@RequestBody UsuarioDto usuario) {
//		if (!roleRestService
//				.modifyRoleRestByUser(usuario.getId(), mapper.map(usuario, UsuarioEntity.class).getRolesRest())
//				.isPresent()) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		return new ResponseEntity<>(new ResponseRestService<>(Boolean.TRUE), HttpStatus.OK);
//	}

}
