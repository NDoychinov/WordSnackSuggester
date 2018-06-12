import Interfaces.Dictionary;
import Interfaces.LetterWord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterWordDictionary implements Dictionary<LetterWord> {
    //The key represents the length of the words contained in the value
    private Map<Integer, List<LetterWord>> dict;

    public LetterWordDictionary() {
        this.dict = new HashMap<>();
    }

    @Override
    public void add(LetterWord word) {
        if (!this.dict.containsKey(word.length())) {
            this.dict.put(word.length(), new ArrayList<>());
        } else {
            this.dict.get(word.length()).add(word);
        }
    }

    @Override
    public List<LetterWord> allSubwords(LetterWord word) {
        List<LetterWord> matched = new ArrayList<>();
        for (Map.Entry<Integer, List<LetterWord>> integerListEntry : this.dict.entrySet()) {
            if (integerListEntry.getKey() <= word.length()) {
                for (LetterWord letterWord : integerListEntry.getValue()) {
                    if (letterWord.isSubWord(word)) {
                        matched.add(letterWord);
                    }
                }
            }
        }
        return matched;
    }

    @Override
    public List<LetterWord> allSubwords(LetterWord word, int length) {
        List<LetterWord> words = this.dict.get(length);
        List<LetterWord> matched = new ArrayList<>();
        for (LetterWord letterWord : words) {
            if (letterWord.isSubWord(word)) {
                matched.add(letterWord);
            }
        }
        return matched;
    }
}
