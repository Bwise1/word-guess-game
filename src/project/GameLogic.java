package project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameLogic {

    MainGameUI game;

    String currentWord, maskedWord;

    List<String> wordsFromFile = new ArrayList<String>();

    public GameLogic(MainGameUI parentGUI) {
        game = parentGUI;

    }

    public void readWords() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("word.txt"));
            String line = reader.readLine();

            while (line != null) {
                String[] wordsLine = line.split(" ");
                for (String word : wordsLine) {
                    wordsFromFile.add(word);
                }
                line = reader.readLine();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//read words

    public void RandomWord() {
        Random rand = new Random(System.currentTimeMillis());
        currentWord = wordsFromFile.get(rand.nextInt(wordsFromFile.size()));
    }

    public void maskString(String s, int x) {
        int n = s.length() / x; //n=2
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {     //i=0, i<6
            if (n >= 1 && (i < n - 1 || i >= (s.length() - n))) {
                sb.append(s.charAt(i));
            } else {
                sb.append("?");
            }
        }
        System.out.println(sb.toString());
        maskedWord = sb.toString();
    }

}
