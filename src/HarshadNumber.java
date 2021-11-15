
public class HarshadNumber {
	public boolean solution(int x) {
        String strX = x + ""; // x를 문자열로 변환
        int sum = 0;
        for(int i=0; i<strX.length(); i++){
            sum += strX.charAt(i)-'0'; // 아스키코드 값끼리 빼서 strX.charAt(i)에 해당하는 숫자를 반환
        }
        return x%sum==0? true:false;
    }
}
