package Boff;

public class BoffIter {
    public static int numbers(int N, int START, int STOP){
        int boffs = 0;
        for(int i = START;i<STOP+1;i++){
            if(N<10){
                if(i%N == 0 || i%10 == N){
                    boffs = boffs+1;
                }
            } else {
                if(i%N == 0 || i%100 == N){
                    boffs = boffs+1;
                }
            }
        }
        return boffs;
    }
}
