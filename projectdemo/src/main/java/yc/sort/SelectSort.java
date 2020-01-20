package yc.sort;

public class SelectSort {

    /**
     * 时间复杂度 N*N
     * 、
     * 思路: 循环遍历 将最小的值跟第一个进行交换 然后去除第一个元素
     *  取剩下最小的数跟第二个进行校验，直到循环到数组长度减1
     * @param args
     */
    public static void main(String[] args) {

    }

    public void selectSort(int[] num) {
        if (num == null || num.length == 0) {
            return;
        }
        for (int i = 0 ; i < num.length-1 ; i++) {
            int small = i;
            for (int j = i ; j < num.length -1 ;j++) {
                if (num[i] < num[small]) {
                   small = j;
                }
            }
            if (num[small] != num[i]) {
                swap(num,small,i);
            }
        }
    }

    public void swap(int[] num, int i ,int j) {

        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }


}
