import java.sql.Time;
import java.util.*;
import java.util.stream.Collectors;

public class Practice5 {
    public static void main(String[] args) {

        System.out.println(sameLetterPattern("ABAB", "CDCD"));
        System.out.println(sameLetterPattern("ABCBA", "BCDCB"));
        System.out.println(sameLetterPattern("FFGG", "CDCD"));
        System.out.println(sameLetterPattern("FFFF", "ABCD"));

        System.out.println(spiderVsFly("H3", "E2"));
        System.out.println(spiderVsFly("A4", "B2"));
        System.out.println(spiderVsFly("B2", "A4"));
        System.out.println(spiderVsFly("A4", "C2"));

        System.out.println(digitsCount(466));
        System.out.println(digitsCount(544));
        System.out.println(digitsCount(121317));
        System.out.println(digitsCount(0));
        System.out.println(digitsCount(12345));
        System.out.println(digitsCount(1289396387328L));

        System.out.println(totalPoints(new String[] {"cat", "create", "sat"}, "caster"));
        System.out.println(totalPoints(new String[] {"trance", "recant"}, "recant"));
        System.out.println(totalPoints(new String[] {"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed"));

        Integer[][] out1 = sumsUp(new int[] {1, 2, 3, 4, 5});
        for (Integer[] i : out1) {
            System.out.print("[");
            for (Integer j : i) {
                System.out.print(j);
            }
            System.out.println("]");
        }
        System.out.println();

        Integer[][] out2 = sumsUp(new int[] {1, 2, 3, 7, 9});
        for (Integer[] i : out2) {
            System.out.print("[");
            for (Integer j : i) {
                System.out.print(j);
            }
            System.out.println("]");
        }
        System.out.println();

        Integer[][] out3 = sumsUp(new int[] {10, 9, 7, 2, 8});
        for (Integer[] i : out3) {
            System.out.print("[");
            for (Integer j : i) {
                System.out.print(j);
            }
            System.out.println("]");
        }
        System.out.println();

        Integer[][] out4 = sumsUp(new int[] {1, 6, 5, 4, 8, 2, 3, 7});
        for (Integer[] i : out4) {
            System.out.print("[");
            for (Integer j : i) {
                System.out.print(j);
            }
            System.out.println("]");
        }
        System.out.println();

        System.out.println(takeDownAverage(new String[] {"95%", "83%", "90%", "87%", "88%", "93%"}));
        System.out.println(takeDownAverage(new String[] {"10%"}));
        System.out.println(takeDownAverage(new String[] {"53%", "79%"}));

        System.out.println(caesarCipher("encode", "hello worldz", 3));
        System.out.println(caesarCipher("decode", "EPQSWX PEWX XEWO!", 4));

        System.out.println(setSetup(5,3));
        System.out.println(setSetup(7,3));

        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome"));
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing"));

        System.out.println(isNew(3));
        System.out.println(isNew(30));
        System.out.println(isNew(321));
        System.out.println(isNew(123));
    }

    public static boolean sameLetterPattern(String str1, String str2) {
        ArrayList<Integer> list1 = stringToNumberList(str1);
        ArrayList<Integer> list2 = stringToNumberList(str2);
        return list1.equals(list2);
    }

    private static ArrayList<Integer> stringToNumberList(String str) {
        char[] chars = str.toCharArray();
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int counter = 1;
        for (char aChar : chars) {
            if (map.containsKey(aChar)) {
                list.add(map.get(aChar));
            } else {
                map.put(aChar, counter);
                list.add(counter);
                counter += 1;
            }
        }
        return list;
    }

    public static String spiderVsFly(String pos1, String pos2) {

        char[] chars1 = pos1.toCharArray();
        int spiderX = (int) chars1[0] - 65;
        int spiderY = Integer.parseInt(String.valueOf(chars1[1]));
        int[] cords1 = new int[] {spiderX, spiderY};

        char[] chars2 = pos2.toCharArray();
        int flyX = (int) chars2[0] - 65;
        int flyY = Integer.parseInt(String.valueOf(chars2[1]));
        int[] cords2 = new int[] {flyX, flyY};

        StringBuilder way = new StringBuilder();
        if (cords1[0] - cords2[0] > 2 || cords2[0] - cords1[0] > 2) {
            for (int i = cords1[1]; i > 0; i--) {
                way.append((char) (cords1[0] + 65));
                way.append(i);
                way.append('-');
            }
            for (int i = 0; i <= cords2[1]; i++) {
                way.append((char) (cords2[0] + 65));
                way.append(i);
                way.append('-');
            }
        } else {
            if (cords1[1] > cords2[1]) {
                for (int i = cords1[1]; i >= cords2[1]; i--) {
                    way.append((char) (cords1[0] + 65));
                    way.append(i);
                    way.append('-');
                }
                for (int i = cords1[0]; i != cords2[0];) {
                    if (cords1[0] - cords2[0] > 0) {
                       i--;
                    } else {
                        i++;
                    }
                    way.append((char) (i + 65));
                    way.append(cords2[1]);
                    way.append('-');
                }
            } else {
                for (int i = cords1[0]; i != cords2[0];) {
                    way.append((char) (i + 65));
                    way.append(cords1[1]);
                    way.append('-');
                    if (cords1[0] - cords2[0] > 0) {
                        i--;
                    } else {
                        i++;
                    }
                }
                for (int i = cords1[1]; i <= cords2[1]; i++) {
                    way.append((char) (cords2[0] + 65));
                    way.append(i);
                    way.append('-');
                }
            }
        }
        way.delete(way.length() - 1, way.length());
        return way.toString();
    }

    public static int digitsCount(long num) {
        int count = 0;
        num = num / 10;
        if (num != 0) {
            count += 1;
            count += digitsCount(num);
        } else {
            count += 1;
        }
        return count;
    }

    public static int totalPoints(String[] array, String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        int points = 0;
        for (String i : array) {
            char[] chars1 = i.toCharArray();
            char[] chars2 = Arrays.copyOf(chars, chars.length);
            Arrays.sort(chars1);
            boolean flag = true;
            for (char j : chars1) {
                boolean letter_flag = false;
                for (int a = 0; a < chars.length; a++) {
                    if (j == chars2[a]) {
                        chars2[a] = ' ';
                        letter_flag = true;
                    }
                }
                if (!letter_flag) {
                    flag = false;
                }
            }
            if (flag) {
                points += i.length() - 2;
                if (i.length() == 6) {
                    points += 50;
                }
            }
        }
        return points;
    }

    public static Integer[][] sumsUp(int[] array) {
        ArrayList<Integer[]> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == 8) {
                    list.add(new Integer[] {array[i], array[j]});
                }
            }
        }
        Integer[][] out = new Integer[list.size()][2];
        out = list.toArray(out);
        return out;
    }

    public static String takeDownAverage(String[] array) {
        List<Integer> list = Arrays.stream(array).map(e -> {
            char[] chars = e.toCharArray();
            char[] num_chars = Arrays.copyOf(chars, chars.length - 1);
            return Integer.valueOf(String.valueOf(num_chars));
        }).toList();

        float sum = (float) list.stream().reduce(0, Integer::sum);
        float avg = sum / (float) list.size() - 5;
        float out = (avg*(list.size() + 1) - sum);
        return Math.round(out) + "%";
    }

    public static String caesarCipher(String mode, String str, int shift) {
        boolean flag = switch (mode) {
            case "encode" -> true;
            case "decode" -> false;
            default -> true;
        };

        str = str.toUpperCase();
        char[] chars = str.toCharArray();

        if (flag) {
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] >= 65 && chars[i] <= 90) {
                    if (chars[i] + shift > 90) {
                        chars[i] = (char) (chars[i] + shift - 26);
                    } else {
                        chars[i] = (char) (chars[i] + shift);
                    }
                }
            }
        } else {
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] >= 65 && chars[i] <= 90) {
                    if (chars[i] - shift < 65) {
                        chars[i] = (char) (chars[i] - shift + 26);
                    } else {
                        chars[i] = (char) (chars[i] - shift);
                    }
                }
            }
        }
        return String.valueOf(chars);
    }

    public static int setSetup(int n, int k) {
        int out = n - k + 1;
        if (n > n-k+1) {
            out *= setSetup(n, k-1);
        }
        return out;
    }

    public static String timeDifference(String city1, String timeStr, String city2) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Los Angeles", -8 * 60);
        map.put("New York", -5 * 60);
        map.put("Caracas", -5 * 60 + 30);
        map.put("Buenos Aires", -3 * 60);
        map.put("London", 0);
        map.put("Rome", 60);
        map.put("Moscow", 3 * 60);
        map.put("Tehran", 3 * 60 + 30);
        map.put("New Delhi", 5 * 60 + 30);
        map.put("Beijing", 8 * 60);
        map.put("Canberra", 10 * 60);
        HashMap<String, Integer> months = new HashMap<>();
        months.put("January", 0);
        months.put("February", 31);
        months.put("March", 59);
        months.put("April", 90);
        months.put("May", 120);
        months.put("June", 151);
        months.put("July", 181);
        months.put("August", 212);
        months.put("September", 242);
        months.put("October", 273);
        months.put("November", 303);
        months.put("December", 334);

        int delta = map.get(city2) - map.get(city1);
        String[] array = timeStr.split(" ");
        long minutes = 0;
        minutes += (months.get(array[0]) + Integer.parseInt(array[1].replaceAll(",",""))) * 1440L;
        minutes += Integer.parseInt(array[2]) * 525600L;
        String[] timeArray = array[3].split(":");
        minutes += Integer.parseInt(timeArray[0]) * 60L;
        minutes += Integer.parseInt(timeArray[1]);
        minutes += delta;
        int year = (int) (minutes / 525600L);
        minutes = minutes % 525600L;
        int month = 1;
        int days = (int) minutes / 1440;
        minutes = minutes % 1440L;
        int hours = (int) minutes / 60;
        minutes = minutes % 60;
        Set<Map.Entry<String, Integer>> months_set = months.entrySet().stream()
                .sorted((x,y)->y.getValue().compareTo(x.getValue()))
                .collect(Collectors.toCollection(LinkedHashSet::new));
        for (Map.Entry<String, Integer> i : months_set) {
            if (i.getValue() <= days) {
                month = i.getValue() / 28 + 1;
                days -= i.getValue();
                break;
            }
        }
        return year + "-" + timeFormat(month) + "-" + timeFormat(days) +
                " " + timeFormat(hours) + ":" + timeFormat((int) minutes);
    }

    private static String timeFormat(int num) {
        String time = String.valueOf(num);
        String out = "0";
        if (time.length() == 1) {
            return out + time;
        } else {
            return time;
        }
    }

    public static boolean isNew(int num) {
        String str = String.valueOf(num);
        char[] chars = str.toCharArray();
        boolean flag = true;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] < chars[i-1]) {
                if ((i != 1 || chars[i] != '0') && (i != 2 || chars[i-1] != '0')) {
                    flag = false;
                }
            }
        }
        return flag;
    }

}
