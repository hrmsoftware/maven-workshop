package se.hrmsoftware.labb;

import java.util.ArrayList;
import java.util.List;

public class BatchHello {

	private final HelloWorld helloWorld;

	public BatchHello(HelloWorld helloWorld) {
		this.helloWorld = helloWorld;
	}

	public List<String> batchGreet(String... names) {
		List<String> result = new ArrayList<String>();
		for (String name : names) {
			result.add(helloWorld.greet(name));
		}
		return result;
	}


}
