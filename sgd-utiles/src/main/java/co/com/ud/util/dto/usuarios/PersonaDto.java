package co.com.ud.util.dto.usuarios;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonaDto {
	
	private Long id;
	private String apellido;
	private String nombre;
	private String cedula;
	private String mail;
	private Date fechaNacimiento;
	private String telefono;
	private String cel;
	private String direccion;

}
