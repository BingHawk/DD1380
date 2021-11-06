import java.util.Scanner;

public class BoffMain{
    public static void main(String[] args){
        test();
        final int N;
        final int START;
        final int STOP;
        Scanner in;

        in = new Scanner(System.in);
        N = in.nextInt();
        START = in.nextInt();
        STOP = in.nextInt();

        int output = Boff.BoffIter.numbers(N,START,STOP);
        System.out.println(output);
        in.close();
        
    };

    //for testing the fast solution against the slower correct solution
    public static void test(){
        String print = "all_fail";
        int failure = 0;
        int tested = 0;
        for(int N = 2;N<10;N++){
            for (int START = N; START < N +2;START++){
                for(int STOP = START +1; STOP < N*10;STOP++){
                    int observed = Boff.BoffFast.numbers(N,START,STOP);
                    int expected = Boff.BoffIter.numbers(N,START,STOP);
                    tested = tested +1;
                    if(observed != expected){
                        failure = failure +1;
                        if(print == "all_fail"){
                            System.out.println("Failure detected for: N = "+N+", START = "+START+", STOP = "+STOP+".\nExpected: "+expected+" Observed: "+observed);
                        }
                    }
                }
            }
        }

        if(print == "n_fail"){
            System.out.println("Number of errors: "+failure+" Total tested: "+tested);
        }
    }
}