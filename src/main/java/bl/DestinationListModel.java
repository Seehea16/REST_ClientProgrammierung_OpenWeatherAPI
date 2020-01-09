package bl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.swing.AbstractListModel;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 * ListModel für die Destination-Liste der GUI.
 * 
 * @author Herbert Seewann
 */
public class DestinationListModel extends AbstractListModel<String>{

    private List<String> destinations; 
    
    /**
     * Konstruktor, in dem man die Liste initialisiert.
     */
    public DestinationListModel() {
        this.destinations = new LinkedList();;
    } 
    
    /**
     * Methode, um die Größe der Liste zu bekommen.
     */
    @Override
    public int getSize() {
       return this.destinations.size();
    }
    
    /**
     * Methode zum Adden einer Destination.
     * @param destinationName Dieser Name wird zur Liste hinzugefügt
     */
    public void add(String destinationName) {
        this.destinations.add(destinationName);
        this.fireContentsChanged(this, 0, this.getSize()-1);
    }

    /**
     * Methode zum Speichern der Destination-Liste als XML-Datei.
     * @param destinations Diese Destinations werden gespeichert
     */
    public void saveXML(List<String> destinations) throws IOException, JDOMException
    { 
         Element root = new Element("destinations");
         Document doc = new Document(root); 
         for(String dest : destinations) {
            Element destination = new Element("destination");
            destination.setText(dest);
            root.addContent(destination);
        }
        XMLOutputter xmlOutput = new XMLOutputter();
        xmlOutput.setFormat(Format.getPrettyFormat()); 
        FileWriter writer = new FileWriter(new File("src/main/java/resource/destinations.xml"));
        xmlOutput.output(doc, writer);
    }
    
    /**
     * Methode zum Laden der Destinations aus einer XML-Datei.
     */
    public void loadXML() throws JDOMException, IOException
    {
        File inputFile = new File("src/main/java/resource/destinations.xml");
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(inputFile);
        List<Element> lvl1 = document.getRootElement().getChildren();
        destinations.clear();
        for(Element element : lvl1) {
            destinations.add(element.getText());
        }
        this.fireContentsChanged(this, 0, this.getSize()-1);
    }
    
    /**
     * Liste nach Temperatur sortieren.
     */
    public void sortByTemperature() {
        Collections.sort(destinations, new SortByTemperature());
        this.fireContentsChanged(this, 0, this.getSize()-1);
    }
    
    /**
     * Liste Nach Luftdruck sortieren.
     */
    public void sortByPressure() {
        Collections.sort(destinations, new SortByPressure());
        this.fireContentsChanged(this, 0, this.getSize()-1);
    }
    
    /**
     * Liste nach Luftfeuchtigkeit sortieren.
     */
    public void sortByHumidity() {
        Collections.sort(destinations, new SortByHumidity());
        this.fireContentsChanged(this, 0, this.getSize()-1);
    }

    /**
     * Methode, um die Destinations-Liste zu bekommen.
     */
    public List<String> getDestinations() {
        return destinations;
    }
    
    /**
     * Methode zum Löschen eines Elementes aus der Destinations-Liste.
     * @param index Index, an welchem das Element gelöscht werden soll
     */
    public void delete(int index) {
        this.destinations.remove(index);
        this.fireContentsChanged(this, 0, this.getSize()-1);
    }

    /**
     * Methode, um ein bestimmtes Element aus der Liste zurückzubekommen.
     * @param index Index, an welchem das Element bekommen werden soll
     */
    @Override
    public String getElementAt(int index) {
       return this.destinations.get(index);
    }
}