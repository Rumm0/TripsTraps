import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test extends Application {
    @Override
    public void start(Stage peaLava) {

        // Nimede küsimine
        String nimi = "";
        String nimi2 = "";
        while (nimi.equals("") || nimi.length() > 17) {
            nimi = JOptionPane.showInputDialog(
                    null,
                    "Mängija 1 nimi:",
                    "Nime sisestamine", JOptionPane.QUESTION_MESSAGE);
        }
        while (nimi2.equals("") || nimi2.length() > 17 || nimi.equals(nimi2)) {
            nimi2 = JOptionPane.showInputDialog(
                    null,
                    "Mängija 2 nimi:",
                    "Nime sisestamine", JOptionPane.QUESTION_MESSAGE);
        }

        // Mängulaua ja Mängijate loomine
        MänguLaud laud = new MänguLaud();
        ArrayList<Mängija> mängijad = Alustaja(nimi, nimi2, laud);

        Label head = new Label("Käib: " + laud.getAktiivne().getNimi());
        head.setFont(new Font(30));
        /*Button ajalugu = new Button("Ajalugu");
        ajalugu.setPrefSize(150, 20);
        */

        GridPane g1 = new GridPane();
        g1.setHgap(10);
        g1.setVgap(10);

        // Nuppude moodustamine
        ArrayList<Button> buttonList = new ArrayList<>(9);
        for (int i = 0; i < 9; i++) {
            buttonList.add(new Button(" "));
            buttonList.get(i).setPrefSize(100, 100);
            buttonList.get(i).setFont(new Font(25));
        }

        // Nuppude klikkamised

        /*ajalugu.setOnAction(event -> {
            ajalugu();
            start(peaLava);
        });*/

        buttonList.get(0).setOnAction((ActionEvent event) -> {
            if (press(1, mängijad, laud)) {
                buttonList.get(0).setText(String.valueOf(laud.getAktiivne().XvõiO));
                head.setText("Käib: " + laud.getAktiivne().getNimi());
            }

        });
        buttonList.get(1).setOnAction((ActionEvent event) -> {
            if (press(2, mängijad, laud)) {
                buttonList.get(1).setText(String.valueOf(laud.getAktiivne().XvõiO));
                head.setText("Käib: " + laud.getAktiivne().getNimi());
            }

        });
        buttonList.get(2).setOnAction((ActionEvent event) -> {
            if (press(3, mängijad, laud)) {
                buttonList.get(2).setText(String.valueOf(laud.getAktiivne().XvõiO));
                head.setText("Käib: " + laud.getAktiivne().getNimi());
            }

        });
        buttonList.get(3).setOnAction((ActionEvent event) -> {
            if (press(4, mängijad, laud)) {
                buttonList.get(3).setText(String.valueOf(laud.getAktiivne().XvõiO));
                head.setText("Käib: " + laud.getAktiivne().getNimi());
            }

        });
        buttonList.get(4).setOnAction((ActionEvent event) -> {
            if (press(5, mängijad, laud)) {
                buttonList.get(4).setText(String.valueOf(laud.getAktiivne().XvõiO));
                head.setText("Käib: " + laud.getAktiivne().getNimi());
            }

        });
        buttonList.get(5).setOnAction((ActionEvent event) -> {
            if (press(6, mängijad, laud)) {
                buttonList.get(5).setText(String.valueOf(laud.getAktiivne().XvõiO));
                head.setText("Käib: " + laud.getAktiivne().getNimi());
            }

        });
        buttonList.get(6).setOnAction((ActionEvent event) -> {
            if (press(7, mängijad, laud)) {
                buttonList.get(6).setText(String.valueOf(laud.getAktiivne().XvõiO));
                head.setText("Käib: " + laud.getAktiivne().getNimi());
            }

        });
        buttonList.get(7).setOnAction((ActionEvent event) -> {
            if (press(8, mängijad, laud)) {
                buttonList.get(7).setText(String.valueOf(laud.getAktiivne().XvõiO));
                head.setText("Käib: " + laud.getAktiivne().getNimi());
            }

        });
        buttonList.get(8).setOnAction((ActionEvent event) -> {
            if (press(9, mängijad, laud)) {
                buttonList.get(8).setText(String.valueOf(laud.getAktiivne().XvõiO));
                head.setText("Käib: " + laud.getAktiivne().getNimi());
            }
        });
        // Nuppude ruudustikku paigutamine
        for (int i = 0; i < 9; i++) {
            GridPane.setConstraints(buttonList.get(i), (i % 3), (i / 3));
        }

        g1.getChildren().addAll(buttonList);
        g1.setPadding(new Insets(10));

        FlowPane flow = new FlowPane(Orientation.VERTICAL, 10, 10);
        flow.setColumnHalignment(HPos.CENTER);
        flow.setPadding(new Insets(20));
        flow.getChildren().addAll(head, g1/*, ajalugu*/);

        VBox vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(50));
        vBox.setMinHeight(200);
        vBox.getChildren().add(flow);

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().add(vBox);

        Scene stseen = new Scene(hBox, Color.SNOW);  // luuakse stseen
        peaLava.setTitle("Must ruut");  // lava tiitelribale pannakse tekst
        peaLava.setScene(stseen);  // lavale lisatakse stseen
        peaLava.show();  // lava tehakse nähtavaks
        this.lava = peaLava;

    }

    private Stage lava;

    // Meetod avab uue akna, mis võtab parameetriks võitja ja annab valiku, kas teha uus mäng, lõpetada või näidata ajalugu
    private void võit(Text võitja) {
        Button uuesti = new Button("Alusta uut mängu");
        Button lõpeta = new Button("Lõpeta mängimine");
        Button ajalugu = new Button("Ajalugu");
        uuesti.setPrefSize(150, 20);
        lõpeta.setPrefSize(150, 20);
        ajalugu.setPrefSize(150, 20);
        HBox valikud = new HBox();
        valikud.setPadding(new Insets(15, 12, 15, 12));
        valikud.setSpacing(10);
        valikud.setStyle("-fx-background-color: #336699;");
        valikud.getChildren().addAll(uuesti, lõpeta);
        BorderPane.setAlignment(võitja, Pos.CENTER);
        BorderPane.setAlignment(valikud, Pos.BOTTOM_CENTER);
        BorderPane.setAlignment(ajalugu, Pos.TOP_CENTER);
        BorderPane Mängulõpp = new BorderPane();
        Mängulõpp.setBottom(valikud);
        Mängulõpp.setCenter(võitja);
        Mängulõpp.setTop(ajalugu);
        Scene TeineStseen = new Scene(Mängulõpp, 300, 300);
        Stage MängLäbi = new Stage();
        MängLäbi.setTitle("Second Stage");
        MängLäbi.setScene(TeineStseen);

        MängLäbi.show();

        uuesti.setOnAction(event -> {
            MängLäbi.close();
            start(lava);
        });

        //Vajutades lõpeta, lõpetab programm töö
        lõpeta.setOnAction(event -> Platform.exit());
        //Ajalugu näitab mängijate nimesid ja mitu korda nad võitnud on
        ajalugu.setOnAction(event -> ajalugu());
    }

    private void ajalugu() {

        Map<String, String> tulemused = new HashMap<>();
        tulemused.put("Fail", "Puudu");
        try {
            tulemused = ajalugu(loeFailist());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
///////////////////////////////////////////////////////////////////////////////
        //https://stackoverflow.com/questions/18618653/binding-hashmap-with-tableview-javafx
        //Teeb Mapist TableView
        //////////////////////////////////////////////////
        // use fully detailed type for Map.Entry<String, String>
        TableColumn<Map.Entry<String, String>, String> column1 = new TableColumn<>("Nimi");
        column1.setCellValueFactory(p -> {
            // this callback returns property for just one cell, you can't use a loop here
            // for first column we use key
            return new SimpleStringProperty(p.getValue().getKey());
        });

        TableColumn<Map.Entry<String, String>, String> column2 = new TableColumn<>("Võite");
        column2.setCellValueFactory(p -> {
            // for second column we use value
            return new SimpleStringProperty(p.getValue().getValue());
        });

        ObservableList<Map.Entry<String, String>> items = FXCollections.observableArrayList(tulemused.entrySet());
        final TableView<Map.Entry<String, String>> table = new TableView<>(items);

        table.getColumns().setAll(column1, column2);
/////////////////////////////////////////////////////////////////////////////
        VBox vbox = new VBox(table);
        Scene scene = new Scene(vbox);
        lava.setScene(scene);
        lava.show();

    }


    // Meetod, mida käivitab nupuvajutus
    boolean press(int nr, ArrayList<Mängija> mängijad, MänguLaud laud) {
        if (MänguLaud.käik(laud, laud.getAktiivne(), nr)) {

            if (viigiKontroll(laud)) {
                võit(new Text("Viik"));
                aktiivneSwap(mängijad, laud);
                return true;
            } else if (kontroll(laud)) {
                võit(new Text("Võitja on: " + laud.getAktiivne().getNimi()));
                kirjuta(laud.getAktiivne().getNimi());
                aktiivneSwap(mängijad, laud);
                return true;
            } else {
                aktiivneSwap(mängijad, laud);
                return true;
            }

        }
        return false;
    }

    // Meetod kontrollib kas mäng on lõppenud viigiga
    boolean viigiKontroll(MänguLaud laud) {
        for (char[] elem : laud.getLaud()) {
            for (char elem2 : elem) {
                if (elem2 == '\u0000') {
                    return false;
                }
            }
        }
        return true;
    }

    //See meetod võtab parameetritena mängijate sisestatud nimed,
    // valib suvaliselt alustaja ning teeb kaks mängijat
    //ja väljastab nad arraylistis.
    public static ArrayList<Mängija> Alustaja(String nimi, String nimi2, MänguLaud laud) {
        int alustaja = (int) (Math.random() * 2);
        ArrayList<Mängija> mängijad = new ArrayList<>();
        if (alustaja == 0) {
            mängijad.add(new Mängija('O', nimi));
            mängijad.add(new Mängija('X', nimi2));
            laud.setAktiivne(mängijad.get(0));
        } else {
            mängijad.add(new Mängija('X', nimi));
            mängijad.add(new Mängija('O', nimi2));
            laud.setAktiivne(mängijad.get(1));
        }
        return mängijad;
    }

    //Meetod kontrollib kas antud laual on üks mängijatest võitnud
    public static boolean kontroll(MänguLaud laud) {
        for (int i = 0; i < 3; i++) {
            //Ridade kontroll
            if (laud.laud[i][0] == laud.laud[i][1] && laud.laud[i][1] == laud.laud[i][2] && laud.laud[i][0] != '\u0000') {
                return true;
            }//Veergude kontroll
            if (laud.laud[0][i] == laud.laud[1][i] && laud.laud[1][i] == laud.laud[2][i] && laud.laud[0][i] != '\u0000') {
                return true;
            }
        }//Diagonaalide kontrollid
        if (laud.laud[0][0] == laud.laud[1][1] && laud.laud[1][1] == laud.laud[2][2] && laud.laud[1][1] != '\u0000') {
            return true;
        }
        return laud.laud[0][2] == laud.laud[1][1] && laud.laud[1][1] == laud.laud[2][0] && laud.laud[1][1] != '\u0000';
    }

    // Meetod vahetab mängulaua aktiivse mängija
    public static void aktiivneSwap(ArrayList<Mängija> list, MänguLaud laud) {
        if (laud.getAktiivne().equals(list.get(0))) {
            laud.setAktiivne(list.get(1));
        } else {
            laud.setAktiivne(list.get(0));
        }
    }

    // meetod loeb logi failist informatsiooni listi
    private static List<String> loeFailist() throws FileNotFoundException {
        InputStream s;
        s = new FileInputStream("app.log");
        List<String> võitjad = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(s, "UTF-8"))) {
            while (bf.ready()) {
                võitjad.add(bf.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return võitjad;
    }

    // meetod teeb logi faili listist mapi, kus võtmeks on mängija nimi ja väärtuseks tema võitude arv
    private static Map<String, String> ajalugu(List<String> võitjad) {

        Map<String, String> ajalugu = new HashMap<>();
        for (String nimi : võitjad) {
            if (ajalugu.containsKey(nimi)) {
                ajalugu.put(nimi, Integer.toString(Integer.parseInt(ajalugu.get(nimi)) + 1));
            } else {
                ajalugu.put(nimi, Integer.toString(1));
            }
        }
        return ajalugu;
    }

    // Meetod kirjutab võidu korral võitja nime logi faili
    private void kirjuta(String tekst) {
        try (FileWriter writer = new FileWriter("app.log", true);
             BufferedWriter bw = new BufferedWriter(writer)) {
            bw.write(tekst);
            bw.newLine();

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

}

