package ds_finalproject;

import java.util.ArrayList;

 
 

public class bstnode {
	ArrayList<bstnode>  Node=new ArrayList<bstnode>();
	 
 
	bstnode left,right;
	int valu;
	String c;
	
	public bstnode(  int valu, String c) {
		super();
		 
		this.valu = valu;
		this.c =c;
	}
	
	
	 public bstnode(String c , int valu, bstnode left, bstnode right) {
	        this.c  = c ;
	        this.valu = valu;
	        this.left = left;
	        this.right = right;
	    }
	
	
//	public bstnode(String c,int valu) {
	 
	//	this.valu = valu;
	//}
	public int getValu() {
		return valu;
	}
	public void setValu(int valu) {
		this.valu = valu;
	}
	public String getC() {
		return c;
	}
	public void setC(String c) {
		this.c = c;
	}
	
	
	public String toString() {
		return c+","+valu ;
	}	
	
	 
	
	
}
