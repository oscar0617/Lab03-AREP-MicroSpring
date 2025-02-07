package edu.escuelaing.arep.server;

@RestController
public class MathController {
    @GetMapping("/e")
    public static String euler(String nousada){
        return Double.toString(Math.E);
        
    }
}
