package data;

import java.util.ArrayList;

/**
 * Datenklasse OpenWeatherResponse
 * 
 * @author Herbert Seewann
 */
public class OpenWeatherResponse {

    private ArrayList<Liste> list;
    private City city;

    public ArrayList<Liste> getList() {
        return list;
    }

    public void setList(ArrayList<Liste> list) {
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "OpenWeatherResponse{" + "list=" + list + ", city=" + city + '}';
    }
}
