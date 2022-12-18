package com.example.filefinder;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

public class FileFinderApp extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("File Finder");
        primaryStage.getIcons().add(new Image("C:\\Users\\Beqir\\Desktop\\FOLDER\\path-icon.png"));

        // Create a label for the file name field
        Label fileNameLabel = new Label("File name:");
        fileNameLabel.setStyle("-fx-font-family: sans-serif;" +
                "-fx-font-size: 14px;" +
                "-fx-color: red;"+
                "-fx-padding: 9px 0px 9px 50px;");
        fileNameLabel.setPrefWidth(150);
        fileNameLabel.setPrefHeight(25);
        // Create a text field for the file name
        TextField fileNameField = new TextField();
        fileNameField.setStyle("-fx-font-family: sans-serif;" +
                "-fx-font-size: 14px;" +
                "-fx-padding: 9px 0 9px 20px;" +
                "-fx-border-width: 1px;" +
                "-fx-border-style: solid;" +
                "-fx-border-color: black;"+
                "-fx-border-radius: 4px;");
       // fileNameField.setPrefWidth(200);
        // Create a label for the root directory field
        Label rootDirectoryLabel = new Label("Root directory:");
        rootDirectoryLabel.setStyle("-fx-font-family: sans-serif;" +
                "-fx-font-size: 14px;" +
                "-fx-color: red;"+
                "-fx-padding: 10px");
        // Create a text field for the root directory
        TextField rootDirectoryField = new TextField();
        rootDirectoryField.setMaxWidth(900);
        rootDirectoryField.setStyle("-fx-font-family: sans-serif;" +
                "-fx-font-size: 14px;" +
                "-fx-padding: 9px;" +
                "-fx-border-width: 1px;" +
                "-fx-border-style: solid;" +
                "-fx-border-color: black;"+
                "-fx-border-radius: 4px;");
        //progressLabel.textProperty().bind(Bindings.format("%.0f%%", progressBar.progressProperty().multiply(100)));
        ProgressBar progressBar = new ProgressBar();
        // Initial progress is 0
        progressBar.setProgress(0.0);
        Label progressBarLabel=new Label();

// Perform a task that updates the progress
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                for (int i = 0; i <= 100; i++) {
                    updateProgress(i, 100);
                    Thread.sleep(10); // Simulate work

                }
                return null;
            }
        };


        progressBar.progressProperty().bind(task.progressProperty());
        progressBarLabel.textProperty().bind(Bindings.format("%.0f%%", progressBar.progressProperty().multiply(100)));


// Start the task on a background thread
        Label searchResultsLabel = new Label("The results:");
        searchResultsLabel.setStyle("-fx-font-family: sans-serif;" +
                "-fx-font-size: 14px;" +
                "-fx-font-color: red;");
        Label searchResultsTextField=new Label();
        searchResultsTextField.setStyle("-fx-font-family: sans-serif;" +
                "-fx-font-size: 14px;" +
                "-fx-border-width: 1px;" +
                "-fx-border-style: solid;" +
                "-fx-border-color: black;"+
                "-fx-border-radius: 4px;");
        searchResultsTextField.setPrefWidth(900);
        searchResultsTextField.setPrefHeight(400);
        Button browseButton = new Button("Browse");
        browseButton.setStyle(" -fx-background-color: Orange;" +
                "-fx-text-fill: white;"+
                "    -fx-font-size: 14px;"+
                "-fx-padding: 9px;"+
                "    -fx-border-radius: 5px;");
        browseButton.setOnAction(event -> {
            DirectoryChooser directoryChooser = new DirectoryChooser();
            directoryChooser.setTitle("Select a folder");
            File selectedFolder = directoryChooser.showDialog(primaryStage);
            if (selectedFolder != null) {
                // Do something with the selected folder
                rootDirectoryField.setText(selectedFolder.getAbsolutePath());
            }
        });


        Button resetButton = new Button("Reset");
        resetButton.setOnAction(event -> searchResultsTextField.setText(""));
        resetButton.setOnAction(event -> progressBar.setProgress(0.0));
        resetButton.setOnAction(event -> progressBarLabel.textProperty().bind(Bindings.format("%.0f%%", progressBar.progressProperty().multiply(100))));
        resetButton.setStyle(" -fx-background-color: blue; " +
                "                -fx-text-fill: white;" +
                "                    -fx-font-size: 14px;" +
                "                -fx-padding: 9px;" +
                "                    -fx-border-radius: 5px;");
        resetButton.setOnMouseEntered(event -> {
            resetButton.setStyle("-fx-background-color: red;"+
                    "-fx-text-fill: white;"+
                    "    -fx-font-size: 14px;"+
                    "-fx-padding: 9px;"+
                    "    -fx-border-radius: 5px;");
        });

        resetButton.setOnMouseExited(event -> {
            resetButton.setStyle(" -fx-background-color: blue;" +
                    "-fx-text-fill: white;"+
                    "    -fx-font-size: 14px;"+
                    "-fx-padding: 9px;"+
                    "    -fx-border-radius: 5px;");;
        });


        // Create a search button
        //button.getStyleClass().add("important-button");
        Button searchButton = new Button("Search");
        searchButton.setStyle(" -fx-background-color: red;" +
                "-fx-text-fill: white;"+
                "    -fx-font-size: 14px;"+
                "-fx-padding: 9px;"+
                "    -fx-border-radius: 5px;");
        //button.setLayoutX(button.getLayoutX() + 10);

        searchButton.setOnMouseEntered(event -> {
            searchButton.setStyle("-fx-background-color: blue;"+
                    "-fx-text-fill: white;"+
                    "    -fx-font-size: 14px;"+
                    "-fx-padding: 9px;"+
                    "    -fx-border-radius: 5px;");
        });

        searchButton.setOnMouseExited(event -> {
            searchButton.setStyle(" -fx-background-color: red;" +
                    "-fx-text-fill: white;"+
                    "    -fx-font-size: 14px;"+
                    "-fx-padding: 9px;"+
                    "    -fx-border-radius: 5px;");;
        });
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Get the file name and root directory from the text fields
                String fileName = fileNameField.getText();
                String rootDirectory = rootDirectoryField.getText();
                // Call the search function
                String searchResults = findFile(new File(rootDirectory), fileName);
                System.out.println(searchResults);
                Thread thread = new Thread(task);
                thread.start();
                searchResultsTextField.setText(searchResults);
            }
        });

        // Create a horizontal layout for the file name and search button
        HBox fileNameLayout = new HBox(fileNameLabel, fileNameField);
        // Create a vertical layout for the file name and root directory fields
        HBox.setMargin(searchButton, new Insets(0, 0, 5, 10));
        HBox.setMargin(resetButton,new Insets(0,0,5,10));
        fileNameLayout.getChildren().add(searchButton);
        fileNameLayout.getChildren().add(resetButton);
        HBox.setMargin(browseButton,new Insets(0,0,5,10));
        fileNameLayout.getChildren().add(browseButton);
        fileNameLayout.getChildren().add(progressBar);
        fileNameLayout.getChildren().add(progressBarLabel);
        VBox layout = new VBox(fileNameLayout,rootDirectoryLabel, rootDirectoryField);
        primaryStage.show();
        layout.getChildren().add(searchResultsLabel);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().add(searchResultsTextField);

        // Add the layout to the scene
        //root.getStylesheets().add(getClass().getResource("your_stylesheet.css").toString());
        Scene scene = new Scene(layout,1000,600);
        //scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        // Add the scene to the stage and show the stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static String findFile(File directory, String fileName) {
        File[] files = directory.listFiles();

        // If the directory is empty, return
        if (files == null) {
            return "The directory is empty";
        }

        // Use a for loop to search for the file
        String searchResult = "File not found";
        for (int i = 0; i < files.length; i++) {
            // Check if this file is the one we are looking for
            File file = files[i];
            if (file.isFile() && file.getName().equals(fileName)) {
                searchResult = file.getAbsolutePath();
                break;
            }
        }

        return searchResult;
    }
}
