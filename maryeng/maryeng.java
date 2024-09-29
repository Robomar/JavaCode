package maryeng;

import java.util.Scanner;

public class maryeng {

    // Method to check if the string contains only numbers
    public static boolean isNumberString(String s) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ccNumber;

        System.out.println("This program uses the Luhn Algorithm to validate a CC number.");
        System.out.println("You can enter 'exit' anytime to quit.");

        while (true) {
            System.out.print("Please enter a CC number to validate: ");
            ccNumber = scanner.next();

            if (ccNumber.equals("exit"))
                break;

            else if (!isNumberString(ccNumber)) {
                System.out.println("Bad input!");
                continue;
            }

            int len = ccNumber.length();
            int doubleEvenSum = 0;

            // Step 1: Double every second digit from the right
            for (int i = len - 2; i >= 0; i = i - 2) {
                int dbl = ((ccNumber.charAt(i) - '0') * 2);
                if (dbl > 9) {
                    dbl = (dbl / 10) + (dbl % 10);
                }
                doubleEvenSum += dbl;
            }

            // Step 2: Add every odd placed digit from the right
            for (int i = len - 1; i >= 0; i = i - 2) {
                doubleEvenSum += (ccNumber.charAt(i) - '0');
            }

            // Step 3: Check if the total sum is divisible by 10
            if (doubleEvenSum % 10 == 0) {
                System.out.println("Valid!");
            } else {
                System.out.println("Invalid!");
            }
        }

        scanner.close();
    }
}