package org.nuclearzone.myblog.repository;

import org.nuclearzone.myblog.domain.BlogPost;

public interface BlogPostRepository extends BlogRepository<BlogPost> {

	BlogPost findByTitle(String title);
}
