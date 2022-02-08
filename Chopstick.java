package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Chopstick {

    private int id;
    private boolean inUse;
    private Rectangle ch;

    public Chopstick(int id, Rectangle ch) {
        this.id = id;
        inUse = false;
        this.ch = ch;
        this.ch.setFill(Color.BLUE);
    }

    public synchronized void release(){
        inUse = false;
       this.ch.setFill(Color.BLUE);
        //System.out.println("Chopstick 1 has been set down.");
        //change rectangle color to show chopstick is released
    }

    public synchronized void take(){
        inUse = true;
        this.ch.setFill(Color.BLACK);
        //System.out.println("Chopstick 1 has been picked up.");
        //change color of rectangle to show chopstick was taken
    }

    public boolean isInUse(){
        return inUse;
    }

    public int getId() {
        return id;
    }
}
