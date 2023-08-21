import java.io.*;
import java.util.*;

public class Q1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> list = new ArrayList<>();

        String nl = br.readLine();
        StringTokenizer st = new StringTokenizer(nl, " ");
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        String location = br.readLine();
        StringTokenizer st2 = new StringTokenizer(location, " ");
        for(int i = 0; i < n; i++){
            list.add(Integer.parseInt(st2.nextToken()));
        }

        int count = 1;  //처음에 테이프를 붙이고 시작
        Collections.sort(list);
        double tape = list.get(0) - 0.5;    //테이프를 시작하는 부분
        for(int i = 0; i < n; i++)
        {
            if(tape + l <= list.get(i)){    //tape + l은 i에서의 테이프 시작 부분에서 테이프 끝까지의 인덱스
                count++;    //테이프가 끝나는 부분이 물이 새는 곳보다 작거나 같은 것을 만족하면 테이프 붙이기
                tape = list.get(i) - 0.5;   //테이프 시작점 초기화
        }
        }
        bw.write(String.valueOf(count));
        bw.flush();
    }
}
