import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q2960 {
    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();    //크기에 제한받지 않는 ArrayList를 이용

        String inputMessage = br.readLine();    //한 줄에 두 개를 입력받아야 하므로 문자열로 입력받기
        StringTokenizer st = new StringTokenizer(inputMessage, " ");    //공백 기준으로 나누는 StringTokenizer
        int n = Integer.parseInt(st.nextToken());   //변수 N
        int k = Integer.parseInt(st.nextToken());   //변수 K
        int p;
        int delete;
        int count = 0;  //몇번 째로 지우는 것인지 파악하는 변수
        for(int i = 2; i <= n; i++){
            list.add(i);    //2부터 N까지의 정수를 담아준다
        }

        while(true){
            p = list.get(0);    //리스트의 가장 첫번째 요소를 담아준다
            list.remove(Integer.valueOf(p));    //p를 객체화하여 리스트에서 제거한다
            delete = p; //p를 지운다git
            count++;   //지울 때마다 count + 1
            for(int i = 2; i * p <= n; i++){
                if(list.contains(i * p)) {  //리스트에 p의 배수가 있으면
                    list.remove(Integer.valueOf(i*p));  //p의 배수들 순차적으로 삭제
                    delete = i * p; //p의 배수를 삭제한다.
                    count++;    //삭제할 때마다 count + 1
                    if(count == k) break;
                }
            }
            if(count == k) {  //count가 K와 같아지면
                bw.write(String.valueOf(delete));   //그 시점에서 지운 수를 출력한다
                break;  //반복문을 종료한다.
            }
            if(list.size() == 0){   //리스트에 아무것도 없으면
                break;  //반복을 종료한다.
            }
        }
        bw.flush();
    }
}