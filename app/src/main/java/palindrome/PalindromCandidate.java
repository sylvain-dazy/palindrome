package palindrome;

public class PalindromCandidate {

    private static final String IGNORED_CHARACTERS_REGEX = "\\s|,|;|\\?|!|/|-|'|:|\\Q.\\E|\\Q\\\\E";

    private String word;

    public PalindromCandidate(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        ignoreSpecialChars();
        replaceToAsciiLetters();
        return word.toLowerCase();
    }

    private void ignoreSpecialChars() {
        word = word.replaceAll(IGNORED_CHARACTERS_REGEX, "");
    }

    private void replaceToAsciiLetters() {
        word = word.replaceAll("é|è|ë", "e").replaceAll("à", "a").replaceAll("ù", "u").replaceAll("ç", "c");
    }
}
