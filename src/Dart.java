/*
[1차] 다트 게임 / 100min.
https://programmers.co.kr/learn/courses/30/lessons/17682


[문제 설명]
카카오톡 게임별의 하반기 신규 서비스로 다트 게임을 출시하기로 했다. 다트 게임은 다트판에 다트를 세 차례 던져 그 점수의 합계로 실력을 겨루는 게임으로, 모두가 간단히 즐길 수 있다.
갓 입사한 무지는 코딩 실력을 인정받아 게임의 핵심 부분인 점수 계산 로직을 맡게 되었다. 다트 게임의 점수 계산 로직은 아래와 같다.

다트 게임은 총 3번의 기회로 구성된다.
각 기회마다 얻을 수 있는 점수는 0점에서 10점까지이다.
점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재하고 각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱 (점수1 , 점수2 , 점수3 )으로 계산된다.
옵션으로 스타상(*) , 아차상(#)이 존재하며 스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다. 아차상(#) 당첨 시 해당 점수는 마이너스된다.
스타상(*)은 첫 번째 기회에서도 나올 수 있다. 이 경우 첫 번째 스타상(*)의 점수만 2배가 된다. (예제 4번 참고)
스타상(*)의 효과는 다른 스타상(*)의 효과와 중첩될 수 있다. 이 경우 중첩된 스타상(*) 점수는 4배가 된다. (예제 4번 참고)
스타상(*)의 효과는 아차상(#)의 효과와 중첩될 수 있다. 이 경우 중첩된 아차상(#)의 점수는 -2배가 된다. (예제 5번 참고)
Single(S), Double(D), Triple(T)은 점수마다 하나씩 존재한다.
스타상(*), 아차상(#)은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을 수도 있다.
0~10의 정수와 문자 S, D, T, *, #로 구성된 문자열이 입력될 시 총점수를 반환하는 함수를 작성하라.


[입력 형식]
"점수|보너스|[옵션]"으로 이루어진 문자열 3세트.
예) 1S2D*3T

점수는 0에서 10 사이의 정수이다.
보너스는 S, D, T 중 하나이다.
옵선은 *이나 # 중 하나이며, 없을 수도 있다.


[출력 형식]
3번의 기회에서 얻은 점수 합계에 해당하는 정수값을 출력한다.
예) 37


[입출력 예제]
예제	dartResult	answer			설명
------------------------------------------------------------------------------
1	1S2D*3T		37		11 * 2 + 22 * 2 + 33
2	1D2S#10S	9		12 + 21 * (-1) + 101
3	1D2S0T		3		12 + 21 + 03
4	1S*2T*3S	23		11 * 2 * 2 + 23 * 2 + 31
5	1D#2S*3S	5		12 * (-1) * 2 + 21 * 2 + 31
6	1T2D3D#		-4		13 + 22 + 32 * (-1)
7	1D2S3T*		59		12 + 21 * 2 + 33 * 2


[기록]
- 점수 | 보너스 | [옵션] 을 배열에 먼저 나눠 담고, 이 값을 이용하여 최종점수를 p 배열에 담아 계산한다.

- 10이나 옵션 *, #이 있고 없고를 신경 써서 복잡하게 생각했는데 
다른 사람 풀이를 보니 10을 다른 문자로 바꿔주고, 숫자 앞에서 cnt를 올려주면 좀 더 간단하게 풀 수 있었다.

*/

public class Dart {
	public int solution(String dartResult) {
        int answer = 0;
        String[][] point= new String[3][3]; // 점수 | 보너스 | [옵션] 배열
        int[] p= new int[3]; // 최종점수 배열
        int cnt=0;
        // point 배열에 점수 | 보너스 | [옵션] 각각 담기
        for(int i=0; i<dartResult.length(); i++){
            if(i<dartResult.length()-1){
                if(dartResult.charAt(i)-'0'>=0 && dartResult.charAt(i)-'0'<=9){ // 숫자일 경우
                    if(dartResult.charAt(i)-'0'==1 && dartResult.charAt(i+1)-'0'==0){ // 10일 경우
                        point[cnt][0]=dartResult.substring(i, i+2); // 두 자리를 점수에 담고 다음 index 건너뛰기
                        i++;
                    } else{
                        point[cnt][0]=dartResult.substring(i, i+1); // 해당 문자만 점수에 담기
                    }
                } else if(dartResult.charAt(i)=='S' || dartResult.charAt(i)=='D' || dartResult.charAt(i)=='T'){ // 보너스 문자일 경우
                    point[cnt][1]=dartResult.substring(i, i+1); // 보너스에 담기
                    if(dartResult.charAt(i+1)=='*' || dartResult.charAt(i+1)=='#'){ // 보너스 다음에 옵션 #, *이 올 경우
                        point[cnt][2]=dartResult.charAt(i+1)+""; // 다음 문자를 옵션에 담고 다음 index 건너뛰기
                        i++;
                    } else{
                        point[cnt][2]=""; // 옵션이 없을 시 빈 문자열 값 담기
                    }
                    cnt++; // 1게임 종료 후 index 증가
                }
            } else{ // 마지막 문자일 때
                if(dartResult.charAt(i)=='S' || dartResult.charAt(i)=='D' || dartResult.charAt(i)=='T'){
                    point[cnt][1]=dartResult.substring(i); // 보너스
                    point[cnt][2]=""; // 옵션
                }
            }
        }
        
        // 각 점수, 보너스, 옵션을 이용하여 최종점수를 p 배열에 담기
        for(int i=0; i<p.length; i++){
            p[i] = Integer.parseInt(point[i][0]);
            if(point[i][1].equals("D")){
                p[i] *= p[i];
            } else if(point[i][1].equals("T")){
                p[i]*=(p[i]*p[i]);
            }
            if(point[i][2].equals("#")){
                p[i] *= -1;
            } else if(point[i][2].equals("*")){
                p[i] *= 2;
                if(i>0){ // 첫 번째 게임이 아닐 경우 이전 게임 점수도 2배
                    p[i-1] *= 2;
                }
            }
        }
        
        // 최종 점수 계산
        for(int i=0; i<p.length; i++){
            answer+=p[i];
        }
        return answer;
    }
}
