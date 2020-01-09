package data;

/**
 * Datenklasse Weather
 * 
 * @author Herbert Seewann
 */
public class Weather {
    private String icon;
    private String description;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Weather{" + "icon=" + icon + ", description=" + description + '}';
    }
}