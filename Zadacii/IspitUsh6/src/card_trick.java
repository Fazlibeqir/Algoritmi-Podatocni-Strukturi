import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class card_trick {
    public static int count(int N){
        // Vasiot kod tuka
        Queue<Integer> deck = new LinkedList<Integer>();
        Stack<Integer> mix= new Stack<>();
        for (int i = 1; i <= 51; i++) {
            deck.add(i);
        }
        int mixes=0;
        do{
            for(int i=7;i>=1;i--){
                mix.add(deck.poll());
            }
            while (!mix.isEmpty()){
                deck.add(mix.pop());
                deck.add(deck.poll());
            }
            mixes++;
        }while (N != deck.peek());
        return mixes;
    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
        System.out.println(count(Integer.parseInt(br.readLine())));
    }

}
