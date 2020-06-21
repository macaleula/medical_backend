package com.ebc43.bc_backend;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.text.CaseUtils;

public class FIleReader {

	public static void main(String[] args) throws IOException {

		triggers();

	}
	
	public static void table_inherits() throws FileNotFoundException, IOException {
		try(BufferedReader br = new BufferedReader(new FileReader("tables.txt"))) {
		    for(String line; (line = br.readLine()) != null; ) {
		    	System.out.println("CREATE TABLE " + line +"_archive () INHERITS (" + line + ");");
		    }
		}
	}
	
	public static void triggers() throws FileNotFoundException, IOException {
		try(BufferedReader br = new BufferedReader(new FileReader("tables.txt"))) {
		    for(String line; (line = br.readLine()) != null; ) {
		    	System.out.println("CREATE TRIGGER soft_delete_" + line);
		    	System.out.println("    AFTER");
		    	System.out.println("        UPDATE OF deleted_at"); 
		    	System.out.println("        OR DELETE");
		    	System.out.println("    ON " + line);
		    	System.out.println("    FOR EACH ROW");
		    	System.out.println("    EXECUTE PROCEDURE archive_record();");
		    	System.out.println("");
		    }
		}
	}
	
	public static void tables() throws FileNotFoundException, IOException {
		try(BufferedReader br = new BufferedReader(new FileReader("tables.txt"))) {
		    for(String line; (line = br.readLine()) != null; ) {
		    	String camel = CaseUtils.toCamelCase(line, true, new char[]{'_'});
		    	System.out.println("php artisan infyom:scaffold " + camel + " --fromTable --tableName=" + line);
		    }
		    // line is not visible here.
		}
	}
	
	public static void ReadPR() throws FileNotFoundException, IOException {
		System.out.println(".antMatchers(HttpMethod.GET, ");
		String fileName = "read_pr";
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
		    for(String line; (line = br.readLine()) != null; ) {
		        System.out.println("\"" + line + "/**\",");
		    }
		    System.out.println(")");
		    // line is not visible here.
		}
	}
	
	public static void ReadPReMR() throws FileNotFoundException, IOException {
		System.out.println(".antMatchers(HttpMethod.GET, ");
		String fileName = "read_pr_mr";
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
		    for(String line; (line = br.readLine()) != null; ) {
		        System.out.println("\"" + line + "/**\",");
		    }
		    System.out.println(")");
		    // line is not visible here.
		}
	}
	
	public static void cruPReMR() throws FileNotFoundException, IOException {
		System.out.println(".antMatchers(HttpMethod.GET, ");
		String fileName = "cru_pr_mr.txt";
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
		    for(String line; (line = br.readLine()) != null; ) {
		        System.out.println("\"" + line + "/**\",");
		    }
		    System.out.println(")");
		    // line is not visible here.
		}
		System.out.println(".antMatchers(HttpMethod.POST, ");
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
		    for(String line; (line = br.readLine()) != null; ) {
		        System.out.println("\"" + line + "/**\",");
		    }
		    System.out.println(")");
		    // line is not visible here.
		}
		System.out.println(".antMatchers(HttpMethod.PUT, ");
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
		    for(String line; (line = br.readLine()) != null; ) {
		        System.out.println("\"" + line + "/**\",");
		    }
		    System.out.println(")");
		    // line is not visible here.
		}
	}
	
	public static void cruPR() throws FileNotFoundException, IOException {
		System.out.println(".antMatchers(HttpMethod.GET, ");
		String fileName = "cru_mr.txt";
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
		    for(String line; (line = br.readLine()) != null; ) {
		        System.out.println("\"" + line + "/**\",");
		    }
		    System.out.println(")");
		}
		System.out.println(".antMatchers(HttpMethod.POST, ");
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
		    for(String line; (line = br.readLine()) != null; ) {
		        System.out.println("\"" + line + "/**\",");
		    }
		    System.out.println(")");
		}
		System.out.println(".antMatchers(HttpMethod.PUT, ");
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
		    for(String line; (line = br.readLine()) != null; ) {
		        System.out.println("\"" + line + "/**\",");
		    }
		    System.out.println(")");
		}
	}
	
	public static void moco() throws FileNotFoundException, IOException {
		System.out.println(".antMatchers(HttpMethod.GET, ");
		String fileName = "read_pr_mr";
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
		    for(String line; (line = br.readLine()) != null; ) {
		        System.out.println("\"" + line + "/**\",");
		    }
		    System.out.println(")");
		    // line is not visible here.
		}
	}

}
