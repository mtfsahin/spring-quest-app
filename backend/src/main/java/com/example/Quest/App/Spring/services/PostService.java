package com.example.Quest.App.Spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Quest.App.Spring.entities.Post;
import com.example.Quest.App.Spring.repos.PostRepository;

@Service
public class PostService {

	private PostRepository postRepository;

	public PostService(PostRepository postRepository) {
		super();
		this.postRepository = postRepository;
	}

	public List<Post> getAllPost(Optional<Long> userId) {
		if(userId.isPresent()) 
			return postRepository.findByUserId(userId.get());
		return postRepository.findAll();
		
	}

	public Post getOnePostById(Long postId) {
		return postRepository.findById(postId).orElse(null);
	}
	
	
	
}
