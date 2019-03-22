package co.com.ud.rest;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.ud.util.dto.PersonaDto;
import co.com.ud.util.error.dto.ResponseRestService;
import co.com.ud.repo.entity.PersonaEntity;
import co.com.ud.bussines.service.IPersonaService;

@RestController
@RequestMapping("/v.1/persona")
public class PersonaController {

	@Autowired
	IPersonaService personaService;

	@Autowired
	ModelMapper mapper;

	@Secured("ROLE_ADMIN")
	@RequestMapping(method = RequestMethod.POST, value = "/")
	public ResponseEntity<ResponseRestService<PersonaDto>> save(@RequestBody PersonaDto personaDto) {
		return new ResponseEntity<>(
				new ResponseRestService<>(
						mapper.map(personaService.save(mapper.map(personaDto, PersonaEntity.class)), PersonaDto.class)),
				HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id_persona}")
	public ResponseEntity<ResponseRestService<PersonaDto>> getPersonaById(
			@PathVariable(value = "id_persona", required = true) Long idPersona) {
		Optional<PersonaEntity> persona = personaService.getPersonById(idPersona);
		if (!persona.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(new ResponseRestService<>(mapper.map(persona.get(), PersonaDto.class)),
				HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public ResponseEntity<ResponseRestService<PersonaDto>> getPersonByName(@RequestParam("nombre") String nombre) {
		List<PersonaEntity> personas = personaService.getPersonByName(nombre);
		if (personas.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(new ResponseRestService<PersonaDto>(mapper.map(personas, PersonaDto[].class)),
				HttpStatus.OK);
	}

}
