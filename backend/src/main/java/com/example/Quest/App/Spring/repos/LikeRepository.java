package com.example.Quest.App.Spring.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Quest.App.Spring.entities.Like;

public interface LikeRepository extends JpaRepository<Like, Long> {

}
