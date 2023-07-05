import java.io.*;
import java.util.StringTokenizer;

public class Q2460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String people = "";         //한 줄에 두 개(타는 사람, 내리는 사람)씩 입력받을 변수
        String out_people = "";     //StringTokenizer로 내리는 사람의 수만 저장할 변수
        String in_people = "";      //StringTokenizer로 타는 사람의 수만 저장할 변수
        int sum = 0;                //각 역에서의 사람 수를 저장할 변수
        int max = 0;                //기차 안의 사람 수의 최대치를 저장할 변수

        for(int i = 0; i < 9; i++){     //역이 10개이므로, 반복문은 10번 돈다.
            people = br.readLine();  //입력을 한 줄로 두개씩만 받는거 헷갈렸음(StringTokenizer로 해결)
            StringTokenizer st = new StringTokenizer(people, " ");  //공백 기준으로 분할
            out_people = st.nextToken();
            in_people = st.nextToken();

            sum -= (Integer.parseInt(out_people) - Integer.parseInt(in_people));    //현재 기차 안의 사람 - (내리는 사람 - 타는 사람)
            if(sum >= max){//현재의 sum과 이전의 sum을 어떻게 비교할지 고민(max가 애초에 sum이면 반복문을 돌면서 max와 sum 비교가능)
                max = sum;
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
    }
}
