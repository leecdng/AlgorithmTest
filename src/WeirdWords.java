/*
이상한 문자 만들기 / 19min.
https://programmers.co.kr/learn/courses/30/lessons/12930

[문제 설명]
문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 각 단어는 하나 이상의 공백문자로 구분되어 있습니다. 
각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.

[제한 사항]
문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.

[입출력 예]
"try hello world" -> "TrY HeLlO WoRlD"

[입출력 예 설명]
"try hello world"는 세 단어 "try", "hello", "world"로 구성되어 있습니다. 
각 단어의 짝수번째 문자를 대문자로, 홀수번째 문자를 소문자로 바꾸면 "TrY", "HeLlO", "WoRlD"입니다. 따라서 "TrY HeLlO WoRlD" 를 리턴합니다.


[기록]
- 공백을 기준으로 한 index 변수를 따로 만들어주고, 공백일 때 index를 초기화 한다.
index가 짝수인지 홀수인지 판단하여 해당 문자를 대문자 또는 소문자로 변환하고, 새로운 String 변수에 더해준다.

- 다른 사람 풀이 참고
문자열 전체를 대문자로 미리 바꾸고, 이전 문자가 대문자면 소문자로 바꾸는 풀이도 있음.
문자가 공백인 경우에도 상관없이 대소문자 변환 메서드를 사용한 경우도 있음.

*/

public class WeirdWords {
	public String solution(String s) {
        String answer = "";
        String txt=""; // 바꾼 문자
        int idx=0; // 공백 기준 index
        for(int i=0; i<s.length(); i++){
            txt = s.substring(i, i+1);
            if(s.substring(i, i+1).equals(" ")){ // 공백이 있으면 idx 초기화
                idx=0;
            } else{
                txt = idx%2==0? txt.toUpperCase() : txt.toLowerCase(); // 짝수는 대문자로, 홀수는 소문자로
                idx++;
            }
            answer += txt;
        }
        return answer;
    }
}
