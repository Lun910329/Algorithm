import java.util.ArrayList;
import java.util.List;

class WordSearch{
    public static void main(String[] args) {
        WordSearch ws = new WordSearch();
        char[][] board = {{'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}};
        String word = "ABCCED";
        String[] words = {"oath","pea","eat","rain"};
        // System.out.println(ws.WordSearchI(board, word));
        System.out.println(ws.findWords(board, words));
    }
    boolean[][] visit;
    public boolean WordSearchI(char[][] board, String word){
        int m = board.length;
        int n = board[0].length;
        visit = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfs(board,word,i,j,0) && board[i][j] == word.charAt(0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word,int i, int j, int index){
        if(index == word.length()){
            return true;
        }
        if(i<0||i>=board.length||j<0||j>=board[0].length||visit[i][j]||board[i][j]!=word.charAt(index)){
            return false;
        }
        visit[i][j] = true;
        if(dfs(board, word, i+1, j, index+1)||dfs(board, word, i, j+1, index+1)||
        dfs(board, word, i-1, j, index+1)||dfs(board, word, i, j-1, index+1)){
            return true;
        }
        visit[i][j] = false;
        return false;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for(String s:words){
            insert(s,root);
        }
        List<String> ans = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(root.children[board[i][j] - 'a']!=null){
                    dfs(board,ans,i,j,root);
                }
            }
        }
        return ans;
    }
    public void dfs(char[][] board,List<String> ans, int i, int j, TrieNode root){
        if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]=='*'){
            return;
        }
        char c = board[i][j];
        if(root.children[c-'a'] == null) return;
        TrieNode cur = root.children[c- 'a'];
        if(cur.isWord){
            ans.add(cur.word);
            cur.isWord = false;
            cur.word = null;
        }
         board[i][j]='*';
        dfs(board,ans,i+1,j,cur);
        dfs(board,ans,i-1,j,cur);
        dfs(board,ans,i,j+1,cur);
        dfs(board,ans,i,j-1,cur);
        board[i][j] = c;
    }
    public void insert(String s, TrieNode rootNode){
        TrieNode ws = rootNode;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(ws.children[c-'a'] == null){
                ws.children[c-'a'] = new TrieNode();
            }
            ws = ws.children[c-'a'];
        }
        ws.isWord = true;
        ws.word = s;
    }
}
class TrieNode{
    String word;
    boolean isWord;
    TrieNode[] children = new TrieNode[26];
    public TrieNode(){}
}