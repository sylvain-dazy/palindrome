package palindrome;

public class App {

    public static void main(String[] args) {
        System.out.println(palindromResult("Engage le jeu que je le gagne"));
    }

    public static String palindromResult(String word) {
        String result = Palindrome.test(word) ? "is" : "is not";
        return String.format("'%s' %s a palindrome", word, result);
    }
}
