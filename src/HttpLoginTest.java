public class HttpLoginTest {
    // Method to perform login to HTTP based application
    public void loginToHttp() {
        // Initialize HTTP client or relevant framework client
        HttpClient client = HttpClient.newHttpClient();
        
        // Prepare the login request with necessary headers and body
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://example.com/login"))
            .header("Content-Type", "application/x-www-form-urlencoded")
            .POST(HttpRequest.BodyPublishers.ofString("username=user&password=pass"))
            .build();

        try {
            // Send the request and get the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Validate the response status code
            if (response.statusCode() == 200) {
                System.out.println("Login successful");
                // Additional validation or session handling can be done here
            } else {
                System.out.println("Login failed with status code: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}