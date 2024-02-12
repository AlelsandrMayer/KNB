import org.example.RockPaperScissors;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

public class RockPaperScissorsTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayInputStream inContent = new ByteArrayInputStream("0\n0\n0\n".getBytes());

    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    private RockPaperScissors game;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        System.setIn(inContent);
        game = new RockPaperScissors();
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    public void testDetermineWinner_PlayerWins() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method determineWinnerMethod = RockPaperScissors.class.getDeclaredMethod("determineWinner", int.class, int.class);
        determineWinnerMethod.setAccessible(true);
        int result = (int) determineWinnerMethod.invoke(game, 0, 2);
        assertEquals(1, result); // Player should win
    }

    @Test
    public void testDetermineWinner_ComputerWins() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method determineWinnerMethod = RockPaperScissors.class.getDeclaredMethod("determineWinner", int.class, int.class);
        determineWinnerMethod.setAccessible(true);
        int result = (int) determineWinnerMethod.invoke(game, 1, 2);
        assertEquals(-1, result); // Computer should win
    }

    @Test
    public void testDetermineWinner_Draw() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method determineWinnerMethod = RockPaperScissors.class.getDeclaredMethod("determineWinner", int.class, int.class);
        determineWinnerMethod.setAccessible(true);
        int result = (int) determineWinnerMethod.invoke(game, 1, 1);
        assertEquals(0, result); // Should be a draw
    }


}

