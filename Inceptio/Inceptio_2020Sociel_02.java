package WebTest.Inceptio;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class Inceptio_2020Sociel_02 {
    public static void main(String[] args) {

        String[][] dep ={{"d5", "d2", "Frontend"}, {"d1", "d0", "IT"}, {"d2", "d0", "RD"}, {"d6", "d2", "Backend"},{"d0", "", "The Company"}, {"d3", "d0", "HR"}};


        listToTree(dep);

    }

    public static String[] listToTree (String[][] departments) {

        if(departments == null){
            return null;
        }
        HashMap<String,Integer> hashMap = new HashMap<>();
//        ["The Company","HR","IT","RD","Backend","Frontend"]

        hashMap.put("The Company",0);
        hashMap.put("HR",1);
        hashMap.put("IT",2);
        hashMap.put("Network Security",3);
        hashMap.put("RD",4);
        hashMap.put("Backend",5);
        hashMap.put("Frontend",6);

        String[] result = new String[departments.length];

        for (int i = 0; i < departments.length; i++) {
            result[i] = departments[i][departments[i].length-1];
        }

        Arrays.sort(result, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {

                return hashMap.get(s1).compareTo(hashMap.get(s2));


            }
        });

//        Arrays.sort(result);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

        return result;






    }

}
