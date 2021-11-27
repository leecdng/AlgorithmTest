/*
두 개 뽑아서 더하기 / 33min.
https://programmers.co.kr/learn/courses/30/lessons/68644

[문제 설명]
정수 배열 numbers가 주어집니다. 
numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.

[제한사항]
numbers의 길이는 2 이상 100 이하입니다.
numbers의 모든 수는 0 이상 100 이하입니다.

[입출력 예]
  numbers	result
---------------------------
[2,1,3,4,1]	[2,3,4,5,6,7]
[5,0,2,7]	[2,5,7,9,12]

[기록]
- 중복값이 없어야 해서 Set을 써보려다가 배열로 변환하는 게 익숙하지 않아서 List를 썼다.
TreeSet을 쓰면 값을 담을 때 정렬도 같이 된다고 한다.

*/

import java.util.*;
public class PickAndAdd {
	public int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList<Integer>();
        // i번째 값과 i번째보다 뒤에 있는 값들(j번째)을 더하기
        for(int i=0; i<numbers.length-1; i++){
            for(int j=i+1; j<numbers.length; j++){
                if(!list.contains(numbers[i]+numbers[j])){ // 같은 결과값이 없을 때만 list에 담기
                    list.add(numbers[i]+numbers[j]);
                }
            }
        }
        Collections.sort(list); // 오름차순 정렬
        int[] answer = list.stream().mapToInt(x->x).toArray(); // 배열로 변환
        return answer;
    }
}