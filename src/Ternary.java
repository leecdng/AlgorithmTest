/*

3진법 뒤집기 / 34min + 11min(수정).
https://programmers.co.kr/learn/courses/30/lessons/68935


문제 설명
자연수 n이 매개변수로 주어집니다. n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.

제한사항
n은 1 이상 100,000,000 이하인 자연수입니다.


- 처음에 ternary.length() 자리에 n을 넣어놓고 헤맴.
- 풀고 나서 보니 리턴값만 필요하다면 코드를 좀 더 간단하게 할 수 있을 것 같아서 수정함.

*/

public class Ternary {
	// 처음 푼 것
	public int solution(int n) {
        int answer = 0;
        int mul = 1;
        String ternary = "";
        // 뒤집힌 3진수로 만들기
        while(n>=3){
            ternary += n%3;
            n /= 3;
        }
        ternary += n;
        
        // 다시 10진수로 만들기
        for(int i=(ternary.length()-1); i>=0; i--){
            answer += (int)(ternary.charAt(i)-'0')*mul;
            mul*=3;
        }
        
        return answer;
    }
	
	
	// 풀고 수정한 것 - 3진수 나타내는 것은 생략하고, 뒤집힌 3진수를 10진수로 변환한 값만 리턴함
	public int solution2(int n) {
        int answer = 0;
        while(n>=3){
            answer += n%3;
            answer *= 3; // answer = ((answer + (n%3)) * 3);
            n /= 3;
        }
        answer += n;
        
        return answer;
    }
}
