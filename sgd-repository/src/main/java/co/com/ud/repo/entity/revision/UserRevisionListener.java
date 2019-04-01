package co.com.ud.repo.entity.revision;

import org.hibernate.envers.RevisionListener;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserRevisionListener implements RevisionListener{

	@Override
	public void newRevision(Object revisionEntity) {
		UserRevEntity exampleRevEntity = (UserRevEntity) revisionEntity;
		String usuario = SecurityContextHolder.getContext().getAuthentication().getName();
		exampleRevEntity.setUsername(usuario);
	}

}
