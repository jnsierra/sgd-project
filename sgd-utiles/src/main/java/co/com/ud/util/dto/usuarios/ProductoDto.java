package co.com.ud.util.dto.usuarios;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoDto {
	
	private Long id;
	private String nombre;
	private String codigoExterno;
	private List<PrecioProductoDto> precio = new ArrayList<>();

}
