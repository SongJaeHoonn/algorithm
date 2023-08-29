import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q1764 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        String nm = br.readLine();
        StringTokenizer st = new StringTokenizer(nm, " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {   //듣도 못한 사람 입력
            map.put(br.readLine(), 0);  //듣도 못한 사람은 밸류값 0
        }
        String name;
        int count = 0;
        for (int j = 0; j < m; j++) {   //보도 못한 사람 입력
            name = br.readLine();
            map.put(name, map.getOrDefault(name, -1) + 1);  //듣도 보도 못한 사람이 되면 밸류값이 1이 됨
            if (map.get(name) == 1) {
                list.add(name);
                count++;
            }
        }

        Collections.sort(list);

        bw.write(String.valueOf(count) + "\n");
        for(String nameList : list){
            bw.write(nameList + "\n");
        }

        bw.flush();

    }
}
