package com.patryk.app;

import java.util.List;

public class EmailSender extends Thread {
    private final String name;
    List<String> emailsToSend;

    public EmailSender(String name, List<String> emailsToSend) {
        this.emailsToSend = emailsToSend;
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (String email : emailsToSend
            ) {
                if (email == null) {
                    System.out.println("sending done");
                    System.out.println(emailsToSend.size() + " has been sent");

                }
                System.out.println("sending " + email);
                emailsToSend.remove(email);
            }
        }
    }
}
