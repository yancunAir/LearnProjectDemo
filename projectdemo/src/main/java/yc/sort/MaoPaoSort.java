package yc.sort;

public class MaoPaoSort {



    public static void main(String[] args){

    }



    public static void maopaosort(Integer[] strArray){

        if(strArray == null || strArray.length == 0){
            return;
        }

        int length = strArray.length;

        for(int i = 0 ; i < length ; i++){
            for(int j = 0 ; j < length-1-i;j++ ){
                if(strArray[j] > strArray[j+1]) {
                    int temp = strArray[j+1];
                    strArray[j+1] = strArray[j];
                    strArray[j] = temp;
                }

            }

        }



    }




}
