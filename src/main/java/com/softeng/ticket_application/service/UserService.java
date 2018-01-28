package com.softeng.ticket_application.service;

import com.softeng.ticket_application.model.User;
import com.softeng.ticket_application.repository.UserRepository;
import com.softeng.ticket_application.model.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 *
 *
 * @author Sideris Argiris
 */
@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	/*@Autowired
	private RoleRepository roleRepository;*/
	@Autowired
	private BCryptPasswordEncoder bCryptEncoder;

	public UserService() {
		// Default constructor
	}

	public User saveUser(final User user) {
		//Role userRole = roleRepository.findByRole("CASHIER");
		//user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		user.setPassword(bCryptEncoder.encode(user.getPassword()));
		user.setActive(true);
		return userRepository.save(user);
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(final String userName) throws UsernameNotFoundException {
		final User user = userRepository.findByEmail(userName);
		return buildUserForAuthentication(user);
	}

	/*private List<GrantedAuthority> getUserAuthority(final Set<Role> userRoles) {
		final Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
		for (Role role : userRoles) {
			roles.add(new SimpleGrantedAuthority(role.getRole()));
		}
		return new ArrayList<GrantedAuthority>(roles);
	}*/

	private UserDetails buildUserForAuthentication(final User user) {
		return new MyUserDetails(user);
	}


}
