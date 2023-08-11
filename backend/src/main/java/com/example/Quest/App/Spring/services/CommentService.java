package com.example.Quest.App.Spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Quest.App.Spring.entities.Comment;
import com.example.Quest.App.Spring.entities.Post;
import com.example.Quest.App.Spring.entities.User;
import com.example.Quest.App.Spring.repos.CommentRepository;
import com.example.Quest.App.Spring.request.CommentCreateRequest;
import com.example.Quest.App.Spring.request.CommentUpdateRequest;

@Service
public class CommentService {

	private CommentRepository commentRepository;
	private UserService userService;
	private PostService postService;

	public CommentService(CommentRepository commentRepository, UserService userService, PostService postService) {
		this.commentRepository = commentRepository;
		this.userService = userService;
		this.postService = postService;
	}

	public List<Comment> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId) {
		if (userId.isPresent() && postId.isPresent()) {
			return commentRepository.findByUserIdAndPostId(userId.get(), postId.get());
		} else if (userId.isPresent()) {
			return commentRepository.findByUserId(userId.get());
		} else if (postId.isPresent()) {
			return commentRepository.findByPostId(postId.get());
		} else
			return commentRepository.findAll();
	}
	
	public Comment getOneCommentById(Long commentId) {
		return commentRepository.f indById(commentId).orElse(null);
	}

	public Comment createOneComment(CommentCreateRequest request) {
		User user = userService.getOneUserById(request.getUserId());
		Post post = postService.getOnePostById(request.getPostId());

		if(user != null && post != null){
			Comment commentToSave = new Comment();
			commentToSave.setId(request.getId());
			commentToSave.setPost(post);
			commentToSave.setUser(user);
			commentToSave.setText(request.getText());
			return commentRepository.save(commentToSave);
		}else	
			return null;
	}

	public Comment updateOneCommentById(Long commentId, CommentUpdateRequest updateRequest) {
		Optional<Comment> comment = commentRepository.findById(commentId);
		if(comment.isPresent()) {
			Comment toUpdate = comment.get();
			toUpdate.setText(updateRequest.getText());
			commentRepository.save(toUpdate);
			return toUpdate;
		}
		return null;
	}

	public void deleteOnePostById(Long commentId) {
		commentRepository.deleteById(commentId);
	}
	
	

}
