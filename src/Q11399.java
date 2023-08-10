import java.io.*;
import java.util.StringTokenizer;

public class Q11399 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String pi = br.readLine();
        int[] piList = new int[n];  //pi를 순서대로 담을 배열
        StringTokenizer st = new StringTokenizer(pi, " ");
        for(int i = 0; i < n; i++){
            piList[i] = Integer.parseInt(st.nextToken());   //pi를 순차적으로 담아줌
        }

        int temp = 0;

        for(int i = 0; i < n - 1; i++){ //오름차순 정렬
            for(int j = 0; j < n - 1; j++) {
                if (piList[j] > piList[j + 1]) {
                    temp = piList[j];
                    piList[j] = piList[j + 1];
                    piList[j + 1] = temp;
                }
            }
        }

        int sum = 0;
        int total = 0;

        for(int i = 0; i < n ; i++){
            sum += piList[i];
            total += sum;
        }
        bw.write(String.valueOf(total));
        bw.flush();
    }
}
