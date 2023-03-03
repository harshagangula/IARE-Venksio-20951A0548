import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ReverseParagraph {

    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static String reverseParagraph(String paragraph) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        List<String> reversedStrings = new ArrayList<>();

        String[] strings = paragraph.split(" ");

        for (String s : strings) {
            Thread t = new Thread(() -> reversedStrings.add(reverseString(s)));
            threads.add(t);
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }

        return String.join(" ", reversedStrings);
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter:");
        String a =sc.nextLine();
        String reversedParagraph = reverseParagraph(a);
        System.out.println(reversedParagraph);
    }
}
