package com.bwj.example;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

	
@RunWith(Parameterized.class)
public class TestSelenium {
	public String name;
	public String id;
	public SeleniumTest seleniumTest;
	
	public TestSelenium(String id, String name) {
		this.name = name;
		this.id = id;
	}
	
	@Before
	public void setup() {
		this.seleniumTest = new SeleniumTest();
	}
	
	@Parameters(name = "{index}: name:{1} id:{0}")
	public static List<String[]> parameters(){
		List<String[]> list = new ArrayList<>();
		File inputFile = new File("user_info.csv");
		if (!inputFile.exists()) {
			System.out.println("Î´ÕÒµ½ÎÄ¼þ");
			System.exit(-1);
		}
//		Reader fis;
		try {
//			fis = new FileReader(inputFile);
			BufferedReader br= new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF-8"));
			String line = null;
			boolean tag = true;
			while((line = br.readLine()) != null) {
				String[] inputs = line.split(",");
				if (inputs.length != 2 || tag) {
					tag = false;
					continue;
				}
				list.add(inputs);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	@Test
	public void testInput() {
		String getedID = this.seleniumTest.getStudentID(this.name);
		System.out.println(getedID);
		assertEquals(getedID, this.id);
	}
}
