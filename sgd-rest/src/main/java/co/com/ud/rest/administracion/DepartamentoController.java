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

import co.com.ud.bussines.service.administracion.IDepartamentoService;
import co.com.ud.repo.entity.administracion.DepartamentoEntity;
import co.com.ud.util.dto.administracion.DepartamentoDto;
import co.com.ud.util.error.dto.ResponseRestService;

@RestController
@RequestMapping("/v.1/departamentos")
public class DepartamentoController {

	@Autowired
	IDepartamentoService departamentoService;
	
	@Autowired
	@Qualifier("mapperConsDepSkipCiudad")
	ModelMapper mapperConsDepSkipCiudad;
	
	@Autowired
	ModelMapper mapper;
	
	@RequestMapping(method=RequestMethod.GET, value="/paises/{idPais}")
	public ResponseEntity< ResponseRestService<DepartamentoDto> > getAllDepartamentoByPais(@PathVariable("idPais") Long idPais){
		DepartamentoDto[] departamentos = mapperConsDepSkipCiudad.map( departamentoService.getAllDepartamentosByPais(idPais), DepartamentoDto[].class);
		
		if(departamentos.length == 0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(new ResponseRestService<>(departamentos),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public ResponseEntity< ResponseRestService<DepartamentoDto> > getAllDepartamentoById(@PathVariable("id") Long id){
		Optional<DepartamentoEntity> departamento = departamentoService.getDepartamentoById(id);
		if(!departamento.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(new ResponseRestService<>(mapper.map(departamento.get(), DepartamentoDto.class)),HttpStatus.OK);
	}
}
