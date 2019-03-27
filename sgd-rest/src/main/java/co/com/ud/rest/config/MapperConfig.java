package co.com.ud.rest.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import co.com.ud.repo.entity.usuarios.UsuarioEntity;
import co.com.ud.util.dto.UsuarioDto;

@Configuration
public class MapperConfig {
	
	
	@Bean(name="genericMapper")
	@Primary
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	@Bean(name="mapperConsUsuario")
	public ModelMapper getModelMapperConsultaUsuario() {
		PropertyMap<UsuarioEntity, UsuarioDto> usuarioMap = new PropertyMap<UsuarioEntity, UsuarioDto>() {
			@Override
			protected void configure() {
				skip().setPersona(null);
			}
		};
		ModelMapper aux = new ModelMapper();
		aux.addMappings(usuarioMap);		
		return aux; 
	}
}
