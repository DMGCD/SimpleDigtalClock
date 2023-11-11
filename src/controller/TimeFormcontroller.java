package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeFormcontroller {

    public Label lblTime;
    public Label lblTime12;
    public Label lblDate;
    public Button btn24H;
    public Button btn12h;

    public void initialize(){
        lblTime.setVisible(false);
        btn24H.setVisible(true);
        btn12h.setVisible(false);

        running12();
}
    private void runningTime(){
        final  Thread thread = new Thread(()->{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss a");
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("EEE , MMM d , yyyy");

            while(true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                final String time =simpleDateFormat.format(new Date());
                final String date =simpleDateFormat1.format(new Date());
                Platform.runLater(()->{
                    lblTime.setText(time);
                    lblDate.setText(date);
                });

            }
        });
        thread.start();
    }
private void running12(){
    final  Thread thread = new Thread(()->{


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss a");
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("EEE , MMM d , yyyy");
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            final String time =simpleDateFormat.format(new Date());
            final String date =simpleDateFormat1.format(new Date());
            Platform.runLater(()->{
                lblTime12.setText(time);
                lblDate.setText(date);
            });

        }
    });
    thread.start();


}


}
