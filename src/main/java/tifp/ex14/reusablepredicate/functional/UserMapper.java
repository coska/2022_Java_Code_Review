/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex14.reusablepredicate.functional;

import static tifp.ex14.reusablepredicate.functional.UserPredicates.IS_ADMIN;
import static tifp.ex14.reusablepredicate.functional.UserPredicates.IS_VIEWER;
import static tifp.ex14.reusablepredicate.functional.UserPredicates.IS_WRITER;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

import lombok.RequiredArgsConstructor;
import tifp.ex14.reusablepredicate.IdentityService;
import tifp.ex14.reusablepredicate.UserEntity;

@RequiredArgsConstructor
public class UserMapper {

	private final IdentityService identityService;

	//Note: private method getXXIdenty() in this class actually becomes 'Function<String, String>'
	private final Map<Predicate<UserDto>, Function<String, String>> identityRoutes = Map.of(
			IS_VIEWER, this::getViewerIdentity, //'identityService::getViewerIdentity' won't work. (e.g. RuntimeException -> 'identityService' is lazy-initialized than this map)
			IS_WRITER, this::getWriterIdentity,
			IS_ADMIN, this::getAdminIdentity);

	public UserEntity map(UserDto userDto) {
		final UserEntity result = new UserEntity();
		result.setIdentity(getIdentity(userDto));
		return result;
	}

	//This core business logic becomes more concise!
	private String getIdentity(UserDto userDto) {
		return identityRoutes.entrySet().stream()
				.filter(entry -> entry.getKey().test(userDto))
				.findFirst()
				.map(entry -> entry.getValue().apply(userDto.getId()))
				.orElseThrow(() -> new RuntimeException("Failed to get the identity of User: " + userDto));
	}

	private String getViewerIdentity(String id) {
		return identityService.getViewerIdentity(id);
	}

	private String getWriterIdentity(String id) {
		return identityService.getWriterIdentity(id);
	}

	private String getAdminIdentity(String id) {
		return identityService.getAdminIdentity(id);
	}
}

//TODO: How different is this compared to If-ELSE-IF-ELSE or Switch-Case?
//Run UserMapperTest multiple times and see what's printed in the console!! (no fixed order of comparisons by Map)