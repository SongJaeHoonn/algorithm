import java.io.*;

public class Q2839 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());    //n 입력받기
        int count = 0;  //설탕 봉지 개수를 담을 변수

        while (true) {  //반복문을 통해 계속 조건을 확인한다
            if (n % 5 == 0) {   //5로 나누어 떨어지면,
                count += n / 5; //n을 5로 나눈 값을 count에 합친다.
                break;  //반복문을 나간다.
            }
            n -= 3; //첫 if문을 지나왔다는 것은 5로 나누어 떨어지지 않는다는 것이므로, 3킬로그램 설탕 봉투에 하나씩 담아본다.
            count++;

            if(n < 0){  //이 때, n이 0보다 작다는 것은 n이 3과 5로 정확히 나누어 떨어지지 않는다는 것이다.
                count = -1; //-1을 출력한다.
                break;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
    }
}

