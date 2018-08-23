package com.ytb.demo.api;


import com.ytb.demo.model.Post;
import com.ytb.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class PostController {


    @Autowired
    private PostRepository postRepository;

    @GetMapping(path = "/posts")
    public ResponseEntity<List<Post>> getAllPosts() {

        List<Post> posts = new ArrayList<Post>();

        postRepository.findAll().forEach(posts::add);

        return  ResponseEntity.ok(posts);

    }


    @GetMapping(path = "/post/{id}")
    public ResponseEntity<Post> getSinglePost(@PathVariable long id){


        Optional<Post>  postOptional = postRepository.findById(id);

        if (!postOptional.isPresent())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(postOptional.get());
    }



    @PostMapping(path = "/post/add")
    public ResponseEntity<Post>  addPost(@RequestBody Post post) {

        postRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri();

        return ResponseEntity.created(location).build();

    }


    @PutMapping("/post/{id}")
    public ResponseEntity<Post> updateStudent(@RequestBody Post post, @PathVariable long id) {

        Optional<Post>  postOptional = postRepository.findById(id);

        if (!postOptional.isPresent())
            return ResponseEntity.notFound().build();


        postRepository.save(post);

        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/post/{id}")
    public ResponseEntity<Post> deletePost(@PathVariable long id) {
        postRepository.deleteById(id);

        return   ResponseEntity.ok().build();
    }




}
