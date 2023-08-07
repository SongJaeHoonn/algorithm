import java.io.*;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Q2309 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String nAndk = br.readLine();
        StringTokenizer stk = new StringTokenizer(nAndk, " ");
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());
        String str;
        int list;
        int ranking = 1;
        int[][] country = new int[n][4];

        for(int i = 0; i < n; i++){
            str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            list = Integer.parseInt(st.nextToken());
            country[list - 1][0] = Integer.parseInt(st.nextToken());
            country[list - 1][1] = Integer.parseInt(st.nextToken());
            country[list - 1][2] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++){
            if(country[i][0] > country[k - 1][0]){
                ranking++;
            }else if((country[i][0] == country[k - 1][0])&& (country[i][1] > country[k - 1][1])){
                ranking++;
            }else if(country[i][0] == country[k - 1][0] && country[i][1] == country[k - 1][1] && country[i][2] > country[k - 1][2]){
                ranking++;
            }
        }

        bw.write(String.valueOf(ranking));
        bw.flush();

    }
}