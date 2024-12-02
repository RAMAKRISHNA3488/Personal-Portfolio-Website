package com.Personal.Portfolio.Personal_Portfolio_Website.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Personal.Portfolio.Personal_Portfolio_Website.Model.Blog;
import com.Personal.Portfolio.Personal_Portfolio_Website.Repos.BlogRepository;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogRepository blogRepository;

	@Override
	public List<Blog> getAllBlogs() {
		return blogRepository.findAll();
	}

	@Override
	public Blog getBlogById(Long id) {
		return blogRepository.findById(id).orElseThrow(() -> new RuntimeException("Blog not found with id: " + id));
	}

	@Override
	public Blog createBlog(Blog blog) {
		return blogRepository.save(blog);
	}

	@Override
	public Blog updateBlog(Long id, Blog blog) {
		Blog existingBlog = getBlogById(id);
		existingBlog.setTitle(blog.getTitle());
		existingBlog.setContent(blog.getContent());
		existingBlog.setAuthor(blog.getAuthor());
		existingBlog.setUpdatedate(LocalDateTime.now());
		return blogRepository.save(existingBlog);

	}

	@Override
	public void deleteBlog(Long id) {
		if (!blogRepository.existsById(id)) {
            throw new RuntimeException("Blog not found with id: " + id);
        }
        blogRepository.deleteById(id);
    }
	

}
