import Interfaces.Dictionary;
import Interfaces.Filler;
import Interfaces.LetterWord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DictionaryFiller implements Filler {
    private Dictionary<LetterWord> dict;
    private boolean isFilled;


    public DictionaryFiller(Dictionary<LetterWord> dict) {
        this.dict = dict;
        this.isFilled = false;
    }

    @Override
    public void fillFromFile(String filePath) {
        if (isFilled) {
            System.out.println("Dictionary have already been filled");
            return;
        }

        System.out.println("Dictionary initializing...");
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            while (line != null) {
                LetterWord word = new LetterWordImpl(line.trim());
                this.dict.add(word);

                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.isFilled = true;
        System.out.println("The dictionary have been initialized!");
    }
}
