package net;

import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * Mit dieser Klasse bekommt man die Icons von OpenWeather.
 * 
 * @author Herbert Seewann
 */
public class OpenWeather_Icons_Client {
    
    /**
     * Mit dieser Methode bekommt man das Icon zur IconId.
     * 
     * @param iconId Übergebenes Kürzel
     */
    public ImageIcon getIcon(String iconId) throws IOException
    {
       URL url = new URL("http://openweathermap.org/img/wn/" + iconId + "@2x.png");
       ImageIcon icon = new ImageIcon(ImageIO.read(url));
       return icon;
    }
    
    public static void main(String[] args) throws IOException {
        OpenWeather_Icons_Client owc = new OpenWeather_Icons_Client();
        ImageIcon icon = owc.getIcon("01d");
        System.out.println(icon.toString());
    }
}