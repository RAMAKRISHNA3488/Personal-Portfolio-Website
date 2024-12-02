package com.Personal.Portfolio.Personal_Portfolio_Website.Service;

import java.util.List;

import com.Personal.Portfolio.Personal_Portfolio_Website.Model.Blog;

public interface BlogService {

	List<Blog> getAllBlogs();

	Blog getBlogById(Long id);

	Blog createBlog(Blog blog);

	Blog updateBlog(Long id, Blog blog);

	void deleteBlog(Long id);

}
