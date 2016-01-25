package Game;

import java.util.ArrayList;

public class Player extends DealerPlayer{
	private int credit;
	private int betC;
	private ArrayList<Integer> myCards = new ArrayList<Integer>();

	public Player(String name, int credit) {
		super(name,credit);
		this.credit = credit;
	}
	public Player(String name) {
		super(name);
		this.credit = 100;
	}

	public int getBetC() {
		return betC;
	}
	
	public void setBetC(int betC) {
		this.betC = betC;
	}
	
	public ArrayList<Integer> getMyCards() {
		return myCards;
	}

	public void setMyCards(int i) {
		myCards.add(i);
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String toString(){
		String s = "\t Credit: "+credit+"\t My Cards: ";
		for(String i : cardType(myCards)){
			s= s  + i+" ";
		}
		return super.toString() + s;
	}

}
