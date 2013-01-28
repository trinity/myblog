package org.nuclearzone.myblog.service;

import org.nuclearzone.myblog.domain.BlogPost;
import org.nuclearzone.myblog.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogPostService extends AbstractBlogService<BlogPost> {

	@Autowired
	private BlogPostRepository postRepository;

	@Override
	protected BlogPostRepository getRepository() {
		return postRepository;
	}
}