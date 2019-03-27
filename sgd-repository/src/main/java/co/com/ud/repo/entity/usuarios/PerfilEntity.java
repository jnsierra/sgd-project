package co.com.ud.repo.entity.usuarios;

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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnTransformer;

import co.com.ud.repo.entity.audit.Auditable;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name="us_tperf")
@Getter @Setter
public class PerfilEntity extends Auditable<String> {
	
	@Id
	@Column(name="perf_perf")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "perfil_generator")
	@SequenceGenerator(name = "perfil_generator", sequenceName = "perfil_seq", allocationSize = 1)
	private Long id;
	@NotBlank
	@NotNull
	@Column(name="perf_nombre", unique=true)
	@ColumnTransformer(read="upper(perf_nombre)", write="upper(?)")
	private String nombre;
	@NotBlank
	@NotNull
	@Column(name="perf_permiso", length = 1200) 
	private String permisos;
	@ManyToMany(mappedBy="perfiles", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<UsuarioEntity> usuarios;

}
