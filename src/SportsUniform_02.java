
public class SportsUniform_02 {
	public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length; // ��ü �л� - ü���� �Ҿ���� �л�
        // �����ϱ�
        int tmp=0;
        for(int i=0; i<lost.length-1; i++){
            if(lost[i]>lost[i+1]){
                tmp = lost[i];
                lost[i] = lost[i+1];
                lost[i+1] = tmp;
            }
        }
        for(int i=0; i<reserve.length-1; i++){
            if(reserve[i]>reserve[i+1]){
                tmp = reserve[i];
                reserve[i] = reserve[i+1];
                reserve[i+1] = tmp;
            }
        }
        
        // ���� ü���� �л��� 1���� ���� ������ ���
        for(int i=0; i<reserve.length; i++){
            for(int j=0; j<lost.length; j++){
                if(lost[j]!=0){
                    if(reserve[i]==lost[j]){
                        reserve[i]=0;
                        lost[j]=0;
                        answer++;
                        
                        break;
                    }
                } // if
            } // for
        } // for
        
        // ������ �л� �� �չ�ȣ or �޹�ȣ���� ü���� �����ֱ�
        for(int i=0; i<reserve.length; i++){
            if(reserve[i]!=0){
                for(int j=0; j<lost.length; j++){
                    if(lost[j]!=0){
                        if(reserve[i]-lost[j]==1 || reserve[i]-lost[j]==-1){
                            reserve[i]=0;
                            lost[j]=0;
                            answer++;

                            break;
                        }
                    } // if
                } // for
            } // if
        } // for
        
       
        return answer;
    }
}
