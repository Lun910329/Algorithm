import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//走迷宫 5
public class Mazz {

    public static Integer BFS_FindObstacle(Character[][] grid){
        if (grid.length == 0 || grid[0].length==0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[] distance = new int[rows*cols+cols]; //[] size row*cols+cols
        LinkedList<Integer> queue = new LinkedList<>();
        int[] dirX = {1,0,-1,0};
        int[] dirY = {0,1,0,-1};
        queue.offer(0); //put grid[0][0] location to queue
        distance[0]=0; // here we can use 1d array just like we store queue (use x*cols+y) as index
        while(!queue.isEmpty()){
            int current = queue.poll();
            //traverse all neighbor
            for(int i = 0; i< 4; i++){
                int x = current/cols+dirX[i]; //0 +1
                int y = current%cols+dirY[i]; //0
                
                //check if neighbors is traversable (not out of border) and not visited
                if(x<0 || x>=rows || y<0 || y>=cols || grid[x][y] =='0') continue;
                int neighbor = x*cols+y;
                distance[neighbor] = distance[current]+1; //distance [current] +1
                if(grid[x][y]=='9') return distance[neighbor];

                queue.offer(neighbor); // 1*3+0 =3
                grid[x][y] = '0'; //marked as visited
            }

        }
        return -1;
    }
    public static void main(String[] args) {
        Character[][] grid1 = {{'1', '1', '1'}, {'1', '0', '1'}, {'1', '9', '1'}};
        System.out.println(BFS_FindObstacle(grid1));
        Character[][] grid2 = {{'1', '1', '0'}, {'1', '1', '1'}, {'1', '0', '9'}};
        System.out.println(BFS_FindObstacle(grid2));
        Character[][] grid3 = {{'1', '1', '1'}, {'1', '0', '1'}, {'1', '9', '1'}};
        System.out.println(BFS_FindObstacle(grid3));
        Character[][] grid4 = {{'1', '0', '0'}, {'1', '0', '0'}, {'1', '9', '1'}};
        System.out.println(BFS_FindObstacle(grid4));
        Character[][] grid5 = {{'1', '9', '0'}, {'0', '0', '0'}, {'1', '9', '1'}};
        System.out.println(BFS_FindObstacle(grid5));
        Character[][] grid6 = {{'1', '1', '0'}, {'0', '1', '0'}, {'1', '1', '1'}};
        System.out.println(BFS_FindObstacle(grid6));
        Character[][] grid7 = {{'1', '1', '0'}, {'0', '0', '0'}, {'1', '9', '1'}};
        System.out.println(BFS_FindObstacle(grid7));
        Character[][] grid8 = {{'1', '1', '0'}, {'1', '1', '0'}, {'1', '1', '9'}};
        System.out.println(BFS_FindObstacle(grid8));

    }
}
