package pl.sda.reservations.service;

import org.springframework.stereotype.Service;

//Servis powinien być bezstanowy

@Service
public class MessageService {
    private int counter = 0;

    public int getCounter() {
        return counter++;
    }
}
