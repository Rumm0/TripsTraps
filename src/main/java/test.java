import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.swing.*;
import java.util.ArrayList;

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
        flow.getChildren().addAll(head, g1);

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
    }
    @FXML
    private Label label;
    private boolean võit() {
        Button uuesti = new Button("Alusta uut mängu");
        if (uuesti.isPressed()) return false;
        Button lõpeta = new Button("Lõpeta mängimine");
        uuesti.setPrefSize(100, 20);
        lõpeta.setPrefSize(100, 20);
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");
        hbox.getChildren().addAll(uuesti, lõpeta);
        BorderPane.setAlignment(hbox, Pos.BOTTOM_CENTER);
        BorderPane secondaryLayout = new BorderPane();

        secondaryLayout.setBottom(hbox);


        Scene secondScene = new Scene(secondaryLayout, 250, 250);

        // New window (Stage)
        Stage newWindow = new Stage();
        newWindow.setTitle("Second Stage");
        newWindow.setScene(secondScene);

        // Set position of second window, related to primary window

        newWindow.show();
        return true;
    }
    // Meetod, mida käivitab nupuvajutus

    boolean press(int nr, ArrayList<Mängija> mängijad, MänguLaud laud) {
        if (MänguLaud.käik(laud, laud.getAktiivne(), nr)) {
            //buttonString = String.valueOf(laud.getLaud()[((nr - 1) / 3)][(nr - 1) % 3]);
                if (kontroll(laud)){
                    võit();
                }
            }
            if (viigiKontroll(laud)) {
                //////////////////// viik /////////////////////////////////
                Platform.exit();
            }
            aktiivneSwap(mängijad, laud);
            return true;
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

}

