package com.ebc43.bc_backend;

import java.util.UUID;

public class GeradorUUID {
	public static void main(String[] args) {
		printNumberStringNewUUID(10);
	}
	
	public static void printNewUUID(int n) {
		UUID id;
		for(int i=0; i<n; i++) {
			id = UUID.randomUUID();
			System.out.println("UUID: " + id);
		}
	}
	
	public static void printNumberStringNewUUID(int n) {
		UUID id;
		String s;
		for(int i=0; i<n; i++) {
			id = UUID.randomUUID();
			s = id.toString().replace("-", "");
			System.out.println("UUID: " + s);
		}
	}
}
