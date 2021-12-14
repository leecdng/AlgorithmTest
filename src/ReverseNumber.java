/*
자연수 뒤집어 배열로 만들기 / 5min.
https://programmers.co.kr/learn/courses/30/lessons/12932

[문제 설명]
자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.

[제한 조건]
n은 10,000,000,000이하인 자연수입니다.

[기록]
- 자연수 n을 문자열로 변환하여 뒷자리 수부터 배열에 순서대로 담았다.

*/

public class ReverseNumber {
	public int[] solution(long n) {
        String num = String.valueOf(n); // 자연수 n을 문자열로 변환
        int[] answer = new int[num.length()];
        for(int i=num.length()-1; i>=0; i--){ // 뒷자리 수부터 배열에 순서대로 담기
            answer[(num.length()-1)-i] = num.charAt(i)-'0';
        }
        return answer;
    }
}
