/*package whatever //do not write package name here */

import java.util.TreeMap;
import java.util.Map;

class GFG {
	public static void main (String[] args) {
		Solution so=new Solution();
		String s[]=so.solution(new String[] {"1.11", "2.0.0", "1.2", "2", "0.1", "1.2.1", "1.1.1", "2.0"});
		String s1[]=so.solution(new String[] {"1.1.2", "1.0", "1.3.3", "1.0.12", "1.0.2"});
		String s2[]=so.solution(new String[] {"1.1.2", "1.0", "1.3.3", "1.0.12", "1.0.2"});
		String s3[]=so.solution(new String[] {"1", "1.0", "1.0.0"});
		String s4[]=so.solution(new String[] {"1.1.1", "1.1.2", "1.2.0"});
		String s5[]=so.solution(new String[] {"0.1", "0.5", "0.9.2"});
		String s6[]=so.solution(new String[] {"1", "5", "1"});
		String s7[]=so.solution(new String[] {"1"});
    // for(int i=0;i<=10001;i++){
    //   System.out.println(so.solution(i))
    // }
		for(int i=0;i<s.length;i++){
			System.out.print(s[i]+" ");
		}
		System.out.println();

		for(int i=0;i<s1.length;i++){
			System.out.print(s1[i]+" ");
		}
		System.out.println();

		for(int i=0;i<s2.length;i++){
			System.out.print(s2[i]+" ");
		}
		System.out.println();

		for(int i=0;i<s3.length;i++){
			System.out.print(s3[i]+" ");
		}
		System.out.println();
		for(int i=0;i<s4.length;i++){
			System.out.print(s4[i]+" ");
		}
		System.out.println();
		for(int i=0;i<s5.length;i++){
			System.out.print(s5[i]+" ");
		}
		System.out.println();

		for(int i=0;i<s6.length;i++){
			System.out.print(s6[i]+" ");
		}
		System.out.println();

		for(int i=0;i<s7.length;i++){
			System.out.print(s7[i]+" ");
		}
		System.out.println();

	}
}


class Solution {
	public static String[] solution(String[] l){
		TreeMap<String, Node> tmap=new TreeMap<> ();
		int i;
		String[] final_out=new String[l.length];

		// Pre Computing
		for(i=0;i<l.length;i++){
			if(!tmap.containsKey(String.valueOf(l[i].charAt(0)))){
				tmap.put(String.valueOf(l[i].charAt(0)), null);
			}
		}

		for(i=0;i<l.length;i++){
			Node curr_orig_head=tmap.get(String.valueOf(l[i].charAt(0)));
			if(curr_orig_head==null){
				curr_orig_head=new Node(l[i]);
				tmap.put(String.valueOf(l[i].charAt(0)),curr_orig_head);
				//System.out.println("put "+l[i]);
			}
			else{
				Node cpy_of_head=curr_orig_head;
				Node prev_node=null;
				boolean inserted=false;
				//int getComparison=StringComparator(l[i], cpy_of_head.data);
				//System.out.println(l[i]+" compared with "+cpy_of_head.data+" resulted into "+(getComparison));
				while(cpy_of_head!=null){
					int getComparison=StringComparator(l[i], cpy_of_head.data);
					if(inserted==false && getComparison==1){
						if(prev_node==null){
							Node temp_of_next=cpy_of_head.next;
							Node newNode=new Node(l[i]);
							newNode.next=cpy_of_head;
							cpy_of_head=newNode;
							//cpy_of_head.next=temp_of_next;
							tmap.put(String.valueOf(l[i].charAt(0)),cpy_of_head);
						}
						else{
							Node temp_of_next=prev_node.next;
							Node newNode=new Node(l[i]);
							prev_node.next=newNode;
							newNode.next=temp_of_next;
						}
						inserted=true;
						break;
					}
					prev_node=cpy_of_head;
					cpy_of_head=cpy_of_head.next;
				}

				if(inserted==false){
					prev_node.next=new Node(l[i]);
				}
			}
		}

		int c=0;
		for(Map.Entry<String, Node> entry : tmap.entrySet()){
			Node curr_node=entry.getValue();
			while(curr_node!=null){
				final_out[c]=curr_node.data;
				c+=1;
				curr_node=curr_node.next;
			}
		}
		//System.out.println(tmap);
		//final_out=new String[]{"0.1","1.1.1","1.2","1.2.1","1.11","2","2.0","2.0.0"};
		return final_out;
	}

	public static int StringComparator(String s1, String s2){
			String[] temp1=s1.split("\\.");
			String[] temp2=s2.split("\\.");
			int i=1;

			if(temp1.length==1 && temp2.length>1){
				return 1;
			}
			else if(temp1.length>1 && temp2.length==1){
				return 2;
			}
			else if(temp2.length==1 && temp1.length==1){
				return 0;
			}
			else if(temp1.length==temp2.length){
				//System.out.println("in");
					for(i=1;i<temp1.length;i++){
						if(Integer.valueOf(temp1[i])!=Integer.valueOf(temp2[i])){
							//System.out.println("in1");

							if(Integer.valueOf(temp1[i])>Integer.valueOf(temp2[i])){
								//System.out.println("for "+s1 +" and "+ s2+" "+Integer.valueOf(temp1[i])+" "+Integer.valueOf(temp2[i])+" returning 2");
								return 2;
							}
							else{
								//System.out.println("for "+s1 +" and "+ s2+" "+Integer.valueOf(temp1[i])+" "+Integer.valueOf(temp2[i])+" returning 1");
								return 1;
							}
						}
					}
					//System.out.println("in1.1.1");

					return 0;
			}
			else if(temp1.length!=temp2.length){
				if(Integer.valueOf(temp1[1])>Integer.valueOf(temp2[1])){
					return 2;
				}
				else if(Integer.valueOf(temp1[1])<Integer.valueOf(temp2[1])){
					return 1;
				}
				else{
					if(temp1.length>temp2.length){
						return 2;
					}
					else{
						return 1;
					}
				}
			}
			else return 0;
	}
}

// Linked List Creation
class Node{
	Node next;
	String data;

	Node(String value){
		data=value;
		next=null;
	}
}
