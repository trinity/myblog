package org.nuclearzone.myblog.service;

import org.nuclearzone.myblog.domain.BlogPostComment;
import org.nuclearzone.myblog.repository.BlogPostCommentRepository;
import org.nuclearzone.myblog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogPostCommentService extends AbstractBlogService<BlogPostComment> {

	@Autowired
	private BlogPostCommentRepository commentRepository;
	
	@Override
	protected BlogRepository<BlogPostComment> getRepository() {
		return commentRepository;
	}
}
