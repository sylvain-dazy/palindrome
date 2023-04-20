package palindrome;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PalindromeTest {

    private Palindrome palindrome;

    @BeforeEach
    public void setUp() {
        palindrome = new Palindrome();
    }

    private void assertNotPalindrom(String word) {
        assertFalse(palindrome.test(word));
    }

    private void assertPalindrom(String word) {
        assertTrue(palindrome.test(word));
    }

    @Test
    public void nullIsNotAPalindrom() {
        assertNotPalindrom(null);
    }

    @Test
    public void emptyStringIsAPalindrom() {
        assertPalindrom("");
    }

    @Test
    public void oneLetterIsAPalindrom() {
        assertPalindrom("a");
    }

    @Test
    public void twoDifferentLettersIsNotPalindrom() {
        assertNotPalindrom("ab");
    }

    @Test
    public void twoSameLettersIsAPalindrom() {
        assertPalindrom("aa");
    }

    @Test
    public void shouldBeCaseInsensitivity() {
        assertPalindrom("Aa");
    }

    @Test
    public void twoSameLettersSeparatedByOneLetterIsPalindrom() {
        assertPalindrom("aba");
        assertPalindrom("aaa");
    }

    @Test
    public void twoDifferentLettersSeparateByOneLetterIsNotAPalindrom() {
        assertNotPalindrom("abc");
        assertNotPalindrom("abb");
        assertNotPalindrom("aab");
    }

    @Test
    public void twoSameLettersSeparatedByTwoDifferentLettersIsNotPalindrom() {
        assertNotPalindrom("abca");
    }

    @Test
    public void twoSameLettersSeparatedByTwoSameLettersIsPalindrom() {
        assertPalindrom("abba");
    }

    @Test
    public void fiveLettersCase() {
        assertNotPalindrom("accba");
        assertPalindrom("abcba");
    }

    @Test
    public void sixLettersCase() {
        assertPalindrom("abccba");
    }

    @Test
    public void specialCharactersShouldBeIgnored() {
        assertPalindrom("a ba");
        assertPalindrom("a,ba");
        assertPalindrom("a;ba");
        assertPalindrom("a?ba");
        assertPalindrom("a!ba");
        assertPalindrom("a/ba");
        assertPalindrom("a-ba");
        assertPalindrom("a'ba");
        assertPalindrom("a.ba");
        assertPalindrom("a:ba");
        assertPalindrom("a\\ba");
    }

    @Test
    public void notAsciiLettersShouldBeReplacedByTheirEquivalent() {
        assertPalindrom("ée");
        assertPalindrom("èe");
        assertPalindrom("ëe");
        assertPalindrom("àa");
        assertPalindrom("ùu");
        assertPalindrom("çc");
    }

    @Test
    public void integration() {
        assertPalindrom("KayAk");
        assertPalindrom("Sos");
        assertPalindrom("1991");
        assertNotPalindrom("Palindrom");
        assertNotPalindrom("I am a palindrom");
        assertPalindrom("madam");
        assertPalindrom("racecar");
        assertPalindrom("12/11/21");
        assertPalindrom("A man, a plan, a canal - Panama");
        assertPalindrom("saippuakivikauppias");
        assertPalindrom("tattarrattat");
        assertPalindrom("La mariée ira mal");
        assertPalindrom("Eh ! ça va, la vache ?");
        assertPalindrom("Léon, émir cornu, d'un roc rime Noël");
    }
}
