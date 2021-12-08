/*
숫자 문자열과 영단어 / 11min.
https://programmers.co.kr/learn/courses/30/lessons/81301

[문제 설명]
네오와 프로도가 숫자놀이를 하고 있습니다. 
네오가 프로도에게 숫자를 건넬 때 일부 자릿수를 영단어로 바꾼 카드를 건네주면 프로도는 원래 숫자를 찾는 게임입니다.

다음은 숫자의 일부 자릿수를 영단어로 바꾸는 예시입니다.

1478 → "one4seveneight"
234567 → "23four5six7"
10203 → "1zerotwozero3"
이렇게 숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 혹은 바뀌지 않고 그대로인 문자열 s가 매개변수로 주어집니다. s가 의미하는 원래 숫자를 return 하도록 solution 함수를 완성해주세요.

참고로 각 숫자에 대응되는 영단어는 다음 표와 같습니다.

숫자	영단어
-------------------
0	zero
1	one
2	two
3	three
4	four
5	five
6	six
7	seven
8	eight
9	nine

[기록]
- String[] num 배열을 만들지 않고, num[i] 대신 Integer.toString(i)나 String.valueOf(i)를 써주는 방법도 있다.
- contains()를 사용할까 생각했지만 단어가 포함될 경우 이중으로 문자열을 체크하는 게 될 것 같아서 사용하지 않았다.

*/

public class NumAndEnglishWords {
	public int solution(String s) {
        String[] num = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] str = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i=0; i<num.length; i++){
            s = s.replaceAll(str[i], num[i]);
        }
        return Integer.parseInt(s);
    }
}
