/*
x만큼 간격이 있는 n개의 숫자 / 14min.
https://programmers.co.kr/learn/courses/30/lessons/12954

[문제 설명]
함수 solution은 정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴해야 합니다. 
다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.

[제한 조건]
x는 -10000000 이상, 10000000 이하인 정수입니다.
n은 1000 이하인 자연수입니다.

[입출력 예]
x	n	answer
------------------------
2	5	[2,4,6,8,10]
4	3	[4,8,12]
-4	2	[-4, -8]


[기록]
- 입출력의 예와 같이 x가 x씩 증가하면 x, x+x, x+x+x, ... 즉 1x, 2x, 3x, ...가 된다.
순서대로 배열에 담으면 answer[0]=1x, answer[1]=2x, answer[2]=3x, ... answer[i]=(i+1)*x가 된다.
- 형변환을 잘 해줄 것.

*/

public class XIntervalNum {
	public long[] solution(int x, int n) {
        long[] answer = new long[n];
        for(int i=0; i<n; i++){
            answer[i]=(long)(i+1)*x;
        }
        return answer;
    }
}
