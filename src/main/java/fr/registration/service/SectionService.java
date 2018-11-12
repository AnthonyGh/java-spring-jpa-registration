package fr.registration.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.registration.model.Section;

@Service
public interface SectionService {

	public void createSection(Section section);

	public void updateSection(Section section);

	public void deleteSectionById(Integer id);

	public List<Section> findAllSections();

}
