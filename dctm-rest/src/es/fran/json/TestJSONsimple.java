package es.fran.json;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Iterator;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class TestJSONsimple {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws URISyntaxException {
		// TODO Auto-generated method stub
		String urlRest ="https://gorest.co.in/public/v1/users";
		
		HttpClient client = HttpClient.newHttpClient();
		CompletableFuture<HttpResponse<String>> response = null;
		String body = null;
		int statusCode = 0;
		
		System.out.println ("*****url Rest *****");
		HttpRequest request = HttpRequest.newBuilder()
				.uri(new URI(urlRest))
				.GET()				
				.build();
/*		
		client.sendAsync(request, BodyHandlers.ofString())
    			.thenApply(HttpResponse::body)
    			.thenAccept(System.out::println)
    			.join();
*/		
		response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
		try {
			body = response.thenApply(HttpResponse::body).get(5, TimeUnit.SECONDS);
			statusCode = response.thenApply(HttpResponse::statusCode).get(5, TimeUnit.SECONDS);
			System.out.println("Status: " + statusCode + " ### " + "body: " + body);
			
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(body);
			
			JSONArray data = (JSONArray) json.get("data");
			
			//JSONArray genItem = new JSONArray ();
			//@SuppressWarnings("unchecked") esto en 
			data.forEach(item -> {
				//System.out.println(item);
				JSONObject obj = (JSONObject) item;
			    System.out.println(obj.get("name"));
			});
/*			
	        Iterator<String> iterator = data.iterator();
	            while (iterator.hasNext()) {
	            	System.out.println(iterator.toString());
	                //System.out.println(iterator.next().toString());
	            }
*/			
		} catch (InterruptedException | ExecutionException | TimeoutException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        



	}

}
