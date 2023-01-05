package game.mechanica;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GameLogicTest {
    private GameLogic gameLogic;
    private final String gameState1 = "Ты потерял память. Принять вызов НЛО?";

    @BeforeAll
    public void init() {
        gameLogic =  new GameLogic();
        gameLogic.addAnswer();
    }
    @Test
    public void answer_Null_String_Argument_Test() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> gameLogic.answer(null));
    }
    @Test
    void answer_Return_No_Empty_List_Test() {
        List<String> gameState = new ArrayList<>();
        gameState.add(gameLogic.answerListGetAnswer(gameState1));
        String gameState2 = "Ты принял вызов. Поднимешься на мостик к их капитану?";
        gameState.add(gameLogic.answerListGetAnswer(gameState2));
        String gameState3 = "Ты поднялся на мостик. Ты кто?";
        gameState.add(gameLogic.answerListGetAnswer(gameState3));
        for(String string: gameState) {
            Assertions.assertFalse( gameLogic.answer(string).isEmpty());
        }
    }
    @Test
    void answer_Return_List_Size_Test() {
        int answerListSize = 4;
        Assertions.assertEquals(answerListSize, gameLogic.answer(gameState1).size());
    }
    @Test
    void answer_Return_String_Type_Test() {
        Assertions.assertEquals("String", gameLogic.answer(gameState1).get(0).getClass().getSimpleName());
    }
}