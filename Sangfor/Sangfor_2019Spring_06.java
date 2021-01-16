
import java.util.*;

public class Sangfor_2019Spring_06 {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        while (sc.hasNext()) {
            HashMap<String,ArrayList<Integer>> hashMap = new LinkedHashMap<>();
            int N = Integer.parseInt(sc.nextLine());

            for (int i = 0; i < N; i++) {
                String count = sc.nextLine();

                String arrayString = sc.nextLine();


                if(!hashMap.containsKey(arrayString)){
                    ArrayList<Integer> tmpArrayList = new ArrayList<>();
                    tmpArrayList.add(i);
                    hashMap.put(arrayString,tmpArrayList);

                }else {
                    hashMap.get(arrayString).add(i);
                }

            }



            TreeMap<Integer,ArrayList<Integer>> treeMap = new TreeMap<>();
            for (String string : hashMap.keySet()) {
                ArrayList<Integer> arrayList = hashMap.get(string);
                if(arrayList.size() > 1){
                    treeMap.put(arrayList.get(0),arrayList);
                }
            }

            if(treeMap.size()<1){
                System.out.println("no");
            }

            for (Integer integer : treeMap.keySet()) {
                ArrayList<Integer> arrayList = treeMap.get(integer);
                for (Integer integer1 : arrayList) {
                    System.out.print(integer1+" ");
                }
                System.out.println();
            }



            // 我觉得这个可能是因为需要排序输出
            /*
            TreeMap<Integer, List<Integer>> re = new TreeMap<Integer, List<Integer>>();
            for(String k : hashMap.keySet()){
                List<Integer> a = hashMap.get(k);
                if(a.size() > 1){
                    re.put(a.get(0), a);
                }
            }
            for(int i : re.keySet()){
                List<Integer> a = re.get(i);
                for(int j : a){
                    System.out.print(j + " ");
                }
                System.out.println();
            }
            if(re.size() < 1){
                System.out.println("no");
            }


             */

            /*
            我原来的想法
            int count = 0;
            for (String string : hashMap.keySet()) {
                ArrayList<Integer> arrayList = hashMap.get(string);
                if(arrayList.size()>1){
                    for (int i = 0; i < arrayList.size() - 1; i++) {
                        System.out.print(arrayList.get(i)+" ");
                    }
                    System.out.println(arrayList.get(arrayList.size()-1));
                }
            }

            if(count == 0){
                System.out.println("no");
            }

            */



        }
    }


}
