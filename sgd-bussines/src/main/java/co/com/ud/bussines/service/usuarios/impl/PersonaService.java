package co.com.ud.bussines.service.usuarios.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ud.bussines.service.usuarios.IPersonaService;
import co.com.ud.repo.entity.usuarios.PersonaEntity;
import co.com.ud.repo.repository.usuarios.IPersonaRepository;

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
