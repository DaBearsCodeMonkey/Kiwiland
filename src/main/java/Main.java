import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage){
        this.stage = stage;
        this.stage.setTitle("Kiwiland");
        initRootlayout();
    }

    private void initRootlayout(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("view/main.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }

        catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
