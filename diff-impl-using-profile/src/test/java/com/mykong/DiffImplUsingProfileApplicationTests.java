package com.mykong;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DiffImplUsingProfileApplicationTests {

	@Rule
	public OutputCapture outputCapture = new OutputCapture();

	@Test
	public void testDefaultProfile() throws Exception {
		DiffImplUsingProfileApplication.main(new String[0]);
		String output = this.outputCapture.toString();
		assertThat(output).contains("Today is sunny day!");
	}

	@Test
	public void testRainingProfile() throws Exception {
		System.setProperty("spring.profiles.active", "raining");
		DiffImplUsingProfileApplication.main(new String[0]);
		String output = this.outputCapture.toString();
		assertThat(output).contains("Today is raining day!");
	}

	@Test
	public void testRainingProfile_withDoption() throws Exception {
		DiffImplUsingProfileApplication.main(new String[]{"--spring.profiles.active=raining"});
		String output = this.outputCapture.toString();
		assertThat(output).contains("Today is raining day!");
	}

	@After
	public void after() {
		System.clearProperty("spring.profiles.active");
	}

}
