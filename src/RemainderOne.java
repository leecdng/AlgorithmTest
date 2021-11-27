/*
나머지가 1이 되는 수 찾기 / 3min.
https://programmers.co.kr/learn/courses/30/lessons/87389

[문제 설명]
자연수 n이 매개변수로 주어집니다. 
n을 x로 나눈 나머지가 1이 되도록 하는 가장 작은 자연수 x를 return 하도록 solution 함수를 완성해주세요. 
답이 항상 존재함은 증명될 수 있습니다.

[제한사항]
3 ≤ n ≤ 1,0]00,000

[입출력 예]
n	result
-----------
10	3
12	11

*/
public class RemainderOne {
	public int solution(int n) {
        int answer = 0;
        for(int x=2; x<n; x++){ // 어떤 자연수든 1로 나누어 떨어지기 때문에 x는 2부터 시작
            if(n%x==1){
                answer=x;
                break;
            }    
        }
        return answer;
    }
}
