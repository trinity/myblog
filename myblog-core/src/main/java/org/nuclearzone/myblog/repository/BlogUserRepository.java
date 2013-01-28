package org.nuclearzone.myblog.repository;

import org.nuclearzone.myblog.domain.BlogUser;

public interface BlogUserRepository extends BlogRepository<BlogUser> {
	
	BlogUser findByUsername(String username);
}
