package co.com.ud.repo.repository.usuarios.impl;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.com.ud.repo.entity.usuarios.PerfilEntity;
import co.com.ud.repo.repository.usuarios.IPerfilRepositoryCustom;

@Repository
@Transactional
public class IPerfilRepositoryImpl implements IPerfilRepositoryCustom {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Optional<PerfilEntity> updatePerfil(PerfilEntity perfilEntity) {
		Query query = entityManager.createQuery("Update PerfilEntity perf set nombre = :nombre, permisos = :permisos where id = :id ");
		query.setParameter("nombre", perfilEntity.getNombre());
		query.setParameter("permisos", perfilEntity.getPermisos());
		query.setParameter("id", perfilEntity.getId());
		int recordsUp =  query.executeUpdate();
		return (recordsUp > 0) ? Optional.of(perfilEntity) : Optional.empty();
	}

}
