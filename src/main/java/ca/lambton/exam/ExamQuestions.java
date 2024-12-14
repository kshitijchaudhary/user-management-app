package ca.lambton.exam;

public class ExamQuestions {

    // Q6: Recursive function to count consonants in a string
    public static int countConsonants(String str) {
        return countConsonantsRecursive(str, str.length() - 1);
    }

    private static int countConsonantsRecursive(String str, int index) {
        if (index < 0) {
            return 0;
        }

        char ch = str.charAt(index);
        // Check if the character is a consonant
        if (isConsonant(ch)) {
            return 1 + countConsonantsRecursive(str, index - 1);
        } else {
            return countConsonantsRecursive(str, index - 1);
        }
    }

    private static boolean isConsonant(char ch) {
        // Check if the character is a consonant (non-vowel alphabetic character)
        return Character.isAlphabetic(ch) && !"aeiouAEIOU".contains(String.valueOf(ch));
    }

    // Q7: Recursive function to check if a number is prime
    public static boolean isPrime(int n) {
        return isPrimeRecursive(n, 2);
    }

    private static boolean isPrimeRecursive(int n, int divisor) {
        if (n <= 1) {
            return false; // 1 and negative numbers are not prime
        }
        if (divisor * divisor > n) {
            return true; // If divisor squared is greater than n, then n is prime
        }
        if (n % divisor == 0) {
            return false; // If n is divisible by any divisor, it's not prime
        }
        return isPrimeRecursive(n, divisor + 1);
    }
}
