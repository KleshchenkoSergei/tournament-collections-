package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Player item1 = new Player("Dmitriy", 15);
    Player item2 = new Player("Leonid", 13);
    Player item3 = new Player("Matvey", 30);
    Player item4 = new Player("Igor", 7);
    Player item5 = new Player("Victor", 13);
    Player item6 = new Player("Bot1", 0);
    Player item7 = new Player("Bot2", -1);

    Game game = new Game();

    @Test
    public void shouldTestWinFirst() {

        game.register(item1);
        game.register(item2);

        int expected = 1;
        int actual = game.round("Dmitriy", "Leonid");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldTestWinSecond() {

        game.register(item2);
        game.register(item3);

        int expected = 2;
        int actual = game.round("Leonid", "Matvey");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldTestNoWin() {

        game.register(item2);
        game.register(item5);

        int expected = 0;
        int actual = game.round("Leonid", "Victor");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldTestNotRegisteredFirst() {

        game.register(item2);
        game.register(item5);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Dmitriy", "Victor");
        });
    }

    @Test
    public void shouldTestNotRegisteredSecond() {

        game.register(item2);
        game.register(item5);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Leonid", "Matvey");
        });
    }

    @Test
    public void shouldTestNoPlayers() {

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Leonid", "Matvey");
        });
    }

    @Test
    public void shouldTestLess1() {

        game.register(item6);
        game.register(item7);

        int expected = 1;
        int actual = game.round("Bot1", "Bot2");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldTestMorePlayers() {

        game.register(item1);
        game.register(item2);
        game.register(item3);
        game.register(item4);

        int expected = 1;
        int actual = game.round("Dmitriy", "Leonid");

        assertEquals(expected, actual);
    }


}