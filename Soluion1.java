import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String str = input.nextLine();

        int len = str.length();
        String doubled = str + str;

        HashSet<Character> seen = new HashSet<>();

        int left = 0;
        int currentSum = 0;
        int best = 0;

        for (int right = 0; right < doubled.length(); right++) {

            char ch = doubled.charAt(right);

            while (seen.contains(ch) || (right - left + 1) > len) {

                char removeChar = doubled.charAt(left);
                seen.remove(removeChar);

                currentSum = currentSum - (removeChar - 'a' + 1);
                left++;
            }

            seen.add(ch);
            currentSum = currentSum + (ch - 'a' + 1);

            if (currentSum > best) {
                best = currentSum;
            }
        }

        System.out.println(best);
    }
}
