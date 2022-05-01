package ru.netology.domain;

import java.util.*;

public class Game {

    private Map<String, Integer> game = new HashMap<>();

    public Game(Map<String, Integer> game) {
        this.game = game;
    }

    public Game() {

    }

    public Integer add(Player player) {
        return this.game.put(player.getName(), player.getStrength());
    }

    public void register(Player player) {
        add(player);
    }

    public int round(String playerName1, String playerName2) {

        int strengthPlayer1 = 0;
        int strengthPlayer2 = 0;
        boolean player1Registered = false;
        boolean player2Registered = false;

        for (Map.Entry<String, Integer> entry : game.entrySet()) {

            if (entry.getKey() == playerName1) {
                strengthPlayer1 = entry.getValue();
                player1Registered = true;
            }
            if (entry.getKey() == playerName2) {
                strengthPlayer2 = entry.getValue();
                player2Registered = true;
            }
        }
        if (player1Registered == false) {
            throw new NotRegisteredException(playerName1);
        }
        if (player2Registered == false) {
            throw new NotRegisteredException(playerName2);
        }

        int result;
        if (strengthPlayer1 == strengthPlayer2) {
            result = 0;
        } else if (strengthPlayer1 > strengthPlayer2) {
            result = 1;
        } else {
            result = 2;
        }

        return result;
    }
}
