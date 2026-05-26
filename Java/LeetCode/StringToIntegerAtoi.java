public class StringToIntegerAtoi {

    public static int myAtoi(String s) {

        int i = 0;
        int n = s.length();

        // Step 1: Ignore leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Step 2: Check sign
        int sign = 1;

        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {

            if (s.charAt(i) == '-') {
                sign = -1;
            }

            i++;
        }

        // Step 3: Convert digits
        int result = 0;

        while (i < n && Character.isDigit(s.charAt(i))) {

            int digit = s.charAt(i) - '0';

            // Step 4: Handle overflow
            if (result > (Integer.MAX_VALUE - digit) / 10) {

                if (sign == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }

            result = result * 10 + digit;

            i++;
        }

        return result * sign;
    }

    public static void main(String[] args) {

        System.out.println(myAtoi("42"));              // 42
        System.out.println(myAtoi("   -042"));         // -42
        System.out.println(myAtoi("1337c0d3"));        // 1337
        System.out.println(myAtoi("0-1"));             // 0
        System.out.println(myAtoi("words and 987"));   // 0
        System.out.println(myAtoi("2147483648"));      // 2147483647
        System.out.println(myAtoi("-2147483649"));     // -2147483648
    }
}
