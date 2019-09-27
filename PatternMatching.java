import java.util.Scanner;

public class PatternMatching {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a string s1: ");
        String str1 = input.nextLine();
        System.out.println("Enter a string s2: ");
        String str2 = input.nextLine();

        int index = getIndexOfSubstring(str1, str2);
        if (index >= 0) System.out.println("matched at index " + index);
        else System.out.println("s2 is not a substring of s1.");

        input.close();
    }

    private static int getIndexOfSubstring(String str, String strSubstring) {
        char[] strChars = str.toCharArray();
        char[] strSubstringChars = strSubstring.toCharArray();
        boolean isSubstringFound = false;

        for (int strCharIndex = 0; strCharIndex < str.length(); strCharIndex++) {
            for (int strSubstringCharIndex = 0; strSubstringCharIndex < strSubstring.length(); strSubstringCharIndex++) {
                if (strCharIndex + strSubstring.length() > str.length()) {
                    // substring is longer than remaining unchecked characters, so it's not a substring
                    return -1;
                } else if (strChars[strCharIndex + strSubstringCharIndex] == strSubstringChars[strSubstringCharIndex]) {
                    isSubstringFound = true;
                } else {
                    isSubstringFound = false;
                    break;
                }
            }
            if (isSubstringFound) return strCharIndex;
        }
        return -1;
    }
}
