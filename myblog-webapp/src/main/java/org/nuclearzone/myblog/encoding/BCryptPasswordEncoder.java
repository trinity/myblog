package org.nuclearzone.myblog.encoding;

import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class BCryptPasswordEncoder implements PasswordEncoder {

	@Override
	public String encodePassword(String rawPass, Object salt) {
		return BCrypt.hashpw(rawPass, BCrypt.gensalt());
	}

	@Override
	public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
		return BCrypt.checkpw(rawPass, encPass);
	}
}
