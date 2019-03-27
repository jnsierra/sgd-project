package co.com.ud.repo.entity.administracion;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import co.com.ud.repo.entity.audit.Auditable;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="ub_tpais")
@Getter @Setter
public class PaisEntity extends Auditable<String> {
	@Id
	@Column(name="pais_pais")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pais_generator")
	@SequenceGenerator(name = "pais_generator", sequenceName = "pais_seq", allocationSize = 1)
	private Long id;
	
	@Column(name="PAIS_NOMBRE", unique=true)
	private String nombre;
	
	@Column(name="PAIS_DESCRIPCION")
	private String descripcion;
	
	@Column(name="PAIS_DEFAULT")
	private String predeterminado;
	
	@Column(name="PAIS_CODIGO", unique=true)
	private String codigo;
	
	@OneToMany(mappedBy="pais", cascade= CascadeType.ALL, orphanRemoval=true)
	private Set<DepartamentoEntity> departamentos;

}