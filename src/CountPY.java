
public class CountPY {
	boolean solution(String s) {
        boolean answer = true;
        int cnt=0;
        for(int i=0; i<s.length(); i++){
            if(i<s.length()-1){
                if(s.substring(i, i+1).toUpperCase().equals("P")){
                    cnt++;
                } else if(s.substring(i, i+1).toUpperCase().equals("Y")){
                    cnt--;
                }
            } else{
                if(s.substring(i).toUpperCase().equals("P")){
                    cnt++;
                } else if(s.substring(i).toUpperCase().equals("Y")){
                    cnt--;
                }
            }
        }
        
        if(cnt!=0){
            answer = false;
        }

        return answer;
    }
}
