import Interfaces.LetterWord;

public class LetterWordImpl implements LetterWord {
    private String word;
    private int[] letterCounter;
    private int length;

    public LetterWordImpl(String word) {
        this.word = word;
        this.length = word.length();
        this.createWordCh(word);
    }

    private void createWordCh(String word) {
        this.letterCounter = new int[31];
        int parsed;
        for (int i = 0; i < word.length(); i++) {
            try {
                parsed = LetterParser.cyrillicToIndex(word.charAt(i));
            } catch (RuntimeException re) {
                parsed = 30;
            }

            this.letterCounter[parsed]++;
        }
    }

    @Override
    public int length() {
        return this.length;
    }

    @Override
    public boolean isSubWord(LetterWord word) {
        for (int i = 'а'; i <= 'я'; i++) {
            int wordANum = this.numberOfChar((char) i);
            int wordBNum = word.numberOfChar((char) i);
            if (wordANum > wordBNum) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int numberOfChar(char ch) {
        int index;
        try {
            index = LetterParser.cyrillicToIndex(ch);
        } catch (RuntimeException re) {
            index = 30;
        }
        return letterCounter[index];
    }

    @Override
    public String toString() {
        return this.word;
    }
}
