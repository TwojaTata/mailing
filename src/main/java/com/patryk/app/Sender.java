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
        while(email!=null){
        System.out.println("sending email to" + email);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            email = null;
        }
    }
}
