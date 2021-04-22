package sample;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtUnsortedArray;

    @FXML
    private TextField txtAscOrder;

    @FXML
    private TextField txtSortedArray;

    @FXML
    private Button btnSort;

    @FXML
    private Button btnQuit;

    @FXML
    void btnQuitOnAction(ActionEvent event) {
        Platform.exit();
    }

    public void sort(int[] arrayToSort, boolean sortOrder)
    {int max = Arrays.stream(arrayToSort).max().getAsInt();
        int min = Arrays.stream(arrayToSort).min().getAsInt();
        int range = max - min + 1;
        int count[] = new int[range];
        int output[] = new int[arrayToSort.length];
        for (int i = 0; i < arrayToSort.length; i++) {
            count[arrayToSort[i] - min]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = arrayToSort.length - 1; i >= 0; i--) {
            output[count[arrayToSort[i] - min] - 1] = arrayToSort[i];
            count[arrayToSort[i] - min]--;
        }

        for (int i = 0; i < arrayToSort.length; i++) {
            arrayToSort[i] = output[i];
        }

        if (sortOrder == false)
        {
            for (int i = 0; i < arrayToSort.length/2; i++)
            {
                int temp = arrayToSort[i];
                arrayToSort[i] = arrayToSort[arrayToSort.length - i - 1];
                arrayToSort[arrayToSort.length - i - 1] = temp;
            }
        }

        String toPresent = "[";
        for(int i = 0; i < arrayToSort.length; i++)
        {
            toPresent = String.format("%s %d", toPresent, arrayToSort[i]);
        }
        toPresent += "]";

        txtSortedArray.setText(toPresent);
    }

    @FXML
    void btnSortOnAction(ActionEvent event) {
        String[] contentUnsorted = txtUnsortedArray.getText().split(" ");
        int[] unsorted = new int[contentUnsorted.length];

        for (int i = 0; i < contentUnsorted.length; i++)
        {
            unsorted[i] = Integer.parseInt(contentUnsorted[i]);
        }

        String type = txtAscOrder.getText();

        sort(unsorted, type.compareTo("Y") == 0 || type.compareTo("y") == 0);
    }

    @FXML
    void initialize() {
        assert txtUnsortedArray != null : "fx:id=\"txtUnsortedArray\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtAscOrder != null : "fx:id=\"txtAscOrder\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtSortedArray != null : "fx:id=\"txtSortedArray\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnSort != null : "fx:id=\"btnSort\" was not injected: check your FXML file 'sample.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'sample.fxml'.";

    }
}
