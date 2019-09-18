public class StringConverter {
    public static int convert(String numString) {
        int firstInt = numString.charAt(0) - '0';
        int minusAsciiValue = '-' - '0';
        String numSubstring = (numString.length() > 1) ? numString.substring(1, numString.length()) : "";

        if (numSubstring.isEmpty()) {
            // if substring is empty, we are on the last digit.
            return 0 + firstInt;
        } else if (firstInt == minusAsciiValue) {
            return -1 * convert(numSubstring);
        } else if (!(0 <= firstInt && firstInt <= 9)){
            throw new NumberFormatException("? Invalid numeric string detected starting at " + numString);
        } else {
            return (int) (Math.pow(10, numString.length() - 1)*(firstInt) + convert(numSubstring));
        }
    }
}
