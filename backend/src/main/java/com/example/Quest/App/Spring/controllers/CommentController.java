package com.example.Quest.App.Spring.controllers;

import java.util.List;ü
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Quest.App.Spring.entities.Comment;
import com.example.Quest.App.Spring.request.CommentCreateRequest;
import com.example.Quest.App.Spring.services.CommentService;
import com.example.Quest.App.Spring.services.CommentUpdateRequest;

@RestController
@RequestMapping("/comments")
public class CommentController {
	

	private CommentService commentService;
	
	
	
	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}

	@GetMapping
	public List<Comment> getAllComment(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId){
		return commentService.getAllCommentsWithParam(userId,postId);
		
	}
	
	@GetMapping("/{commentId}")
	public Comment getOneComment(@PathVariable Long commentId) {
		return commentService.getOneCommentById(commentId);
	}
	
	@PostMapping
	public Comment createOneComment(@RequestBody CommentCreateRequest request) {
		return commentService.createOneComment(request);
	}
	
	@PutMapping("/{commentId}")
	public Comment updateOneComment(@PathVariable Long commentId, @RequestBody CommentUpdateRequest request) {
		return commentService.updateOneCommentById(commentId, request);
	}
	
	
	
	
}
