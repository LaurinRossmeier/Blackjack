package Game;

import java.util.ArrayList;

public class Dealer extends DealerPlayer{
	private ArrayList<Integer> myCards = new ArrayList<Integer>();

	public void setMyCards(int i) {
		myCards.add(i);
	}
	
	public ArrayList<Integer> getMyCards() {
		return myCards;
	}

	public String toString(){
		String s = "\t My Cards: ";
		for(String i : cardType(myCards)){
			s = s  + i+" ";
		}
		return super.toString() + s;
	}

	@Override
	public int getBetC() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCredit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setCredit(int credit) {
		// TODO Auto-generated method stub
		
	}

}
