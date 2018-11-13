package fr.registration.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.registration.model.Chapitre;

@Service
public interface ChapitreService {

	public void createChapitre(Chapitre chapitre);

	public void updateChapitre(Chapitre chapitre);

	public void deleteChapitreById(Integer id);
	
	public List<Chapitre> findAllChapitres();

	public Chapitre findChapitreById(Integer id);

}
