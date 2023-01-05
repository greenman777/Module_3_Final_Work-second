package game.mechanica;

import java.util.ArrayList;
import java.util.List;

public class GameLogic {
    private static final List<String> answerList = new ArrayList<>();
    private static final String WRONG_INPUT_ARGUMENT = "Входящий аргумент = null";

    public void addAnswer() {
        answerList.add(0, "Ты потерял память. Принять вызов НЛО?");
        answerList.add(1, "Ты принял вызов. Поднимешься на мостик к их капитану?");
        answerList.add(2, "Подняться на мостик корабля");
        answerList.add(3, "Отказаться подниматься на мостик");
        answerList.add(4, "Ты не пошел на переговоры. Поражение!");
        answerList.add(5, "Ты поднялся на мостик. Ты кто?");
        answerList.add(6, "Рассказать правду о себе");
        answerList.add(7, "Солгать о себе");
        answerList.add(8, "Ты отказался подниматься на мостик. Поражение!");
        answerList.add(9, "Тебя вернули домой. Победа!");
        answerList.add(10, "");
        answerList.add(11, "Ты рассказал неправду о себе. Поражение!");
    }

    public String answerListGetAnswer(String getString) // для проведения тестов
    {
        String stringToReturn = "";
        for (String string : answerList) {
            if (string.equals(getString))
                stringToReturn = string;
        }
        return stringToReturn;
    }

    public List<String> answer(String gameState) {
        if (gameState == null) {
            throw new IllegalArgumentException(WRONG_INPUT_ARGUMENT);
        }
        List<String> answer = new ArrayList<>();
        if (gameState.equals(answerList.get(0))) //gameState 0
        {
            answer.add(0, answerList.get(1)); //gameState 1
            answer.add(1, answerList.get(2));
            answer.add(2, answerList.get(3));
            answer.add(3, answerList.get(4));
        } else if (gameState.equals(answerList.get(1))) //gameState 1
        {
            answer.add(0, answerList.get(5)); //gameState 2
            answer.add(1, answerList.get(6));
            answer.add(2, answerList.get(7));
            answer.add(3, answerList.get(8));
        } else if (gameState.equals(answerList.get(5))) //gameState 2
        {
            answer.add(0, answerList.get(9)); //gameState 3
            answer.add(1, answerList.get(10));
            answer.add(2, answerList.get(10));
            answer.add(3, answerList.get(11));
        }
        return answer;
    }
}

