package co.com.ud.rest.administracion;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.ud.bussines.service.administracion.ICiudadService;
import co.com.ud.repo.entity.administracion.CiudadEntity;
import co.com.ud.repo.entity.administracion.DepartamentoEntity;
import co.com.ud.util.dto.administracion.CiudadDto;
import co.com.ud.util.error.dto.ResponseRestService;

@RestController
@RequestMapping("/v.1/ciudades")
public class CiudadController {

	@Autowired
	ModelMapper mapper;

	@Autowired
	ICiudadService ciudadService;

	@RequestMapping(value = "/{idDepa}", method = RequestMethod.POST)
	public ResponseEntity<ResponseRestService<CiudadDto>> save(@RequestBody(required = true) CiudadDto ciudadDto,@PathVariable("idDepa") Long idDepa) {
		//Seteo el id del departamento dentro de la ciudad
		CiudadEntity ciudad = mapper.map(ciudadDto, CiudadEntity.class);
		ciudad.setDepartamento(new DepartamentoEntity());
		ciudad.getDepartamento().setId(idDepa);
		
		return new ResponseEntity<>(
				new ResponseRestService<CiudadDto>(
						mapper.map(ciudadService.save(ciudad), CiudadDto.class)),
				HttpStatus.CREATED);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<ResponseRestService<CiudadDto>> getAll() {
		
		CiudadDto[] ciudades = mapper.map(ciudadService.getAllCiudades(), CiudadDto[].class);
		if(ciudades.length == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(new ResponseRestService<>(ciudades) , HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ResponseRestService<CiudadDto>> getCiudadById(Long id) {
		Optional<CiudadEntity> ciudad = ciudadService.getCiudadById(id);
		if(!ciudad.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(new ResponseRestService<>(mapper.map(ciudad.get(), CiudadDto.class )) , HttpStatus.OK);	
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<ResponseRestService<Boolean>> deleteById(@PathVariable("id")Long id) {
		return new ResponseEntity<>(new ResponseRestService<>( ciudadService.deleteById(id)) , HttpStatus.OK);
	}

}
