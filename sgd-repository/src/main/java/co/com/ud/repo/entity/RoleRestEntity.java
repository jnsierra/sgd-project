package co.com.ud.repo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="us_trore")
@Getter @Setter
public class RoleRestEntity extends Auditable<String> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rolerest_generator")
	@SequenceGenerator(name = "rolerest_generator", sequenceName = "rolerest_seq", allocationSize = 1)
	@Column(name="rore_rore")
	private Long id;
	
	@NotNull(message="El nombre del role no puede ser nulo")
	@NotEmpty(message="El nombre del role no puede ser vacio")
	@Column(name="rore_nombre", unique=true)
	private String nombre;
	
	@ManyToMany(mappedBy = "rolesRest", fetch = FetchType.LAZY, cascade= {CascadeType.MERGE,CascadeType.PERSIST})
	private Set<UsuarioEntity> usuarios;
	
	public RoleRestEntity() {
	}	
}