package co.com.ud.repo.repository.administracion;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.ud.repo.entity.administracion.PaisEntity;

@Repository
public interface IPaisRepository extends CrudRepository<PaisEntity, Long>, JpaRepository<PaisEntity, Long> {
	
	Optional<PaisEntity> findPaisById(@Param("id") Long id);

}
