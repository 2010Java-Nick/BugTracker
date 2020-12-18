package BugTracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import BugTracker.dtos.PostDto;
import BugTracker.services.PostService;

@Controller
public class PostController {
	PostService postService;
	
	@Autowired
	@Qualifier(value = "postService")
	public void setPostService(PostService postService) {
		this.postService = postService;
	}
	
	
	@RequestMapping(path = "/post", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
		postService.createPost(postDto.toPost());
		return new ResponseEntity<PostDto>(postDto, HttpStatus.CREATED);
	}
	
	
	public PostController() {
		// TODO Auto-generated constructor stub
	}

}
