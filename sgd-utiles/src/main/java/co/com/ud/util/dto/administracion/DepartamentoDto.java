package co.com.ud.util.dto.administracion;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DepartamentoDto  {

	private Long id;
	
	private String nombre;
	
	private String descripcion;
	
	private String predeterminado;
	
	private String codigo;	
	
	private Set<CiudadDto> ciudades;

}
