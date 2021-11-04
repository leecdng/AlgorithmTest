class LottoRank {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0, 0};
        
        int point=0;
        for(int i=0; i<win_nums.length; i++){
            for(int j=0; j<lottos.length; j++){
                if(win_nums[i]==lottos[j]){
                    point++;
                }
            }
        }
        int temp=0;
        for(int j=0; j<lottos.length; j++){
            if(lottos[j]==0){
                temp++;
            }
        }
        
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
