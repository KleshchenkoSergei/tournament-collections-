package ru.netology.domain;

import java.util.ArrayList;
import java.util.Collection;

public class Game {

    private Collection<Player> game = new ArrayList<>();

    public boolean add(Player player) {
        return this.game.add(player);
    }

    public void register(Player player) {
        add(player);
    }

    public int round(String playerName1, String playerName2) {

        int strengthPlayer1 = 0;
        int strengthPlayer2 = 0;
        boolean player1Registered = false;
        boolean player2Registered = false;
        for (Player player : game) {
            if (player.getName() == playerName1) {
                strengthPlayer1 = player.getStrength();
                player1Registered = true;
            }
            if (player.getName() == playerName2) {
                strengthPlayer2 = player.getStrength();
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
