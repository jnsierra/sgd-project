package co.com.ud.repo.entity.administracion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import co.com.ud.repo.entity.audit.Auditable;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="ub_tciud")
@Getter @Setter
public class CiudadEntity extends Auditable<String> {
	@Id
	@Column(name="CIUD_CIUD")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ciud_generator")
	@SequenceGenerator(name = "ciud_generator", sequenceName = "ciud_seq", allocationSize = 1)
	private Long id;
	
	@Column(name="CIUD_NOMBRE")
	private String nombre;
	
	@Column(name="CIUD_DESCRIPCION")
	private String descripcion;
	
	@Column(name="CIUD_DEFAULT")
	private String predeterminado;
	
	@Column(name="CIUD_CODIGO", unique=true)
	private String codigo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ciud_depa")
	private DepartamentoEntity departamento;
}
