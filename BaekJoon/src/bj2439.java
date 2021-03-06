import java.io.*;

public class bj2439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=1;i<=n;i++){
            for(int k=0;k<n-i;k++){
                sb.append(" ");
            }
            for(int j=0;j<i;j++){
                sb.append("*");
            }
            sb.append("\n");
        }
        br.close();

        System.out.print(sb);
    }
}