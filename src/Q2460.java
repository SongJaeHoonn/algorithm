import java.io.*;
import java.util.StringTokenizer;

public class Q2460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String people = "";
        String out_people = "";
        String in_people = "";
        int sum = 0;
        int max = 0;

        for(int i = 0; i < 9; i++){
            people = br.readLine();  //입력을 한 줄로 두개씩만 받는거 헷갈렸음(StringTokenizer로 해결)
            StringTokenizer st = new StringTokenizer(people, " ");
            out_people = st.nextToken();
            in_people = st.nextToken();

            sum -= (Integer.parseInt(out_people) - Integer.parseInt(in_people));
            if(sum >= max){//현재의 sum과 이전의 sum을 어떻게 비교할지 고민(max가 애초에 sum이면 반복문을 돌면서 max와 sum 비교가능)
                max = sum;
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
    }
