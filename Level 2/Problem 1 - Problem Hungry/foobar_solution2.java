/*package whatever //do not write package name here */

import java.util.Arrays;

class GFG {
	public static void main (String[] args) {
		Solution so=new Solution();
		System.out.println(so.solution(new int[] {2, 0, 2, 2, 0}));
		System.out.println(so.solution(new int[] {-2, -3, 4, -5}));
		System.out.println(so.solution(new int[] {0, 0, 0, 2, 0}));
		System.out.println(so.solution(new int[] {0,-2,0,0}));
		System.out.println(so.solution(new int[] {-6,-1,-2,-3,-5}));
		System.out.println(so.solution(new int[] {5,-1,-2,6}));

    // for(int i=0;i<=10001;i++){
    //   System.out.println(so.solution(i))
    // }

	}
}

class Solution{
	public static String solution(int[] xs){
		Arrays.sort(xs);
		String s="";
		long sum=1;
		int last_ind=-1;
		int zero=0,gr=0,i=0;
		for(i=0;i<xs.length;i++){
			if(xs[i]>0){
				gr+=1;
				sum*=xs[i];
			}
			else if(xs[i]<0){
				last_ind=i;
			}
			else if(xs[i]==0){
				zero+=1;
			}
		}
		//System.out.println(sum);
		if(zero==xs.length){
			sum=0;
		}
		else if(xs.length==1){
				sum=xs[0];
			}
		else if(last_ind!=-1)
		{
			if(gr==0 && zero>=1 && (last_ind==0||last_ind==-1)){
				sum=0;
			}
			else{


					int tillWhere=last_ind%2==0?1:0;
					//System.out.println(tillWhere+" "+last_ind);
					for(i=0;i<=last_ind-tillWhere;i++){
						//System.out.println(xs[i]);
						sum*=xs[i];
					}

			}
		}
		//System.out.println(sum);
		s=String.valueOf(sum);
		return s;
	}
}
