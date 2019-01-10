package Controllers;

import javafx.event.ActionEvent;
import javafx.stage.FileChooser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ImportButtonController {

    private MainController mainController;


    void initialize(MainController mainController){
        this.mainController = mainController;
    }

    public void importFile(ActionEvent event){
        String trainStations[] = null;
        FileChooser fileChooser = new FileChooser();
        File file;
        String user = System.getProperty("user.name");
        fileChooser.setTitle("Open Text file");
        fileChooser.setInitialDirectory(new File(String.format("C:\\Users\\%s\\Downloads", user)));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT file", "*txt"));
        file = fileChooser.showOpenDialog(null);

        if(file != null) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                trainStations = br.readLine().replace(",","").split(" ");
            }

            catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        mainController.startUpKiwiland(trainStations);
    }


}
