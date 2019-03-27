package co.com.ud.rest.administracion;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.ud.bussines.service.administracion.IPaisService;
import co.com.ud.repo.entity.administracion.PaisEntity;
import co.com.ud.util.dto.administracion.PaisDto;
import co.com.ud.util.error.dto.ResponseRestService;

@RestController
@RequestMapping("/v.1/paises")
public class PaisController {

	@Autowired
	IPaisService paisService;

	@Autowired
	ModelMapper mapper;

	@Autowired
	@Qualifier("mapperConsPaisAll")
	ModelMapper mapperConsPaisAll;

	@Autowired
	@Qualifier("mapperConsDepSkipCiudad")
	ModelMapper mapperConsDepSkipCiudad;

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public ResponseEntity<ResponseRestService<PaisDto>> getAllPais() {
		PaisDto[] paisesDto = mapperConsPaisAll.map(paisService.getAllPaises(), PaisDto[].class);
		if (paisesDto.length == 0) {
			new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(new ResponseRestService<>(paisesDto), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<ResponseRestService<PaisDto>> getPaisById(@PathVariable("id") Long id) {
		Optional<PaisEntity> pais = paisService.getPaisById(id);
		if (!pais.isPresent()) {
			new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		PaisDto paisesDto = mapperConsDepSkipCiudad.map(pais.get(), PaisDto.class);
		return new ResponseEntity<>(new ResponseRestService<>(paisesDto), HttpStatus.OK);
	}
}