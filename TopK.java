import java.util.*;

public class TopK {
    public static class sortByValue implements Comparator<Map.Entry<Integer,Integer>>{
        public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2){
            if(o1.getValue() == o2.getValue()){
                return o2.getKey() - o1.getKey();
            }
            else{
                return o2.getValue()-o1.getValue();
            }
        }
    }
    public static int[] topK(int[] arr, int k){
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            hm.put(arr[i],hm.getOrDefault(arr[i], 0) +1);
        }
        List<Map.Entry<Integer,Integer>> entries = new ArrayList<>(hm.entrySet());
        Collections.sort(entries,new sortByValue());
        int[] result = new int[k];
        for(int i=0; i<k; i++ ){
            result[i] = entries.get(i).getKey();
        }
        return result ;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};

        System.out.println(Arrays.toString(topK(arr,2)));
        
        // HashMap<Integer,Integer> hm = new HashMap<>();
        // for(int i=0; i<arr.length; i++){
        //     hm.put(arr[i],hm.getOrDefault(arr[i], 0) +1);
        // }
        // System.out.println(hm);
        // List<Map.Entry<Integer,Integer>> entries = new ArrayList<>(hm.entrySet());
        // System.out.println(entries);
        // System.out.println(entries.get(0).getValue());
    }
}
