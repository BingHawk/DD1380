public class Boff{
    public static void main(String[] args){
        final int N = 7;
        final int START = 11;
        final int STOP = 99; //TODO: Take N, START and STOP as dynamic input
        int output = numbers(N,START,STOP);
        System.out.println(output);
    };

    public static int numbers(int N, int START, int STOP){
        // Let O be all numbers from START to STOP.
        // Searching for the size of the Union (S) of multiples (M) and endDigits (E) where:
        // Multiples are numbers in O that are devisible by N and,
        // endDigits are numbers that end with the digits in N. 
        // Union = E + M - E^M where E^M is the numbers that are both in E and M. 

        int multiples; //Number of numbers in the interval that are a multiple of N
        
        //moving the starting index to the first multiple. 
        int multiplesStart = START;
        while(multiplesStart%N != 0){
            multiplesStart = multiplesStart +1;
        }
        //Calculating number of multiples. since multiplesStart is the first multiple number, 
        //if the total number of digits is not devisible by N, there is exactly one more multiple than is given by division. 
        //multiples = (int) Math.ceil((STOP-multiplesStart)/N);
        if((STOP-multiplesStart)%N == 0){
            multiples = (STOP-multiplesStart)/N;
        } else {
            multiples = (STOP-multiplesStart)/N + 1;
        }

        int endDigits;
        float freq;
        int same; //number of numbers that are both divisible by N and end in N. 
        if(N < 10){
            
            //moving the starting index to the first number ending in N. 
            int endStart = START;
            while(endStart%10 != N){
                endStart = endStart +1;
            }
            //endDigits = (int) Math.ceil((STOP - endStart)/10); //Number of numbers in the interval that ends with N if N is one digit
            if((STOP-endStart)%10 == 0){
                endDigits = (STOP-endStart)/10;
            } else {
                endDigits = (STOP-endStart)/10 + 1;
            }


            //deviding into cases based on Largest common denominator of N with 10
            if(N%2 == 0){
                freq = (2/(N*10)); //Frequency of numbers that are both divisible by N and end in N. 
            } else if(N%5 == 0) {
                freq = (5/(N*10));
            } else {
                freq = (1/(N*10));
            };

            //moving the starting index to the first number that's both ending in N and is devisible by N. 
            int sameStart = START;
            while(sameStart%N != 0 || sameStart%10 != N){
                sameStart = sameStart + 1;
                System.out.println(sameStart);
            };
            same = (int) Math.ceil(freq * (STOP - sameStart)); 

            if(freq * (STOP - sameStart)%1 == 0.0){
                same = (int) freq * (STOP - sameStart);
            } else {
                same = (int) freq * (STOP - sameStart) + 1;
            }

        } else {

            //moving the starting index to the first number ending in N. 
            int endStart = START;
            while(endStart%100 != N){
                endStart = endStart +1;
            };

            //endDigits = (int) Math.ceil((STOP - endStart)/100); //Number of numbers in the interval that ends with N if N is two digits
            if((STOP-endStart)%100 == 0){
                endDigits = (STOP-endStart)/100;
            } else {
                endDigits = (STOP-endStart)/100 + 1;
            }
            //deviding into cases based on Largest common denominator of N with 100
            if(N%2 == 0){
                freq = (2/(N*100)); //Number of digits that are both divisable by N and end in N
            } else if (N%4 == 0){
                freq = (4/(N*100));
            } else if(N%5 == 0){
                freq = (5/(N*100));
            } else if(N%10 == 0){
                freq = (10/(N*100));
            } else if(N%20 == 0){
                freq = (20/(N*100));
            } else if(N%25 == 0){
                freq = (25/(N*100));
            } else if(N%50 == 0){
                freq = (50/(N*100));
            } else {
                freq = (1/(N*100));
            };
        
            //moving the starting index to the first number that's both ending in N and is devisible by N. 
            int sameStart = START;
            while(sameStart%N != 0 || sameStart%100 != N){
                sameStart = sameStart + 1;
            };
            same = (int) Math.ceil(freq * (STOP - sameStart));   
        };     
        System.out.println(multiples);
        System.out.println(endDigits);
        System.out.println(same);
        return multiples + endDigits - same; 
    };

    public static int findSCP(int x, int y){
        return 0;
    };
}