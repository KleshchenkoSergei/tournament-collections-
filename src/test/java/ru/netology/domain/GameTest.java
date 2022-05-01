package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    Player item1 = new Player(1, "Dmitriy", 15);
    Player item2 = new Player(2, "Leonid", 13);
    Player item3 = new Player(3, "Matvey", 30);
    Player item4 = new Player(4, "Igor", 7);
    Player item5 = new Player(5, "Victor", 13);
    Player item6 = new Player(6, "Bot1", 0);
    Player item7 = new Player(7, "Bot2", -1);

    @Test
    public void shouldTestWinFirst() {

        Game game = new Game();

        game.register(item1);
        game.register(item2);

        int expected = 1;
        int actual = game.round("Dmitriy", "Leonid");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldTestWinSecond() {

        Game game = new Game();

        game.register(item2);
        game.register(item3);

        int expected = 2;
        int actual = game.round("Leonid", "Matvey");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldTestNoWin() {

        Game game = new Game();

        game.register(item2);
        game.register(item5);

        int expected = 0;
        int actual = game.round("Leonid", "Victor");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldTestNotRegisteredFirst() {

        Game game = new Game();

        game.register(item2);
        game.register(item5);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Dmitriy", "Victor");
        });
    }

    @Test
    public void shouldTestNotRegisteredSecond() {

        Game game = new Game();

        game.register(item2);
        game.register(item5);

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Leonid", "Matvey");
        });
    }

    @Test
    public void shouldTestNoPlayers() {

        Game game = new Game();

        assertThrows(NotRegisteredException.class, () -> {
            game.round("Leonid", "Matvey");
        });
    }

    @Test
    public void shouldTestLess1() {

        Game game = new Game();

        game.register(item6);
        game.register(item7);

        int expected = 1;
        int actual = game.round("Bot1", "Bot2");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldTestMorePlayers() {

        Game game = new Game();

        game.register(item1);
        game.register(item2);
        game.register(item3);
        game.register(item4);

        int expected = 1;
        int actual = game.round("Dmitriy", "Leonid");

        assertEquals(expected, actual);
    }


}