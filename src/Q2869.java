import java.io.*;
import java.util.StringTokenizer;

public class Q2869
{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String inputInt = br.readLine();    //A, B, V 입력받는 변수
        StringTokenizer st = new StringTokenizer(inputInt, " ");

        int a = Integer.parseInt(st.nextToken()); //A
        int b = Integer.parseInt(st.nextToken()); //B
        int v = Integer.parseInt(st.nextToken()); //V
        int day = (v - b) / (a - b);  //날 수(변화량으로 나눠준다. 정상에 올라가면 내려오지 않으므로, v-b를 정상으로 생각한다.)
        if((v - b) % (a - b) != 0) day++; //만약 v가 마지막 날에 올라간 높이보다 높다면, 하루를 추가해준다.
        bw.write(String.valueOf(day));
        bw.flush();

    }
}
