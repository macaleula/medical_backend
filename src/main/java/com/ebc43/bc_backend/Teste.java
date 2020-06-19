package com.ebc43.bc_backend;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ebc43.bc_backend.TaskManagement.InterdicaoAmbiente.InterdicaoAmbiente;

public class Teste {

	public static void main(String[] args) {

		BCryptPasswordEncoder e = new BCryptPasswordEncoder();
		System.out.println(e.encode("password4"));
	}
	
	public static void printList(List<InterdicaoAmbiente> list) {
		for(InterdicaoAmbiente i : list) {
			System.out.println("i :" + i.getDataMudanca());
		}
	}

}
