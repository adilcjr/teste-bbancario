package br.com.bb.utils;

public class RestPreconditions {
	
	public static <T> T checkNotNull (T data, String dataName) {
		if (data == null) {
			throw new RuntimeException(dataName + " não podem ser nulo!");
		}
		return data;
	}

}
