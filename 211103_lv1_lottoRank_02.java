class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0, 0};
        
        int point=0; // 일치하는 번호 개수
        int temp=0; // 알 수 없는 번호 0의 개수
        for(int i=0; i<lottos.length; i++){
            if(lottos[i]==0){
                temp++;
            } else{
                for(int j=0; j<win_nums.length; j++){
                    if(lottos[i]==win_nums[j]){
                        point++;
                    }
                } //for
            } //if
        } //for
        
        answer[0] = lottos.length - point - temp + 1;
        if(answer[0]==lottos.length+1){
            answer[0]=lottos.length;
        }
        answer[1] = lottos.length - point + 1;
        if(answer[1]==lottos.length+1){
            answer[1]=lottos.length;
        }
        
        return answer;
    }
}
