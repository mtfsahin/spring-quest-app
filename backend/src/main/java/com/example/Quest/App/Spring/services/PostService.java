package com.example.Quest.App.Spring.services;

import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Quest.App.Spring.request.PostUpdateRequest;
import com.example.Quest.App.Spring.entities.Post;
import com.example.Quest.App.Spring.entities.User;
import com.example.Quest.App.Spring.repos.PostRepository;
import com.example.Quest.App.Spring.request.PostCreateRequest;

@Service
public class PostService {

	private PostRepository postRepository;
	private UserService userService;
 
	public PostService(PostRepository postRepository, UserService userService) {
		this.postRepository = postRepository;
		this.userService = userService;
	}

	public List<Post> getAllPost(Optional<Long> userId) {
		if(userId.isPresent()) 
			return postRepository.findByUserId(userId.get());
		return postRepository.findAll();
		
	}

	public Post getOnePostById(Long postId) {
		return postRepository.findById(postId).orElse(null);
	}

	public Post createOnePost(PostCreateRequest request) {
        User user = userService.getOneUserById(request.getUserId());
		
		if(user == null)
			return null;
		Post toSave = new Post();
		toSave.setId(request.getId());
		toSave.setText(request.getText());
		toSave.setTitle(request.getTitle());
		toSave.setUser(user);
		
		return postRepository.save(toSave);
	}

	public Post updateOnePostById(Long postId, PostUpdateRequest updatePost) {
		Optional<Post> post = postRepository.findById(postId);
		if(post.isPresent()) {
			Post toUpdate = post.get();
			toUpdate.setText(updatePost.getText());
			toUpdate.setTitle(updatePost.getTitle());
			postRepository.save(toUpdate);
			return toUpdate;
		}
		return null;
	}

	public void deleteOnePostById(Long postId) {
		postRepository.deleteById(postId);
	}
	
}
