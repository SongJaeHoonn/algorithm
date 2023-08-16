import java.io.*;
import java.util.*;

public class Q1026 {
    public static void main(String[] args) throws IOException {
        //옛날 옛적에 수학이 항상 큰 골칫거리였던 나라가 있었다. 이 나라의 국왕 김지민은 다음과 같은 문제를 내고 큰 상금을 걸었다.
        //
        //길이가 N인 정수 배열 A와 B가 있다. 다음과 같이 함수 S를 정의하자.
        //
        //S = A[0] × B[0] + ... + A[N-1] × B[N-1]
        //
        //S의 값을 가장 작게 만들기 위해 A의 수를 재배열하자. 단, B에 있는 수는 재배열하면 안 된다.
        //
        //S의 최솟값을 출력하는 프로그램을 작성하시오.
        //
        //입력
        //첫째 줄에 N이 주어진다. 둘째 줄에는 A에 있는 N개의 수가 순서대로 주어지고, 셋째 줄에는 B에 있는 수가 순서대로 주어진다.
        // N은 50보다 작거나 같은 자연수이고, A와 B의 각 원소는 100보다 작거나 같은 음이 아닌 정수이다.
        //
        //출력
        //첫째 줄에 S의 최솟값을 출력한다.
        //1. N과 A, B를 입력받는다
        //2. B를 순회하며 제일 큰 수를 찾는다.
        //3. B의 제일 큰 수와 A의 제일 작은 수를 같은 인덱스에 배치한다.
        //4. S를 계산하여 출력한다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] A = new int[n];   //A 배열
        int[] B = new int[n];   //B 배열
        String a = br.readLine();
        String b = br.readLine();

        StringTokenizer sta = new StringTokenizer(a, " ");
        for(int i = 0; i < n; i++){
            A[i] = Integer.parseInt(sta.nextToken());   //A 순서대로 담기
        }

        StringTokenizer stb = new StringTokenizer(b, " ");
        for(int i = 0; i < n; i++){
            B[i] = Integer.parseInt(stb.nextToken());   //B 순서대로 담기
        }

        Arrays.sort(A); //A 오름차순 정렬

        int maxB = B[0];
        int idxB = 0;
        int idxA = 0;
        int sum = 0;
        for(int k = 0; k < n; k++) {
            maxB = B[0];    //한 턴 돌때마다 maxB를 다시 처음 인덱스로 초기화
            for (int i = 0; i < n; i++) {
                if (maxB <= B[i]) { //최댓값 찾는 과정
                    maxB = B[i];
                    idxB = i;
                }
            }
            B[idxB] = -1;   //최댓값 찾았으면 그 값은 제외하기 위해 -1로 변경

            sum += A[k]*maxB;   //A의 가장 작은 값과 B의 가장 큰 값 차례로 계산
        }

        bw.write(String.valueOf(sum));
        bw.flush();
    }
}
