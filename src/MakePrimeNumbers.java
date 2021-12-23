/*
소수 만들기 / 15min.
https://programmers.co.kr/learn/courses/30/lessons/12977

[문제 설명]
주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다. 숫자들이 들어있는 배열 nums가 매개변수로 주어질 때, nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.

[제한사항]
nums에 들어있는 숫자의 개수는 3개 이상 50개 이하입니다.
nums의 각 원소는 1 이상 1,000 이하의 자연수이며, 중복된 숫자가 들어있지 않습니다.

[입출력 예]
[1,2,3,4] -> 1
[1,2,7,6,4] -> 4


[입출력 예 설명]
입출력 예 #1
[1,2,4]를 이용해서 7을 만들 수 있습니다.

입출력 예 #2
[1,2,4]를 이용해서 7을 만들 수 있습니다.
[1,4,6]을 이용해서 11을 만들 수 있습니다.
[2,4,7]을 이용해서 13을 만들 수 있습니다.
[4,6,7]을 이용해서 17을 만들 수 있습니다.


[기록]
- 배열에서 세 개의 수를 중복 없이 조합한 후, 조합된 수가 소수인지 확인.
- 소수인지 확인하기 -> 조합된 수를 나누어서 나누어 떨어지는 수가 있는지 체크.
소수 찾기 문제에서 풀었던 것처럼 나누는 수의 범위를 해당 수의 제곱근까지로 하고 짝수를 제외하여 효율성을 조금 더 높였다.

*/

public class MakePrimeNumbers {
	public int solution(int[] nums) {
        int answer = 0;
        int n = 0;
        boolean chk;
        for(int i=0; i<nums.length-2; i++){
            for(int j=i+1; j<nums.length-1; j++){
                for(int k=j+1; k<nums.length; k++){
                    n = nums[i]+nums[j]+nums[k]; // 3개의 수 조합
                    if(n%2!=0){ // 짝수이면 소수가 아님
                        chk = true;
                        for(int l=3; l<=Math.sqrt(n); l+=2){ // 소수인지 체크
                            if(n%l==0){
                                chk = false;
                                break;
                            }
                        }
                        if(chk) answer++; // 소수이면 카운트
                    }
                }
            }
        }
        return answer;
    }
}
