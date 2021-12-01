/*
2016년
https://programmers.co.kr/learn/courses/30/lessons/12901


[문제 설명]
2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요? 
두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요. 
요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT
입니다. 예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 "TUE"를 반환하세요.

[제한 조건]
2016년은 윤년입니다.
2016년 a월 b일은 실제로 있는 날입니다. (13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다)

[입출력 예]
a	b	result
----------------
5	24	"TUE"

[기록]
- a월 b일이 2016년에서 며칠째 날짜인지 구하여 해당 요일을 구했다.
- 총 일수 = a월 이전 달들의 날짜 합 + b일
- 일~토요일을 각각 0~6으로 정함.
- 1월 1일이 5(금요일)로 시작하기 때문에, 총 일수+4를 7(요일 수)로 나눈 나머지가 해당 요일을 반환하는 규칙성을 가진다.

- indexOf()를 쓸 때 1, 2가 10, 11, 12 등을 포함할 수 있으므로 앞뒤에 구분 문자를 넣어주어야 한다.
- Calendar를 이용하면 좀 더 간단하다.

*/

public class Year2016 {
	public String solution(int a, int b) {
        // 마지막 날짜를 기준으로 각 달을 구분
        String m31 = "/1월/3월/5월/7월/8월/10월/12월";
        String m29 = "/2월"; // 윤년
        String m30 = "/4월/6월/9월/11월";
        int lastDay=0; // 달의 마지막 날짜
        int totalDays=0; // a월 b일의 당해 총 일수
        
        for(int i=1; i<a; i++){ // a월 이전 달들의 총 일수 구하기
            if(m31.indexOf("/"+i+"월")!=-1) lastDay=31;
            else if(m29.indexOf("/"+i+"월")!=-1) lastDay=29;
            else lastDay=30;
            
            totalDays+=lastDay;
        }
        totalDays+=b; // b일 더해서 a월 b일 총 일수 구하기
        int week = (totalDays+4)%7; // 해당 요일 구하기
        String answer = "";
        
        switch(week){ // 0~6을 해당 요일(일~토)로 반환
            case 0:
                answer="SUN";
                break;
            case 1:
                answer="MON";
                break;
            case 2:
                answer="TUE";
                break;
            case 3:
                answer="WED";
                break;
            case 4:
                answer="THU";
                break;
            case 5:
                answer="FRI";
                break;
            case 6:
                answer="SAT";
        }
        return answer;
    }
}
