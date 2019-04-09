package com.patryk.app;

import io.codearte.jfairy.Fairy;

import java.util.concurrent.ThreadLocalRandom;

public class Main{
    public static void main(String[] args) {

//        Niech watek głowny wylosuje liczbe
//        Dla wylosowanej liczby niech zostanie pobrane 'z bazy' (wróżką) tyle mejli
//        każdy mejl jest pobierany osobnym wątkiem
//        Jak tylko adres mejlowy spływa, niech osobny wątek udaje, że wysyła mejla
//        Tylko metody poznane dotąd mogą być użyte.

        int randomNumber = ThreadLocalRandom.current().nextInt(1,100+1);
        generateEmail(randomNumber);

    }

    static void generateEmail(int numberOfEmails){
        Sender sender = new Sender("sender");
        sender.start();
        Fairy fairy = Fairy.create();
        for (int i = 0; i < numberOfEmails ; i++) {
            new MailDistributor(fairy, "mailDistributor NO"+i, sender).start();
        }
    }
}
