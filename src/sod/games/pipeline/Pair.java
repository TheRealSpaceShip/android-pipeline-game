package sod.games.pipeline;

public class Pair < A, B > {
	private A first;
	private B second;
	
	public Pair (A a_, B b_)
	{
		first = a_;
		second = b_;
	}

	public A getFirst(){
		return first;
	}
	
	public B getSecond(){
		return second;
	}
	
	public void setFirst( A in_){
		first = in_;
	}
	
	public void setSecond(B in_){
		second = in_;
	}
	

}
