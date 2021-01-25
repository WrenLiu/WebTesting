import java.util.ArrayList;
import java.util.Scanner;

public class HJ47 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int m=sc.nextInt();
            //二维数组存储键值对
            int[][] data=new int[n][2];
            for(int i=0;i<n;i++){
                data[i][0]=sc.nextInt();
                data[i][1]=sc.nextInt();
            }
            ArrayList<String> list=new ArrayList<String>();
            //若出现重复值,利用这两个变量存储前一个值,丢弃后出现的重复值(如题目要求)
            int KEY=data[0][0];
            int VALUE=data[0][1];
            list.add(KEY+" "+VALUE);
            for(int i=1;i<=n-1;i++){
                int diff=data[i][0]-KEY-1;
                if(diff>0){
                    for(int j=1;j<=diff;j++){
                        int key=KEY+j;
                        int value=VALUE+(data[i][1]-VALUE)/(data[i][0]-KEY)*j;
                        list.add(key+" "+value);
                    }
                    list.add(data[i][0]+" "+data[i][1]);
                    KEY=data[i][0];
                    VALUE=data[i][1];
                    //两个键相等则直接跳过,此时KEY,VVALUE保存的还是上一个值
                }else if(diff==-1)
                    continue;
                else{
                    list.add(data[i][0]+" "+data[i][1]);
                    KEY=data[i][0];
                    VALUE=data[i][1];
                }
            }
            for(String s:list)
                System.out.println(s);
        }
    }
}

