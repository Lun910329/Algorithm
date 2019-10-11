import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class WordLadder{
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        WordLadder wd = new WordLadder();
        System.out.println(wd.ladderLength(beginWord, endWord, wordList));
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord)){
            return 0;
        }
        Queue<String> q = new LinkedList<>();
        int step = 1;
        Set<String> dic = new HashSet<>(wordList);
        q.add(beginWord);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                String word = q.poll();
                char[] count = word.toCharArray();
                for(int j=0;j<count.length;j++){
                    char temp = count[j];
                    for(char c='a';c<='z';c++){
                        count[j] = c;
                        String changeWord = String.valueOf(count);
                        if(dic.contains(changeWord)){
                            if(changeWord.equals(endWord)) return step+1;
                            q.add(changeWord);
                            dic.remove(word);
                        }
                    }
                    count[j] = temp;
                }
            }
            step++;
        }
        return -1;
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        return ans;
    }
}