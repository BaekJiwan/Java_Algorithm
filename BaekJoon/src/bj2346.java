import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class bj2346 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<int[]> deque = new ArrayDeque<int[]>(); //풍선은 번호와 내부에 적힌 수를 가진다.{위치,종이에 적힌 수}
        //이부분을 단순히 링크드리스트로 사용하면 메모리초과 오류가 발생한다...
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); //풍선의 개수 n 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine()," "); //풍선 내부의 수 입력받기
        br.close();

        for(int i=1;i<=n;i++){ // 풍선의 개수만큼 반복, 풍선의 번호와 내부의 종이를 deque에 저장
            deque.offer(new int[]{i,Integer.parseInt(st.nextToken())});
        }

        int temp = deque.pollFirst()[1]; //맨 앞 풍선을 터뜨리고 종이의 수를 temp에 초기화
        bw.write(1+" "); //터진 풍선의 번호를 sb에 저장
        while(!deque.isEmpty()){
            if(temp>0){ //종이의 수가 양수라면 맨앞의 요소를 맨뒤로 보내면서 터트릴 풍선을 제일 앞에 위치시키기
                for(int i=1;i<temp;i++){
                    deque.offerLast(deque.pollFirst());
                }
                bw.write(deque.peekFirst()[0]+" ");
                temp = deque.pollFirst()[1]; // 터진 풍선을 제거하면서 내부에 적힌 종이의 수를 가져오기
            } else{ // 종이의 수가 음수라면 맨뒤의 요소를 맨앞으로 보내면서 터트릴 풍선을 제일 뒤에 위치시키기
                for(int i=1;i<-temp;i++){
                    deque.offerFirst(deque.pollLast());
                }
                bw.write(deque.peekLast()[0]+" ");
                temp = deque.pollLast()[1];// 터진 풍선을 제거하면서 내부에 적힌 종이의 수를 가져오기
            }
        }
        bw.flush();
        bw.close();
    }
}
