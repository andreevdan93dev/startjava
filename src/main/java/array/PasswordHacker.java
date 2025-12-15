package array;

import java.util.Random;

public class PasswordHacker {
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String RESET = "\u001B[0m";
    private static final String[] POPULAR_PASSWORDS = {"admin", "qwerty", "123456"};

    public static void main(String[] args) throws InterruptedException {
        tryHack("123456".toCharArray());
        tryHack("qwerty".toCharArray());
        tryHack(generatePassword());
        tryHack(generatePassword());
        tryHack(generatePassword());

    }


    private static char[] generatePassword() {
        Random random = new Random();
        int length = random.nextInt(6, 13);
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            password.append((char) (random.nextInt(33, 122)));
        }
        return password.toString().toCharArray();
    }

    private static void tryHack(char[] password) throws InterruptedException {
        char[] spins = {'-', '\\', '|', '/'};
        System.out.print("Hacking:  ");

        for (int i = 0; i < spins.length * 3; i++) {
            System.out.print("\b" + spins[i % spins.length]);
            Thread.sleep(250);
        }

        if (isCanHack(password)) {
            System.out.print(GREEN + " ✓ Password cracked: " + new String(password));
        } else {
            System.out.print(RED + " ✗ Strong password: " + new String(password));
        }
        System.out.println(RESET);
    }

    private static boolean isCanHack(char[] password) throws InterruptedException {
        boolean isEmpty = password.length == 0;
        boolean enoughLength = password.length > 8;
        boolean onlyDigits = true;
        boolean onlyLetters = true;
        boolean onlySpecialSymbols = true;
        boolean hasSpecialSymbols = false;
        boolean onlyLowerCaseLetters = true;
        boolean onlyUpperCaseLetters = true;
        boolean isPopularPassword = isPopularPassword(password);
        for (int i = 0; i < password.length; i++) {
            if (Character.isDigit(password[i])) {
                onlyLetters = false;
                onlySpecialSymbols = false;
            } else if (Character.isLetter(password[i])) {
                onlyDigits = false;
                onlySpecialSymbols = false;
            } else {
                hasSpecialSymbols = true;
                onlyDigits = false;
                onlyLetters = false;
            }
            if (Character.isLowerCase(password[i])) {
                onlyUpperCaseLetters = false;
            } else if (Character.isUpperCase(password[i])) {
                onlyLowerCaseLetters = false;
            }
        }
        return !(!isEmpty
                && enoughLength
                && !onlyDigits
                && !onlyLetters
                && !onlySpecialSymbols
                && !onlyLowerCaseLetters
                && !onlyUpperCaseLetters
                && hasSpecialSymbols
                && !isPopularPassword);
    }

    private static boolean isPopularPassword(char[] password) {
        for (String s : POPULAR_PASSWORDS) {
            if (s.equals(new String(password))) {
                return true;
            }
        }
        return false;
    }
}
