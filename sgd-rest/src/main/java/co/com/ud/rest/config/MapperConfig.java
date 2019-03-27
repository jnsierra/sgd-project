package co.com.ud.rest.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import co.com.ud.repo.entity.administracion.DepartamentoEntity;
import co.com.ud.repo.entity.administracion.PaisEntity;
import co.com.ud.repo.entity.usuarios.UsuarioEntity;
import co.com.ud.util.dto.administracion.DepartamentoDto;
import co.com.ud.util.dto.administracion.PaisDto;
import co.com.ud.util.dto.usuarios.UsuarioDto;

@Configuration
public class MapperConfig {
	
	
	@Bean(name="genericMapper")
	@Primary
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
	@Bean(name="mapperConsUsuario")
	public ModelMapper getModelMapperConsultaUsuario() {
		PropertyMap<UsuarioEntity, UsuarioDto> map = new PropertyMap<UsuarioEntity, UsuarioDto>() {
			@Override
			protected void configure() {
				skip().setPersona(null);
			}
		};
		ModelMapper aux = new ModelMapper();
		aux.addMappings(map);		
		return aux; 
	}
	
	@Bean(name="mapperConsPaisAll")
	public ModelMapper getModelMapperConsPaisAll() {
		PropertyMap<PaisEntity, PaisDto> usuarioMap = new PropertyMap<PaisEntity, PaisDto>() {
			@Override
			protected void configure() {
				skip().setDepartamentos(null);
			}
		};
		ModelMapper aux = new ModelMapper();
		aux.addMappings(usuarioMap);		
		return aux; 
	}
	
	@Bean(name="mapperConsDepSkipCiudad")
	public ModelMapper getModelMapperConsPaisById() {
		PropertyMap<DepartamentoEntity, DepartamentoDto> map = new PropertyMap<DepartamentoEntity, DepartamentoDto>() {
			@Override
			protected void configure() {
				skip().setCiudades(null);
			}
		};
		ModelMapper aux = new ModelMapper();
		aux.addMappings(map);		
		return aux; 
	}
	
}