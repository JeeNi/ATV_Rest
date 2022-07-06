package com.obc.atv_rest.repository;

import com.obc.atv_rest.entity.Comment;
import com.obc.atv_rest.payload.CommentDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findCommentBySectIndexAndSectName(int cCode, String cName);
}
