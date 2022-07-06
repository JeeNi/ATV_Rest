package com.obc.atv_rest.repository;

import com.obc.atv_rest.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
