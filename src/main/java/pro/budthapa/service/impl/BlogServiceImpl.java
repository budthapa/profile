package pro.budthapa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pro.budthapa.domain.Blog;
import pro.budthapa.domain.Category;
import pro.budthapa.repository.BlogRepository;
import pro.budthapa.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService{

	@Autowired
	private BlogRepository blogRepository;
	
	@Override
	public List<Blog> findAllBlogs() {
		return (List<Blog>)blogRepository.findAll();
	}

	@Override
	public Blog saveBlog(Blog blog) {
		return blogRepository.save(blog);
	}

	@Override
	public Blog findBlogById(Long id) {
		return blogRepository.findOne(id);
	}

	@Override
	public Blog updateBlog(Blog blog) {
		return blogRepository.save(blog);
	}
	
	public void deleteBlog(Long id){
		blogRepository.delete(id);
	}

	@Override
	public List<Blog> findRecentBlog() {
		return blogRepository.findFirst2ByOrderByCreateDateDesc();
	}

	@Override
	public List<Blog> findAllBlogsByCategory(Category category) {
		return blogRepository.findBlogByCategory(category);
	}

}
