package org.nuclearzone.myblog.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;

import org.bson.types.ObjectId;
import org.nuclearzone.myblog.domain.BlogPost;
import org.nuclearzone.myblog.domain.BlogPostComment;
import org.nuclearzone.myblog.service.BlogPostCommentService;
import org.nuclearzone.myblog.service.BlogPostService;
import org.nuclearzone.myblog.service.BlogUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {

	@Autowired
	private BlogPostService postService;
	
	@Autowired
	private BlogPostCommentService commentService;
	
	@Autowired
	private BlogUserService userService;
	
	@RequestMapping(value="/posts", method=RequestMethod.GET)
	public String listPosts(@RequestParam(required=false,defaultValue="0",value="page") int page,
							@RequestParam(required=false,defaultValue="2",value="size") int size,
							Map<String, Object> model) {
		
		Page<BlogPost> posts = postService.findAll(new PageRequest(page, size, Direction.DESC, "date"));
		
		model.put("post", new BlogPost());
				
		model.put("postList", posts.getContent());
		model.put("postCount", posts.getTotalElements());
		model.put("pageCount", posts.getTotalPages());
		model.put("currentPage", posts.getNumber());
		
		return "posts";
	}
	
	@RequestMapping(value="/posts/view/{postId}", method=RequestMethod.GET)
	public String viewPost(@PathVariable("postId") String postId, Map<String, Object> model) {
		
		BlogPost post = null;
		
		if(ObjectId.isValid(postId)) {
			post = postService.findById(ObjectId.massageToObjectId(postId));
		}
		
		model.put("post", post);
		
		return "viewpost";
	}
	
	@RequestMapping(value="/posts/view/{postId}/comments/add", method=RequestMethod.POST)
	public String addPostComment(@PathVariable("postId") String postId,
			@RequestParam(value="text", required=true) String text, 
			@RequestParam(value="username", required=true) String username) {
		
		BlogPost post = null;
		
		if(ObjectId.isValid(postId)) {
			post = postService.findById(ObjectId.massageToObjectId(postId));
		}
		
		if(post != null) {
			BlogPostComment comment = new BlogPostComment();
			comment.setId(ObjectId.get());
			comment.setText(text);
			comment.setUsername(username);
			comment.setDate(new Date());
			if(post.getComments() == null) {
				post.setComments(new HashSet<BlogPostComment>());
			}
			post.getComments().add(comment);
			commentService.save(comment);
			postService.save(post);
		}
		
		return "redirect:/posts/view/" + postId;
	}
	
	@RequestMapping(value="/posts/add", method=RequestMethod.GET)
	public String addPost(Map<String, Object> model) {
		model.put("post", new BlogPost());
		return "addpost";
	}
	
	@RequestMapping(value="/posts/add", method=RequestMethod.POST)
	public String addPost(@ModelAttribute("post") BlogPost post, BindingResult result) {
		post.setDate(new Date());
		post.setUser(userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));
		postService.save(post);
		return "redirect:/posts";
	}

	@RequestMapping(value="/posts/delete/{postId}", method=RequestMethod.GET)
	public String deletePost(@PathVariable("postId") String postId) {
		postService.delete(ObjectId.massageToObjectId(postId));
		return "redirect:/posts";
	}
}