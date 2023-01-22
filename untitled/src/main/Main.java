package main;

import elements.PlugBoard;
import elements.Rotor1;
import elements.Rotor2;
import elements.Rotor3;
import enigma.Enigma;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

/*
        Scanner scanner = new Scanner(System.in);
        String date = scanner.next();
        String plain = scanner.next();

        String cipher = startEnigma(date, plain);
        System.out.println(cipher);

 */

        System.out.println(startEnigma("1944/9/1","zjgjnexeobhimuukrjxmammncddanqtplckhahcydinddoxkndzqczagvetkeyqvjcufbblkveedlhetndboyvniffjzyvtniridapyzbiyujqpmibclvivteqdktcwnzvuhvlxaiqwmlsknvopmsrrmkjjxbtjwpajeltfbjcoapcnizamampjmatacmyyudiumcyxumnlkdbazvszzbtaakgjvotzytmmazsftazvwacocuxehxdfuovwszzokllaazbmvixogndsuguufbtqysrikwikpmpvqlugvqanievukztwxdijimzsxqolzvtxdysruwlrrckmtiwxwsevxgvwqjdgqkhluvteoqghyrmeipqhviraaajmswxuomfylbzyyxcxbsxxigndxelkjxrqycldhwtdfwhloawwvuahgfjnirwztujulrbegjttceggaliixkgqlxfxrhmiwwbgumohsmswlizddanafpzpzzvwfpcchqbbzkhozyeiyoowizxsmheqmtluwacdyimwrrtfuvdfinxpmvegvxcfdnkwiqlnpvsortjcvyjkawrisabkywuqngpbqmirtxtnbnlzfiedjvsgdwcclqbkqdwxdvheoekfufjpqkbuezjyrhkfewjjfeuwaooheeavpegatqvrsttgblwjdxjcnvsnmcdhooospooqnqavbvwyxihyrvfzfwcqaidzsmhqbfmnccweehzsazqwgrwbaszgvgczvizidlnakowagnzrlhbzocjbmayepmfkqzaycvdoo"));
    }

    static String startEnigma(String date, String plain) {

        plain = plain.toLowerCase();

        try {
            RandomAccessFile file = new RandomAccessFile("EnigmaFile.txt", "r");
            String str;
            str = file.readLine();

            while (str != null) {

                if (str.contains("Date:")) {
                    String[] dataData = str.split(" ");
                    String dataFile = (dataData[1]);

                    if (dataFile.equals(date)) {

                        str = file.readLine();
                        String[] plugData = str.split(": ");
                        String plugBoard = plugData[1];

                        PlugBoard plugBoardEnigma = plugBoard(plugBoard);


                        str = file.readLine();
                        String[] rotor1Data = str.split(" ");
                        String rotor1 = rotor1Data[1].toLowerCase();
                        rotor1 = rotor1.substring(1, rotor1.length() - 1);

                        Rotor1 rotor1Enigma = new Rotor1(rotor1);


                        str = file.readLine();
                        String[] rotor2Data = str.split(" ");
                        String rotor2 = rotor2Data[1].toLowerCase();
                        rotor2 = rotor2.substring(1, rotor2.length() - 1);

                        Rotor2 rotor2Enigma = new Rotor2(rotor2);


                        str = file.readLine();
                        String[] rotor3Data = str.split(" ");
                        String rotor3 = rotor3Data[1].toLowerCase();
                        rotor3 = rotor3.substring(1, rotor3.length() - 1);

                        Rotor3 rotor3Enigma = new Rotor3(rotor3);


                        Enigma enigma = new Enigma(plugBoardEnigma, rotor3Enigma, rotor2Enigma, rotor1Enigma, plain);
                        return (enigma.getCipher());
                    }

                }

                str = file.readLine();

            }

            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    private static PlugBoard plugBoard(String plugBoard) {

        plugBoard = plugBoard.substring(1,plugBoard.length() - 1);
        String[] plugs = plugBoard.split(", ");

        Map<Character, Character> plugMap = new HashMap<>();
        for (String s: plugs) {
            s = s.toLowerCase();
            Character key = s.charAt(0);
            Character value = s.charAt(1);
            plugMap.put(key, value);
        }

        return new PlugBoard(plugMap);
    }

}
