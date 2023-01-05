package game.mechanica;

import java.util.HashMap;
import java.util.Map;

public class GameCount {

    private final Map<String, Integer> mapOfPlayers;
    private static final String WRONG_INPUT_ARGUMENT = "Входящий аргумент = null";

    public GameCount() {
        mapOfPlayers = new HashMap<>();
    }

    public void addUser(String name) {
        if (name == null) {
            throw new IllegalArgumentException(WRONG_INPUT_ARGUMENT);
        }
        if (!mapOfPlayers.containsKey(name)) {
            mapOfPlayers.put(name, 0);
        }
    }

    public Integer getGameCount(String name) {
        if (name == null) {
            throw new IllegalArgumentException(WRONG_INPUT_ARGUMENT);
        }
        Integer gameCount = 0;
        if (mapOfPlayers.containsKey(name)) {
            gameCount = mapOfPlayers.get(name);
        }
        return gameCount;
    }

    public void setGameCount(String name, Integer gameCount) {
        if (name == null || gameCount == null) {
            throw new IllegalArgumentException(WRONG_INPUT_ARGUMENT);
        }
        if (mapOfPlayers.containsKey(name)) {
            mapOfPlayers.replace(name, mapOfPlayers.get(name), gameCount);
        }
    }

    public boolean getThisUser(String name) {
        if (name == null) {
            throw new IllegalArgumentException(WRONG_INPUT_ARGUMENT);
        }
        return mapOfPlayers.containsKey(name);
    }
}


