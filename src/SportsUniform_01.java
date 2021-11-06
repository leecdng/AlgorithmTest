
public class SportsUniform_01 {
	public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length; // 전체 학생 - 체육복 잃어버린 학생
        // 여벌 체육복 학생이 1벌만 도난 당했을 경우
        for(int i=0; i<reserve.length; i++){
            for(int j=0; j<lost.length; j++){
                if(lost[j]!=0){
                    if(reserve[i]==lost[j]){
                        reserve[i]=0;
                        lost[j]=0;
                        answer++;
                        
                        break;
                    }
                }
            }
        }
        
        // 나머지 학생 중 앞번호 or 뒷번호에게 체육복 빌려주기
        int tmp1=0;
        int[] lost1=new int[lost.length];
        int[] reserve1=new int[reserve.length];
        for(int i=0; i<lost.length; i++){
            lost1[i]=lost[i];
        }
        for(int i=0; i<reserve.length; i++){
            reserve1[i]=reserve[i];
        }
        for(int i=0; i<reserve1.length; i++){
            if(reserve1[i]!=0){
                for(int j=0; j<lost1.length; j++){
                    if(lost1[j]!=0){
                        if(reserve1[i]-lost1[j]==1){
                            reserve1[i]=0;
                            lost1[j]=0;
                            tmp1++;

                            break;
                        }
                    }
                }
            }
        }
        
        int tmp2=0;
        int[] lost2=new int[lost.length];
        int[] reserve2=new int[reserve.length];
        for(int i=0; i<lost.length; i++){
            lost2[i]=lost[i];
        }
        for(int i=0; i<reserve.length; i++){
            reserve2[i]=reserve[i];
        }
        for(int i=0; i<reserve2.length; i++){
            if(reserve2[i]!=0){
                for(int j=0; j<lost2.length; j++){
                    if(lost2[j]!=0){
                        if(reserve2[i]-lost2[j]==-1){
                            reserve2[i]=0;
                            lost2[j]=0;
                            tmp2++;

                            break;
                        }
                    }
                }
            }
        }
        
        int tmp3=0;
        int[] lost3=new int[lost.length];
        int[] reserve3=new int[reserve.length];
        for(int i=0; i<lost.length; i++){
            lost3[i]=lost[i];
        }
        for(int i=0; i<reserve.length; i++){
            reserve3[i]=reserve[i];
        }
        for(int i=0; i<reserve3.length; i++){
            if(reserve3[i]!=0){
                for(int j=0; j<lost3.length; j++){
                    if(lost3[j]!=0){
                        if(reserve3[i]-lost3[j]==-1 || reserve3[i]-lost3[j]==1){
                            reserve3[i]=0;
                            lost3[j]=0;
                            tmp3++;

                            break;
                        }
                    }
                }
            }
        }
        
        if(tmp1>=tmp2){
            if(tmp1>=tmp3){
                answer+=tmp1;
            } else{
                answer+=tmp3;
            }
        }else{
            answer+=tmp2;
        }
        return answer;
    }
}
