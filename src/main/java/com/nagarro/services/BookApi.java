package com.nagarro.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.models.Book;

public class BookApi {
	
	public ArrayList<Book> getBooks() {
		String url = "http://localhost:8090/allBooks";
		ArrayList<Book> books = null ;
		HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();

		HttpClient client = HttpClient.newBuilder().build();

		HttpResponse<String> response;
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());

			System.out.println(response.statusCode());

			System.out.println(response.body());

			String res = "{books:" + response.body() + "}";

			// Converting jsonData string into JSON object
			JSONObject jsnobject = new JSONObject(res);
			// Printing JSON object

			// Getting languages JSON array from the JSON object
			JSONArray jsonArray = jsnobject.getJSONArray("books");

			// Creating an empty ArrayList of type Object
			ArrayList<Object> listdata = new ArrayList<Object>();

			books = new ArrayList<Book>();
			// Checking whether the JSON array has some value or not
			if (jsonArray != null) {

				// Iterating JSON array
				for (int i = 0; i < jsonArray.length(); i++) {

					// Adding each element of JSON array into ArrayList
					listdata.add(jsonArray.get(i));
					ObjectMapper objectMapper = new ObjectMapper();
					String src = jsonArray.get(i).toString();
					Book book = objectMapper.readValue(src, Book.class);
					books.add(book);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			return books;
		
	}
}
