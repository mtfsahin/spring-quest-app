package com.example.Quest.App.Spring.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Quest.App.Spring.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

	List<Post> findByUserId(Long userId);
	
	

}
