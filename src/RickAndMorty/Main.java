import org.json.JSONObject;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

void main() throws IOException, InterruptedException {
    int id = 4;
    String url = "https://rickandmortyapi.com/api/character/";

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url + id))
            .GET()
            .build();

    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

    if (response.statusCode() == 200) {
        System.out.println(response.body());

        JSONObject obj = new JSONObject(response.body());
        String name = obj.getString("name");
        System.out.println("Name: " + name);
    } else {
        System.err.println("Error: Received HTTP " + response.statusCode());
    }
}