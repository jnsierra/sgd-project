package co.com.ud.bussines.service;

import java.util.List;
import java.util.Optional;

import co.com.ud.repo.entity.PersonaEntity;

public interface IPersonaService {
	/**
	 * Metodo con el cual persisto una persona
	 * @param persona
	 * @return
	 */
	PersonaEntity save(PersonaEntity persona);
	/**
	 * Metodo con el cual busco todos las personas que se encuentran en la base de datos
	 * @return
	 */
	List<PersonaEntity> getAllPersons();
	/**
	 * Metodo con el cual obtengo una persona por medio de su id
	 * @param id
	 * @return
	 */
	Optional<PersonaEntity> getPersonById(Long id );
	/**
	 * Metodo con el cual obtengo un usuario por su nombre
	 * @param id
	 * @return
	 */
	List<PersonaEntity> getPersonByName(String name);
}
