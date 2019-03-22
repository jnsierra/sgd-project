package co.com.ud.repo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.ud.repo.entity.PersonaEntity;

@Repository
public interface IPersonaRepository extends CrudRepository<PersonaEntity, Long> , JpaRepository<PersonaEntity, Long>{
	
	Optional<PersonaEntity> buscarPersonaXId(@Param("id")Long id);
	
	List<PersonaEntity> buscarPersonas();
	
	List<PersonaEntity> buscarPersonasXNombre(@Param("nombre")String nombre);
	
}
