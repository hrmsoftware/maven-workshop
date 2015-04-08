package se.hrmsoftware.labb;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BatchHelloTest {

	@Test
	public void testBatchHello() {
		String[] names = new String[]{"foo", "bar"};
		List<String> expectedResult = Arrays.asList("Tjipp, foo", "Tjipp, bar");
		HelloWorld helloWorld = new HelloWorld("Tjipp, ");
		List<String> result = new BatchHello(helloWorld).batchGreet(names);
		assertEquals(expectedResult, result);
	}

}