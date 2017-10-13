package pro.budthapa.helper;

import java.util.List;

import pro.budthapa.domain.Blog;

public class BlogHelper {
	public static List<Blog> replaceSpaceWithHypen(List<Blog> blogList) {
		for(int i=0;i<blogList.size();i++) {
			blogList.get(i).setTitleWithHypen(blogList.get(i).getTitle().replace(" ", "-"));
		}
		return blogList;
	}
}
