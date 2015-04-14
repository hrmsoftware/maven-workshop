package se.hrm;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Just Dohs a Duff...
 *
 * ...and screams a bit if the etc/hello.sh file isn't present at the expected location.
 */
public class Doh {

	public static void main(String[] args)  {
		System.out.println();

		if(!Files.exists(Paths.get("etc/hello.sh"))) {
			System.out.println("AAAAAAAARRRGH the etc/hello.sh file isn't found!");
		}
	}
}
