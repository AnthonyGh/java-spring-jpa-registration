package fr.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.registration.model.Chapitre;

public interface ChapitreRepository extends JpaRepository<Chapitre, Integer> {

	public Chapitre findChapitreById(Integer id);

}
