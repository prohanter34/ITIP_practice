import javax.swing.*;
import java.util.*;

public class Practice4 {

    public static void main(String[] args) {

        System.out.println(nonRepeatable("abracadabra"));
        System.out.println(nonRepeatable("paparazzi"));

        String[] arr1 = generateBrackets(1);
        for (String i : arr1) {
            System.out.println(i);
        }
        String[] arr2 = generateBrackets(2);
        for (String i : arr2) {
            System.out.println(i);
        }
        String[] arr3 = generateBrackets(3);
        for (String i : arr3) {
            System.out.println(i);
        }

        String[] arr21 = binarySystem(3);
        for (String i : arr21) {
            System.out.println(i);
        }
        String[] arr22 = binarySystem(4);
        for (String i : arr22) {
            System.out.println(i);
        }

        System.out.println(alphabeticRow("abcdjuwx"));
        System.out.println(alphabeticRow("klmabzyxw"));

        System.out.println(countLetters("aaabbcdd"));
        System.out.println(countLetters("vvvvaajaaaaa"));

        System.out.println(convertToNum("eight"));
        System.out.println(convertToNum("five hundred sixty seven"));

        System.out.println(uniqueSubstring("123412324"));
        System.out.println(uniqueSubstring("111111"));
        System.out.println(uniqueSubstring("77897898"));

        int[][] array1 = {{1, 3, 1},
                          {1, 5, 1},
                          {4, 2, 1}};
        System.out.println(shortestWay(array1));
        int[][] array2 = {{2, 7, 3},
                          {1, 4, 8},
                          {4, 5, 9}};
        System.out.println(shortestWay(array2));

        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));

        System.out.println(switchNums(519, 723));
        System.out.println(switchNums(491, 3912));
        System.out.println(switchNums(6274, 71259));
    }

    public static String nonRepeatable(String str) {
        StringBuilder out = new StringBuilder();
        for (char i : str.toCharArray()) {
            if (!out.toString().contains(String.valueOf(i))) {
                out.append(i);
            }
        }
        return out.toString();
    }

    public static String[] generateBrackets(int n) {
        int num1 = (int)Math.pow(2, n*2-1);
        int num2 = (int)Math.pow(2, n*2) - 1;
        ArrayList<String> list = new ArrayList<>();
        for (int i = num1; i <= num2; i++) {
            list.add(Integer.toBinaryString(i));
        }
        ArrayList<String> list2 = new ArrayList<>();
        for (String s : list) {
            int count0 = 0;
            int count1 = 0;
            for (char j : s.toCharArray()) {
                if (j == '0') {
                    count0 += 1;
                } else {
                    count1 += 1;
                }
            }
            if (count0 == count1) {
                list2.add(s);
            }
        }
        ArrayList<String> listOut = new ArrayList<>();
        for (String i : list2) {
            int count1 = 1;
            boolean flag = true;
            for (char j : i.toCharArray()) {
                if (j == '1') {
                    count1 += 1;
                } else {
                    count1 -= 1;
                    if (count1 < 1) {
                        flag = false;
                    }
                }
            }
            if (flag) {

                listOut.add(i.replaceAll("1", "(").replaceAll("0", ")"));
            }
        }
        String[] array = new String[listOut.size()];
        array = listOut.toArray(array);
        return array;
    }

    public static String[] binarySystem(int n) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = (int) Math.pow(2, n); i <= Math.pow(2, n+1) - 1; i++) {
            list.add(Integer.toBinaryString(i).replaceFirst("1", ""));
        }
        ArrayList<String> listOut = new ArrayList<>();
        for (String i : list) {
            char[] chars = i.toCharArray();
            boolean flag0 = true;
            for (int j = 1; j < chars.length; j++) {
                if (chars[j] == '0' && chars[j] == chars[j - 1]) {
                    flag0 = false;
                    break;
                }
            }
            if (flag0) {
                listOut.add(i);
            }
        }
        String[] array = new String[listOut.size()];
        listOut.toArray(array);
        return array;
    }

    public static String alphabeticRow(String str) {
        char[] chars = str.toCharArray();
        StringBuilder out1 = new StringBuilder();
        StringBuilder out2 = new StringBuilder();
        out1.append(chars[0]);
        out2.append(chars[0]);
        String outStr = "";
        for (int i = 1; i < str.length(); i++) {
            if (chars[i] == chars[i-1] + 1) {
                out1.append(chars[i]);
            } else {
                String str1 = out1.toString();
                if (str1.length() > outStr.length()) {
                    outStr = str1;
                }
                out1 = new StringBuilder();
                out1.append(chars[i]);
            }
            if (chars[i] + 1 == chars[i-1]) {
                out2.append(chars[i]);
            } else {
                String str1 = out2.toString();
                if (str1.length() > outStr.length()) {
                    outStr = str1;
                }
                out2 = new StringBuilder();
                out2.append(chars[i]);
            }
        }
        String str1 = out1.toString();
        if (str1.length() > outStr.length()) {
            outStr = str1;
        }
        String str2 = out2.toString();
        if (str2.length() > outStr.length()) {
            outStr = str2;
        }
        return outStr;
    }


    public static String countLetters(String str) {
        ArrayList<Pair> list = new ArrayList<>();
        char[] chars = str.toCharArray();
        int count = 1;
        char letter = chars[0];
        for (int i = 1; i < str.length(); i++) {
            if (chars[i] == chars[i-1]) {
                count += 1;
            } else {
                list.add(new Pair(count, letter));
                letter = chars[i];
                count = 1;
            }
        }
        list.add(new Pair(count, letter));
        Collections.sort(list);
        StringBuilder out = new StringBuilder();
        for (Pair i : list) {
            out.append(i.value.toString());
            out.append(i.key.toString());
        }
        return out.toString();
    }

    public static int convertToNum(String str) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        map.put("ten", 10);
        map.put("eleven", 11);
        map.put("twelve", 12);
        map.put("thirteen", 13);
        map.put("fourteen", 14);
        map.put("fifteen", 15);
        map.put("sixteen", 16);
        map.put("seventeen", 17);
        map.put("eighteen", 18);
        map.put("nineteen", 19);
        map.put("twenty", 20);
        map.put("thirty", 30);
        map.put("forty", 40);
        map.put("fifty", 50);
        map.put("sixty", 60);
        map.put("seventy", 70);
        map.put("eighty", 80);
        map.put("ninety", 90);
        map.put("hundred", 100);
        String[] array = str.split(" ");
        int num = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (Objects.equals(array[i + 1], "hundred")) {
                num += map.get(array[i]) * 100;
                i++;
            } else {
                num += map.get(array[i]);
            }
        }
        if (!Objects.equals(array[array.length - 1], "hundred")) {
            num += map.get(array[array.length - 1]);
        }
        return num;
    }

    public static String uniqueSubstring(String str) {
        StringBuilder strB = new StringBuilder();
        String out = "";
        for (Character i : str.toCharArray()) {
            if (!strB.toString().contains(i.toString())) {
                strB.append(i);
            } else if (strB.toString().length() > out.length()) {
                out = strB.toString();
            }
        }
        return out;
    }

    public static int shortestWay(int[][] array) {
        for (int i = 1; i < array.length; i++) {
            array[i][0] += array[i-1][0];
            array[0][i] += array[0][i-1];
        }
        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                array[i][j] += Math.min(array[i-1][j], array[i][j-1]);
            }
        }
        return array[array.length - 1][array.length - 1];
    }

    public static String numericOrder(String str) {
        String[] array = str.split(" ");
        HashMap<Integer, String> map = new HashMap<>();
        for (String i : array) {
            StringBuilder strB = new StringBuilder();
            int num = 0;
            for (Character j : i.toCharArray()) {
                if (Character.isDigit(j)) {
                    if (num == 0) {
                        num = Integer.parseInt(j.toString());
                    } else {
                        num = num * 10 + Integer.parseInt(j.toString());
                    }
                } else {
                    strB.append(j);
                }
            }
            map.put(num, strB.toString());
        }
        StringBuilder out = new StringBuilder();
        for (int i = 1; i < array.length + 1; i++) {
            out.append(map.get(i));
            if (i != array.length) {
                out.append(" ");
            }
        }
        return out.toString();
    }

    public static int switchNums(Integer num1, Integer num2) {
        char[] chars1 = num1.toString().toCharArray();
        char[] chars2 = num2.toString().toCharArray();
        for (int j = 0; j < chars2.length; j++) {
            char max = '0';
            int maxInd = 0;
            for (int i = 0; i < chars1.length; i++) {
                if (chars1[i] > max) {
                    max = chars1[i];
                    maxInd = i;
                }
            }
            if (chars1[maxInd] > chars2[j]) {
                chars2[j] = chars1[maxInd];
                chars1[maxInd] = '0';
            }
        }
        return Integer.parseInt(String.valueOf(chars2));
    }
}
