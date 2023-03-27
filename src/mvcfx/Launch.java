package mvcfx;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launch extends Application {
    
    private static Stage stage;
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;        
        Parent root = FXMLLoader.load(getClass().getResource("view/LoginView.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sistema de Cadastro");        
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getStage() {
        return stage;
    }
    
    
    
}
