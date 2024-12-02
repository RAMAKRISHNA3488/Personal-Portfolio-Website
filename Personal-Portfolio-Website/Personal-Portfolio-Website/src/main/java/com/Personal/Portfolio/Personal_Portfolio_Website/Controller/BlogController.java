package com.Personal.Portfolio.Personal_Portfolio_Website.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Personal.Portfolio.Personal_Portfolio_Website.Model.Blog;
import com.Personal.Portfolio.Personal_Portfolio_Website.Service.BlogService;

@Controller
@RequestMapping("/api/blogs")
public class BlogController {
	@Autowired
	private BlogService blogService;

	@GetMapping
	public ResponseEntity<List<Blog>> getAllBlogs() {
		return ResponseEntity.ok(blogService.getAllBlogs());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Blog> getBlogById(@PathVariable Long id) {
		return ResponseEntity.ok(blogService.getBlogById(id));
	}

	@PostMapping
	public ResponseEntity<Blog> createBlog(@RequestBody Blog blog) {
		return ResponseEntity.ok(blogService.createBlog(blog));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Blog> updateBlog(@PathVariable Long id, @RequestBody Blog blog) {
		return ResponseEntity.ok(blogService.updateBlog(id, blog));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBlog(@PathVariable Long id) {
		blogService.deleteBlog(id);
		return ResponseEntity.noContent().build();
	}

}
