import Controller.PainelAdmController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {



    @Override public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXMLView/Painel_adm.fxml"));
        VBox root = loader.load();

        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("SGA - Sistema de Gerenciamento de Atendimento");
        PainelAdmController controller = loader.getController();
        controller.primaryStage = primaryStage;

        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
