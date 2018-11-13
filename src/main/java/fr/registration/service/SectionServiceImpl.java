package fr.registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.registration.model.Section;
import fr.registration.repository.SectionRepository;

@Service
public class SectionServiceImpl implements SectionService{

	@Autowired
	private SectionRepository dao;
	
	@Override
	public void createSection(Section section) {
		dao.save(section);		
	}

	@Override
	public void updateSection(Section section) {
		dao.save(section);
	}

	@Override
	public void deleteSectionById(Integer id) {
		dao.delete(id);
	}

	@Override
	public List<Section> findAllSections() {
		return dao.findAll();
	}

	@Override
	public Section findSectionById(Integer id) {
		return dao.findSectionById(id);
	}

	
	
}
