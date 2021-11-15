import java.util.*;
public class DivisibleNumbers {
	public int[] solution(int[] arr, int divisor) {
        int[] tmp = new int[arr.length]; // 임시 배열 (나누어 떨어지는 숫자가 아니면 0이 들어감)
        int cnt=0; // 나누어 떨어지는 숫자 개수
        for(int i=0; i<arr.length; i++){
            if(arr[i]%divisor==0){
                tmp[i]=arr[i];
                cnt++;
            }
        }
        
        if(cnt>0){ // 나누어 떨어지는 숫자가 있으면
            int j=0;
            int[] answer = new int[cnt];
            for(int i=0; i<tmp.length; i++){
                if(tmp[i]!=0){ // 나누어 떨어지는 숫자일 경우에만 answer 배열에 담기
                    answer[j]=tmp[i];
                    j++;
                }
            }
            Arrays.sort(answer); // 오름차순 정렬
            return answer;
        } else{ // 나누어 떨어지는 숫자가 없으면
            int[] answer = {-1};
            return answer;
        }
    }
}
