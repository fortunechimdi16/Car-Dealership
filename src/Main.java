import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private VBox vbox;
    private HBox hbox;
    private Label count, heading, carText;
    private Button viewDetails;
    private ChoiceBox<String> choice;
    private Car current;
    private ImageView imgView;
    private Image image;
    private Dealership dealership;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        dealership = new Dealership();
        dealership.initializeInventory();

        heading = new Label("Car Dealership Inventory");
        heading.setStyle("-fx-font-family:'Verdana'; -fx-font-size 20; -fx-font-weight:bold;");
        count = new Label(dealership.toString());

        String[] names = {"2018 Lexus Lx570", "2019 Mercedes Benz", "2021 Toyota Camry", "2022 Porsche Cayman"};

        Label select = new Label("Select a car:");

        choice = new ChoiceBox<>();
        choice.getItems().addAll(names);
        choice.setOnAction(this::processChoice);

        viewDetails = new Button("View Details");
        viewDetails.setAlignment(Pos.CENTER);
        viewDetails.setOnAction(this::processButtonPush);

        carText = new Label("");

        imgView = new ImageView();
        imgView.setFitWidth(100);
        imgView.setPreserveRatio(true);

        hbox = new HBox(imgView, carText);
        hbox.setPadding(new Insets(16, 16, 16, 25));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: White");

        vbox = new VBox(heading, count, select, choice, viewDetails, hbox);
        vbox.setSpacing(10);
        vbox.setStyle("-fx-background-color:Lavender");
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setPrefSize(450, 500);

        Group root = new Group(vbox);
        Scene scene = new Scene(root, 450, 500);
        primaryStage.setTitle("Car Dealership");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void processChoice(ActionEvent event) {
       current = dealership.inventory.get(choice.getSelectionModel().getSelectedIndex());

    }

    private void processButtonPush(ActionEvent event) {
       carText.setText(current.toString());
       Image img = new Image(current.carImage);
       imgView.setImage(img);

        }
    }



