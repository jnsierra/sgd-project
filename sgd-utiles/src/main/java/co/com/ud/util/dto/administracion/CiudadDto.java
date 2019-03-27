package co.com.ud.util.dto.administracion;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CiudadDto {

	private Long id;
	
	private String nombre;
	
	private String descripcion;
	
	private String predeterminado;
	
	private String codigo;
	
}
