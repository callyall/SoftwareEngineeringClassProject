package com.softeng.ticket_application.repository;



import com.softeng.ticket_application.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 *
 * @author Dionisis Patrikios
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	 User findByEmail(String email);
	 User findById(int id);
}
