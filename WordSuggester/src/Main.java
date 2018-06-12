import Interfaces.Dictionary;
import Interfaces.Filler;
import Interfaces.LetterWord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    private static LetterWord mainWord;
    private static int mainWordSize;
    private static final String DICTIONARY_FILE = "bg-BG.dic";

    public static void main(String[] args) throws IOException {

        Dictionary<LetterWord> dict = new LetterWordDictionary();

        Filler filler = new DictionaryFiller(dict);
        filler.fillFromFile(DICTIONARY_FILE);

        while (true) {
            initializeMainWord();

            List<LetterWord> subWords = dict.allSubwords(mainWord, mainWordSize);
            System.out.println(subWords);
        }

    }

    private static void initializeMainWord() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String main = reader.readLine();
        int size =  Integer.parseInt(reader.readLine());
        mainWordSize = size;
        Main.mainWord = new LetterWordImpl(main);
    }
}
