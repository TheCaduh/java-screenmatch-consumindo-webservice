package br.com.alura.screenmatch.principal;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TmdbClient {
    public static void main(String[] args) {
        try {

            String url = "https://api.themoviedb.org/3/search/movie?query=avatar&language=pt-BR";
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI3YWY1NzYzMWZhYjQwZWFmNjM1NDIwOTQ4OGNhNTQ1MCIsIm5iZiI6MTc2MTcwMjc1NS44OTMsInN1YiI6IjY5MDE3MzYzYjNhYTNlYmQyNDM5YTBhMCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.BDWCQ9Ue1Wp7LJD6uqISizAFcej7TYVutIp_Lv8ksK4");
            connection.setRequestProperty("accept", "application/json");
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString());
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
