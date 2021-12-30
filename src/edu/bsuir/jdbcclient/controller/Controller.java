package edu.bsuir.jdbcclient.controller;

import edu.bsuir.jdbcclient.client.Client;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class Controller {

    private Client client = new Client();
    private String data = null;

    @FXML
    private TextField field_for_ip;

    @FXML
    private TextField field_for_port;

    @FXML
    private TextField field_for_data;

    @FXML
    private TextArea results_output;

    @FXML
    private Button connectbutton;

    @FXML
    public Button sendbutton;

    public void initialize(){

        field_for_ip.setText("localhost");
        field_for_port.setText("8080");

        connectbutton.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            try {
                client.connectionCreate("localhost",8080);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        sendbutton.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            try {
                String serverWord = client.dataSendAndTake(field_for_data.getText());
                results_output.setText(serverWord);
                client.streamsClose();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

}

