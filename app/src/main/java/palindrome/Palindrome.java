package palindrome;

public class Palindrome {

    private static final String IGNORED_CHARACTERS_REGEX = "\\s|,|;|\\?|!|/|-|'|:|\\Q.\\E|\\Q\\\\E";

    public boolean test(String word) {
        return word == null ? false : checkAllLetters(onlyAsciiLetters(word));
    }

    private String ignoreSpecialChars(String word) {
        return word.replaceAll(IGNORED_CHARACTERS_REGEX, "");
    }

    private String replaceToAsciiLetters(String word) {
        return word.replaceAll("é|è|ë", "e").replaceAll("à", "a").replaceAll("ù", "u").replaceAll("ç", "c");
    }

    private String onlyAsciiLetters(String word) {
        return replaceToAsciiLetters(ignoreSpecialChars(word)).toLowerCase();
    }

    private boolean checkAllLetters(String word) {
        for (int position = 0; position < word.length() / 2; position++)
            if (symetricLettersAreDifferents(word, position))
                return false;
        return true;
    }

    private boolean symetricLettersAreDifferents(String word, int position) {
        char letter = word.charAt(position);
        char symetricLetter = word.charAt(symetricPosition(word, position));
        return letter != symetricLetter;
    }

    private int symetricPosition(String word, int position) {
        return word.length() - position - 1;
    }
}
