package co.com.ud.rest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.ud.bussines.service.IPerfilService;
import co.com.ud.repo.entity.usuarios.PerfilEntity;
import co.com.ud.util.dto.PerfilDto;
import co.com.ud.util.error.dto.ResponseRestService;

@RestController
@RequestMapping("/v.1/perfiles")
public class PerfilController {

	@Autowired
	ModelMapper mapper;
	@Autowired
	IPerfilService perfilService;

	@RequestMapping(method = RequestMethod.POST, value = "/")
	public ResponseEntity<ResponseRestService<PerfilDto>> save(@RequestBody(required = true) PerfilDto perfilDto) {
		return new ResponseEntity<>(
				new ResponseRestService<>(
						mapper.map(perfilService.save(mapper.map(perfilDto, PerfilEntity.class)), PerfilDto.class)),
				HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/")
	public ResponseEntity<ResponseRestService<PerfilDto>> update(@RequestBody(required = true) PerfilDto perfilDto) {
		return new ResponseEntity<>(
				new ResponseRestService<>(
						mapper.map(perfilService.update(mapper.map(perfilDto, PerfilEntity.class)), PerfilDto.class)),
				HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.GET, value="/")
	public ResponseEntity<ResponseRestService<PerfilDto>> getAll(){
		PerfilDto[] perfiles = mapper.map(perfilService.findAllPerfil(), PerfilDto[].class);
		if(perfiles.length == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(new ResponseRestService<>(perfiles), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<ResponseRestService<Boolean>> delete(@PathVariable("id") Long idPerfil) {
		return new ResponseEntity<>(new ResponseRestService<>(perfilService.deletePerfilById(idPerfil)), HttpStatus.OK);
	}
}
