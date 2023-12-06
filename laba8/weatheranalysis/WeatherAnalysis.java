import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

public class WeatherAnalysis {

    private static final Gson gson = new Gson();

    public static void main(String[] args) {
        // Взаємодія з API та отримання даних
        List<WeatherData> weatherDataList = fetchDataFromApi("your_api_endpoint_here");

        // Виведення отриманих даних для перевірки
        weatherDataList.forEach(System.out::println);
    }

    private static List<WeatherData> fetchDataFromApi(String apiUrl) {
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }

                in.close();

                // Перетворення рядка JSON у список WeatherData
                return parseJsonToWeatherDataList(content.toString());
            } else {
                System.out.println("HTTP GET request failed with response code " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static List<WeatherData> parseJsonToWeatherDataList(String jsonString) {
        // Перетворення рядка JSON у список WeatherData
        return List.of(gson.fromJson(jsonString, WeatherData[].class));
    }