public class Test {
    public static void main(String[] args) {
        // 2 ,4, 5, 6, 3, 2, 1
        int []arr = {2 ,4, 5, 6, 3, 2, 1};
        quickSort(arr, 0, arr.length-1);
        for(int i=0; i<arr.length; ++i){
            System.out.print(arr[i] + " ");
        }
    }

    public static void quickSort(int [] arr, int left, int right){
        if(left>=right){
            return;
        }
        int pivot = left;
        int tmp = arr[pivot];
        int less = left;
        int great = right;
        while(great>less){
            while (great>less&&arr[great]>tmp){
                --great;
            }
            arr[pivot] = arr[great];
            while(great>less&&arr[less]<=tmp){
                ++less;
            }
            arr[great] = arr[less];
            arr[less] = arr[pivot];
        }
        quickSort(arr, left, less-1);
        quickSort(arr, less+1, right);

    }

}
