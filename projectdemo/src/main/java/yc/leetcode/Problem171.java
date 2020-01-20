package yc.leetcode;

public class Problem171 {


    public static void main(String[] args) {

        System.out.println(slove("ZY"));

    }


    public static int slove(String s) {
        int length = s.length();
        int result = 0;
        for (int i = 0; i < length; i++) {
           int num  = s.charAt(i) - 64;

            result += Math.pow(26,length-1-i) * num;
        }

        return result;

    }

}
