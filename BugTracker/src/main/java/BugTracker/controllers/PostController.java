package BugTracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import BugTracker.dtos.PostDto;
import BugTracker.pojos.Post;
import BugTracker.pojos.Ticket;
import BugTracker.services.PostService;

@Controller
public class PostController {
	PostService postService;
	
	@Autowired
	@Qualifier(value = "postService")
	public void setPostService(PostService postService) {
		this.postService = postService;
	}
	
	/**
	 * createPost in Post controller takes in a postDTO from the front end,
	 * calls the service to create the ticket in the database, adding into the ticketId that is being assigned to then creates a new
	 * response entity and returns that
	 * 
	 * @param ticketDto
	 * @return ResponseEntity<TicketDto>
	 * @author Vincent
	 */
	@CrossOrigin
	@RequestMapping(path = "/post", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
		Post post = postService.toPost(postDto);
		System.out.println(post);
		postService.createPost(post);
		ResponseEntity<PostDto> rEntity =  new ResponseEntity<PostDto>(postDto, HttpStatus.CREATED);
		return rEntity;
	}
	
	
	@CrossOrigin
	@RequestMapping(path = "/post/{ticketId}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<PostDto>> getAllPostsByTicketId(@PathVariable(name = "ticketId") long ticketId) {
		ResponseEntity<List<PostDto>> rEntity = new ResponseEntity<List<PostDto>>(postService.toDisplay(postService.getAllPostsInTicket(ticketId)), 
				HttpStatus.OK);
	
		return rEntity;
	}

}
