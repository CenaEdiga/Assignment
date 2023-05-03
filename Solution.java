import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	  public int networkDelayTime(int[][] times, int N, int K) {
	        int[][] cost = new int[N + 1][N + 1];
	        for(int[] c : cost) Arrays.fill(c, Integer.MAX_VALUE >> 1);
	        for(int i = 1; i <= N; i++) cost[i][i] = 0;
	        for(int[] time : times){
	            cost[time[0]][time[1]] = time[2];
	        }
	        for(int k = 1; k <= N; k++){
	            for(int i = 1; i <= N; i++){
	                for(int j = 1; j <= N; j++){
	                    cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);
	                }
	            }
	        }
	        int res = 0;
	        for(int i = 1; i <= N; i++){
	            if(cost[K][i] > 6000) return -1;
	            res = Math.max(res, cost[K][i]);
	        }
	        return res;
	    }
	  public static void main(String[] args) {
		  Solution s1=new Solution();
		  Scanner s=new Scanner(System.in);
		  int [][] arr= new int [3][3];
		  for (int i=0;i<3;i++) {
			  for(int j=0;j<3;j++) {
				  arr[i][j]=s.nextInt();
			  }
		  }
		  int N=s.nextInt();
		  int K=s.nextInt();
		  System.err.println(s1.networkDelayTime(arr,N,K));
		  
	}

}
