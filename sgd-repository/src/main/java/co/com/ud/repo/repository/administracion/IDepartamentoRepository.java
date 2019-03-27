package co.com.ud.repo.repository.administracion;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.ud.repo.entity.administracion.DepartamentoEntity;

@Repository
public interface IDepartamentoRepository extends JpaRepository<DepartamentoEntity, Long>, CrudRepository<DepartamentoEntity, Long> {
	
	List<DepartamentoEntity> findDepartamentoByPais(@Param("idPais")Long idPais);
	
	Optional<DepartamentoEntity> findDepartamentoById(@Param("id")Long id);
	
}
