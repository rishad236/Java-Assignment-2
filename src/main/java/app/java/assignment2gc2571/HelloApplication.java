public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("phone_view.fxml"));
        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setTitle("Phone Info");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
