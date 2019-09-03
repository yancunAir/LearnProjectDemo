package yc.leetcode;

public class Problem66 {



    public static void main(String[] args){

        int[] digits = new int[4];
        digits[0] =9;
        digits[1] =9;
        digits[2] =9;
        digits[3] =9;

        plusOne(digits);
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0)
                return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }





}
