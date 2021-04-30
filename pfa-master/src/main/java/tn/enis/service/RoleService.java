package tn.enis.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.enis.entities.Role;
import tn.enis.repositories.RoleRepository;

@Service
@Slf4j

public class RoleService {

	@Autowired
	private RoleRepository roleRepository;

	public List<Role> getAll() {
		log.info("liste de année academique");
		return roleRepository.findAll();
	}

	public Long save(Role role) {
		roleRepository.saveAndFlush(role);
		return role.getRoleId();
	}

	public Long update(Role role) {
		roleRepository.saveAndFlush(role);
		return role.getRoleId();
	}

	public void delete(long id) {
		roleRepository.delete(id);
	}

	public Role find(long id) {
		return roleRepository.findOne(id);
	}

}