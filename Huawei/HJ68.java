
import javax.naming.PartialResultException;
import java.lang.reflect.Array;
import java.util.*;

public class HJ68 {


    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
//        0代表从高到低，1代表从低到高
        while(sc.hasNext()){

            int total = Integer.parseInt(sc.nextLine());
            int method = Integer.parseInt(sc.nextLine());


            TreeMap<Integer, ArrayList<String>> treeMap = new TreeMap<>();

            for (int i = 0; i < total; i++) {


                String[] strs = sc.nextLine().split(" ");
                int grade = Integer.parseInt(strs[1]);

                if(treeMap.containsKey(grade)){
                    treeMap.get(grade).add(strs[0]);
                }else{
                    ArrayList<String> tmpArrayList = new ArrayList<>();
                    tmpArrayList.add(strs[0]);
                    treeMap.put(grade,tmpArrayList);
                }
            }

            if(method == 1){

                while (treeMap.size() > 0) {

                    int grade = treeMap.firstKey();

                    if(treeMap.get( grade ).size() > 1 ){

                        ArrayList arrayList = treeMap.get(grade);

                        for (int j = 0; j < arrayList.size(); j++) {

                            System.out.println(arrayList.get(j)+" "+grade);

                        }

                        treeMap.remove(grade);

                    }else {
                        System.out.println(treeMap.get(grade).get(0) + " "+ grade);
                        treeMap.remove(grade);
                    }


                }
            }else if(method == 0){

                while (treeMap.size() > 0) {

                    int grade = treeMap.lastKey();

                    if(treeMap.get( grade ).size() > 1 ){

                        ArrayList arrayList = treeMap.get(grade);

                        for (int j = 0; j < arrayList.size(); j++) {

                            System.out.println(arrayList.get(j)+" "+grade);

                        }

                        treeMap.remove(grade);

                    }else {
                        System.out.println(treeMap.get(grade).get(0) + " "+ grade);
                        treeMap.remove(grade);
                    }


                }
            }




        }


    }

}
