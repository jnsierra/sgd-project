package co.com.ud.repo.entity.administracion;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import co.com.ud.repo.entity.audit.Auditable;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ub_tdepa")
@NamedQueries({ 
	@NamedQuery(name = "DepartamentoEntity.findDepartamentoByPais", query = "from DepartamentoEntity d inner join fetch d.pais p where p.id = :idPais"),
	@NamedQuery(name = "DepartamentoEntity.findDepartamentoById", query = "from DepartamentoEntity d inner join fetch d.ciudades where d.id = :id ")
})
@Getter @Setter
@Audited
public class DepartamentoEntity extends Auditable<String> {
	@Id
	@Column(name = "depa_depa")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "depa_generator")
	@SequenceGenerator(name = "depa_generator", sequenceName = "depa_seq", allocationSize = 1)
	private Long id;

	@Column(name = "depa_nombre", unique = true)
	private String nombre;

	@Column(name = "depa_descripcion")
	private String descripcion;

	@Column(name = "depa_default")
	private String predeterminado;

	@Column(name = "depa_codigo", unique = true)
	private String codigo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "depa_pais")
	private PaisEntity pais;

	@OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<CiudadEntity> ciudades;

}
