package yc.sort;

/**
 * 二分查找
 * 有比较大的缺陷 数组的值必须是有序的。
 */
public class BinarySearch {

    public static void main(String[] args) {

        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};

        int result = binarySearch(array,8,0,array.length-1);
        System.out.println(result);
    }

    //使用递归来进行二分查找
    public static int binarySearch(int[] array, int key, int low, int high) {

        if (low > high) {
            return -1;
        }

        int middle = low + (high - low) / 2;
        if (array[middle] > key) {
            return binarySearch(array,key,low,middle-1);
        } else if (array[middle] < key) {
            return binarySearch(array,key,middle+1,high);
        } else {
            return middle;
        }



    }


}
