
import java.util.*;

public class HJ102 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            char[] chs = sc.nextLine().toCharArray();

            Arrays.sort(chs);


            TreeMap<Integer, ArrayList<Character>> treeMap = new TreeMap<>();

            int index = 0;
            while (index < chs.length){

                int left = index;

                int right = index;
                while(right < chs.length && chs[right] == chs[left]){
                    right++;
                }

                int num = right - left;

                if(treeMap.containsKey(num)){
                    treeMap.get(num).add(chs[left]);
                }else{

                    ArrayList<Character> arrayList = new ArrayList<>();
                    arrayList.add(chs[left]);
                    treeMap.put(num,arrayList);

                }

                index = right;


            }

            while(!treeMap.isEmpty()) {


                ArrayList<Character> arrayList = treeMap.get(treeMap.lastKey());
                for (Character character : arrayList) {
                    System.out.print(character);
                }

                treeMap.remove(treeMap.lastKey());

            }
            System.out.println();














        }



    }


}
