package goldman;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StudentGrade2 {
    public int studgrade(String[][] scores){
    	if (scores == null || scores.length == 0) {
    		return 0;
    	}
    	Map<String, Integer> sum = new HashMap<String, Integer>(); // sum of scores
    	Map<String, Integer> freq = new HashMap<String, Integer>(); // frequency
    	for (int i = 0; i < scores.length; i++) {
    		String student = scores[i][0];
    		int theScore = Integer.parseInt(scores[i][1]);
    		
    		int curSum = sum.getOrDefault(student, 0);
    		sum.put(student, curSum + theScore);
    		
    		int curFreq = freq.getOrDefault(student, 0);
    		freq.put(student, curFreq + 1);
    	}
    	
    	int max = Integer.MIN_VALUE;
    	for (String student : sum.keySet()) {
    		int theSum = sum.get(student);
    		int theFreq = freq.get(student);
    		max = Math.max(max, Math.floorDiv(theSum, theFreq));
    	}
    	return max;
    	
    }

    public static void main(String[] args){
        String[][] scores = {{"Charles", "-100"}, {"Charles", "200"}, {"Charles","-300"}};
        StudentGrade2 studentGrade = new StudentGrade2();
        System.out.println(studentGrade.studgrade(scores));
    }
}
