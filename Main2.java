
import java.util.*;

public class Main2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        int[] freq = new int[256];

        // Count frequency
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }

        Character[] chars = new Character[s.length()];

        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }

        // Sort according to frequency
        Arrays.sort(chars, new Comparator<Character>() {

            public int compare(Character a, Character b) {

                if (freq[b] != freq[a]) {
                    return Integer.compare(freq[b], freq[a]);
                }

                return Character.compare(a, b);
            }
        });

        StringBuilder result = new StringBuilder();

        for (char ch : chars) {
            result.append(ch);
        }

        System.out.println(result);

        sc.close();
    }
}