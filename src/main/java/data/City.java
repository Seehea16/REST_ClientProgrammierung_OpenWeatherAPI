package data;

/**
 * Datenklasse City
 * 
 * @author Herbert Seewann
 */
public class City {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "City{" + "name=" + name + '}';
    }
}