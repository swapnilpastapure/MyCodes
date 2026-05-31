public class Q12_IntegerToRoman {

    public static String intToRoman(int num) {

        int[] values = {
                1000, 900, 500, 400,
                100, 90, 50, 40,
                10, 9, 5, 4, 1
        };

        String[] romans = {
                "M", "CM", "D", "CD",
                "C", "XC", "L", "XL",
                "X", "IX", "V", "IV", "I"
        };

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                result.append(romans[i]);
                num -= values[i];
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        System.out.println(intToRoman(3749)); // MMMDCCXLIX
        System.out.println(intToRoman(58));   // LVIII
        System.out.println(intToRoman(1994)); // MCMXCIV
    }
}
