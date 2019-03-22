package co.com.ud.bussines.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ud.bussines.service.IPersonaService;
import co.com.ud.repo.entity.PersonaEntity;
import co.com.ud.repo.repository.IPersonaRepository;

@Service
public class PersonaService implements IPersonaService {
	@Autowired
	IPersonaRepository personaRepository;

	@Override
	public PersonaEntity save(PersonaEntity persona) {
		return personaRepository.save(persona);
	}

	@Override
	public List<PersonaEntity> getAllPersons() {
		return personaRepository.buscarPersonas();
	}

	@Override
	public Optional<PersonaEntity>getPersonById(Long id) {
		return personaRepository.buscarPersonaXId(id);
	}

	@Override
	public List<PersonaEntity> getPersonByName(String name) {
		return personaRepository.buscarPersonasXNombre(name);
	}

}
