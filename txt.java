package ds_finalproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

import javax.swing.JTextArea;

import ds_finalproject.BinarySearchTree.Node;

public class txt {
	 static String arr[]=null;static String h="";static String f="";
	 String str; static String text="";static String stri=""; static String o="";
	 static StringBuilder b=null;
static ArrayList<bstnode>  Node=new ArrayList<bstnode>();
 static  PriorityQueue<bstnode> pq = new PriorityQueue<>(Comparator.comparingInt(l ->l.valu) );


	public static void main(String[] args) throws IOException
	{ 
		String sss="";
		   BufferedReader r=null;
				 try { 
				 FileReader s=new FileReader("s.txt"  );
				  r=new BufferedReader(s);
					String line;
					String st="";
					while((line=r.readLine())!=null) {
						//it read all line and put it into null string
					st=st+line;
				//	 st+="\n";
			   
				} 
				 
					 
				
		 	  //store content of main file
					 	  text=st;
				
					 for(int j=0 ;j<st.length();j++) {
						  char c=st.charAt(j);
						    	 int n=(int)c;
						    	 if((n>=97&&n<=122)||n==32) {
						    	 //System.out.print 
						    		   sss =(st.charAt(j)+"=>"+	freq (st.charAt(j),st)+"   ");
						              // sss+="\n";
						    
						    
						    String array[]= sss.split("   ");
							    
							  System.out.println(array[0] );
							   arr =array[0].split("=>");
							//     h+=arr[0];
							 
							  h+=arr [0];   f+=arr[1];
							  
							 
							 // System.out.println(h+f);
						    bstnode node=new bstnode(Integer.parseInt(f), h);
						      Node.add(node);
						      pq.add(node);
						 
						      
						      h="";f="";
						      
						  //store freq of word in file
						    
						     try { 
		 				 FileWriter f=new FileWriter("s.cmp" ,true );
		 			 
		 			   f.write  (  sss);
		 				  
		 				  
		 				 f.close(); }
		 				   
		  					 catch (IOException e1) {
		 				     
		 				      e1.printStackTrace();
		 				    }  
						     
						    
						    
						    
						     
						 	
						    
						    
						    
						    
				    
						    
					   String str=Character.toString(c );
						//  System.out.print("*"+st);
						   st=st.replaceAll (str,"+");
						 // System.out.print(s);
						 
						    
						     System.out.println("\n"); }
						      }
					 
					
					
						 
				 }
				 
				 
					 catch (IOException e) {
				     
				      e.printStackTrace();
				    } 
					
					
			 
					
				 for(int j=0;j<Node.size();j++) {
						 
							 System.out.println(Node.get(j));	}
				
				 
			 
				System.out.println( pq.toString() );
				 
			 	 while(pq.size()!=1) {
			 		 
				 bstnode left =pq.poll(); 
				 // System.out.println(left);
				 bstnode right =pq.poll();
				   System.out.println(right);
				   //System.out.println(right);
				   System.out.println(pq.toString());
				int sum=left.valu+right.valu;
				
				//pq.add(new bstnode(sum,left.getC()+right.getC()));
				pq.add(new bstnode(null,sum,left,right));
				System.out.println(pq.toString());
				}
			 		 
				 
			 	 
			 	bstnode root=pq.peek(); 
			 	//print tree diagram
			 	print("",root,false);
			 	//map for storing huffman coding
			 	Map<String, String> huffmanCode = new HashMap<>();
			 	encode(root, " ", huffmanCode);
			 	
			 	
			 	 
			 	  
			 	 System.out.println("codes of word:"+huffmanCode);
			 	
			 	  System.out.println("content of file:"+text);
			 	 
			 	 
			 	 
			 	 	StringBuilder sb = new StringBuilder();
			 		for (char ch: text.toCharArray()) {
			 			stri=Character.toString(ch);
			 		 sb.append(huffmanCode.get(stri));// System.out.println(sb);
			 		}

			 		
			 		
			 		  String array[] = (sb.toString()).split(" ");
			 	      
			 	      String  result = "";
			 	      for(int i=0; i<array.length; i++) {
			 	         result+=array[i];
			 	      }
			 		
			 		
			 		System.out.println("encoded string  : " + result);
			 		
			 		
			 		
			 		 try { 
		 				 FileWriter f=new FileWriter("s.cmp" ,true );
		 			 
		 			   f.write  (" \n");
		 				f.write(result);  
		 				  
		 				   f.close();
		 				    } 
		  					 catch (IOException e1) {
		 				     
		 				      e1.printStackTrace();
		 				    }	 
			 		
			 		
			 		
			 		
			 		System.out.print("decoded string:");
			 		
			 		
			 		
			 		
			 		if (isLeaf(root)) {
			 			 // Special case: For input like a, aa, aaa, etc.
			 			 while (root.valu-- > 0) {
			 			     System.out.print(root.c );
			 			 }
			 			}
			 			else {
			 			 // Traverse the Huffman Tree again and this time,
			 			 // decode the encoded string
			 			 int index = -1;
			 			 while (index < result.length() - 1) {
			 				 
			 			     index = decode( result, index, root );
			 			   
			 			 }  
			 			
			 			 
			 			}
			 		 
			 		
			 		
			 		
			 		 
			 		
			 		
			 		// System.out.print(Node.toString());
			 		
			 		
			 		
			 		
			 		
			 		
			 		
			 		
			 		
			 		
	 }
	 
	
		static  int freq(char c,String str) {
							int f=0;
							for(int i=0 ;i<str.length();i++) {
								if(str.charAt(i)==c) {
									f++;
								}
							}
							
			 				return f;
							
						}	
							
			
		
		 public  static void encode(bstnode root, String str,
	             Map<String, String> huffmanCode)
	{
	if (root == null) {
	 return;
	}

	// Found a leaf node
	if (isLeaf(root)) {
	 huffmanCode.put(root.c, str.length() > 0 ? str : "1");
	}

	encode(root.left, str + '0', huffmanCode);
	encode(root.right, str + '1', huffmanCode);}
		 
		 
		public static int decode( String  sb,int index,bstnode root ) {
			
			 
			if (root == null) {
				 return index;
				}

				// Found a leaf node
				if (isLeaf(root)) {
				 System.out.print(root.c );
				  try { 
	 				 FileWriter f=new FileWriter("s.txt" ,true );
	 			 
	 			   f.write  (" \n");
	 				f.write(root.c);  
	 				  
	 				   f.close();
	 				    } 
	  					 catch (IOException e1) {
	 				     
	 				      e1.printStackTrace();
	 				    }	 
				 
				 
				 
				 
				 //text(s,root.c,r);
				 return index;
				}

				index++;

				root = (sb.charAt(index) == '0') ? root.left : root.right;
				index = decode( sb, index,root  );
				return index;
			
			
			
			
			
			
		}
		 
	
			
		 		
		 
		
		  public static void print(String prefix,bstnode n, boolean isLeft) {
			    if (n != null) {
			        print(prefix + "     ", n.right, false);
			        System.out.println (prefix + ("|-- ") + n.c+n.valu);
			        print(prefix + "     ", n.left, true);
			    }
			}
		
		
		
		
		
		
		
		
		
		
	 
		 public static boolean isLeaf(bstnode root) {
			 return root.left == null && root.right == null;
			 }

	 
	}
