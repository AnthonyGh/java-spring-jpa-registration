package fr.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.registration.model.Section;

public interface SectionRepository extends JpaRepository<Section, Integer>{

}
