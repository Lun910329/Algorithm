import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class BusRoute{
    public static void main(String[] args) {
        BusRoute br = new BusRoute();
        int[][] routes = {{1,2,7},{3,6,7}};
        int S = 1, T = 6;
        System.out.print(br.numBusesToDestination(routes, S, T));
    }
    public int numBusesToDestination(int[][] routes, int S, int T) {
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        Set<Integer> visit = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        int res = 0;
        q.add(S);
        for(int i=0;i<routes.length;i++){
            for(int j=0;j<routes[i].length;j++){
                if(!map.containsKey(routes[i][j])){
                    map.put(routes[i][j],new ArrayList<>());
                }
                map.get(routes[i][j]).add(i);
            }
        }
        while(!q.isEmpty()){
            int size = q.size();
            res++;
            for(int i=0;i<size;i++){
                int cur = q.poll();
                ArrayList<Integer> buses = map.get(cur);
                for(int bus:buses){
                    if(visit.contains(bus)) continue;
                    visit.add(bus);
                    for(int j=0;j<routes[bus].length;j++){
                        if(routes[bus][j] == T){
                            return res;
                        }
                        q.add(routes[bus][j]);
                    }
                }
            }
        }
        return -1;
    }
}