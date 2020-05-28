package Controller;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PainelAdmController implements Initializable {

    public Stage primaryStage;
    public Stage userStage;
    public PainelUserController apresentador;

    @FXML private Label preferencial_atual;
    private int p_atual = 0;
    @FXML private Label preferencial_anterior;
    private int p_anterior = 0;
    @FXML private Label preferencial_seguinte;
    private int p_seguinte = 1;
    @FXML private Label comum_atual;
    private int c_atual = 0;
    @FXML private Label comum_anterior;
    private int c_anterior = 0;
    @FXML private Label comum_seguinte;
    private int c_seguinte = 1;

    @FXML public void avancar_comum(ActionEvent event) {
        if(c_atual == 0){
            c_atual = c_atual+1;
            System.out.println(c_atual);
            c_seguinte = c_seguinte+1;
            apresentador.senha_atual.setText(String.valueOf(c_atual));
            comum_atual.setText(String.valueOf(c_atual));
            comum_seguinte.setText(String.valueOf(c_seguinte));
            apresentador.senha_anterior5.setText(apresentador.senha_anterior4.getText());
            apresentador.senha_anterior4.setText(apresentador.senha_anterior3.getText());
            apresentador.senha_anterior3.setText(apresentador.senha_anterior2.getText());
            apresentador.senha_anterior2.setText(apresentador.senha_anterior1.getText());
            apresentador.senha_anterior1.setText(apresentador.senha_atual.getText());
        }else{
            c_anterior = c_atual;
            c_atual = c_atual+1;
            c_seguinte = c_atual+1;
            apresentador.senha_anterior5.setText(apresentador.senha_anterior4.getText());
            apresentador.senha_anterior4.setText(apresentador.senha_anterior3.getText());
            apresentador.senha_anterior3.setText(apresentador.senha_anterior2.getText());
            apresentador.senha_anterior2.setText(apresentador.senha_anterior1.getText());
            apresentador.senha_anterior1.setText(apresentador.senha_atual.getText());
            apresentador.senha_atual.setText(String.valueOf(c_atual));
            comum_anterior.setText(String.valueOf(c_anterior));
            comum_atual.setText(String.valueOf(c_atual));
            comum_seguinte.setText(String.valueOf(c_seguinte));
        }
    }

    @FXML public void avancar_preferencial(ActionEvent event) {
        if(p_atual == 0){
            p_atual = p_atual+1;
            p_seguinte = p_seguinte+1;
            apresentador.senha_atual.setText("P-"+String.valueOf(p_atual));
            preferencial_atual.setText("P-"+String.valueOf(p_atual));
            preferencial_seguinte.setText("P-"+String.valueOf(p_seguinte));
            apresentador.senha_anterior5.setText(apresentador.senha_anterior4.getText());
            apresentador.senha_anterior4.setText(apresentador.senha_anterior3.getText());
            apresentador.senha_anterior3.setText(apresentador.senha_anterior2.getText());
            apresentador.senha_anterior2.setText(apresentador.senha_anterior1.getText());
            apresentador.senha_anterior1.setText(apresentador.senha_atual.getText());
        }else{
            p_anterior = p_atual;
            p_atual = p_atual+1;
            p_seguinte = p_atual+1;
            apresentador.senha_anterior5.setText(apresentador.senha_anterior4.getText());
            apresentador.senha_anterior4.setText(apresentador.senha_anterior3.getText());
            apresentador.senha_anterior3.setText(apresentador.senha_anterior2.getText());
            apresentador.senha_anterior2.setText(apresentador.senha_anterior1.getText());
            apresentador.senha_anterior1.setText(apresentador.senha_atual.getText());
            apresentador.senha_atual.setText("P-"+String.valueOf(p_atual));
            preferencial_anterior.setText("P-"+String.valueOf(p_anterior));
            preferencial_atual.setText("P-"+String.valueOf(p_atual));
            preferencial_seguinte.setText("P-"+String.valueOf(p_seguinte));
        }
    }

    @FXML public void voltar_comum(ActionEvent event) {
        if(c_atual == 0){
            System.out.println("nao pode");
        }else{
             c_seguinte = c_atual;
             c_atual = c_anterior;
             c_anterior = c_anterior-1;
            apresentador.senha_anterior5.setText(apresentador.senha_anterior4.getText());
            apresentador.senha_anterior4.setText(apresentador.senha_anterior3.getText());
            apresentador.senha_anterior3.setText(apresentador.senha_anterior2.getText());
            apresentador.senha_anterior2.setText(apresentador.senha_anterior1.getText());
            apresentador.senha_anterior1.setText(apresentador.senha_atual.getText());
            apresentador.senha_atual.setText(String.valueOf(c_atual));
            comum_anterior.setText(String.valueOf(c_anterior));
            comum_atual.setText(String.valueOf(c_atual));
            comum_seguinte.setText(String.valueOf(c_seguinte));
        }
    }

    @FXML public void voltar_preferencial(ActionEvent event) {
        if(p_atual == 0){
            System.out.println("nao pode");
        }else{
            p_seguinte = p_atual;
            p_atual = p_anterior;
            p_anterior = p_anterior-1;
            apresentador.senha_anterior5.setText(apresentador.senha_anterior4.getText());
            apresentador.senha_anterior4.setText(apresentador.senha_anterior3.getText());
            apresentador.senha_anterior3.setText(apresentador.senha_anterior2.getText());
            apresentador.senha_anterior2.setText(apresentador.senha_anterior1.getText());
            apresentador.senha_anterior1.setText(apresentador.senha_atual.getText());
            apresentador.senha_atual.setText(String.valueOf(p_atual));
            preferencial_anterior.setText(String.valueOf(p_anterior));
            preferencial_atual.setText(String.valueOf(p_atual));
            preferencial_seguinte.setText(String.valueOf(p_seguinte));
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

            Platform.runLater(()-> {
                try{
                userStage = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXMLView/Painel_user.fxml"));
                VBox root = loader.load();
                userStage.setScene(new Scene(root));
                userStage.setTitle("SGA - Sistema de Gerenciamento de Atendimento");
                PainelUserController controller = loader.getController();
                controller.primaryStage = userStage;
                apresentador = controller;
                userStage.show();

                } catch (IOException e) {
                    e.printStackTrace();
                }

                comum_atual.setText(String.valueOf(c_atual));
                comum_anterior.setText(String.valueOf(c_anterior));
                comum_seguinte.setText(String.valueOf(c_seguinte));

                preferencial_atual.setText("P-"+p_atual);
                preferencial_anterior.setText("P-"+p_anterior);
                preferencial_seguinte.setText("P-"+p_seguinte);

                apresentador.senha_anterior1.setText("");
                apresentador.senha_anterior2.setText("");
                apresentador.senha_anterior3.setText("");
                apresentador.senha_anterior4.setText("");
                apresentador.senha_anterior5.setText("");
                apresentador.senha_atual.setText("0");
            });



    }
}
