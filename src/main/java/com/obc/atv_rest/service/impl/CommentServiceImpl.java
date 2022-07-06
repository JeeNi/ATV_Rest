package com.obc.atv_rest.service.impl;

import com.obc.atv_rest.entity.Comment;
import com.obc.atv_rest.payload.CommentDTO;
import com.obc.atv_rest.payload.PostDTO;
import com.obc.atv_rest.repository.CommentRepository;
import com.obc.atv_rest.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;
    private ModelMapper mapper;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, ModelMapper mapper) {
        this.commentRepository = commentRepository;
        this.mapper = mapper;
    }

    @Override
    public List<CommentDTO> getPostInfo(int cCode, String cName) {
        List<Comment> comments = commentRepository.findCommentBySectIndexAndSectName(cCode, cName);

        return comments.stream().map(comment -> mapToDTO(comment)).collect(Collectors.toList());
    }

    // convert entity into DTO
    private CommentDTO mapToDTO(Comment comment) {
        CommentDTO commentDTO = mapper.map(comment, CommentDTO.class);

        return commentDTO;
    }

    // convert DTO to entity
    private Comment mapToEntity(CommentDTO commentDTO) {
        Comment comment = mapper.map(commentDTO, Comment.class);

        return comment;
    }
}
