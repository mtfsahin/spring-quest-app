package com.example.Quest.App.Spring.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Quest.App.Spring.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
