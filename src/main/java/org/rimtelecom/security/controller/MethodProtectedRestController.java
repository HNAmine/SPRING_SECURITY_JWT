package org.rimtelecom.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("myressource")
public class MethodProtectedRestController {

	@Autowired
	org.rimtelecom.dao.UtilisateurDao utilisateurDao;
	/**
	 * This is an example of some different kinds of granular restriction for
	 * endpoints. You can use the built-in SPEL expressions in @PreAuthorize
	 * such as 'hasRole()' to determine if a user has access. Remember that the
	 * hasRole expression assumes a 'ROLE_' prefix on all role names. So 'ADMIN'
	 * here is actually stored as 'ROLE_ADMIN' in database!
	 **/
	@RequestMapping(value = "protected", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN') or hasRole('ROOT')")
	public ResponseEntity<?> getProtectedGreeting() {
		return ResponseEntity.ok("Greetings from admin protected method!");
	}

	@RequestMapping(value = "public", method = RequestMethod.GET)
	public ResponseEntity<?> getPublicGreeting() {
		return ResponseEntity.ok("public ressource !");
	}
	
}