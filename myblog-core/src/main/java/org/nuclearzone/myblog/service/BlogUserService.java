package org.nuclearzone.myblog.service;

import org.nuclearzone.myblog.domain.BlogUser;
import org.nuclearzone.myblog.repository.BlogUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogUserService extends AbstractBlogService<BlogUser> {

	@Autowired
	private BlogUserRepository userRepository;
	
	public BlogUser findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	protected BlogUserRepository getRepository() {
		return userRepository;
	}
}