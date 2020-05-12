/*package whatever //do not write package name here */

import java.util.*;

class GFG {
	public static void main (String[] args) {
		Solution so=new Solution();
    for(int i=0;i<=10001;i++){
      System.out.println(so.solution(i))
    }

	}
}

public class Solution{
//   // Creating obj of Sieve class
public static ArrayList<Integer> primes;
  Solution(){
    Sieve si=new Sieve();
    primes=si.SieveOfEratosthenes();
  }
  public static String solution(int n){

    int indexCounts[]=new int[5];
    indexCounts[0]=4;
    indexCounts[1]=46;
    indexCounts[2]=475;
    indexCounts[3]=4719;
    indexCounts[4]=10009;

    int countBefore[]=new int[5];
    countBefore[0]=4;
    countBefore[1]=25;
    countBefore[2]=168;
    countBefore[3]=1229;
    countBefore[4]=2287;

    int i;
    for(i=0;i<5;i++){
      if(n<indexCounts[i]){
        break;
      }
    }
    if(n<4){
        String s="";
        if(n==0){
            s="23571";
        }
        else if(n==1){
            s="35711";
        }
        else if(n==2){
            s="57111";
        }
        else{
            s="71113";
        }
        return s;
    }
    else{
      int diff=(n-indexCounts[i-1])/(i+1);
      int left=(n-indexCounts[i-1])%(i+1);
      int nth_prime=countBefore[i-1]+diff;
      int total_curr_dig=((i+1)-(left+1))+1;
      int left_digits=5-total_curr_dig;
      int leftNumbersInSeries=countBefore[i]-(countBefore[i-1]+(diff+1));
      int howManyMoreNumbers=0;
      if((leftNumbersInSeries*(i+1))<left_digits){
          howManyMoreNumbers=leftNumbersInSeries+(int)(Math.ceil((double)(left_digits-(leftNumbersInSeries*(i+1)))/(double)(i+2)));
      }
      else{
          howManyMoreNumbers=(int)(Math.ceil((double)(left_digits/(double)(i+1))));
      }

      String s="";
      //int cpy=nth_prime;
      for(i=0;i<=howManyMoreNumbers;i++){
        s+=String.valueOf(primes.get(nth_prime));
        nth_prime+=1;
      }

      s=s.substring(left,(left+5));
      return s;
    }
  }

//   // Sieve
//   public static ArrayList<Integer> SieveOfEratosthenes()
//     {
//       int MAX_SIZE = 1000005;
//       ArrayList<Integer> primes=new ArrayList<> ();

//         boolean [] IsPrime = new boolean[MAX_SIZE];

//         for(int i = 0; i < MAX_SIZE; i++)
//             IsPrime[i] = true;

//         for (int p = 2; p * p < MAX_SIZE; p++)
//         {
//             if (IsPrime[p] == true)
//             {for (int i = p * p; i < MAX_SIZE; i += p)
//                     IsPrime[i] = false;
//             }
//         }

//         for (int p = 2; p < MAX_SIZE; p++)
//         if (IsPrime[p] == true)
//                 primes.add(p);
//         return primes;
//     }
}

// For one time finding array of primes
class Sieve{
  public static ArrayList<Integer> SieveOfEratosthenes()
  {
    int MAX_SIZE = 1000005;
    ArrayList<Integer> primes=new ArrayList<> ();

      boolean [] IsPrime = new boolean[MAX_SIZE];

      for(int i = 0; i < MAX_SIZE; i++)
          IsPrime[i] = true;

      for (int p = 2; p * p < MAX_SIZE; p++)
      {
          if (IsPrime[p] == true)
          {for (int i = p * p; i < MAX_SIZE; i += p)
                  IsPrime[i] = false;
          }
      }

      for (int p = 2; p < MAX_SIZE; p++)
      if (IsPrime[p] == true)
              primes.add(p);
      return primes;
  }
}
