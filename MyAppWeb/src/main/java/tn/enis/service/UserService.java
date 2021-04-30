package tn.enis.service;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tn.enis.entities.Role;
import tn.enis.entities.User;
import tn.enis.repositories.RoleRepository;
import tn.enis.repositories.UserRepository;

@Service("userService")
public class UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Value("${myapp.role.admin}")
	private String adminRole;

	@Value("${myapp.role.user}")
	private String userRole;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public Long save(User user, String role) {

		LOGGER.info("default Admin Role {}", this.adminRole);

		Role roleEntity = null;
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

		if (role.equals(adminRole)) {
			roleEntity = roleRepository.findByRole(adminRole);
		} else if (role.equals(userRole)) {
			roleEntity = roleRepository.findByRole(userRole);
		}

		user.setRoles(new HashSet<Role>(Arrays.asList(roleEntity)));
		user.setCreatedAt((Date) Calendar.getInstance().getTime());
		user.setUpdatedAt((Date) Calendar.getInstance().getTime());
		User u = userRepository.saveAndFlush(user);
		LOGGER.info("User Id added {}", u.getId());
		return u.getId();

	}

	public List<User> userList() {
		return userRepository.findAll();
	}

	public Long update(User user) {
		user.setUpdatedAt((Date) Calendar.getInstance().getTime());
		User u = userRepository.saveAndFlush(user);
		return u.getId();
	}

	public void delete(long userId) {
		User user = findUser(userId);
		
		Iterator<Role> iterator = user.getRoles().iterator();
		while (iterator.hasNext()) {
			iterator.next();
		    iterator.remove();
		}
		userRepository.delete(user);
	}

	public User findUser(long userId) {
		return userRepository.findOne(userId);
	}

	public Page<User> findAll(PageRequest pageRequest) {
		return userRepository.findAll(pageRequest);
	}

}
