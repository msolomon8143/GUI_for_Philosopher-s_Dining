package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Philosopher implements Runnable{

    private int id;
    private Chopstick leftChopstick;
    private Chopstick rightChopstick;
    private Circle ph;

    public Philosopher(int id, Chopstick leftChopstick, Chopstick rightChopstick, Circle ph) {
        this.id = id;//set it
        this.leftChopstick = leftChopstick;
        this.rightChopstick = rightChopstick;
        this.ph = ph;
    }

    @Override
    public void run() {
        while(true){
            eat();//execute eat
        }

    }

    public void eat(){
        synchronized (leftChopstick) {
            //if (!leftChopstick.isInUse())//left not being used
                pickUpLeftChopstick();
            synchronized (rightChopstick) {
                //if (!rightChopstick.isInUse())//right not being used
                    pickUpRightChopstick();
                try {
                    this.ph.setFill(Color.RED);
                    //Thread.sleep(3000);
                    Thread.sleep((int) (Math.random() * 2000));
                } catch (InterruptedException e) {
                    System.out.println("Exception occurred.");
                    e.printStackTrace();
                }
                releaseRightChopstick();
            }

            releaseLeftChopstick();
        }


        think();
    }
    private void pickUpLeftChopstick(){
        leftChopstick.take();
        //System.out.println("Philosopher " + id + " is eating.");
        //Change color to show the philosopher is eating
        //System.out.flush();
    }

    private void pickUpRightChopstick(){
        rightChopstick.take();
        //System.out.println("Philosopher " + id + " is eating.");
        //Change color to show the philosopher is eating
        //System.out.flush();
    }

    private void releaseLeftChopstick(){
        leftChopstick.release();
    }

    private void releaseRightChopstick(){
        rightChopstick.release();
    }

    private void think(){
        //System.out.println("Philosopher " + id + " is thinking.\n");
        //Change the color to circle ph to show the philosopher is thinking
        //System.out.flush();
        try {
            this.ph.setFill(Color.YELLOW);
            //Thread.sleep(3000);
            Thread.sleep((int) (Math.random()*2000));
        } catch (InterruptedException e) {
            System.out.println("Exception occurred.");
            e.printStackTrace();
        }
    }


}
