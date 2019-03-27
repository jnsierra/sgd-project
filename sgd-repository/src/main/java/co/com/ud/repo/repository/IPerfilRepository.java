package co.com.ud.repo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.ud.repo.entity.usuarios.PerfilEntity;

@Repository
public interface IPerfilRepository extends CrudRepository<PerfilEntity, Long>, JpaRepository<PerfilEntity, Long>, IPerfilRepositoryCustom  {
}