package bl;

import data.OpenWeatherResponse;
import java.util.Comparator;
import net.OpenWeather_Weather_Client;

/**
 * Comparator-Klasse, um nach Luftfeuchtigkeit zu sortieren.
 * 
 * @author Herbert Seewann
 */
public class SortByHumidity implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        OpenWeather_Weather_Client owc = new OpenWeather_Weather_Client();
        OpenWeatherResponse opr1 = owc.getForecast(o1);
        OpenWeatherResponse opr2 = owc.getForecast(o2);
        if(opr1.getList().get(0).getMain().getHumidity() >
                opr2.getList().get(0).getMain().getHumidity()) {
            return 1;
        } else if (opr1.getList().get(0).getMain().getHumidity() <
                opr2.getList().get(0).getMain().getHumidity()) {
            return -1;
        } else {
            return 0;
        }
    }
}