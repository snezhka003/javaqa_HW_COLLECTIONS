package ru.netology.game;

import java.util.HashMap;

public class Game {
    HashMap<String, Integer> players = new HashMap<>();

    public void register (Player player) {
        players.put(player.getName(), player.getStrength());
    }

    public int round (String playerName1, String playerName2) {
        Integer player1 = null;
        Integer player2 = null;

        for (String key : players.keySet()) {
            if (players.containsKey(playerName1)) {
                player1 = players.get(playerName1);
            }
            if (players.containsKey(playerName2)) {
                player2 = players.get(playerName2);
            }
        }

        if (!players.containsKey(playerName1)) {
            throw new NotRegisteredException("Игрок " + playerName1 + " не зарегистрирован!");
        }
        if (!players.containsKey(playerName2)) {
            throw new NotRegisteredException("Игрок " + playerName2 + " не зарегистрирован!");
        }

        if (player1 == player2) {
            return 0;
        }
        if (player1 > player2) {
            return 1;
        } else {
            return 2;
        }
    }
}
