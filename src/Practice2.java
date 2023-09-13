import java.util.Arrays;

public class Practice2 {
    public static void main(String[] args) {

        System.out.println(duplicateChars("Donald"));
        System.out.println(duplicateChars("orange"));

        System.out.println(getInitials("Ryan Gosling"));
        System.out.println(getInitials("Barack Obama"));

        int[] a = {44, 32, 86, 19};
        System.out.println(differenceEvenOdd(a));
        int[] a2 = {22, 50, 16, 63, 31, 55};
        System.out.println(differenceEvenOdd(a2));

        int[] b = {1,2,3,4,5};
        System.out.println(equalToAvg(b));
        int[] b2 = {1, 2, 3, 4, 6};
        System.out.println(equalToAvg(b2));

        int[] c = {1, 2, 3};
        System.out.println(Arrays.toString(indexMult(c)));
        int[] c2 = {3, 3, -2, 408, 3, 31};
        System.out.println(Arrays.toString(indexMult(c2)));

        System.out.println(reverse("Hello world"));
        System.out.println(reverse("The quick brown fox"));

        System.out.println(Tribonacci(7));
        System.out.println(Tribonacci(11));

        System.out.println(pseudoHash(5));
        System.out.println(pseudoHash(10));
        System.out.println(pseudoHash(0));

        System.out.println(botHelper("Hello, I’m under the water, please help me"));
        System.out.println(botHelper("Two pepperoni pizzas please"));

        System.out.println(isAnagram("listen", "silent"));
        System.out.println(isAnagram("eleven plus two", "twelve plus one"));
        System.out.println(isAnagram("hello", "world"));

    }
    public static boolean duplicateChars (String x) {
        x = x.toLowerCase();
        char[] chars = x.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                   return true;
                }
            }
        }
        return false;
    }

    public static String getInitials(String name) {
        char[] chars = name.toCharArray();
        String initials = String.valueOf(chars[0]);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                initials += String.valueOf(chars[i+1]);
                return initials;
            }
        }
        return "error";
    }

    public static int differenceEvenOdd(int[] array) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                a += array[i];
            } else {
                b += array[i];
            }
        }
        if (a > b) {
            return a - b;
        } else {
            return b - a;
        }
    }

    public static boolean equalToAvg(int[] array) {
        int a = 0;
        for (int i = 0; i < array.length; i++) {
            a += array[i];
        }
        float avg = (float) a / (float) array.length;
        for (int i = 0; i < array.length; i++) {
            if (array[i] ==  avg) {
                return true;
            }
        }
        return false;
    }

    public static int[] indexMult(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] *= i;
        }
        return array;
    }

    public static String reverse(String str) {
        char[] chars = str.toCharArray();
        String out = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            out += String.valueOf(chars[i]);
        }
        return out;
    }

    public static int Tribonacci(int x) {
        int[] a = {0, 0, 1};
        int b;
        for (int i = 0; i < x - 3; i++) {
            b = a[0] + a[1] + a[2];
            a[i%3] = b;
        }
        return Arrays.stream(a).max().getAsInt();
    }

    public static String pseudoHash(int x) {
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int i;
        String out = "";
        for (int j = 0; j < x; j++) {
            i = (int)(Math.random() * 100d / 6.25d);
            out += String.valueOf(chars[i]);
        }
        return out;
    }

    public static String botHelper(String str) {
        str = str.toLowerCase();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'h') {
                if (chars[i+1] == 'e') {
                    if (chars[i+2] == 'l') {
                        if (chars[i+3] == 'p') {
                            return "Calling for a staff member";
                        }
                    }
                }
            }
        }
        return "Keep waiting";
    }

    public static boolean isAnagram(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return String.valueOf(chars1).equals(String.valueOf(chars2));
    }

}
