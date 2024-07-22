import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AllDuplicateLettersInAWord {
    public static void brute(String str)
    {
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if(count.containsKey(str.charAt(i)))
                count.put(str.charAt(i) , count.get(str.charAt(i))+1);
            else count.put(str.charAt(i),1);

        }

        for (Map.Entry<Character,Integer> mapElement : count.entrySet()) {
            if (mapElement.getValue() > 1)
                System.out.println(mapElement.getKey());
        }
    }
    public static void optimal(String str)
    {
        int len = str.length();


        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String sortedStr = new String(chars);


        for (int i = 0; i < len; i++) {
            int count = 1;


            while (i < len - 1
                    && sortedStr.charAt(i)
                    == sortedStr.charAt(i + 1)) {
                count++;
                i++;
            }


            if (count > 1) {
                System.out.println(sortedStr.charAt(i));
            }
        }
    }

}
