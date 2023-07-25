package com.example.Quest.App.Spring.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Quest.App.Spring.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
