package com.obc.atv_rest.service;

import com.obc.atv_rest.payload.PostDTO;
import java.util.List;

public interface PostService {
    PostDTO creatPost(PostDTO postDTO);

    List<PostDTO> getAllPosts();

    PostDTO getPostById(long id);
}
