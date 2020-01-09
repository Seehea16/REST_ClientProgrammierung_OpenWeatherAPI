package data;

import java.util.List;

/**
 * Datenklasse OpenWeatherResponse
 * 
 * @author Herbert Seewann
 */
public class OpenWeatherResponse {

    private List<Liste> list;
    private List<City> city;

    public List<Liste> getList() {
        return list;
    }

    public void setList(List<Liste> list) {
        this.list = list;
    }

    public List<City> getCity() {
        return city;
    }

    public void setCity(List<City> city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "OpenWeatherResponse{" + "list=" + list + ", city=" + city + '}';
    }
}
