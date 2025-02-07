// package edu.escuelaing.arep;

// import java.io.PrintWriter;
// import java.io.StringWriter;

// import org.junit.jupiter.api.Test;

// import static org.junit.jupiter.api.Assertions.*;

// class HttpServerTest {

//     @Test
//     void testHelloRestService() {
//         String path = "/app/hello";
//         String query = "name=John";
//         String result = HttpServer.helloRestService(path, query);
//         String expectedResponse = "HTTP/1.1 200 OK\r\n"
//                 + "Content-Type: application/json\r\n"
//                 + "\r\n"
//                 + "{\"name\": \"John\"}";
//         assertEquals(expectedResponse, result);
//     }

//     @Test
//     void testGetContentTypeHtml() {
//         String contentType = HttpServer.getContentType("index.html");
//         assertEquals("text/html", contentType);
//     }

//     @Test
//     void testGetContentTypeCss() {
//         String contentType = HttpServer.getContentType("styles.css");
//         assertEquals("text/css", contentType);
//     }

//     @Test
//     void testGetContentTypeJs() {
//         String contentType = HttpServer.getContentType("script.js");
//         assertEquals("application/javascript", contentType);
//     }

//     @Test
//     void testGetContentTypeUnknown() {
//         String contentType = HttpServer.getContentType("file.unknown");
//         assertEquals("text/plain", contentType);
//     }

//     @Test
//     void testServeFileNotFound() {
//         String filePath = "nonexistent.html"; 
//         StringWriter stringWriter = new StringWriter();
//         PrintWriter printWriter = new PrintWriter(stringWriter);
//         HttpServer.serveFile(printWriter, filePath);
//         String response = stringWriter.toString();
//         assertTrue(response.contains("HTTP/1.1 404 Not Found"));
//         assertTrue(response.contains("<h1>404 File Not Found</h1>"));
//     }
// }
