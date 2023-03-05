import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bus {

    public static void main(String[] args) throws Exception {
        int i,j,k;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());// prviot e N
        int M = Integer.parseInt(br.readLine());// vtoriot e M
        br.close();
        // Vasiot kod tuka
        //N -adults
        //M -kids
        // plati N i k-1 bileti za M za edno dete(M) ne mora da plati bilet
        //N moze sam da odi , ke plati za N bilet
        int sumNaAdults=0;
        int sumNaKids=0;
        int min=0;
        int max=0;
        for(i=1;i<=N;i++){  // BUS >=1 --> N;
            sumNaAdults+=100;//cena na bilet e 100den.
        }
        for(j=0;j<M-1;j++) {
            sumNaKids+=100;
        }
        if(N>M){
            min=sumNaAdults;
        } else if (N<M) {
            min=sumNaKids+100;
        }
        max=sumNaAdults+sumNaKids;

            //Presmetaj kolkav e min i max broj na denari sto moze da platat patnicite za bileti


        System.out.println(min);//min
        System.out.println(max);//max

    }

}

