package co.com.ud.repo.entity.usuarios;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import co.com.ud.repo.entity.audit.Auditable;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "us_ttius")
@NamedQueries({
		@NamedQuery(name = "UsuarioEntity.getAllUsers", query = "select distinct u from UsuarioEntity u inner join fetch u.rolesRest rol inner join fetch u.perfiles perfil "),
		@NamedQuery(name = "UsuarioEntity.authenticateUser", query = "select usuarioEntity from UsuarioEntity usuarioEntity where usuarioEntity.usuario = :usuario and usuarioEntity.contrasena = :contrasena  ") })
@Getter
@Setter
public class UsuarioEntity extends Auditable<String> {
	@Id
	@Column(name = "tius_tius", nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_generator")
	@SequenceGenerator(name = "usuario_generator", sequenceName = "usuario_seq", allocationSize = 1)
	private Long id;
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "tius_usuario", unique = true)
	private String usuario;
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "tius_contra_act")
	private String contrasena;
	@NotNull
	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "tius_pers")
	private PersonaEntity persona;
	@Column(name = "tius_sede")
	private Long sede;
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "usuario_rolerest", joinColumns = @JoinColumn(name = "tius_tius"), inverseJoinColumns = @JoinColumn(name = "rore_rore"))
	private Set<RoleRestEntity> rolesRest;
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "usua_perf", joinColumns = @JoinColumn(name = "tius_tius"),inverseJoinColumns = @JoinColumn(name = "perf_perf"))
	private Set<PerfilEntity> perfiles;

	public UsuarioEntity() {
		super();
	}

}