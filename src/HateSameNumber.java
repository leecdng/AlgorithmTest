import java.util.*;
public class HateSameNumber {
	public int[] solution(int []arr) {
        int[] tmp = new int[arr.length];
        int j=1;
        tmp[0]=arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i-1]!=arr[i]){
                tmp[j]=arr[i];
                j++;
            }
        }
        int[] answer = new int[j];
        System.arraycopy(tmp, 0, answer,0, j);
        
        return answer;
    }
}
