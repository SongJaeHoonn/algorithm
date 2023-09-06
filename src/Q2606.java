import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2606 {
    static Queue<Integer> queue = new LinkedList<>();
    static int[][] computer;
    static boolean[] visited;
    static int cn, biComCount;
    static int count = 0;
    static void bfs(int start){
        queue.add(1);
        visited[1] = true;
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int i = 1; i < cn + 1; i++){
                if(computer[node][i] == 1 && visited[i] != true){
                    queue.add(i);
                    visited[i] = true;
                    count++;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        //신종 바이러스인 웜 바이러스는 네트워크를 통해 전파된다. 한 컴퓨터가 웜 바이러스에 걸리면 그 컴퓨터와 네트워크 상에서 연결되어 있는 모든 컴퓨터는 웜 바이러스에 걸리게 된다.
        //
        //예를 들어 7대의 컴퓨터가 <그림 1>과 같이 네트워크 상에서 연결되어 있다고 하자.
        // 1번 컴퓨터가 웜 바이러스에 걸리면 웜 바이러스는 2번과 5번 컴퓨터를 거쳐 3번과 6번 컴퓨터까지 전파되어 2, 3, 5, 6 네 대의 컴퓨터는 웜 바이러스에 걸리게 된다.
        // 하지만 4번과 7번 컴퓨터는 1번 컴퓨터와 네트워크상에서 연결되어 있지 않기 때문에 영향을 받지 않는다.
        //
        //
        //
        //어느 날 1번 컴퓨터가 웜 바이러스에 걸렸다. 컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때,
        // 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 작성하시오.
        //
        //입력
        //첫째 줄에는 컴퓨터의 수가 주어진다. 컴퓨터의 수는 100 이하인 양의 정수이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다.
        // 둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다. 이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.
        //
        //출력
        //1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력한다.

        //1. 컴퓨터의 수, 직접연결 컴퓨터쌍의 수, 컴퓨터 번호 쌍 입력받기
        //2. 직접 연결되어 있는 컴퓨터 번호 쌍을 2차원 배열에 저장
        //3. 반복문을 돌며 1번 컴퓨터를 찾고, 1번 컴퓨터에 연결되어 있는 컴퓨터를 찾아가며 카운트
        //4. 계속 연결연결해서 카운트

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        cn = Integer.parseInt(br.readLine());
        biComCount = Integer.parseInt(br.readLine());
        visited = new boolean[cn + 1];
        computer = new int[cn + 1][cn + 1];
        String biCom;
        for(int i = 0; i < biComCount; i++){
            biCom = br.readLine();
            StringTokenizer st = new StringTokenizer(biCom, " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            computer[b][a] = 1;
            computer[a][b] = 1;
        }
        bfs(1);
        bw.write(String.valueOf(count));
        bw.flush();
    }
}
