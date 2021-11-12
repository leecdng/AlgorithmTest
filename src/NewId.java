public class NewId {
	public String solution(String new_id) {
        String answer = "";
        // 1 소문자로
        new_id = new_id.toLowerCase();
        // 2 특문 없애기
        answer = new_id.replaceAll("[^a-z0-9-_.]", "");
        // 3 ..은 .으로 바꾸기
        while(answer.indexOf("..")!=-1){
            answer = answer.replace("..", ".");
        }
        // 4 마침표(.)가 처음이나 끝에 위치한다면 제거
        if(answer.length()>1){
            if(answer.substring(0,1).equals(".")) answer = answer.substring(1);
        }
        if(answer.length()>1){
            if(answer.substring(answer.length()-1).equals(".")){
                answer = answer.substring(0,answer.length()-1);
            }
        }
        // 5 빈 문자열이라면, "a"를 대입
        if (answer.equals(".") || answer.equals("")) answer="a";
        // 6 길이가 16자 이상이면 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
        // 만약 제거 후 마침표(.)가 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거
        while (answer.length()>15){
            answer = answer.substring(0,answer.length()-1);
        }
        if(answer.length()>1){
            if(answer.substring(answer.length()-1).equals(".")){
                answer = answer.substring(0, answer.length()-1);
            }
        }
        // 7 길이가 2자 이하라면, 마지막 문자를 길이가 3이 될 때까지 반복해서 끝에 붙이기
        while(answer.length()<3){
            answer += answer.substring(answer.length()-1);
        }
        
        return answer;
    }
}
