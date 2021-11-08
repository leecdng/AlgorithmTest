
public class CalculateMoney {
	public long solution(int price, int money, int count) {
        long answer = -1;
        long total = 0; // 총 이용금액
        for(int i=1; i<=count; i++){
            total += price * i;
        }
        answer = -(money - total); // 부족한 금액
        if(answer<0){ // 금액이 남으면 0을 return
            answer=0;
        }

        return answer;
    }
}
