package co.com.ud.repo.entity.revision;

import javax.persistence.Entity;

import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@RevisionEntity(UserRevisionListener.class)
@Getter @Setter
public class UserRevEntity extends DefaultRevisionEntity {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	 
	 

}
