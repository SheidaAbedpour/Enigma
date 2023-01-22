package elements;

import java.util.HashMap;
import java.util.Map;

public class PlugBoard {

    private Map<Character, Character> plugBoard = new HashMap<>();

    public PlugBoard(Map<Character, Character> plugBoard) {

        for (char c = 'a'; c <= 'z'; c++)
            this.plugBoard.put(c, c);

        for (Map.Entry<Character, Character> entry : plugBoard.entrySet()) {
            this.plugBoard.put(entry.getKey(), entry.getValue());
            this.plugBoard.put(entry.getValue(), entry.getKey());
        }
    }

    public Map<Character, Character> getPlugBoard() {
        return plugBoard;
    }

}
