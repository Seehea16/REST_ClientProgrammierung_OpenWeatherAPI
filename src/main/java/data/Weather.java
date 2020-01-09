package data;

/**
 * Datenklasse Weather
 * 
 * @author Herbert Seewann
 */
public class Weather {
    private String icon;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "Weather{" + "icon=" + icon + '}';
    }
}