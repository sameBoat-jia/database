package four;

import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {
        int a[]={1,2,3,4,5,6,7,8};
        Scanner sca=new Scanner(System.in);
        System.out.print("输入要查找的数据：");
        int x=sca.nextInt();
        int loc=binarySearch(a,a.length,x);//返回数据所在位置
        System.out.print(x+"的位置在第："+loc);
    }
    private static int binarySearch(int[] a, int length, int x) {
        int left=0;
        int right=length-1;
        int mid;
        while(left<=right){
            mid=(left+right)/2;
            if(a[mid]==x){
                return mid;
            }else if(a[mid]>x){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return -1;//未找到返回-1
    }

}
