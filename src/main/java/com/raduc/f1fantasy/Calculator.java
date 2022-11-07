package com.raduc.f1fantasy;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class Calculator {
    private List<Driver> drivers = new ArrayList<>();
    private List<Team> teams = new ArrayList<>();

    public void createData() {
        // Mercedes
        drivers.add(new Driver("Lewis Hamilton", 22.0));
        drivers.add(new Driver("George Russell", 23.2));

        // Red Bull
        drivers.add(new Driver("Max Verstappen", 33.2));
        drivers.add(new Driver("Sergio Perez", 22.9));

        // Ferrari
        drivers.add(new Driver("Charles Leclerc", 24.3));
        drivers.add(new Driver("Carlos Sainz", 18.7));

        // Mclaren
        drivers.add(new Driver("Lando Norris", 15.1));
        drivers.add(new Driver("Daniel Ricciardo", 5.6));

        // Alpine
        drivers.add(new Driver("Fernando Alonso", 10.6));
        drivers.add(new Driver("Esteban Ocon", 11.9));

        // Aston Martin
        drivers.add(new Driver("Lance Stroll", 9.2));
        drivers.add(new Driver("Sebastian Vettel", 10.4));

        // Alpha Tauri
        drivers.add(new Driver("Pierre Gasly", 8.5));
        drivers.add(new Driver("Yuki Tsunoda", 4.0));

        // Haas
        drivers.add(new Driver("Kevin Magnussen", 6.4));
        drivers.add(new Driver("Mick Schumacher", 5.7));

        // Williams
        drivers.add(new Driver("Alex Albon", 6.4));
        drivers.add(new Driver("Nicholas Latifi", 4.6));

        // Alfa Romeo
        drivers.add(new Driver("Valtteri Bottas", 8.6));
        drivers.add(new Driver("Zhou Guanyu", 4.3));

        teams.add(new Team("Red Bull", 39.6));
        teams.add(new Team("Mercedes", 31.4));
        teams.add(new Team("Ferrari", 29.3));
        teams.add(new Team("Alpine", 13.0));
        teams.add(new Team("McLaren", 12.2));
        teams.add(new Team("Aston Martin", 11.6));
        teams.add(new Team("Haas", 6.0));
        teams.add(new Team("Alfa Romeo", 6.0));
        teams.add(new Team("Alpha Tauri", 5.2));
        teams.add(new Team("Williams", 5.1));
    }

    public String getDrivers() {
        StringBuilder listOfDrivers = new StringBuilder();
        for (Driver driver: drivers) {
            listOfDrivers.append(driver.getName() + ", " + driver.getPrice() + " millions\n");
        }
        return listOfDrivers.toString();
    }

    public String getTeam(Double budget) {
        Double bestBudget = 0.0;
        Double sum = 0.0;
        StringBuilder team = new StringBuilder();

        for (int a = 0; a<20; a++) {
            for (int b = 1; b<20; b++) {
                for (int c = 2; c<20; c++) {
                    for (int d = 3; d<20; d++) {
                        for (int e = 4; e<20; e++) {
                            sum += drivers.get(a).getPrice() + drivers.get(b).getPrice() + drivers.get(c).getPrice() + drivers.get(d).getPrice() + drivers.get(e).getPrice();

                            for (int i = 0; i<10; i++) {
                                sum += teams.get(i).getPrice();

                                if (sum <= budget && sum > bestBudget) {
                                    team = new StringBuilder();
                                    team.append(drivers.get(a).getName() + "\n");
                                    team.append(drivers.get(b).getName() + "\n");
                                    team.append(drivers.get(c).getName() + "\n");
                                    team.append(drivers.get(d).getName() + "\n");
                                    team.append(drivers.get(e).getName() + "\n");
                                    team.append(teams.get(i).getName() + "\n");
                                    team.append(sum);

                                    bestBudget = sum;
                                }

                                sum = 0.0;
                            }
                        }
                    }
                }
            }
        }

        return team.toString();
    }

    public void getDataFromApi() throws IOException, JSONException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://fantasy-api.formula1.com/f1/2022/players")).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JSONObject myObject = new JSONObject(response.body());
        JSONArray players = (JSONArray) myObject.get("players");

//        for (Object player: players) {
//            drivers.add(new Driver(player.get("last_name"), 100.0));
//        }
//
//        System.out.println(myObject); // Your json object


//        StringBuilder result = new StringBuilder();
//        URL url = new URL("https://fantasy-api.formula1.com/f1/2022/players");
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setRequestMethod("GET");
//        try (BufferedReader reader = new BufferedReader(
//                new InputStreamReader(conn.getInputStream()))) {
//            for (String line; (line = reader.readLine()) != null; ) {
//                result.append(line);
//            }
//        }
//        JSONArray array = new JSONArray(result.toString());
//        for(int i=0; i < array.length(); i++)
//        {
//            JSONParser parser = new JSONParser();
//            JSONObject json = (JSONObject) parser.parse(stringToParse);
//            JSONObject object = array.getJSONObject(i);
//            var test = 0;
//        }
    }
}
