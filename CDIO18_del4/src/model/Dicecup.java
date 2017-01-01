package model;

public class Dicecup {

	private Die die1 = new Die();
	private Die die2 = new Die();

	public int getSum(){
		return die1.getValue() + die2.getValue(); 
	}

	public Die getDie1() {
		return die1;
	}

	public Die getDie2() {
		return die2;
	}
	
	public int roll(){
		die1.roll();
		die2.roll();
		return die1.getValue() + die2.getValue();
	}
}
