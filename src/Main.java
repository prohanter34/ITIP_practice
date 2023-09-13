
public class Main {
    public static void main(String[] args) {

        System.out.println(convert(5));
        System.out.println(convert(3));
        System.out.println(convert(8));

        System.out.println(fitCalc(15, 1));
        System.out.println(fitCalc(24, 2));
        System.out.println(fitCalc(41, 3));

        System.out.println(containers(3, 4, 2));
        System.out.println(containers(5, 0, 2));
        System.out.println(containers(4, 1, 4));

        System.out.println(triangleType(5, 5, 5));
        System.out.println(triangleType(5, 4, 5));
        System.out.println(triangleType(3, 4, 5));
        System.out.println(triangleType(5, 1, 1));

        System.out.println(ternaryEvaluation(8, 4));
        System.out.println(ternaryEvaluation(1, 11));
        System.out.println(ternaryEvaluation(5, 9));

        System.out.println(howManyItems(22f, 1.4f , 2f));
        System.out.println(howManyItems(45f, 1.8f , 1.9f));
        System.out.println(howManyItems(100f, 2f , 2f));

        System.out.println(factorial(3));
        System.out.println(factorial(5));
        System.out.println(factorial(7));

        System.out.println(gcd(48, 18));
        System.out.println(gcd(52, 8));
        System.out.println(gcd(259, 28));

        System.out.println(ticketSaler(70, 1500));
        System.out.println(ticketSaler(24, 950));
        System.out.println(ticketSaler(53, 1250));

        System.out.println(tables(5, 2));
        System.out.println(tables(31, 20));
        System.out.println(tables(123, 58));

    }
    public static float convert(int x) {
        return x * 3.78541f;
    }

    public static int fitCalc(int x, int y) {
        return x * y;
    }

    public static int containers(int x, int y, int z) {
        return 20 * x + 50 * y + 100 * z;
    }

    public static String triangleType(int x, int y, int z) {
        if (x > 0 || y > 0 || z > 0) {
            if (x + y <= z || x + z <= y || y + z <= x) {
                return "not a triangle";
            } else if (x == y || x == z || z == y) {
                if (x == y && x == z) {
                    return "equilateral";
                } else {
                    return "isosceles";
                }
            } else {
                return "different-sided";
            }
        } else {
            return "error";
        }
    }

    public static int ternaryEvaluation(int x, int y) {
        return x > y ? x : y;
    }

    public static int howManyItems(float n, float w, float h) {
        return (int)(n / (w * h) / 2);
    }

    public static int factorial(int x) {
        int a = 1;
        while (x >= 1) {
            a *= x;
            x -= 1;
        }
        return a;
    }

    public static int gcd(int x, int y) {
        int a = x;
        while (a > 0) {
            if (x % a == 0 && y % a == 0) {
                return a;
            }
            a -= 1;
        }
        return 1;
    }

    public static int ticketSaler(int count, int price) {
        return (int) (count * price / 1.38888888f);
    }

    public static int tables(int people, int tables) {
        if (people <= tables * 2) {
            return 0;
        } else {
            return people - tables * 2;
        }
    }

}