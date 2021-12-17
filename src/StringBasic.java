/*
문자열 다루기 기본 / 2min.
https://programmers.co.kr/learn/courses/30/lessons/12918

[문제 설명]
문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요. 
예를 들어 s가 "a234"이면 False를 리턴하고 "1234"라면 True를 리턴하면 됩니다.

[제한 사항]
s는 길이 1 이상, 길이 8 이하인 문자열입니다.

[기록]
- s를 int형으로 변환했을 때 문자가 있으면 예외가 생기는 점을 이용하여 풀었다. 이렇게 예외로 처리하는 것은 좋은 방법은 아니라고 함.
- 정규표현식을 바로 사용할 수 있도록 좀 더 공부할 것.

*/

public class StringBasic {
	public boolean solution(String s) {
        try{
            Integer.parseInt(s);
        } catch(Exception e){
            return false;
        }
        return s.length()==4 || s.length()==6? true:false;
    }
}
