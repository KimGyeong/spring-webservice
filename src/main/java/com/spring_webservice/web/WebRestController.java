package com.spring_webservice.web;

import com.spring_webservice.domain.posts.PostsRepository;
import com.spring_webservice.domain.posts.PostsSaveRequestDto;
import com.spring_webservice.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebRestController {
    private PostsRepository postsRepository;

    private PostsService postsService;

    public WebRestController(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld!";
    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto) {
        return postsService.save(dto);
    }
}
