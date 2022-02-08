package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }
    /*
    public class DiningPhilosophers {

        private static final int NUM_PHILOSOPHERS = 5;

        public static void main(String[] args) {
            Chopstick[] chopsticks = new Chopstick[NUM_PHILOSOPHERS];

            for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
                chopsticks[i] = new Chopstick(1);//?
            }

            Philosopher[] philosophers = new Philosopher[NUM_PHILOSOPHERS];

            for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
                philosophers[i] = new Philosopher(i, chopsticks[i], chopsticks[(i + 1) % NUM_PHILOSOPHERS]);
                new Thread(philosophers[i]).start();
            }
        }
    }
*/

    public static void main(String[] args) {
        launch(args);
    }
}
