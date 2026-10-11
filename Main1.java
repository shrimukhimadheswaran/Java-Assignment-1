import java.util.*;

public class Main1  {

    static String encryptString(String Input1, int Input2) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < Input1.length(); i++) {

            char ch = Input1.charAt(i);

            // Keep spaces unchanged
            if (ch == ' ') {
                result.append(' ');
            }

            // Lowercase character
            else if (ch >= 'a' && ch <= 'z') {

                int value = ch - 'a';

                int encryptedValue = (value + Input2) % 26;

                char encryptedChar = (char) ('A' + encryptedValue);

                result.append(encryptedChar);
            }

            // Uppercase character
            else if (ch >= 'A' && ch <= 'Z') {

                int value = ch - 'A';

                int encryptedValue = (value + Input2) % 26;

                char encryptedChar = (char) ('a' + encryptedValue);

                result.append(encryptedChar);
            }

            // Keep other characters unchanged
            else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String Input1 = sc.nextLine();
        int Input2 = sc.nextInt();

        String result = encryptString(Input1, Input2);

        System.out.println(result);

        sc.close();
    }
}