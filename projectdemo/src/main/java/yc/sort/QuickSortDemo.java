package yc.sort;

import java.util.Collection;
import java.util.Collections;

public class QuickSortDemo {

    /**
     * 时间复杂度平均 nlogn 最坏情况 n*n
     * @param args
     */
    public static void main(String[] args) {
        QuickSortDemo demo = new QuickSortDemo();
        int[] array = new int[]{4,2,8,3,5,7,9,11,24,16};
        demo.sort(array,0,9);
    }

    public void sort(int[] array, int low, int high){
        if (low < high) {
            int pivot  = getPivot(array,low,high);
            sort(array,low,pivot-1);
            sort(array,pivot+1,high);
        }
    }

    public int getPivot(int[] array, int low, int high) {
        int pivot  = array[low];
        while (low < high) {
            while(low < high && pivot <= array[high]) {
                high--;
            }
            array[low] = array[high];
            while (low < high && pivot >= array[low]) {
                low++;
            }
            array[high] = array[low];
        }
        array[low] = pivot;
        return low;
    }

}

