/*
 * RaceTrack.java
 * 
 * This program uses 3 seperate threads to control three cars as they move across a gui
 * that is displayed by javafx
 * 
 * Sam Taylor
 * 12/19/22
 * CMSC 403
 * 
 */


package RaceTrack;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;



public class RaceTrack extends Application {
    private static final File car = new File("C:/Users/samtl/OneDrive/Documents/school/2022/3_fall/403_programming_languages/homework/assignment8/RaceTrack/car.png");
    private boolean running = false;        //if the threads are running
    private boolean done = false;           //if the threads have reached the end of the track
    private boolean flag = false;           //if the threads have been started at some point

    Thread[] drivers = new Thread[3];

    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void start(Stage primaryStage) throws IOException {
        //root is the place to add images and stuff to
        StackPane root = new StackPane();

        //Image is the source of the image. ImageView is the image on the StackPane
        Image carPic = new Image(car.toURI().toString(), 25, 25, false, false);

        ImageView[] carPicView = new ImageView[3];
        for (int i = 0; i < 3; i++){
            carPicView[i] = new ImageView(carPic);
            carPicView[i].setTranslateX(-150);              //puts the cars very far on the left
            carPicView[i].setTranslateY(i * 25 - 25);       //[-25, 0, 25] spaces them out y-wise
            root.getChildren().add(carPicView[i]);          //adds it to the stackplane officially
        }


        Random rand = new Random();
        for (int i = 0; i < 3; i++){
            int j = i;                                          //tbph idk why i have to do this
            drivers[i] = new Thread(() -> {
                while(true){
                    //if running changes then all threads will be affected
                    while (running){
                        
                        double progress = carPicView[j].getTranslateX();
                        
                        //next double goes to slow so i use nextint to move the cars forward
                        progress += rand.nextInt(10);
                        //end of the track is 150
                        if (progress >= 150){
                            running = false;
                            int winner = j + 1;
                            Platform.runLater(() -> {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("WINNER");
                                alert.setHeaderText("Car " + winner + " wins!!!");
                                alert.showAndWait();
                                done = true;
                                //tell other cars to stop if they're still running
                                notifyAll();
                            });
                        }
                        double sameProgress = progress;         //but vscode yells at me if i dont
                        Platform.runLater(() ->{
                            //actually moves the car
                            carPicView[j].setTranslateX(sameProgress);
                        });
                        try{
                            Thread.sleep(50);
                        } catch(InterruptedException ex){}
                    }
                    System.out.println("");         //if you take this out it doesn't work. really.
                }
            });
        }


        //button to start all of the threads
        //doesn't do anything if the thread is already started
        //plays it if it's paused
        Button start = new Button();
        start.setText("Start");
        start.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //flag is for if it's the very first time
                //if it gets reset i can't start the threads again so flag says whether or not
                //to start the threads
                if (!running && !done && !flag){
                    running = true;
                    flag = true;
                    drivers[0].start();
                    drivers[1].start();
                    drivers[2].start();
                //if you hit the reset button then it starts the race again
                } else if(!running && !done && flag){
                    running = true;
                }
            }

        });
        start.setTranslateX(-100);
        start.setTranslateY(-50);
        root.getChildren().add(start);


        //button to temporarily stop all of the threads
        Button pause = new Button();
        pause.setText("Stop");
        pause.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                running = false;
            }

        });
        pause.setTranslateX(0);
        pause.setTranslateY(-50);
        root.getChildren().add(pause);



        //button to make all of the threads start over
        Button reset = new Button();
        reset.setText("reset");
        reset.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                for (int i = 0; i < 3; i++){
                    carPicView[i].setTranslateX(-150);
                }
                running = false;
                done = false;
            }

        });
        reset.setTranslateX(100);
        reset.setTranslateY(-50);
        root.getChildren().add(reset);



        primaryStage.setTitle("Race Track");
        primaryStage.setScene(new Scene(root, 500, 200));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}