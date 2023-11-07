package ua.foxminded.git.anagrams;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();

        AnagramMaker maker = new AnagramMaker(str);
        maker.viewAnagramMaker();

    }
}