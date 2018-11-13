package fr.registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.registration.model.Chapitre;
import fr.registration.repository.ChapitreRepository;

@Service
public class ChapitreServiceImpl implements ChapitreService {

	@Autowired
	private ChapitreRepository dao;
	
	@Override
	public void createChapitre(Chapitre chapitre) {
		dao.save(chapitre);
	}

	@Override
	public void updateChapitre(Chapitre chapitre) {
		dao.save(chapitre);
	}

	@Override
	public void deleteChapitreById(Integer id) {
		dao.delete(id);
	}

	@Override
	public List<Chapitre> findAllChapitres() {
		return dao.findAll();
	}

	@Override
	public Chapitre findChapitreById(Integer id) {
		return dao.findChapitreById(id);
	}

}
