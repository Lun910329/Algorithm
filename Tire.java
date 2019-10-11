import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
class Tire{
    TrieNode root = new TrieNode();
    public void insert(String s){
        TrieNode ws = root;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(ws.children[c-'a'] == null){
                ws.children[c-'a'] = new TrieNode();
            }
            ws = ws.children[c-'a'];
        }
        ws.isString = true;
        ws.word = s;
    }
    public boolean search(String s){
        TrieNode ws = root;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(ws.children[c-'a']==null){
                return false;
            }
            ws = ws.children[c-'a'];
        }
        return ws.isString;
    }
    public List<String> searchPrefix(String prefix){
        List<String> ans = new ArrayList<>();
        Queue<TrieNode> queue = new LinkedList<>();
        TrieNode ws = root;
        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            if(ws.children[c-'a']==null){
                return new ArrayList<>();
            }
            else{
                ws = ws.children[c-'a'];
            }
        }
        queue.add(ws);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TrieNode cur = queue.poll();
                if(cur.word!=null){
                    ans.add(cur.word);
                }
                for(int j=0;j<26;j++){
                    if(cur.children[j]!=null){
                        queue.add(cur.children[j]);
                    }
                }
            }
        }

        return ans;
    }
    public List<String> searchPrefixDfs(String prefix){
        List<String> ans = new ArrayList<>();
        TrieNode ws = root;
        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            if(ws.children[c-'a']==null){
                return new ArrayList<>();
            }
            else{
                ws = ws.children[c-'a'];
            }
        }
        for(char c ='a';c<='z';c++){
            if(ws.children[c-'a']!=null){
                dfs(ws.children[c-'a'],ans);
            }
        }
        return ans;
    }
    public void dfs(TrieNode node,List<String> list){
        if(node.isString){
            list.add(node.word);
            return;
        }
        for(char c='a';c<='z';c++){
            if(node.children[c-'a']!=null){
                dfs(node.children[c-'a'],list);
            }
        }
    }
    public static void main(String[] args) {
        Tire tire = new Tire();
        tire.insert("apple");
        tire.insert("application");
        tire.insert("a");
        tire.insert("banana");
        tire.insert("big");
        System.out.print(tire.search("banana"));
        System.out.println(tire.searchPrefix("b"));
        // System.out.println(tire.searchPrefixDfs("b"));
    }
}
class TrieNode{
    boolean isString;
    TrieNode[] children = new TrieNode[26];
    String word;
    public TrieNode(){

    }
}