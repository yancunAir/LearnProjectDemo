package yc.leetcode;

public class Problem278 {

    public int firstBadVersion(int n) {

        int half  = n/2;

        int result = 0;

        while(true) {
            if (isBadVersion(half)) {
                if (isBadVersion(half -1) ) {
                    half = (half -1)/2;
                } else {
                    result= half;
                    break;
                }
            } else {
                half = (n + half)/2;
            }
        }

        return result;

    }

    private boolean isBadVersion(int version) {
        if ( version == 1 || version == 2 || version ==3 || version ==4) {
            return false;
        }
        if (version == 7 || version == 8) {
            return true ;
        }
        return false;
    }

    public static void main(String[] args) {
        Problem278 problem278 = new Problem278();
        int badVersion = problem278.firstBadVersion(8);
        System.out.println(badVersion);
    }

}
