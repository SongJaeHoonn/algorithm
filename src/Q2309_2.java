import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Q2309_2 {
    public static void main(String[] args) throws IOException {
        //왕비를 피해 일곱 난쟁이들과 함께 평화롭게 생활하고 있던 백설공주에게 위기가 찾아왔다. 일과를 마치고 돌아온 난쟁이가 일곱 명이 아닌 아홉 명이었던 것이다.
        //
        //아홉 명의 난쟁이는 모두 자신이 "백설 공주와 일곱 난쟁이"의 주인공이라고 주장했다. 뛰어난 수학적 직관력을 가지고 있던 백설공주는, 다행스럽게도 일곱 난쟁이의 키의 합이 100이 됨을 기억해 냈다.
        //
        //아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시오.
        //
        //입력
        //아홉 개의 줄에 걸쳐 난쟁이들의 키가 주어진다. 주어지는 키는 100을 넘지 않는 자연수이며, 아홉 난쟁이의 키는 모두 다르며, 가능한 정답이 여러 가지인 경우에는 아무거나 출력한다.
        //
        //출력
        //일곱 난쟁이의 키를 오름차순으로 출력한다. 일곱 난쟁이를 찾을 수 없는 경우는 없다.

        //1. 난쟁이들의 키를 입력받아 배열에 저장한다
        //2. 배열을 돌며 키의 합을 계산하며 차례로 다른 배열에 저장한다.
        //3. 100이 될 때 반복문을 탈출한다.
        //3. 배열을 오름차순으로 정렬한다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Integer> height = new ArrayList<>();
        int totalHeight = 0;
        for(int i = 0; i < 9; i++){
            height.add(Integer.parseInt(br.readLine()));
        }


        for(int x = 0; x < 9; x++){
            totalHeight += height.get(x);
        }
        int temp;
        temp = totalHeight;
        int i = 0;
        int j = 0;
            for(i = 0; i < 8; i++){
                for(j = i + 1; j < 9; j++){
                    totalHeight = temp;
                    totalHeight -= (height.get(i) + height.get(j));
                    if(totalHeight == 100) {
                        height.remove(i);
                        height.add(i, 0);
                        height.remove(j);
                        height.add(j, 0);
                        break;
                    }
                }
                if(totalHeight == 100) break;
            }
        Collections.sort(height);

        for(int q = 2; q < 9; q++){
            bw.write(height.get(q) + "\n");
        }

        bw.flush();

    }
}

