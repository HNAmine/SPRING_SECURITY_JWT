package org.rimtelecom.controller;

import java.util.List;

import org.rimtelecom.model.UtilisateurEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UtilisateurRestController {

	@Autowired
	org.rimtelecom.dao.UtilisateurDao utilisateurDao;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROOT')")
	public List<UtilisateurEntity> getAllUsers() {
		return this.utilisateurDao.findAll();
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROOT')")
	public UtilisateurEntity addUser(@RequestBody UtilisateurEntity user) {
		return this.utilisateurDao.save(user);
	}
}
