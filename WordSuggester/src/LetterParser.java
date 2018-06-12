public final class LetterParser {
    public static int cyrillicToIndex(char letter) {
        String str = String.valueOf(letter).trim();
        switch (str) {
            case "а":
            case "А":
                return 0;
            case "б":
            case "Б":
                return 1;
            case "в":
            case "В":
                return 2;
            case "г":
            case "Г":
                return 3;
            case "д":
            case "Д":
                return 4;
            case "е":
            case "Е":
                return 5;
            case "ж":
            case "Ж":
                return 6;
            case "з":
            case "З":
                return 7;
            case "и":
            case "И":
                return 8;
            case "й":
            case "Й":
                return 9;
            case "к":
            case "К":
                return 10;
            case "л":
            case "Л":
                return 11;
            case "м":
            case "М":
                return 12;
            case "н":
            case "Н":
                return 13;
            case "о":
            case "О":
                return 14;
            case "п":
            case "П":
                return 15;
            case "р":
                return 16;
            case "с":
            case "С":
                return 17;
            case "т":
            case "Т":
                return 18;
            case "у":
            case "У":
                return 19;
            case "ф":
            case "Ф":
                return 20;
            case "х":
            case "Х":
                return 21;
            case "ц":
            case "Ц":
                return 22;
            case "ч":
            case "Ч":
                return 23;
            case "ш":
            case "Ш":
                return 24;
            case "щ":
            case "Щ":
                return 25;
            case "ъ":
            case "Ъ":
                return 26;
            case "ь":
            case "Ь":
                return 27;
            case "ю":
            case "Ю":
                return 28;
            case "я":
            case "Я":
                return 29;

            default:
                throw new RuntimeException("LetterParser: failed to parse " + str + " from cyrillic letter to index");
        }
    }

    public static char indexToCyrillic(int index) {
        if (index < 0 || index > 29) {
            throw new RuntimeException("LetterParser: failed to parse from index to cyrillic letter");
        }
        return (char) (index + 'а');
    }
}
