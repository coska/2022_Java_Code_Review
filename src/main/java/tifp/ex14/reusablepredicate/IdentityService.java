/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex14.reusablepredicate;

public interface IdentityService {

	String getViewerIdentity(String id);
	String getWriterIdentity(String id);
	String getAdminIdentity(String id);
}
