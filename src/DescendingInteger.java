/*
정수 내림차순으로 배치하기 / 14min.
https://programmers.co.kr/learn/courses/30/lessons/12933

[문제 설명]
함수 solution은 정수 n을 매개변수로 입력받습니다. 
n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요. 
예를들어 n이 118372면 873211을 리턴하면 됩니다.

[제한 조건]
n은 1이상 8000000000 이하인 자연수입니다.

[기록]
- n을 문자열로 변환 -> 한 글자씩 정수 배열에 담기 -> 배열 오름차순 정렬 -> 배열값 해당 자릿수만큼 곱해서 더하기
이 순서대로 풀었다.

*/

import java.util.*;
public class DescendingInteger {
	public long solution(long n) { // n이 118372일 때
        long answer = 0;
        String num = String.valueOf(n); // 정수 n을 문자열로 변환 -> "118372"
        int[] arr = new int[num.length()];
        for(int i=0; i<num.length(); i++){ // 문자열 num을 한 글자씩 정수 배열에 담기 -> {1,1,8,3,7,2}
            arr[i] = num.charAt(i)-'0';
        }
        Arrays.sort(arr); // 오름차순 정렬 -> {1,1,2,3,7,8}
        for(int i=0; i<arr.length; i++){ // 배열값 해당 자릿수만큼 곱해서 더하기
            answer += i>0? arr[i] * Math.pow(10, i) : arr[i];
        }
        return answer;
    }
}
