package pro.budthapa.service;

import java.util.List;

import pro.budthapa.domain.Blog;
import pro.budthapa.domain.Category;

public interface BlogService {
	public List<Blog> findAllBlogs();
	public Blog saveBlog(Blog blog);
	public Blog findBlogById(Long id);
	public Blog updateBlog(Blog blog);
	public void deleteBlog(Long id);
	public List<Blog> findRecentBlog();
	public List<Blog> findAllBlogsByCategory(Category category);
	public List<Blog> findLatest5Blog();
}
