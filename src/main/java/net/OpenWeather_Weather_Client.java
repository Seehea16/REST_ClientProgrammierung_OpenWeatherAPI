package net;

import com.google.gson.Gson;
import data.OpenWeatherResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Mit dieser Klasse bekommt man die Wetterdaten von OpenWeather.
 * 
 * @author Herbert Seewann
 */
public class OpenWeather_Weather_Client {
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/forecast?units=metric";
    private static String APIKEY = "1a7132b899d361e44aa1265630e6d655";
    private static Client client;
    private Gson gson;

    /**
     * Konstruktor der Klasse OpenWeather_Weather_Client
     */
    public OpenWeather_Weather_Client() {
        gson = new Gson();
    } 
    
    /**
     * Mit dieser Methode bekommt man den Forecast einer bestimmten Stadt.
     * @param city Stadt, von der der Forecast gefunden werden soll
     */
    public OpenWeatherResponse getForecast(String city) {
        client = ClientBuilder.newClient();
        String uri = BASE_URL + "&q="+city+"&appid="+APIKEY;
        WebTarget target = client.target(uri);
        Response result = target.request().accept(MediaType.APPLICATION_JSON).get();
        String jsondaten = result.readEntity(String.class);
        OpenWeatherResponse owr = gson.fromJson(jsondaten, OpenWeatherResponse.class);    
        return owr;
    }
    
    public static void main(String[] args) {
       OpenWeather_Weather_Client owc = new OpenWeather_Weather_Client();
       OpenWeatherResponse owr = owc.getForecast("Hausmannst%C3%A4tten");
       System.out.println(owr.getCity().getName());
       System.out.println(owr.getList().get(0).toString());
       System.out.println(owr.getList().get(1).toString());
       System.out.println(owr.getList().get(2).toString());
    }
}