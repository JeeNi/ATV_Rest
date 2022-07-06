package com.obc.atv_rest.controller;

import com.obc.atv_rest.payload.CommentDTO;
import com.obc.atv_rest.payload.PostDTO;
import com.obc.atv_rest.service.PostService;
import com.obc.atv_rest.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/list")
public class PostController {
    private PostService postService;
    private CommentService commentService;

    public PostController(PostService postService, CommentService commentService) {
        this.postService = postService;
        this.commentService = commentService;
    }

    // create blog post
    @PostMapping
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO) {
        return new ResponseEntity<>(postService.creatPost(postDTO), HttpStatus.CREATED);
    }

    // get all posts rest api
    @GetMapping
    public List<CommentDTO> getAllPosts() {
        List<PostDTO> posts = postService.getAllPosts();

        int cCode = posts.get(1).getCCode();
        String cName = posts.get(1).getCName();

        System.out.println(cCode);
        System.out.println(cName);

        List<CommentDTO> comments = commentService.getPostInfo(cCode, cName);
//        List<PostDTO> totalList = List<comments>;

        System.out.println("controller : " + comments);

        return comments;
    }

    // get post by id
    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }
}
