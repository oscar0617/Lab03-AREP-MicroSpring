package edu.escuelaing.arep;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MicroServerTest {

    private static ExecutorService serverExecutor;
    private static final String BASE_URL = "http://localhost:8080/app";

    @BeforeAll
    static void startServer() {
        serverExecutor = Executors.newSingleThreadExecutor();
        serverExecutor.submit(() -> {
            try {
                MicroServer.main(new String[]{});
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @AfterAll
    static void stopServer() {
        MicroServer.stopServer();
        serverExecutor.shutdown();
    }

    @Test
    void testGreetingEndpoint() throws Exception {
        String response = sendGetRequest("/greeting");
        assertEquals("Hola Mundo", response.trim(), "El endpoint debe retornar Hola Mundo");
    }

    @Test
    void testEulerEndpoint() throws Exception {
        String response = sendGetRequest("/e");
        assertEquals("2.718281828459045", response.trim(), "El endpoint /e debe retornar el valor de Euler.");
    }

    @Test
    void testPiEndpoint() throws Exception {
        String response = sendGetRequest("/pi");
        assertEquals("3.141592653589793", response.trim(), "El endpoint /pi debe retornar el valor de PI.");
    }

    @Test
    void testMultiplicacionEndpoint() throws Exception {
        String response = sendGetRequest("/multiplicacion?valor1=2&valor2=3");
        assertEquals("6.0", response.trim(), "El endpoint /multiplicacion debe retornar 6.0 para 2 * 3.");
    }

    @Test
    void testRestaEndpoint() throws Exception {
        String response = sendGetRequest("/resta?valor1=5&valor2=3");
        assertEquals("2.0", response.trim(), "El endpoint /resta debe retornar 2.0 para 5 - 3.");
    }

    @Test
    void testSumaEndpoint() throws Exception {
        String response = sendGetRequest("/suma?valor1=4&valor2=6");
        assertEquals("10.0", response.trim(), "El endpoint /suma debe retornar 10.0 para 4 + 6.");
    }

    private String sendGetRequest(String endpoint) throws Exception {
        URL url = new URL(BASE_URL + endpoint);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            return response.toString();
        }
    }
}
