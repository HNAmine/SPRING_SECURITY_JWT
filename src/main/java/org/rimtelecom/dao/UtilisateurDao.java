package org.rimtelecom.dao;

import org.rimtelecom.model.UtilisateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Interface UtilisateurDao.
 */
@Repository
public interface UtilisateurDao extends JpaRepository<UtilisateurEntity, Long> {
	UtilisateurEntity findByUsername(String username);
}
