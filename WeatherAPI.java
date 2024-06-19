package weatherAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherAPI {
    private static final String API_URL = "http://api.openweathermap.org/data/2.5/weather";
    private static final String API_KEY = "779964e61a0071a4c1ef530e46776364";

    public static String getWeather(String city) throws IOException {
        @SuppressWarnings("deprecation")
        URL url = new URL(API_URL + "?q=" + city + "&appid=" + API_KEY);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        connection.disconnect();
        return content.toString();
    }
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter city name: ");
        String city = null;
        try {
            city = br.readLine();
            System.out.println(getWeather(city));

        } catch (IOException e) {
            e.printStackTrace();
        
    }}
}

