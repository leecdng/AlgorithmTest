class KakaoClawCrane_file {
    public int solution(int[][] board, int[] moves) {
        int[] basket= new int[moves.length]; // 뽑힌 인형 바구니
        int k=0; // 실제 작동 위치 (moves-1)
        int answer = 0; // 사라진 인형 개수
        for(int j=0; j<moves.length; j++){
            k = moves[j]-1;
            for(int i=0; i<board.length; i++){
                if(board[i][k]!=0){
                    basket[j-answer]=board[i][k]; // 뽑은 인형 바구니에 담기
                    board[i][k]=0; // 뽑은 인형 자리 비우기 
                    if(j-answer>0){
                        if(basket[j-answer]==basket[j-answer-1]){
                            answer+=2;
                        }
                    }
                    break;
                }
            }
        }
        
        return answer;
    }
}
