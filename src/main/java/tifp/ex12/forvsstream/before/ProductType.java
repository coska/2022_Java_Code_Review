/*
 * Copyright (c) 2022. Bizard Consulting Inc.
 * All rights reserved by Brendan Sungwook Kim and Distributable only for a personal learning purpose.
 */
package tifp.ex12.forvsstream.before;

//실제 인터뷰에서 사용한 예제입니다. 잘못된 것, 더 개선할 수 있는 것들을 찾아보세요.

public enum ProductType {

	DDA, CREDIT_CARD, HELOC;

	public static ProductType of(String type) {
		for (ProductType productType : values()) {
			if (type.equals(productType)) {
				return productType;
			}
		}
		return null;
	}

	//TODO Let's find a bug and fix potential issues!
	public static void main(String[] args) {
		System.out.println(ProductType.of("DRAFT"));
		System.out.println(ProductType.of("DDA"));
	}

	//TODO JUnit test & reuse the test cases for the improved.
}
