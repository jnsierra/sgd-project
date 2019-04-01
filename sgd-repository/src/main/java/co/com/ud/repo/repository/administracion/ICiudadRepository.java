package co.com.ud.repo.repository.administracion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.ud.repo.entity.administracion.CiudadEntity;

@Repository
public interface ICiudadRepository extends CrudRepository<CiudadEntity, Long>, JpaRepository<CiudadEntity, Long>{

}
