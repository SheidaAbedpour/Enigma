package elements;

import java.util.HashMap;
import java.util.Map;

public class Reflector {

    private final static Map<Character, Character> reflector = new HashMap<>();

    private final static Reflector Reflector = new Reflector();

    private Reflector() {
        for (char c = 'a'; c <= 'z'; c++) {
            reflector.put(c, (char) (('z' - c) + 97));
        }
    }

    public static Reflector getReflectorInstance() {
        return Reflector;
    }

    public Map<Character, Character> getReflectorMap() {
        return reflector;
    }

}
