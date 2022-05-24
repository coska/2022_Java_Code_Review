/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex14.reusablepredicate.flaw;

import lombok.RequiredArgsConstructor;
import tifp.ex14.reusablepredicate.IdentityService;
import tifp.ex14.reusablepredicate.UserEntity;

@RequiredArgsConstructor
public class UserMapper {

	private final IdentityService identityService;

	public UserEntity map(UserDto userDto) {
		final UserEntity result = new UserEntity();
		switch (userDto.getAuthType()) {
			case VIEWER:
				final String viewerIdentity = identityService.getViewerIdentity(userDto.getId());
				result.setIdentity(viewerIdentity);
				break;
			case WRITER:
				final String writerIdentity = identityService.getWriterIdentity(userDto.getId());
				result.setIdentity(writerIdentity);
				break;
			case ADMIN:
			default:
				final String adminIdentity = identityService.getAdminIdentity(userDto.getId());
				result.setIdentity(adminIdentity);
				break;
		}
		return result;
	}
}
