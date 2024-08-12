package ca.georgiancollege2330;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PhoneViewController {

    @FXML
    private TableView<Phone> phoneTable;
    @FXML
    private TableColumn<Phone, String> brandColumn;
    @FXML
    private TableColumn<Phone, String> modelColumn;
    @FXML
    private TableColumn<Phone, String> osColumn;
    @FXML
    private TableColumn<Phone, String> screenSizeColumn;
    @FXML
    private TableColumn<Phone, String> priceColumn;

    private final ObservableList<Phone> phones = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        // Set up columns
        brandColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
        osColumn.setCellValueFactory(new PropertyValueFactory<>("os"));
        screenSizeColumn.setCellValueFactory(new PropertyValueFactory<>("screenSize"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        // Load data
        loadPhoneData();
    }

    private void loadPhoneData() {
        String apiUrl = "https://api.example.com/phones"; // Replace with a real API

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
            connection.setRequestMethod("GET");

            InputStreamReader reader = new InputStreamReader(connection.getInputStream());
            JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();

            for (JsonElement element : jsonArray) {
                String brand = element.getAsJsonObject().get("brand").getAsString();
                String model = element.getAsJsonObject().get("model").getAsString();
                String os = element.getAsJsonObject().get("os").getAsString();
                String screenSize = element.getAsJsonObject().get("screen_size").getAsString();
                String price = element.getAsJsonObject().get("price").getAsString();

                phones.add(new Phone(brand, model, os, screenSize, price));
            }

            phoneTable.setItems(phones);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
