import java.io.*;
import java.util.StringTokenizer;

public class Q3036 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());    //N 입력받기
        String radius = br.readLine();  //반지름 공백 기준으로 입력받기
        int boonja = 0; //출력할 분자 초기화
        int boonmo = 0; //출력할 분모 초기화
        int[] length = new int[n];    //원의 둘레 저장할 배열 length

        StringTokenizer st = new StringTokenizer(radius, " ");  //공백 기준으로 문자열 나눈다
        for(int i = 0; i < n; i++){
            length[i] = 2 * Integer.parseInt(st.nextToken());   //원둘레는 애초에 3.14가 공통으로 들어있음(지우기)
        }                                                       //3.14까지 곱해주면 기약 분수로 출력 할 수 없음(실수이므로)

        for(int i = 1; i < n; i++){
            for(int j = 0; j <= length[0] && j <= length[i]; j++){
                if(length[0] % j == 0 && length[i] % j == 0){   //첫번째 원과 i번째 원의 최대공약수 구하기
                    boonja = (int)length[0] / j;    //분자와 분모 최대공약수로 나눠주기
                    boonmo = (int)length[i] / j;
                }
            }
            bw.write(boonja + "/" + boonmo + "\n"); //기약분수 형태로 출력
        }
        bw.flush();
    }
}

