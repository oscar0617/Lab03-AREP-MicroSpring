package edu.escuelaing.arep.services;

import edu.escuelaing.arep.annotations.GetMapping;
import edu.escuelaing.arep.annotations.RequestParam;
import edu.escuelaing.arep.annotations.RestController;

@RestController
public class MathController {
    @GetMapping("/e")
    public static String euler(String nousada){
        return Double.toString(Math.E);
    }

    @GetMapping("/pi")
	public static String pi(@RequestParam(value = "v", defaultValue = "Diana") String name) {
		return Double.toString(Math.PI);
	}

    @GetMapping("/multiplicacion")
    public static String multiplicacion(@RequestParam(value = "valor1", defaultValue = "1") Double valor1, @RequestParam(value = "valor2", defaultValue = "1") Double valor2) {
        return Double.toString(valor1*valor2);
	}

    @GetMapping("/resta")
    public static String resta(@RequestParam(value = "valor1", defaultValue = "1") Double valor1, @RequestParam(value = "valor2", defaultValue = "1") Double valor2) {
        return Double.toString(valor1-valor2);
	}

    @GetMapping("/suma")
    public static String suma(@RequestParam(value = "valor1", defaultValue = "1") Double valor1, @RequestParam(value = "valor2", defaultValue = "1") Double valor2) {
        return Double.toString(valor1+valor2);
	}


}
