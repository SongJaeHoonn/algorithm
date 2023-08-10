import java.io.*;

public class Q1110 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());    //N 입력받기
        int sum = 0;    //합한 수를 저장할 변수
        int count = 0;  //사이클을 저장할 변수
        int newNum = n; //새로운 수를 저장할 변수 (처음에 n으로 시작해야 계속 나눠줄 수 있음)
        String number; //파싱에 이용할 변수 (정수형 -> 문자열)

        if(0 > n || n > 99) return; //n 제한

        while(true){
            sum = (newNum / 10)+(newNum % 10); //십의 자리 수와 일의 자리 수 합치기
            number = String.valueOf(newNum % 10) + String.valueOf(sum % 10);    //number에 새로운 수의 일의 자리 수와 합한 수의 일의 자리 수를 문자열로 파싱 후 문자열끼리 더해준다.
            newNum = Integer.parseInt(number);  //number를 다시 정수형으로 파싱한다
            count++;    //한 사이클이 끝났으면 count에 1을 더해준다

            if(newNum == n) break;  //새로운 수가 다시 n이 되면 반복문을 빠져나간다.
        }

        bw.write(String.valueOf(count));
        bw.flush();
    }
}
