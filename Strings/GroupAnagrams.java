public class GroupAnagrams {
    public ArrayList<ArrayList<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> groupedAnagrams= new HashMap<>();
        for(String words: strs){
            char[] ch = words.toCharArray();
            Arrays.sort(ch);
            String sortedWords = String.valueOf(ch);
            if(!groupedAnagrams.containsKey(sortedWords)){
                groupedAnagrams.put(sortedWords, new ArrayList<>());
            }
            groupedAnagrams.get(sortedWords).add(words);
        }
        return new ArrayList<>(groupedAnagrams.values());
    }
}