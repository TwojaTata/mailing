package com.patryk.app;

public class Sender extends Thread {
    private volatile String email;
    private final String name;

    Sender(String name) {
        this.name = name;
    }

    void setEmail(String email){
        this.email = email;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sending email to" + email);
    }
}
