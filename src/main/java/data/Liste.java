package data;

import java.util.List;

/**
 * Datenklasse Liste
 * 
 * @author Herbert Seewann
 */
public class Liste {
    private Main main;
    private List<Weather> weather;
    private String dt_txt;

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }

    @Override
    public String toString() {
        return "Liste{" + "main=" + main + ", weather=" + weather + ", dt_txt=" + dt_txt + '}';
    }
}