/*
정수 제곱근 판별 / 10min.
https://programmers.co.kr/learn/courses/30/lessons/12934

[문제 설명]
임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.

[제한 사항]
n은 1이상, 50000000000000 이하인 양의 정수입니다.

[기록]
- Math.pow(x, 2) 대신 x * x를 써줄 수 있다. 그렇게 하면 return 할 때 long형으로 형변환 하지 않아도 될 듯.
- x의 범위는 n이 1일 경우가 있기 때문에 x<n이 아니라 x<=n이 되어야 한다.
- x<=n/x로 범위를 바꾸면 -1을 리턴할 때 반복문이 도는 횟수를 줄일 수 있다.

*/

public class SquareRoot {
	public long solution(long n) {
        for(long x=1; x<=n; x++){
            if(n==Math.pow(x, 2)){
                return (long) Math.pow(x+1, 2); // Math.pow()의 반환형은 double이라 형변환 필요
            }
        }
        return -1;
    }
}