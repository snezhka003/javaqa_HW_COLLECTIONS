package ru.netology.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Player player1 = new Player(11, "Iamwinner", 40);
    Player player2 = new Player(222, "tester", 32);
    Player player3 = new Player(3, "superplayer", 40);
    Player player4 = new Player(45, "megatron", 51);

    @Test
    public void shouldBeExceptionForAllPlayers() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("looser", "badplayer");
        });
    }

    @Test
    public void shouldBeExceptionForFirstPlayer() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("looser", "tester");
        });
    }

    @Test
    public void shouldBeExceptionForSecondPlayer() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Iamwinner", "badplayer");
        });
    }

    @Test
    public void shouldBeRoundInADraw() {
        Game game = new Game();
        game.register(player1);
        game.register(player3);

        int expected = 0;
        int actual = game.round("Iamwinner", "superplayer");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeRoundWithWinFirsPlayer() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Iamwinner", "tester");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeRoundWithWinSecondPlayer() {
        Game game = new Game();
        game.register(player2);
        game.register(player4);

        int expected = 2;
        int actual = game.round("tester", "megatron");

        Assertions.assertEquals(expected, actual);
    }
}
