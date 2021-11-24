/*

K번째수
https://programmers.co.kr/learn/courses/30/lessons/42748


[문제 설명]
배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.
예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면

	1. array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
	2. 1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
	3. 2에서 나온 배열의 3번째 숫자는 5입니다.
	
배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, 
commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

[제한사항]
- array의 길이는 1 이상 100 이하입니다.
- array의 각 원소는 1 이상 100 이하입니다.
- commands의 길이는 1 이상 50 이하입니다.
- commands의 각 원소는 길이가 3입니다.

[기록]
- 여기서는 확장 for문보다 그냥 for문을 쓰는 게 변수 k를 안 만들어서 좋았을 것 같다.
- 안쪽 for문 돌리는 대신 copyOfRange(복사할 배열, 시작 인덱스, 마지막 인덱스) 를 써주면 간단해진다.
new int[] 이런 식으로 선언 안 하고 선언과 동시에 값을 넣을 수 있음. 기존 메서드 정확히 공부하기.

 */

import java.util.*;
public class KthNumber {
	public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int k=commands.length; // index를 위한 변수
        for(int[] c : commands){
            int[] temp = new int[c[1]-c[0]+1]; // i~j번째까지 자른 배열 담는 변수
            for(int i=c[0]-1; i<c[1]; i++){ // i~j번째까지 배열 담기
                temp[i-(c[0]-1)] = array[i];
            }
            Arrays.sort(temp); // 자른 배열 정렬
            answer[commands.length-k] = temp[c[2]-1]; // k번째 수 넣어주기 (commands.length-k ---> 0,1,2,...)
            k--;
        }
        return answer;
    }
}
