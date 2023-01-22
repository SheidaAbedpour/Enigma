package elements;

import java.util.HashMap;
import java.util.Map;

public abstract class Rotor {

    private Map<Character, Character> rotor = new HashMap<>();
    private String Order;

    public Rotor(String order) {
        this.Order = order;
        setRotor();
    }

    private void setRotor() {
        int i = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            rotor.put(c, Order.charAt(i++));
        }
    }

    public Map<Character, Character> getRotor() {
        return rotor;
    }

    public void rotate() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(Order.charAt(Order.length() - 1));
        for (int i = 0; i < Order.length() - 1; i++)
            stringBuilder.append(Order.charAt(i));

        Order = stringBuilder.toString();

        setRotor();

    }

    public void replaceKeysValues() {

        Map<Character, Character> newMap = new HashMap<>();

        for (Map.Entry<Character, Character> entry : rotor.entrySet())
            newMap.put(entry.getValue(), entry.getKey());

        rotor = newMap;
    }

}
