package palindrome;

public class Palindrome {

    public static boolean test(String word) {
        return word == null ? false : checkAllLetters(new PalindromCandidate(word).toString());
    }

    private static boolean checkAllLetters(String word) {
        for (int position = 0; position < word.length() / 2; position++)
            if (symetricLettersAreDifferents(word, position))
                return false;
        return true;
    }

    private static boolean symetricLettersAreDifferents(String word, int position) {
        char letter = word.charAt(position);
        char symetricLetter = word.charAt(symetricPosition(word, position));
        return letter != symetricLetter;
    }

    private static int symetricPosition(String word, int position) {
        return word.length() - position - 1;
    }
}
