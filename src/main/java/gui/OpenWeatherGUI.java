package gui;

import bl.DestinationListModel;
import data.Liste;
import data.OpenWeatherResponse;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.OpenWeather_Icons_Client;
import net.OpenWeather_Weather_Client;

/**
 * GUI - Klasse
 * 
 * @author Herbert Seewann
 */
public class OpenWeatherGUI extends javax.swing.JFrame {

    private DestinationListModel model;
    private OpenWeather_Weather_Client owc;
    private OpenWeatherResponse owr;
    private OpenWeather_Icons_Client oic;
    private ArrayList<Liste> day1, day2, day3, day4, day5;
    
    /**
     * GUI-Konstruktor.
     */
    public OpenWeatherGUI() {
        try {
            initComponents();
            model = new DestinationListModel();
            liList.setModel(model);
            
            model.loadXML();
            
            owc = new OpenWeather_Weather_Client();
            oic = new OpenWeather_Icons_Client();

            this.setButtonDays();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Hier wird der Forecast-String auf 5 Listen aufgeteilt.
     */
    public void filterForecast() {
        day1 = new ArrayList<>();
        day2 = new ArrayList<>();
        day3 = new ArrayList<>();
        day4 = new ArrayList<>();
        day5 = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        ArrayList<Liste> list = owr.getList();
        for(int i = 0; i < list.size(); i++) {
            Liste l = list.get(i);
            LocalDateTime ld = LocalDateTime.parse(l.getDt_txt(), DateTimeFormatter.ofPattern("yyyy-MM-DD HH:mm:ss")); 
            String dayOfWeek = ld.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.GERMANY);
            if(dayOfWeek.equals(LocalDateTime.now().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.GERMANY))) {
                day1.add(l);
            } else if (dayOfWeek.equals(LocalDateTime.now().plusDays(1).getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.GERMANY))) {
                day2.add(l);
            } else if (dayOfWeek.equals(LocalDateTime.now().plusDays(2).getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.GERMANY))) {
                day3.add(l);
            } else if (dayOfWeek.equals(LocalDateTime.now().plusDays(3).getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.GERMANY))) {
                day4.add(l);
            } else if (dayOfWeek.equals(LocalDateTime.now().plusDays(4).getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.GERMANY))) {
                day5.add(l);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spListPane = new javax.swing.JScrollPane();
        liList = new javax.swing.JList<>();
        paCurrentWeather = new javax.swing.JPanel();
        lbDate = new javax.swing.JLabel();
        tfDate = new javax.swing.JTextField();
        lbTemp = new javax.swing.JLabel();
        tfTemp = new javax.swing.JTextField();
        lbTempMin = new javax.swing.JLabel();
        tfTempMin = new javax.swing.JTextField();
        lbTempMax = new javax.swing.JLabel();
        tfTempMax = new javax.swing.JTextField();
        lbPressure = new javax.swing.JLabel();
        tfPressure = new javax.swing.JTextField();
        lbHumidity = new javax.swing.JLabel();
        tfHumidity = new javax.swing.JTextField();
        paWeatherForecast = new javax.swing.JPanel();
        btToday = new javax.swing.JButton();
        btDay2 = new javax.swing.JButton();
        btDay3 = new javax.swing.JButton();
        btDay4 = new javax.swing.JButton();
        btDay5 = new javax.swing.JButton();
        paAnzeige = new javax.swing.JPanel();
        uhrzeit1 = new javax.swing.JLabel();
        uhrzeit2 = new javax.swing.JLabel();
        uhrzeit3 = new javax.swing.JLabel();
        uhrzeit4 = new javax.swing.JLabel();
        uhrzeit5 = new javax.swing.JLabel();
        uhrzeit6 = new javax.swing.JLabel();
        uhrzeit7 = new javax.swing.JLabel();
        uhrzeit8 = new javax.swing.JLabel();
        icon1 = new javax.swing.JLabel();
        icon2 = new javax.swing.JLabel();
        icon3 = new javax.swing.JLabel();
        icon4 = new javax.swing.JLabel();
        icon5 = new javax.swing.JLabel();
        icon6 = new javax.swing.JLabel();
        icon7 = new javax.swing.JLabel();
        icon8 = new javax.swing.JLabel();
        description1 = new javax.swing.JLabel();
        description2 = new javax.swing.JLabel();
        description3 = new javax.swing.JLabel();
        description4 = new javax.swing.JLabel();
        description5 = new javax.swing.JLabel();
        description6 = new javax.swing.JLabel();
        description7 = new javax.swing.JLabel();
        description8 = new javax.swing.JLabel();
        mbMenuBar = new javax.swing.JMenuBar();
        meDestination = new javax.swing.JMenu();
        miAdd = new javax.swing.JMenuItem();
        miDel = new javax.swing.JMenuItem();
        meSort = new javax.swing.JMenu();
        miTemp = new javax.swing.JMenuItem();
        miPressure = new javax.swing.JMenuItem();
        meHummidity = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("OpenWeatherGUI");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        liList.setBorder(javax.swing.BorderFactory.createTitledBorder("Städte"));
        liList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                liListMouseClicked(evt);
            }
        });
        spListPane.setViewportView(liList);

        paCurrentWeather.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Current Weather ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        paCurrentWeather.setLayout(new java.awt.GridLayout(6, 2));

        lbDate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbDate.setText("Date");
        paCurrentWeather.add(lbDate);

        tfDate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfDate.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        tfDate.setMinimumSize(new java.awt.Dimension(28, 15));
        tfDate.setName(""); // NOI18N
        tfDate.setPreferredSize(new java.awt.Dimension(28, 15));
        paCurrentWeather.add(tfDate);

        lbTemp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbTemp.setText("Temperature");
        paCurrentWeather.add(lbTemp);

        tfTemp.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        paCurrentWeather.add(tfTemp);

        lbTempMin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbTempMin.setText("Temperature (min)");
        paCurrentWeather.add(lbTempMin);

        tfTempMin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        paCurrentWeather.add(tfTempMin);

        lbTempMax.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbTempMax.setText("Temperature (max)");
        paCurrentWeather.add(lbTempMax);

        tfTempMax.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        paCurrentWeather.add(tfTempMax);

        lbPressure.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbPressure.setText("Pressure");
        paCurrentWeather.add(lbPressure);

        tfPressure.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        paCurrentWeather.add(tfPressure);

        lbHumidity.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbHumidity.setText("Humidity");
        paCurrentWeather.add(lbHumidity);

        tfHumidity.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        paCurrentWeather.add(tfHumidity);

        paWeatherForecast.setBorder(javax.swing.BorderFactory.createTitledBorder("Wetter Vorhersage - Nächsten 5 Tage"));

        btToday.setText("Heute");
        btToday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTodayActionPerformed(evt);
            }
        });

        btDay2.setText("Morgen");
        btDay2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDay2ActionPerformed(evt);
            }
        });

        btDay3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDay3ActionPerformed(evt);
            }
        });

        btDay4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDay4ActionPerformed(evt);
            }
        });

        btDay5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDay5ActionPerformed(evt);
            }
        });

        paAnzeige.setLayout(new java.awt.GridLayout(3, 8));

        uhrzeit1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        uhrzeit1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paAnzeige.add(uhrzeit1);

        uhrzeit2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        uhrzeit2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paAnzeige.add(uhrzeit2);

        uhrzeit3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        uhrzeit3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paAnzeige.add(uhrzeit3);

        uhrzeit4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        uhrzeit4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paAnzeige.add(uhrzeit4);

        uhrzeit5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        uhrzeit5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paAnzeige.add(uhrzeit5);

        uhrzeit6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        uhrzeit6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paAnzeige.add(uhrzeit6);

        uhrzeit7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        uhrzeit7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paAnzeige.add(uhrzeit7);

        uhrzeit8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        uhrzeit8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paAnzeige.add(uhrzeit8);

        icon1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paAnzeige.add(icon1);

        icon2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paAnzeige.add(icon2);

        icon3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paAnzeige.add(icon3);

        icon4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paAnzeige.add(icon4);

        icon5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paAnzeige.add(icon5);

        icon6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paAnzeige.add(icon6);

        icon7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paAnzeige.add(icon7);

        icon8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paAnzeige.add(icon8);

        description1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paAnzeige.add(description1);

        description2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paAnzeige.add(description2);

        description3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paAnzeige.add(description3);

        description4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paAnzeige.add(description4);

        description5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paAnzeige.add(description5);

        description6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paAnzeige.add(description6);

        description7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paAnzeige.add(description7);

        description8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paAnzeige.add(description8);

        javax.swing.GroupLayout paWeatherForecastLayout = new javax.swing.GroupLayout(paWeatherForecast);
        paWeatherForecast.setLayout(paWeatherForecastLayout);
        paWeatherForecastLayout.setHorizontalGroup(
            paWeatherForecastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paWeatherForecastLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btToday, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btDay2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btDay3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btDay5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btDay4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(paWeatherForecastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(paWeatherForecastLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(paAnzeige, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        paWeatherForecastLayout.setVerticalGroup(
            paWeatherForecastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paWeatherForecastLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paWeatherForecastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paWeatherForecastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btToday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btDay2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btDay3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btDay4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btDay5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(231, Short.MAX_VALUE))
            .addGroup(paWeatherForecastLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paWeatherForecastLayout.createSequentialGroup()
                    .addContainerGap(65, Short.MAX_VALUE)
                    .addComponent(paAnzeige, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        meDestination.setText("Destination");

        miAdd.setText("Add ");
        miAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAddActionPerformed(evt);
            }
        });
        meDestination.add(miAdd);

        miDel.setText("Delete");
        miDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miDelActionPerformed(evt);
            }
        });
        meDestination.add(miDel);

        mbMenuBar.add(meDestination);

        meSort.setText("Sort");

        miTemp.setText("by Temperature");
        miTemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miTempActionPerformed(evt);
            }
        });
        meSort.add(miTemp);

        miPressure.setText("by Pressure");
        miPressure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPressureActionPerformed(evt);
            }
        });
        meSort.add(miPressure);

        meHummidity.setText("by Hummidity");
        meHummidity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meHummidityActionPerformed(evt);
            }
        });
        meSort.add(meHummidity);

        mbMenuBar.add(meSort);

        setJMenuBar(mbMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paCurrentWeather, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paWeatherForecast, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spListPane, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spListPane)
            .addGroup(layout.createSequentialGroup()
                .addComponent(paCurrentWeather, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paWeatherForecast, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Mit dieser Methode wird eine Destination zur Liste hinzugefügt.
     */
    private void miAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAddActionPerformed
        try {
            String destination = JOptionPane.showInputDialog(this, "Bitte Ort eingeben:", 
                    "Destination hinzugüfen", JOptionPane.INFORMATION_MESSAGE);
            if(destination != null && !destination.equals("")) {
                this.model.add(destination);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_miAddActionPerformed

    /**
     * Mit dieser Methode wird eine Destination von der Liste entfernt.
     */
    private void miDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miDelActionPerformed
        try {
            int index = liList.getSelectedIndex();
            if (index == -1) {
                JOptionPane.showMessageDialog(this, "Keine Destination ausgewählt!", "Fehler", JOptionPane.WARNING_MESSAGE);
            } else if(JOptionPane.showConfirmDialog(this, "Ausgewählte Destination wirklich löschen?", "Destination löschen", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                 model.delete(index);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_miDelActionPerformed

    /**
     * Diese Methode speichert beim Schließen des Fensters die Destination-Liste in einer XML-Datei.
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            this.model.saveXML(this.model.getDestinations());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * Durch diese Methode wird nach der Auswahl einer Destination das aktuelle Wetter angezeigt.
     */
    private void liListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_liListMouseClicked
        changeDaten(); 
    }//GEN-LAST:event_liListMouseClicked

    /**
     * Wettervorhersage Heute.
     */
    private void btTodayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTodayActionPerformed
        setdaten(day1);
        setIconsAndDescriptions(day1);
    }//GEN-LAST:event_btTodayActionPerformed

    /**
     * Wettervorhersage Tag 2.
     */
    private void btDay2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDay2ActionPerformed
        setdaten(day2);
        setIconsAndDescriptions(day2);
    }//GEN-LAST:event_btDay2ActionPerformed

    /**
     * Wettervorhersage Tag 3.
     */
    private void btDay3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDay3ActionPerformed
        setdaten(day3);
        setIconsAndDescriptions(day3);
    }//GEN-LAST:event_btDay3ActionPerformed

    /**
     * Wettervorhersage Tag 4.
     */
    private void btDay4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDay4ActionPerformed
        setdaten(day4);
        setIconsAndDescriptions(day4);
    }//GEN-LAST:event_btDay4ActionPerformed

    /**
     * Wettervorhersage Tag 5.
     */
    private void btDay5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDay5ActionPerformed
        setdaten(day5);
        setIconsAndDescriptions(day5);
    }//GEN-LAST:event_btDay5ActionPerformed

    /**
     * Wetterdaten für nächsten Eintrag setzen.
     * @param list Liste mit Wetterdaten für die kommenden Tage
     */
    public void setdaten(ArrayList<Liste> list) {
        try {
            Liste l = list.get(0);
            tfDate.setText(l.getDt_txt());
            tfTemp.setText(String.format("%.2f°C", l.getMain().getTemp()));
            tfTempMax.setText(String.format("%.2f°C", l.getMain().getTemp_max()));
            tfTempMin.setText(String.format("%.2f°C", l.getMain().getTemp_min()));
            tfHumidity.setText(l.getMain().getHumidity()+"");
            tfPressure.setText(l.getMain().getPressure()+"");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Liste nach Temperatur sortieren.
     */
    private void miTempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miTempActionPerformed
        try {
            model.sortByTemperature();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_miTempActionPerformed

    /**
     * Liste nach Luftdruck sortieren.
     */
    private void miPressureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPressureActionPerformed
        try {
            model.sortByPressure();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_miPressureActionPerformed

    /**
     * Liste nach Luftfeuchtigkeit sortieren.
     */
    private void meHummidityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meHummidityActionPerformed
        try {
            model.sortByHumidity();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_meHummidityActionPerformed

    /**
     * Icons für die Wettervorhersage setzen.
     * @param list Liste mit Wetterdaten für die kommenden Tage
     */
    public void setIconsAndDescriptions(ArrayList<Liste> list) {
        try {
            for (int i = 0; i < list.size(); i++) {
                Liste l = list.get(i);
                String picId = l.getWeather().get(0).getIcon();
                ImageIcon icon = oic.getIcon(picId);
                String uhrzeit = l.getDt_txt().substring(11, 16);
                switch(i) {
                    case 1:
                        icon1.setIcon(icon);
                        description1.setText(l.getWeather().get(0).getDescription());
                        uhrzeit1.setText(uhrzeit);
                        break;
                    case 2:
                        icon2.setIcon(icon);
                        description2.setText(l.getWeather().get(0).getDescription());
                        uhrzeit2.setText(uhrzeit);
                        break;
                    case 3:
                        icon3.setIcon(icon);
                        description3.setText(l.getWeather().get(0).getDescription());
                        uhrzeit3.setText(uhrzeit);
                        break;
                    case 4:
                        icon4.setIcon(icon);
                        description4.setText(l.getWeather().get(0).getDescription());
                        uhrzeit4.setText(uhrzeit);
                        break;
                    case 5:
                        icon5.setIcon(icon);
                        description5.setText(l.getWeather().get(0).getDescription());
                        uhrzeit5.setText(uhrzeit);
                        break;
                    case 6:
                        icon6.setIcon(icon);
                        description6.setText(l.getWeather().get(0).getDescription());
                        uhrzeit6.setText(uhrzeit);
                        break;
                    case 7:
                        icon7.setIcon(icon);
                        description7.setText(l.getWeather().get(0).getDescription());
                        uhrzeit7.setText(uhrzeit);
                        break;
                    case 8:
                        icon8.setIcon(icon);
                        description8.setText(l.getWeather().get(0).getDescription());
                        uhrzeit8.setText(uhrzeit);
                        break;
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Durch diese Methode werden die Wetterdaten bei Destination-Auswahl geändert.
     */
    public void changeDaten() {
        try {
            int index = liList.getSelectedIndex();
            String city = model.getElementAt(index);
            owr = owc.getForecast(city);
            this.filterForecast();
            Liste l = day1.get(0);

            tfDate.setText(l.getDt_txt());
            tfTemp.setText(String.format("%.2f°C", l.getMain().getTemp()));
            tfTempMax.setText(String.format("%.2f°C", l.getMain().getTemp_max()));
            tfTempMin.setText(String.format("%.2f°C", l.getMain().getTemp_min()));
            tfHumidity.setText(l.getMain().getHumidity() + "%");
            tfPressure.setText(l.getMain().getPressure() + "");
            setIconsAndDescriptions(day1);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Button-Beschriftungen setzen.
     */
    public void setButtonDays() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
            Calendar c = Calendar.getInstance();
            c.setTime(new Date());
            c.add(Calendar.DAY_OF_WEEK, 2);
            btDay3.setText(sdf.format(c.getTime()));
            c.add(Calendar.DAY_OF_WEEK, 1);
            btDay4.setText(sdf.format(c.getTime()));
            c.add(Calendar.DAY_OF_WEEK, 1);
            btDay5.setText(sdf.format(c.getTime()));
            c.add(Calendar.DAY_OF_WEEK, 1);
            btDay5.setText(sdf.format(c.getTime()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OpenWeatherGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OpenWeatherGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OpenWeatherGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OpenWeatherGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OpenWeatherGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDay2;
    private javax.swing.JButton btDay3;
    private javax.swing.JButton btDay4;
    private javax.swing.JButton btDay5;
    private javax.swing.JButton btToday;
    private javax.swing.JLabel description1;
    private javax.swing.JLabel description2;
    private javax.swing.JLabel description3;
    private javax.swing.JLabel description4;
    private javax.swing.JLabel description5;
    private javax.swing.JLabel description6;
    private javax.swing.JLabel description7;
    private javax.swing.JLabel description8;
    private javax.swing.JLabel icon1;
    private javax.swing.JLabel icon2;
    private javax.swing.JLabel icon3;
    private javax.swing.JLabel icon4;
    private javax.swing.JLabel icon5;
    private javax.swing.JLabel icon6;
    private javax.swing.JLabel icon7;
    private javax.swing.JLabel icon8;
    private javax.swing.JLabel lbDate;
    private javax.swing.JLabel lbHumidity;
    private javax.swing.JLabel lbPressure;
    private javax.swing.JLabel lbTemp;
    private javax.swing.JLabel lbTempMax;
    private javax.swing.JLabel lbTempMin;
    private javax.swing.JList<String> liList;
    private javax.swing.JMenuBar mbMenuBar;
    private javax.swing.JMenu meDestination;
    private javax.swing.JMenuItem meHummidity;
    private javax.swing.JMenu meSort;
    private javax.swing.JMenuItem miAdd;
    private javax.swing.JMenuItem miDel;
    private javax.swing.JMenuItem miPressure;
    private javax.swing.JMenuItem miTemp;
    private javax.swing.JPanel paAnzeige;
    private javax.swing.JPanel paCurrentWeather;
    private javax.swing.JPanel paWeatherForecast;
    private javax.swing.JScrollPane spListPane;
    private javax.swing.JTextField tfDate;
    private javax.swing.JTextField tfHumidity;
    private javax.swing.JTextField tfPressure;
    private javax.swing.JTextField tfTemp;
    private javax.swing.JTextField tfTempMax;
    private javax.swing.JTextField tfTempMin;
    private javax.swing.JLabel uhrzeit1;
    private javax.swing.JLabel uhrzeit2;
    private javax.swing.JLabel uhrzeit3;
    private javax.swing.JLabel uhrzeit4;
    private javax.swing.JLabel uhrzeit5;
    private javax.swing.JLabel uhrzeit6;
    private javax.swing.JLabel uhrzeit7;
    private javax.swing.JLabel uhrzeit8;
    // End of variables declaration//GEN-END:variables
}
