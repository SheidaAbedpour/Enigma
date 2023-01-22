package enigma;

import elements.*;

public class Enigma {

    private final PlugBoard plugBoard;
    private final Rotor1 rotor1;
    private final Rotor2 rotor2;
    private final Rotor3 rotor3;
    private int count = 0;
    private String Cipher;

    public Enigma(PlugBoard plugBoard, Rotor3 rotor3, Rotor2 rotor2, Rotor1 rotor1, String plain) {
        this.plugBoard = plugBoard;
        this.rotor1 = rotor1;
        this.rotor2 = rotor2;
        this.rotor3 = rotor3;

        start(plain);
    }

    private void start(String plain) {

        StringBuilder stringBuilder = new StringBuilder();

        for (char c : plain.toCharArray()) {

            char plug = plugBoard.getPlugBoard().get(c);

            char charRotor3 = rotor3.getRotor().get(plug);
            char charRotor2 = rotor2.getRotor().get(charRotor3);
            char charRotor1 = rotor1.getRotor().get(charRotor2);

            char charReflector = Reflector.getReflectorInstance().getReflectorMap().get(charRotor1);

            count++;

            rotor3.replaceKeysValues();
            rotor2.replaceKeysValues();
            rotor1.replaceKeysValues();


            charRotor1 = rotor1.getRotor().get(charReflector);
            charRotor2 = rotor2.getRotor().get(charRotor1);
            charRotor3 = rotor3.getRotor().get(charRotor2);

            plug = plugBoard.getPlugBoard().get(charRotor3);

            rotor3.replaceKeysValues();
            rotor2.replaceKeysValues();
            rotor1.replaceKeysValues();


            rotor3.rotate();
            updateRotors();

            stringBuilder.append(plug);
        }

        Cipher = stringBuilder.toString();
    }

    private void updateRotors() {

        if (count % 26 == 0)
            rotor2.rotate();
        if (count % (26 * 26) == 0)
            rotor1.rotate();
    }


    public PlugBoard getPlugBoard() {
        return plugBoard;
    }

    public Rotor1 getRotor1() {
        return rotor1;
    }

    public Rotor2 getRotor2() {
        return rotor2;
    }

    public Rotor3 getRotor3() {
        return rotor3;
    }

    public String getCipher() {
        return Cipher;
    }
}
