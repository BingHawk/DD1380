package Boff;
public class BoffFast {
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
            if(multiplesStart > STOP+1){
                break;
            }
        }
        //Calculating number of multiples. since multiplesStart is the first multiple number, 
        //if the total number of digits is not devisible by N, there is exactly one more multiple than is given by division. 
        if(multiplesStart < STOP){
            if((STOP-multiplesStart)%N == 0){
                multiples = (STOP-multiplesStart)/N + 1;
            } else {
                multiples = (STOP-multiplesStart)/N + 1;
            }
        } else {
            multiples = 0;
        }


        int endDigits;
        int freqInv;
        int same; //number of numbers that are both divisible by N and end in N. 
        if(N < 10){
            
            //moving the starting index to the first number ending in N. 
            int endStart = START;
            while(endStart%10 != N){
                endStart = endStart +1;
                if(endStart > STOP+1){
                    break;
                }
            }
            //endDigits = (int) Math.ceil((STOP - endStart)/10); //Number of numbers in the interval that ends with N if N is one digit
            if(endStart < STOP){
                if((STOP-endStart)%10 == 0){
                    endDigits = (STOP-endStart)/10 + 1;
                } else {
                    endDigits = (STOP-endStart)/10 + 1;
                }
            } else {
                endDigits = 0;
            }



            //deviding into cases based on Largest common denominator of N with 10
            if(N%2 == 0){
                freqInv = ((N*10)/2); //Inverse frequency of numbers that are both divisible by N and end in N. 
            } else if(N%5 == 0) {
                freqInv = ((N*10)/5);
            } else {
                freqInv = ((N*10));
            };

            //moving the starting index to the first number that's both ending in N and is devisible by N. 
            int sameStart = START;
            while(sameStart%N != 0 || sameStart%10 != N){
                sameStart = sameStart + 1;
                if(sameStart > STOP+1){
                    break;
                }
            };

            if(sameStart<STOP){
                if((STOP - sameStart)%freqInv == 0){
                    same = (STOP - sameStart)/freqInv + 1;
                } else {
                    same = (STOP - sameStart)/freqInv + 1;
                }
            } else {
                same = 0;
            }


        } else {

            //moving the starting index to the first number ending in N. 
            int endStart = START;
            while(endStart%100 != N){
                endStart = endStart +1;
                if(endStart > STOP+1){
                    break;
                }
            };

            //endDigits = (int) Math.ceil((STOP - endStart)/100); //Number of numbers in the interval that ends with N if N is two digits
            if(endStart < STOP){
                if((STOP-endStart)%100 == 0){
                    endDigits = (STOP-endStart)/100 +1;
                } else {
                    endDigits = (STOP-endStart)/100 + 1;
                }
            } else {
                endDigits = 0;
            }

            //deviding into cases based on Largest common denominator of N with 100
            if(N%50 == 0){
                freqInv = ((N*100)/50); //Number of digits that are both divisable by N and end in N
            } else if (N%25 == 0){
                freqInv = ((N*100)/25);
            } else if(N%20 == 0){
                freqInv = ((N*100)/20);
            } else if(N%10 == 0){
                freqInv = ((N*100)/10);
            } else if(N%5 == 0){
                freqInv = ((N*100)/5);
            } else if(N%4 == 0){
                freqInv = ((N*100)/4);
            } else if(N%2 == 0){
                freqInv = ((N*100)/2);
            } else {
                freqInv = ((N*100)/1);
            };
        
            //moving the starting index to the first number that's both ending in N and is devisible by N. 
            int sameStart = START;
            while(sameStart%N != 0 || sameStart%100 != N){
                sameStart = sameStart + 1;
                if(sameStart > STOP+1){
                    break;
                }
            };
            //System.out.println("Same start = "+sameStart);
            if(sameStart < STOP){
                //System.out.println("freqInv used is: "+freqInv);
                if((STOP - sameStart)%freqInv == 0){
                    same = (STOP - sameStart)/freqInv + 1;
                } else {
                    same = (STOP - sameStart)/freqInv + 1;
                }  
            } else {
                same = 0;
            }

        };     
        //System.out.println(multiples + "\n" + endDigits + "\n" + same);
        return multiples + endDigits - same; 
    };
    
}
