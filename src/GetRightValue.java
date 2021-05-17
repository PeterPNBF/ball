import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GetRightValue{
    public static void main(String []args){
        Stack<Character> stack = new Stack<>();
        Integer arr[]={1,2,null,null, 3};
        getRightValue(arr);
    }
    public static void getRightValue(Integer arr[]){
        int index = 0;
        int pIndex = -1;
        int levelNodeNum = 1;
        List<Integer> res = new ArrayList<>();

        while(index<arr.length){// index=0,<7   / index=2<7  6<7
            res.add(getRightNotNullValue(arr, index, pIndex));//0,1,{1}    / 2,2 {1,3}   {1,3,4}
            levelNodeNum = levelNodeNum << 1 ;
            pIndex = index;
            index+=levelNodeNum;//iFndex=2    index=6
        }
        if(index!=arr.length){
            Integer ret = getRightNotNullValue(arr, arr.length - 1, pIndex);
            if(ret != null) {
                res.add(ret);
            }
        }
        System.out.println(res);
    }
    /**
     * 获取某行最右非空值
     **/
    public static Integer getRightNotNullValue(Integer arr[], int index, int pIndex){

        while(index>pIndex){
            if(arr[index]!=null){
                return arr[index];
            }
            index--;
        }
        return null;
    }

}