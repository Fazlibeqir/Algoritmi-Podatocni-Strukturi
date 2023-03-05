import java.util.Scanner;
public class LDS {
    private static int najdolgaOpagackaSekvenca(int[] a) {
        // Vasiot kod tuka
        int n=a.length;
        int size[]=new int[n];
        for(int i=0;i<n;i++){
            size[i]=1;
        }
        for(int i=0;i<n;i++){
          for(int j=0;j<i;j++){
              if(a[i]<a[j] && size[i]<size[j]+1){
                  size[i]=size[j]+1;
              }
          }
        }
        int max=size[0];
        for(int i=1;i<size.length;i++){
            if(size[i]>max) max=size[i];
        }
        return max;
    }

        public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int n = stdin.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = stdin.nextInt();
        }
        System.out.println(najdolgaOpagackaSekvenca(a));
    }


}
