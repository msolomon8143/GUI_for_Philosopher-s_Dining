package sample;


import javafx.fxml.FXML;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Controller {

    private Circle[] philo;
    private Rectangle[] chop;

    @FXML
    Circle ph1,ph2,ph3,ph4,ph5;
    @FXML
    Rectangle ch1,ch2,ch3,ch4,ch5;

    //@FXML
    public void initialize(){
        philo = new Circle[5];
        philo[0]=ph1;philo[1]=ph2;philo[2]=ph3;philo[3]=ph4;philo[4]=ph5;
        chop = new Rectangle[5];
        chop[0]=ch1;chop[1]=ch2;chop[2]=ch3;chop[3]=ch4;chop[4]=ch5;

        ArrayList<Chopstick> Chopsticks = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Chopsticks.add(new Chopstick(i,chop[i]));
        }

        ArrayList<Philosopher> philosophers = new ArrayList<>();

        philosophers.add(new Philosopher(0, Chopsticks.get(4),Chopsticks.get(0),philo[0] ));
        philosophers.add(new Philosopher(1, Chopsticks.get(0),Chopsticks.get(1),philo[1] ));
        philosophers.add(new Philosopher(2, Chopsticks.get(1),Chopsticks.get(2),philo[2] ));
        philosophers.add(new Philosopher(3, Chopsticks.get(2),Chopsticks.get(3),philo[3] ));
        philosophers.add(new Philosopher(4, Chopsticks.get(3),Chopsticks.get(4),philo[4] ));

        for (int i = 0; i < 5; i++) {
            new Thread(philosophers.get(i)).start();
        }



    }


}
