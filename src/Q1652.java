import java.io.*;

public class Q1652 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());    //N 입력받기
        String[][] room = new String[n][n]; //nxn 배열 생성
        String str; //.과 X를 저장할 변수 생성

        for(int i = 0; i < n; i++){
            str = br.readLine();
            for(int j = 0; j < n; j++){
                room[i][j] = String.valueOf(str.charAt(j)); //str을 한 문자씩 순서대로 배열에 담는다.
            }
        }

        int countGaro = 0;  //.의 개수를 저장할 가로 변수
        int sleepGaro = 0;  //가로에서 누울 수 있는 자리 수를 저장할 변수

        for(int i = 0; i < n; i++){ //가로
            for(int j = 0; j < n; j++){
                if(room[i][j].equals(".")) {
                    countGaro++;
                }else if(room[i][j].equals("X")){
                    if(countGaro >= 2){
                        sleepGaro++;
                    }
                    countGaro = 0;
                }
            }
            if(countGaro >= 2){
                sleepGaro++;
                countGaro = 0;
            }
            countGaro = 0;
        }

        int countSero = 0;
        int sleepSero = 0;

        for(int i = 0; i < n; i++){ //세로
            for(int j = 0; j < n; j++){
                if(room[j][i].equals(".")){
                    countSero++;
                }else if(room[j][i].equals("X")){
                    if(countSero >= 2){
                        sleepSero++;
                    }
                    countSero = 0;
                }
            }
            if(countSero >= 2) {
                sleepSero++;
                countSero = 0;
            }
            countSero = 0;
        }

        bw.write(String.valueOf(sleepGaro)+ " " + String.valueOf(sleepSero));
        bw.flush();

    }
}
