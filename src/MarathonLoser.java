import java.util.*;
public class MarathonLoser {
	public String solution(String[] participant, String[] completion) {
        String answer = "";
        List<String> allList = new ArrayList<String>();
        List<String> completionList = new ArrayList<String>();
        for(int i=0; i<participant.length; i++){
            allList.add(participant[i]);
            if(i<completion.length) completionList.add(completion[i]);
        }
        Collections.sort(allList);
        Collections.sort(completionList);
        
        for(int i=0; i<completionList.size(); i++){
            if(!allList.get(i).equals(completionList.get(i))){
                answer = allList.get(i);
                break;
            }
        }
        if(answer.equals("")) answer = allList.get(allList.size()-1);
        
        return answer;
    }
}
