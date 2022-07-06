package com.obc.atv_rest.service.impl;

import com.obc.atv_rest.entity.Post;
import com.obc.atv_rest.exception.ResourceNotFoundException;
import com.obc.atv_rest.payload.PostDTO;
import com.obc.atv_rest.repository.PostRepository;
import com.obc.atv_rest.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;
    private ModelMapper mapper;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, ModelMapper mapper) {
        this.postRepository = postRepository;
        this.mapper = mapper;
    }

    @Override
    public PostDTO creatPost(PostDTO postDTO) {
        // convert DTO to entity
        Post post = mapToEntity(postDTO);
        Post newPost = postRepository.save(post);

        // convert entity to DTO
        PostDTO postResponse = mapToDTO(newPost);

        return postResponse;
    }

    @Override
    public List<PostDTO> getAllPosts() {
        List<Post> posts = postRepository.findAll();

        return posts.stream().map(post -> mapToDTO(post)).collect(Collectors.toList());
    }

    public PostDTO getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        return mapToDTO(post);
    }

    // convert entity into DTO
    private PostDTO mapToDTO(Post post) {
        PostDTO postDTO = mapper.map(post, PostDTO.class);

        return postDTO;
    }

    // convert DTO to entity
    private Post mapToEntity(PostDTO postDTO) {
        Post post = mapper.map(postDTO, Post.class);

        return post;
    }
}
