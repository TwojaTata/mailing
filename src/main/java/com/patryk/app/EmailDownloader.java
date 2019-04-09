package com.patryk.app;

import io.codearte.jfairy.Fairy;

import java.util.ArrayList;
import java.util.List;

public class EmailDownloader extends Thread {

    private final Fairy fairy;
    private final String name;
    private Sender sender;
    EmailDownloader(Fairy fairy, String name, Sender sender) {
        this.name = name;
        this.fairy = fairy;
        this.sender = sender;
    }

    @Override
    public void run() {
        synchronized (this) {
            String email = (fairy.person().getEmail());
            sender.setEmail(email);
        }
    }
}
