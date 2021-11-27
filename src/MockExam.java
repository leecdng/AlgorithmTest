/*
모의고사 / 127min.
https://programmers.co.kr/learn/courses/30/lessons/42840


[문제 설명]
수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 
수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 
가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.


[제한 조건]
시험은 최대 10,000 문제로 구성되어있습니다.
문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.

[입출력 예]
answers		return
-------------------
[1,2,3,4,5]	[1]
[1,3,2,4,2]	[1,2,3]


[기록]
- 처음에 list를 정렬했으나 for문이 순서대로 돌아가기 때문에 정렬이 따로 필요 없었다.
- 난 각 수포자의 답에서 규칙성을 찾아 풀었지만, 대부분 다른 사람들은 5, 8, 10개씩 패턴으로 정해서 풀었다. 코드가 더 단순해 보임.
- if문을 안 쓰고 Math.max() 메서드로 최고점을 가려낼 수도 있다.

*/

import java.util.*;
public class MockExam {
	public int[] solution(int[] answers) {
        int a=0; // 1번 수포자 답
        int b=0; // 2번 수포자 답
        int c=0; // 3번 수포자 답
        int point[]=new int[3]; // 각 수포자의 점수 배열
        for(int i=1; i<=answers.length; i++){
            // 1번 수포자 답
            a = i%5==0? 5:i%5;
            // 2번 수포자 답
            if(i%2!=0){
                b=2;
            }else{
                if(i%8==2) b=1;
                else if(i%8==4) b=3;
                else if(i%8==6) b=4;
                else if(i%8==0) b=5;
            }
            // 3번 수포자 답
            if(i%10==1 || i%10==2) c=3;
            else if(i%10==3 || i%10==4) c=1;
            else if(i%10==5 || i%10==6) c=2;
            else if(i%10==7 || i%10==8) c=4;
            else if(i%10==9 || i%10==0) c=5;
            // 채점해서 point 배열에 담기
            if(answers[i-1]==a) point[0]++;
            if(answers[i-1]==b) point[1]++;
            if(answers[i-1]==c) point[2]++;
        }
        // 수포자 중 1등 가려내기
        List<Integer> list = new ArrayList<Integer>(); // 수포자 중 1등 번호 담는 List
        int max=point[0]; // 임시 최고점
        list.add(1); // 임시 1등 번호
        for(int j=1; j<point.length; j++){
            if(max==point[j]){ // 임시 최고점과 같으면 list에 같이 번호 추가
                list.add(j+1);
            } else if(max<point[j]){ // 임시 최고점보다 크면 list를 초기화하고 단독으로 list에 번호 추가
                list.clear();
                list.add(j+1);
                max=point[j]; // 최고점 갱신
            }
        }
        int[] answer = list.stream().mapToInt(x->x).toArray(); // list를 배열로 변환
        return answer;
    }
}
