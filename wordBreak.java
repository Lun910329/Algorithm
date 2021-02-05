import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class wordBreak{
    public static void main(String[] args) {
        wordBreak wb = new wordBreak();
        String s ="catsanddog";
        List<String> list = new ArrayList<>();
        list.add("cats");
        list.add("dog");
        list.add("sand");
        list.add("and");
        list.add("cat");
        System.out.println(wb.wordBreakI(s, list));
        System.out.println(wb.wordBreakII(s, list));
    }

    public boolean wordBreakI(String s, List<String> wordDict){
        Set<String> set = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[s.length()];
        queue.add(0);
        while(!queue.isEmpty()){
            int startIndex = queue.poll();
            if(!visit[startIndex]){
                for(int end = startIndex+1; end<s.length(); end++){
                    if(set.contains(s.substring(startIndex,end))){
                        queue.add(end);
                        if(end == s.length()){
                            return true;
                        }
                    }
                }
                visit[startIndex] = true;
            }
        }
        return false;
    }
    
    public List<String> wordBreakII(String s, List<String> wordDict){
        Set<String> wordDic = new HashSet<>(wordDict);
        return dfs(s,wordDic,new HashMap<String,List<String>>());
    }
    public List<String> dfs(String s, Set<String> set, HashMap<String,List<String>> map){
        if(map.containsKey(s)){
            return map.get(s);
        }
        List<String> res = new ArrayList<>();
        if(s.length()==0){
            res.add("");
            return res;
        }
        for(String word:set){
            if(s.startsWith(word)){
                List<String> subList = dfs(s.substring(word.length()),set,map);
                for(String sub:subList){
                    res.add(word + (sub.isEmpty()?"":" ") + sub);
                }
            }
            map.put(word,res);
        }
        return res;
    }
}