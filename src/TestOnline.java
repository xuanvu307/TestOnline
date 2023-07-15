import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class TestOnline {
    public static void main(String[] args) {
        String str = "hfdawhwhcoomddă=aw, â=aa, đ=dd, ê=ee, ô=oo, ơ=ow, ư=w";
        System.out.println(counterVNKey(str));
    }

    public static int counterVNKey(String str) {
        Queue<Character> queue = new ArrayDeque<>();
        Set<String> set = new HashSet<>(Set.of("aw", "aa", "oo", "ow", "dd", "ee"));
        String s = str.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            queue.add(s.charAt(i));
        }
        int result = 0;
        while (!queue.isEmpty()) {
            char chr = queue.poll();
            if (chr == 'w') {
                result += 1;
            }
            if (chr == 'a' || chr == 'd' || chr == 'e' || chr == 'o') {
                if (!queue.isEmpty()) {
                    char c = queue.poll();
                    if (set.contains(String.valueOf(chr) + c)) {
                        result += 1;
                    }
                }
            }
        }
        return result;
    }
    //  time complexity O(n)
    //  space complexity O(n);
}
