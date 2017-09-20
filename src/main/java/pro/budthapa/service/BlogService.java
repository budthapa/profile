package pro.budthapa.service;

import java.util.List;

import pro.budthapa.domain.Blog;

public interface BlogService {
	public List<Blog> findAllBlogs();
	public Blog saveBlog(Blog blog);
	public Blog findBlogById(Long id);
	public Blog updateBlog(Blog blog);
	public void deleteBlog(Long id);
	public List<Blog> findRecentBlog();
}
