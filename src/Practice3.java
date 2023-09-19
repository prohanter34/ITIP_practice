import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Practice3 {
    public static void main(String[] args) {

        System.out.println(replaceVovels("apple"));
        System.out.println(replaceVovels("Even if you did this task not by yourself," +
                " you have to understand every single line of code."));

        System.out.println(stringTransform("hello"));
        System.out.println(stringTransform("bookkeeper"));

        System.out.println(doesBlockFit(1, 3, 5, 4, 5));
        System.out.println(doesBlockFit(1, 8, 1, 1, 1));
        System.out.println(doesBlockFit(1, 2, 2, 1, 1));

        System.out.println(numCheck(243));
        System.out.println(numCheck(52));

        int[] a1 = {1, -3, 2};
        System.out.println(countRoots(a1));
        int[] a2 = {2, 5, 2};
        System.out.println(countRoots(a2));
        int[] a3 = {1, -6, 9};
        System.out.println(countRoots(a3));

        String[][] b1 = {
                {"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Banana", "Shop2", "Shop3", "Shop4"},
                {"Orange", "Shop1", "Shop3", "Shop4"},
            {"Pear", "Shop2", "Shop4"}
        };
        System.out.println(Arrays.toString(salesData(b1)));
        String[][] b2 = {
                {"Fridge", "Shop2", "Shop3"},
                {"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Laptop", "Shop3", "Shop4"},
                {"Phone", "Shop1", "Shop2", "Shop3", "Shop4"}
        };
        System.out.println(Arrays.toString(salesData(b2)));

        System.out.println(validSplit("apple eagle egg goat"));
        System.out.println(validSplit("cat dog goose fish"));

        int[] c1 = {3, 1, 4, 2, 7, 5};
        System.out.println(waveForm(c1));
        int[] c2 = {1, 2, 3, 4, 5};
        System.out.println(waveForm(c2));
        int[] c3 = {1, 2, -6, 10, 3};
        System.out.println(waveForm(c3));

        System.out.println(commonVovel("Hello world"));
        System.out.println(commonVovel("Actions speak louder than words."));

        int[][] d1 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 29, 10},
                {5, 5, 5, 5, 35},
                {7, 4, 3, 14, 2},
                {1, 0, 11, 10, 1}
        };
        d1 = dataScience(d1);
        for (int[] i : d1) {
            System.out.println(Arrays.toString(i));
        }
        int[][] d2 = {
                {6, 4, 19, 0, 0},
                {81, 25, 3, 1, 17},
                {48, 12, 60, 32, 14},
                {91, 47, 16, 65, 217},
                {5, 73, 0, 4, 21}
        };
        d2 = dataScience(d2);
        for (int[] i : d2) {
            System.out.println(Arrays.toString(i));
        }
    }

    public static String replaceVovels(String str) {
        char[] vovels = {'a', 'e', 'i', 'o', 'u', 'y', 'A', 'E', 'I', 'O', 'U', 'Y'};
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (char j : vovels) {
                if (chars[i] == j) {
                    chars[i] = '*';
                }
            }
        }
        return String.valueOf(chars);

    }

    public static String stringTransform(String str) {
        char[] chars = str.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i-1]) {
                str = str.replaceAll(String.valueOf(chars[i]).repeat(2),
                        "Double" + String.valueOf(chars[i]).toUpperCase());
            }
        }
        return str;
    }

    public static boolean doesBlockFit(int a, int b, int c, int w, int h) {
        if (a <= w & (b <= h | c <= h)) {
            return true;
        } else if (b <= w & (a <= h | c <= h)) {
            return true;
        } else if (c <= w & (a <= h | c <= h)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean numCheck(int num) {
        String str = String.valueOf(num);
        int num2 = 0;
        for (char i : str.toCharArray()) {
            num2 += (int) Math.pow((int) i, 2);
        }
        return num % 2 == num2 % 2;
    }

    public static int countRoots(int[] array) {
        double D = Math.pow(array[1], 2) - (double) (4 * array[0] * array[2]);
        int count = 0;
        if (D < 0) {
            return 0;
        } else if (D == 0) {
            if ((-array[1] + Math.sqrt(D))/2 % 1 == 0) {
                return 1;
            }
        } else {
            if ((-array[1] + Math.sqrt(D))/2 % 1 == 0) {
                count += 1;
            }
            if ((-array[1] - Math.sqrt(D))/2 % 1 == 0) {
                count += 1;
            }
        }
        return count;
    }

    public static String[] salesData(String[][] data) {
        int count = 0;
        ArrayList<String> output = new ArrayList<String>();
        for (String[] array : data) {
            if (array.length > count) {
                count = array.length;
            }
        }
        for (String[] array : data) {
            if (array.length == count) {
                output.add(array[0]);
            }
        }
        String[] out = new String[output.size()];
        return output.toArray(out);
    }

    public static boolean validSplit(String str) {
        char[] chars = str.toCharArray();
        ArrayList<Character> first = new ArrayList<>();
        ArrayList<Character> last = new ArrayList<>();
        first.add(chars[0]);
        last.add(chars[chars.length - 1]);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                first.add(chars[i+1]);
                last.add(chars[i-1]);
            }
        }
        boolean flag = true;
        for (char i : (ArrayList<Character>)first.clone()) {
            if (flag & !last.contains(i)) {
                first.remove(first.indexOf(i));
                flag = false;
            } else {
                if (last.contains(i)) {
                    last.remove(last.indexOf(i));
                    first.remove(first.indexOf(i));
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean waveForm(int[] array) {
        boolean flag;
        if (array[0] > array[1]) {
            flag = true;
        } else {
            flag = false;
        }
        for (int i = 1; i < array.length - 1; i++) {
            if (flag) {
                if (array[i] > array[i+1]) {
                    return false;
                } else {
                    flag = false;
                }
            } else {
                if (array[i] < array[i+1]) {
                    return false;
                } else {
                    flag = true;
                }
            }
        }
        return true;
    }

    public static char commonVovel(String str) {
        str = str.toLowerCase();
        char[] chars = {'a', 'e', 'i', 'o', 'u', 'y'};
        int[] count = new int[6];
        for (char i : str.toCharArray()) {
            for (int j = 0; j < chars.length; j++) {
                if (i == chars[j]) {
                    count[j] += 1;
                }
            }
        }
        int c = 0;
        char vovel = '0';
        for (int i = 0; i < count.length; i++) {
            if (count[i] > c) {
                c = count[i];
                vovel = chars[i];
            }
        }
        return vovel;
    }

    public static int[][] dataScience(int[][] data) {
        float avg = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                if (i != j) {
                    avg += data[j][i];
                }
            }
            data[i][i] = (int)Math.round(avg / (data.length - 1));
            avg = 0;
        }
        return data;
    }

}
