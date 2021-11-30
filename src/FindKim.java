/*
서울에서 김서방 찾기 / 6min.
https://programmers.co.kr/learn/courses/30/lessons/12919


[문제 설명]
String형 배열 seoul의 element중 "Kim"의 위치 x를 찾아, "김서방은 x에 있다"는 String을 반환하는 함수, solution을 완성하세요. 
seoul에 "Kim"은 오직 한 번만 나타나며 잘못된 값이 입력되는 경우는 없습니다.

[제한 사항]
seoul은 길이 1 이상, 1000 이하인 배열입니다.
seoul의 원소는 길이 1 이상, 20 이하인 문자열입니다.
"Kim"은 반드시 seoul 안에 포함되어 있습니다.

[입출력 예]
	seoul				return
-------------------------------------
["Jane", "Kim"]		"김서방은 1에 있다"

*/

public class FindKim {
	public String solution(String[] seoul) {
        int x=0;
        for(x=0; x<seoul.length; x++){
            if(seoul[x].contains("Kim")) break; // Kim과 일치하면 for문 종료
        }
        String answer = "김서방은 " + x +"에 있다"; // for문 조건식에 사용되는 변수를 for문 바깥에 선언하여 그대로 return 하기
        return answer;
    }
}
