/*
시저 암호 / 57min.
https://programmers.co.kr/learn/courses/30/lessons/12926

[문제 설명]
어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다. 
예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다. "z"는 1만큼 밀면 "a"가 됩니다. 
문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.

[제한 조건]
- 공백은 아무리 밀어도 공백입니다.
- s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
- s의 길이는 8000이하입니다.
- n은 1 이상, 25이하인 자연수입니다.

[입출력 예]
s, n -> result
------------------------------------
"AB", 1 -> "BC"
"z", 1 -> "a"
"a B z", 4 -> "e F d"

[기록]
- n만큼 밀었을 때 z 또는 Z를 넘어갈 경우, 원래 더한 것에서 알파벳 전체 개수인 26만큼 빼줘야 한다.

*/

public class CaesarCipher {
	public String solution(String s, int n) {
        String answer = "";
        for(int i=0; i<s.length(); i++){
            char nChar = (char)(s.charAt(i) + n); // n만큼 밀린 문자
            if(s.charAt(i) !=' '){ // 문자가 공백이 아닐 때
                if(nChar > 122 || (s.charAt(i)>=65 && s.charAt(i)<=90) && nChar>90){ // n만큼 밀렸을 때 Z 또는 z를 넘어간 경우 26 빼주기
                    nChar = (char)(nChar-26);
                }
                answer += nChar;
            } else{ // 문자가 공백이면 그대로 공백으로 담기
                answer += s.charAt(i);
            }
        }
        return answer;
    }
}
