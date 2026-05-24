public class ZigzagConversion {

    public static String convert(String s, int numRows) {

        // Edge case
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        // Create rows
        StringBuilder[] rows = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        // Traverse characters
        for (char c : s.toCharArray()) {

            rows[currentRow].append(c);

            // Change direction at top or bottom
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            currentRow += goingDown ? 1 : -1;
        }

        // Combine all rows
        StringBuilder result = new StringBuilder();

        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String s1 = "PAYPALISHIRING";
        int numRows1 = 3;

        System.out.println(convert(s1, numRows1));
        // Output: PAHNAPLSIIGYIR

        String s2 = "PAYPALISHIRING";
        int numRows2 = 4;

        System.out.println(convert(s2, numRows2));
        // Output: PINALSIGYAHRPI

        String s3 = "A";
        int numRows3 = 1;

        System.out.println(convert(s3, numRows3));
        // Output: A
    }
}
