package com.patryk.app;

import io.codearte.jfairy.Fairy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main{
    private static Sender sender = new Sender("EmailSenderThread");

    private static synchronized void generateEmails(int numberOfEmails) {
        Fairy fairy = Fairy.create();
        sender.start();
        for (int i = 0; i < numberOfEmails; i++) {
            System.out.println("receiving email: " + i);
            new EmailDownloader(fairy, "mailDistributor NO" + i, sender).start();
        }
    }
    public static void main(String[] args) {

//        Niech watek głowny wylosuje liczbe
//        Dla wylosowanej liczby niech zostanie pobrane 'z bazy' (wróżką) tyle mejli
//        każdy mejl jest pobierany osobnym wątkiem
//        Jak tylko adres mejlowy spływa, niech osobny wątek udaje, że wysyła mejla
//        Tylko metody poznane dotąd mogą być użyte.

        int randomNumber = ThreadLocalRandom.current().nextInt(1,100+1);
        generateEmails(randomNumber);

    }




}
