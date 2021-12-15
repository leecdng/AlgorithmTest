/*
문자열 내림차순으로 배치하기 / 40min.
https://programmers.co.kr/learn/courses/30/lessons/12917

[문제 설명]
문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.

[제한 사항]
str은 길이 1 이상인 문자열입니다.

[입출력 예]
	s		return
--------------------------------------------
"Zbcdefg"	"gfedcbZ"


[기록]
- 대문자는 소문자보다 작은 것으로 간주합니다. -> 아스키코드에서는 대문자가 소문자보다 작은 값이기 때문에
이를 이용하여 char 타입 배열에 담아 정렬하여 풀었다.

*/

import java.util.*;
public class DescendingString {
	public String solution(String s) {
        String answer = "";
        char[] sArr = new char[s.length()];
        for(int i=0; i<s.length(); i++){ // 각 문자를 순서대로 배열에 담기
            sArr[i] = s.charAt(i);
        }
        Arrays.sort(sArr); // 배열 오름차순 정렬
        for(int i=sArr.length-1; i>=0; i--){ // 내림차순으로 한 글자씩 문자열에 더하기
            answer += sArr[i];
        }
        return answer;
    }
}
