package com.edmundsassoc.mcsj.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.edmundsassoc.mcsj.entity.Vnmast;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConsumeJSON extends Application {

  private ObservableList<Vnmast> listOfPeople;
  private static final String JSON_URL = "http://localhost:8080/mcsj/vnmasts";
  private static final String IMAGE_URL = "http://www.fontspring.com/presentation_20150512/images/ajax_loader_blue_512.gif";
  private final ExecutorService executorService = Executors.newCachedThreadPool();
  private Image loadImage;

  @Override
  public void start(Stage stage) throws Exception {

    loadImage = new Image(IMAGE_URL);
    VBox root = new VBox();
    root.setAlignment(Pos.TOP_CENTER);
    root.setPadding(new Insets(20));
    root.setSpacing(20);

    Button button = new Button("Fill GridPane");

    root.getChildren().addAll(button);

    button.setOnAction(e -> {
      // Display loading image
      ImageView loading = new ImageView(loadImage);
      loading.setFitWidth(60);
      loading.setFitHeight(60);
      root.getChildren().add(loading);
      executorService.submit(fetchList);
    });

    fetchList.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
      @Override
      public void handle(WorkerStateEvent t) {
        listOfPeople = FXCollections.observableArrayList(fetchList.getValue());
        GridPane gridPane = createGridPane(listOfPeople);
        // Remove Loading Image and add GridPane
        root.getChildren().remove(1);
        VBox.setVgrow(gridPane, Priority.ALWAYS);
        root.getChildren().add(gridPane);
        stage.sizeToScene();
      }
    });

    ScrollPane scrollPane = new ScrollPane(root);
    Scene scene = new Scene(scrollPane, 600, 500);
    stage.setScene(scene);
    stage.setTitle("Load Data from JSON");
    stage.show();

    stage.setOnCloseRequest(e -> {
      executorService.shutdown();
    });
  }

  public GridPane createGridPane(ObservableList<Vnmast> listOfPeople) {
    GridPane gridPane = new GridPane();
    gridPane.setAlignment(Pos.CENTER);
    gridPane.setGridLinesVisible(true);
    gridPane.setPadding(new Insets(20));
    gridPane.setMinHeight(800);
    gridPane.setMaxWidth(800);

    // Create headings
    Label vnmIdHeading = new Label("Vendor Id");
    vnmIdHeading.setStyle("-fx-font-weight: bold");
    Label nameHeading = new Label("Name");
    nameHeading.setStyle("-fx-font-weight: bold");
    Label statusHeading = new Label("Status");
    statusHeading.setStyle("-fx-font-weight: bold");

    gridPane.add(vnmIdHeading, 0, 0);
    gridPane.add(nameHeading, 1, 0);
    gridPane.add(statusHeading, 2, 0);

    // Aligning at center
    alignElements(nameHeading, nameHeading, statusHeading);

    // Setting Constraints
    for(int i = 0; i < 3; i++) {
      ColumnConstraints column = new ColumnConstraints(200);
      gridPane.getColumnConstraints().add(column);
    }

    for(int i = 0; i < listOfPeople.size(); i++) {

      Vnmast people = listOfPeople.get(i);
      Label vnmIdLabel = new Label(people.getVnm_Id());
      Label nameLabel = new Label(people.getName());
      Label statusLabel = new Label(people.getStatus());

      // Adding to GridPane and necessary configuration
      gridPane.add(vnmIdLabel, 0, i + 1);
      gridPane.add(nameLabel, 1, i + 1);
      gridPane.add(statusLabel, 2, i + 1);

      // Aligning at center
      alignElements(vnmIdLabel, nameLabel, statusLabel);
    }
    return gridPane;
  }

  /**
   * Align elements at the center
   * 
   * @param nodes
   */
  private void alignElements(Node... nodes) {
    for(Node node : nodes) {
      GridPane.setHalignment(node, HPos.CENTER);
      GridPane.setValignment(node, VPos.CENTER);
    }
  }

  /**
   * Task to fetch details from JSONURL
   * 
   * @param <V>
   */
  private Task<List<Vnmast>> fetchList = new Task<List<Vnmast>>() {
    @Override
    protected List<Vnmast> call() throws Exception {
      List<Vnmast> list = null;
      try {
        list = new Gson().fromJson(readUrl(JSON_URL), new TypeToken<List<Vnmast>>() {
        }.getType());
      }
      catch(Exception e) {
        e.printStackTrace();
      }
      return list;
    }
  };

  /**
   * Read the URL and return the json data
   * 
   * @param urlString
   * @return
   * @throws Exception
   */
  private static String readUrl(String urlString) throws Exception {
    BufferedReader reader = null;
    try {
      URL url = new URL(urlString);
      reader = new BufferedReader(new InputStreamReader(url.openStream()));
      StringBuffer buffer = new StringBuffer();
      int read;
      char[] chars = new char[1024];
      while((read = reader.read(chars)) != -1)
        buffer.append(chars, 0, read);

      return buffer.toString();
    }
    finally {
      if(reader != null)
        reader.close();
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
