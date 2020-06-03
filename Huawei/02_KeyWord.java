import java.util.*;
//  https://www.nowcoder.com/ta/huawei  
//  密码验证合格程序
//  还有正则表达式方法

public class Main {
    public static void main(String[] args) {

  Scanner sc = new Scanner(System.in);
        Boolean b = false;



        while(sc.hasNext()){
            String keyword = sc.nextLine();

            if(checkLength(keyword) && checkCharKinds(keyword) && checkCharRepeat(keyword)){
                System.out.println("OK");
            }else{
                System.out.println("NG");
            }

        }



    }


    public static boolean checkCharRepeat(String password){
        for(int i=0 ;i<password.length()-2 ;i++){
            String substr1 =password.substring(i, i+3);
            if (password.substring(i+1).contains(substr1)) {
                return false;
            }
        }
        return true;
    }


    public static boolean checkLength(String password){
        return password.length()>8;
    }

    public static boolean checkCharKinds(String password){
        Integer digital=0, lowercase =0,uppercase =0,others=0;
        for (int i = 0; i < password.length(); i++) {

            Character c = password.charAt(i);

            if( c<=57 && c>=48){
                digital=1;
                continue;
            }else if( c<=122 && c>=97){
                lowercase=1;
                continue;
            }else if(c<=90 && c>=65){
                uppercase=1;
                continue;
            }else{
                others=1;
                continue;
            }
        }

        return (digital+lowercase+uppercase+others) >= 3;
    }

}