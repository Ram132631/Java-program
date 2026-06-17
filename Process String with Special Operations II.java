import java.util.*;
public class Main {
    public char processStr(String s, long k) {
        int n = s.length();
        long[] len = new long[n];
        long cur = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if ('a' <= c && c <= 'z') {
                cur++;
            } else if (c == '*') {
                if (cur > 0) {
                    cur--;
                }
            } else if (c == '#') {
                cur *= 2;
            } else { // %
                // length unchanged
            }
            len[i] = cur;
        }
        if (k >= cur) {
            return '.';
        }
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            long before = (i == 0) ? 0 : len[i - 1];
            long after = len[i];
            if ('a' <= c && c <= 'z') {
                if (k == before) {
                    return c;
                }
            } else if (c == '*') {
                continue;
            } else if (c == '#') {
                if (k >= before) {
                    k -= before;
                }
            } else {
                k = after - 1 - k;
            }
        }
        return '.';
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        long k = sc.nextLong();
        Main obj = new Main();
        System.out.println(obj.processStr(s, k));
        sc.close();
    }
}