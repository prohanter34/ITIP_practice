import java.util.*;

public class Practice6 {
    public static void main(String[] args) {

        System.out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.", "sworn love lived"));
        System.out.println(hiddenAnagram("An old west action hero actor", "Clint Eastwood"));
        System.out.println(hiddenAnagram("Mr. Mojo Rising could be a song title", "Jim Morrison"));
        System.out.println(hiddenAnagram("Banana? margaritas", "ANAGRAM"));
        System.out.println(hiddenAnagram("D  e b90it->?$ (c)a r...d,,#~", "bad credit"));
        System.out.println(hiddenAnagram("Bright is the moon", "Bongo mirth"));

        String[] a = collect("intercontinentalisationalism", 6);
        for (String i : a) {
            System.out.println(i);
        }
        String[] a1 = collect("strengths", 3);
        for (String i : a1) {
            System.out.println(i);
        }
        String[] a2 = collect("pneumonoultramicroscopicsilicovolcanoconiosis", 15);
        for (String i : a2) {
            System.out.println(i);
        }

        System.out.println(nicoCipher("myworldevolvesinhers", "tesh"));
        System.out.println(nicoCipher("andiloveherso", "tesha"));
        System.out.println(nicoCipher("mubashirhassan", "crazy"));
        System.out.println(nicoCipher("edabitisamazing", "matt"));
        System.out.println(nicoCipher("iloveher", "612345"));

        int[] b = twoProduct(new int[] {1, 2, 3, 9, 4, 5, 15}, 45);
        for (int i : b) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
        int[] b1 = twoProduct(new int[] {1, 2, 3, 9, 4, 15, 3, 5}, 45);
        for (int i : b1) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
        int[] b2 = twoProduct(new int[] {1,  2, -1,  4,  5,  6,  10, 7}, 20);
        for (int i : b2) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
        int[] b3 = twoProduct(new int[] {1, 2, 3, 4, 5,  6, 7, 8, 9, 10}, 10);
        for (int i : b3) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
        int[] b4 = twoProduct(new int[] {100, 12, 4, 1, 2}, 15);
        for (int i : b4) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();

        int[] c = isExact(6);
        for (int i : c) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
        int[] c1 = isExact(24);
        for (int i : c1) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
        int[] c2 = isExact(125);
        for (int i : c2) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
        int[] c3 = isExact(720);
        for (int i : c3) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
        int[] c4 = isExact(1024);
        for (int i : c4) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
        int[] c5 = isExact(40320);
        for (int i : c5) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();

        System.out.println(fractions("0.(6)"));
        System.out.println(fractions("1.(1)"));
        System.out.println(fractions("3.(142857)"));
        System.out.println(fractions("0.19(2367)"));
        System.out.println(fractions("0.1097(3)"));

        System.out.println(pilish_string("33314444"));
        System.out.println(pilish_string("TOP"));
        System.out.println(pilish_string("X"));

        System.out.println(generateNonconsecutive("3 + 5 * (2 - 6)"));
        System.out.println(generateNonconsecutive("6 - 18 / (-1 + 4)"));
        System.out.println(generateNonconsecutive("6 - 18 / (-1 * 4 + 10)"));

        System.out.println(isValid("aabbcd"));
        System.out.println(isValid("aabbccddeefghi"));
        System.out.println(isValid("abcdefghhgfedecba"));

        System.out.println(findLCS("abcd", "bd"));
        System.out.println(findLCS("aggtab", "gxtxamb"));
        System.out.println(findLCS("HABRAHABR", "HARBOUR"));
    }

    public static String hiddenAnagram(String str1, String str2) {
        str1 = str1.toLowerCase();
        str1 = str1.replaceAll("[^a-z]", "");
        str2 = str2.toLowerCase();
        str2 = str2.replaceAll("[^a-z]", "");
        for (int i = 0; i <= str1.length() - str2.length(); i++) {
            String str = str1.substring(i, i + str2.length());
            if (Practice2.isAnagram(str2, str)) {
                return str;
            }
        }
        return "not found";
    }

    public static String[] collect(String str, int num) {
        int count = str.length() / num;
        char[] chars = str.toCharArray();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(String.valueOf(Arrays.copyOfRange(chars, i*num, i*num+num)));
        }
        String[] out = new String[list.size()];
        out = list.toArray(out);
        return out;
    }

    public static String nicoCipher(String str, String key) {
        str = whiteSpaceAdd(str, key.length());
        char[] charsKey = key.toCharArray();
        Arrays.sort(charsKey);
        ArrayList<Object[]> keyList = new ArrayList<>();
        for (int i = 0; i < charsKey.length; i++) {
            keyList.add(new Object[] {charsKey[i], i});
        }
        HashMap<Integer, Character[]> map = new HashMap<>();
        char[] chars = str.toCharArray();
        int height = str.length() / key.length();
        for (int i = 0; i < key.length(); i++) {
            Character[] chars1 = new Character[height];
            for (int j = 0; j < height; j++) {
                chars1[j] = chars[i + key.length() * j];
            }
            for (int j = 0; j < keyList.size(); j++) {
                if (keyList.get(j)[0] != null) {
                    if (keyList.get(j)[0].equals(key.charAt(i))) {
                        map.put((Integer) keyList.get(j)[1], chars1);
                        keyList.set(j, new Object[] {null, null});
                        break;
                    }
                }
            }
        }
        List<Map.Entry<Integer, Character[]>> outList = map.entrySet().stream().sorted((x, y) -> x.getKey().compareTo(y.getKey())).toList();
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < key.length(); j++) {
                out.append(outList.get(j).getValue()[i]);
            }
        }
        return out.toString();
    }

    private static String whiteSpaceAdd(String str, int num) {
        int length = num - str.length() % num;
        str += " ".repeat(length);
        return str;
    }

    public static int[] twoProduct(int[] array, int num) {
        int gap = 999999999;
        int[] out = new int[2];
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] * array[j] == num) {
                    if (j - i < gap) {
                        out[1] = array[j];
                        out[0] = array[i];
                        gap = j - i;
                    }
                }
            }
        }
        if (out[0] == 0) {
            return new int[0];
        } else {
            return out;
        }
    }

    public static int[] isExact(int num) {
        if (num == 2) {
            return new int[] {2, 2};
        }
        for (int i = num / 2; i > 2; i--) {
            if (num % i == 0) {
                int[] array = isExact(num/ i);
                if (Arrays.equals(array, new int[0])) {
                    continue;
                }
                if (array[1] == i - 1) {
                    return new int[] {num, i};
                }
            }
        }
        return new int[0];
    }

    public static String fractions(String str) {
        int[] array = new int[3];
        String[] split = str.split("\\.");
        array[0] = Integer.parseInt(split[0]);
        StringBuilder strNum1 = new StringBuilder();
        StringBuilder strNum2 = new StringBuilder();
        char[] chars = split[1].toCharArray();
        boolean flag = true;
        for (int i = 0; i < chars.length; i++) {
            if (flag) {
                if (chars[i] != '(') {
                    strNum1.append(chars[i]);
                } else {
                    flag = false;
                    if (!strNum1.isEmpty()) {
                        array[1] = Integer.parseInt(strNum1.toString());
                    }
                }
            } else {
                if(chars[i] != ')') {
                    strNum2.append(chars[i]);
                } else {
                    if (!strNum2.isEmpty()) {
                        array[2] = Integer.parseInt(strNum2.toString());
                    }
                    break;
                }
            }
        }
        String denominatorStr = "9".repeat(strNum2.length()) +
                "0".repeat(strNum1.length());
        int denominator = Integer.parseInt(denominatorStr);
        int numerator = Integer.parseInt(strNum1.append(strNum2.toString()).toString()) - array[1];
        int[] fraction = simplifyFraction(numerator, denominator);
        fraction[0] += array[0] * fraction[1];
        return fraction[0] + "/" + fraction[1];
    }

    private static int[] simplifyFraction(int numerator, int denominator) {
        for(;;) {
            int nod = findNOD(denominator, numerator);
            if (nod > 1) {
                denominator /= nod;
                numerator /= nod;
            } else {
                return new int[] {numerator, denominator};
            }
        }
    }

    private static int findNOD(int num1, int num2) {
        int max = Integer.max(num1, num2);
        for (int i = max / 2; i > 1; i--) {
            if (num1 % i == 0 && num2 % i == 0) {
                return i;
            }
        }
        return 1;
    }

    public static String pilish_string (String str) {
        ArrayList<String> list = new ArrayList<>();
        double pi = Math.PI;
        String strPi = String.valueOf(pi);
        char[] chars = strPi.toCharArray();
        char[] chars2 = str.toCharArray();
        int startInd = 0;
        for (char i : chars) {
            if (i != '.') {
                int length = Integer.parseInt(String.valueOf(i));
                int counter = 0;
                StringBuilder stB = new StringBuilder();
                if (startInd >= chars2.length) {
                    break;
                }
                for (int j = startInd; j < startInd + length; j++) {
                    if (j < chars2.length) {
                        stB.append(chars2[j]);
                    } else {
                        int lenRep = length - counter;
                        stB.append(stB.substring(stB.length() - 1).repeat(lenRep));
                        break;
                    }
                    counter += 1;
                    if (counter == length) {
                        break;
                    }
                }
                list.add(stB.toString());
                startInd += Integer.parseInt(String.valueOf(i));
            }
        }
        StringBuilder out = new StringBuilder();
        for (String i : list) {
            out.append(" ").append(i);
        }
        return out.substring(1);
    }

    public static String generateNonconsecutive(String str) {
        str = str.replaceAll("\\(", "( ").replaceAll("\\)", " )");
        String[] array = str.split(" ");
        ArrayList<String> list = new ArrayList<>(Arrays.asList(array));
        list = generateNonList(list);
        return String.valueOf(list.get(0));
    }

    private static ArrayList<String> generateNonList(ArrayList<String> list) {
        boolean flag = false;
        ArrayList<String> subList = new ArrayList<>();
        int first = 0;
        int last;
        while (list.contains("(")) {
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i - 1).equals("(")) {
                    first = i;
                    flag = true;
                    subList = new ArrayList<>();
                }
                if (list.get(i).equals(")")) {
                    last = i - 1;
                    replaceSubList(list, generateNonList(subList).get(0), first, last);
                    flag = false;
                }
                if (flag) {
                    subList.add(list.get(i));
                }
            }
        }
        if (list.contains("*")) {
            countBySign(list, "*");
        }
        if (list.contains("/")) {
            countBySign(list, "/");
        }
        if (list.contains("+")) {
            countBySign(list, "+");
        }
        if (list.contains("-")) {
            countBySign(list, "-");
        }
        return list;
    }

    private static void replaceSubList(ArrayList<String> list, String replaceStr, int firstInd, int lastInd) {
        for (int i = firstInd - 1; i < lastInd + 1; i++) {
            list.remove(firstInd);
        }
        list.set(firstInd - 1, replaceStr);
    }

    private static void countBySign(ArrayList<String> list, String ch) {
        while (list.contains(String.valueOf(ch))) {
            int index = list.indexOf(ch);
            int first = Integer.parseInt(list.get(index - 1));
            int second = Integer.parseInt(list.get(index + 1));
            if (ch.equals("*")) {
                replaceSubList(list, String.valueOf(first * second), index, index);
            } else if (ch.equals("/")) {
                replaceSubList(list, String.valueOf(first / second), index, index);
            } else if (ch.equals("+")) {
                replaceSubList(list, String.valueOf(first + second), index, index);
            } else if (ch.equals("-")) {
                replaceSubList(list, String.valueOf(first - second), index, index);
            }
        }
    }

    public static String isValid(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for (char i : chars) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        Integer[] nums = map.values().toArray(new Integer[0]);
        Arrays.sort(nums);
        boolean flag = true;
        Integer first = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if (!first.equals(nums[i])) {
                flag = false;
                break;
            }
        }
        if (!nums[nums.length - 1].equals(first + 1) && !nums[nums.length - 1].equals(first)) {
            flag = false;
        }
        return flag ? "YES" : "NO";
    }
    public static String findLCS(String str1, String str2) {
        int[][] array = new int[str1.length() + 1][str2.length() + 1];
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        for (int i = 0; i < chars1.length ; i++) {
            for (int j  = 0; j < chars2.length; j++) {
                if (chars1[i] == chars2[j]) {
                    array[i+1][j+1] = array[i][j] + 1;
                } else {
                    array[i+1][j+1] = Integer.max(array[i][j+1], array[i+1][j]);
                }
            }
        }
        StringBuilder out = new StringBuilder();
        int x = chars1.length;
        int y = chars2.length;
        while (x > 0 && y > 0) {
            if (chars1[x - 1] == chars2[y - 1]) {
                out.append(chars1[x - 1]);
                x -= 1;
                y -= 1;
            } else if (array[x-1][y] > array[x][y-1]) {
                x -= 1;
            } else {
                y -= 1;
            }
        }
        return out.reverse().toString();
    }

}
