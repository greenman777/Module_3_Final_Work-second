package game.mechanica;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GameCountTest {
    private GameCount gameCount;
    private final String name = "user";
    private final Integer zero = 0;
    private boolean getUser;
    @BeforeAll
    public void init() {
        gameCount = new GameCount();
        gameCount.addUser(name);
        getUser = gameCount.getThisUser(name);
    }

    @Test
    public void addUser_Null_String_Argument_Test() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> gameCount.addUser(null));
    }
    @Test
    void addUser_Checking_Adding_Name_Test() {
        Assertions.assertTrue(getUser);
    }
    @Test
    void getGameCount_Null_String_Argument_Test() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> gameCount.getGameCount(null));
    }
    @Test
    void getGameCount_Return_Integer_Type_Test() {
        Assertions.assertEquals("Integer", gameCount.getGameCount(name).getClass().getSimpleName());
    }
    @Test
    void getGameCount_Return_Number_Test() {
        Assertions.assertEquals(zero, gameCount.getGameCount(name));
    }
    @Test
    void setGameCount_Null_String_Argument_Test() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> gameCount.setGameCount(null, zero));
    }
    @Test
    void setGameCount_Null_Integer_Argument_Test() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> gameCount.setGameCount(name, null));
    }
    @Test
    void setGameCount_Null_String_Integer_Argument_Test() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> gameCount.setGameCount(null, null));
    }
    @Test
    void setGameCount_Test() {
        Integer count = 4;
        gameCount.setGameCount(name,count);
        Assertions.assertEquals(gameCount.getGameCount(name), count);
    }
    @Test
    void getThisUser_Null_String_Argument_Test() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> gameCount.getThisUser(null));
    }
    @Test
    void getThisUser_Test() {
        Assertions.assertTrue(gameCount.getThisUser(name));
    }
}