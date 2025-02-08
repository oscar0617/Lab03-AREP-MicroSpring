package edu.escuelaing.arep.services;

import edu.escuelaing.arep.annotations.GetMapping;
import edu.escuelaing.arep.annotations.RequestParam;
import edu.escuelaing.arep.annotations.RestController;

@RestController
public class GreetingController {


	@GetMapping("/greeting")
	public static String greeting(@RequestParam(value = "name", defaultValue = "Mundo") String name) {
		return "Hola " + name;
	}
	
}