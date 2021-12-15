/*
약수의 합 / 2min.
https://programmers.co.kr/learn/courses/30/lessons/12928

[문제 설명]
정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.

[제한 사항]
n은 0 이상 3000이하인 정수입니다.

[기록]
- n/2보다 큰 약수는 n뿐이므로, for문에서 i의 범위를 i<=n/2로 하고
for문 밖에서 answer에 따로 n을 더해주면 반복문 횟수를 줄일 수 있다. 

*/

public class SumOfDivisors {
	public int solution(int n) {
        int answer = 0;
        for(int i=1; i<=n; i++){
            if(n%i==0) answer += i;
        }
        return answer;
    }
}
