package co.com.ud.repo.entity.usuarios;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import co.com.ud.repo.entity.audit.Auditable;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "us_tpers")
@NamedQueries({
	@NamedQuery(name="PersonaEntity.buscarPersonaXId", query="select new PersonaEntity(pers.id, pers.apellido, pers.nombre, pers.cedula, pers.mail, pers.fechaNacimiento, pers.telefono, pers.cel, pers.direccion) from PersonaEntity pers where pers.id = :id"),
	@NamedQuery(name="PersonaEntity.buscarPersonas", query="select new PersonaEntity(pers.id, pers.apellido, pers.nombre, pers.cedula, pers.mail, pers.fechaNacimiento, pers.telefono, pers.cel, pers.direccion) from PersonaEntity pers order by pers.nombre "),
	@NamedQuery(name="PersonaEntity.buscarPersonasXNombre", query="select new PersonaEntity(pers.id, pers.apellido, pers.nombre, pers.cedula, pers.mail, pers.fechaNacimiento, pers.telefono, pers.cel, pers.direccion) from PersonaEntity pers where upper(pers.nombre) like '%:nombre%' order by pers.nombre ")
})
@Getter
@Setter
public class PersonaEntity extends Auditable<String> {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_generator")
	@SequenceGenerator(name = "person_generator", sequenceName = "person_seq", allocationSize = 1)
	@Column(name = "pers_pers", updatable = false, nullable = false)
	private Long id;
	@Column(name = "pers_apellido")
	private String apellido;
	@NotNull
	@NotBlank
	@Column(name = "pers_nombre")
	private String nombre;
	@NotNull
	@NotBlank
	@Column(name = "pers_cedula", unique=true)
	private String cedula;
	@NotNull
	@NotBlank
	@Column(name = "pers_email", unique=true)
	private String mail;
	@Temporal(TemporalType.DATE)
	@Column(name = "pers_fecha_nac")
	private Calendar fechaNacimiento;
	@Column(name = "pers_tel")
	private String telefono;
	@Column(name = "pers_cel")
	private String cel;
	@Column(name = "pers_dir")
	private String direccion;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "persona", optional=true)
	private UsuarioEntity usuario;
	
	
	
	public PersonaEntity(Long id, String apellido, @NotNull @NotBlank String nombre, @NotNull @NotBlank String cedula,
			@NotNull @NotBlank String mail, Calendar fechaNacimiento, String telefono, String cel, String direccion) {
		super();
		this.id = id;
		this.apellido = apellido;
		this.nombre = nombre;
		this.cedula = cedula;
		this.mail = mail;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		this.cel = cel;
		this.direccion = direccion;
	}

	public PersonaEntity() {
		super();
	}

}
