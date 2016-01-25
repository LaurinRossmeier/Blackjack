package Game;

import java.util.ArrayList;

public abstract class DealerPlayer {
	
	private String name;
	
	public DealerPlayer() {
		name = "Dealer";
	}
	
	public DealerPlayer(String name) {
		this.name = name;
	}
	
	public DealerPlayer(String name, int credit) {
		
	}
	
	public String getName() {
		return name;
	}
	
	public abstract int getBetC();
	
	public abstract int getCredit();

	public abstract void setCredit(int credit);
	
	
	public abstract void setMyCards(int i);

	public abstract ArrayList<Integer> getMyCards();
	
	public String[] cardType(ArrayList<Integer> cards){
		int counter = 0;
		String[] cardType = new String[cards.size()];
		for(Integer i : cards){
			switch (i){
				case 0: cardType[counter] = "Ass";
					break;
				case 1: cardType[counter] = "2";
					break;
				case 2: cardType[counter] = "3";
					break;
				case 3: cardType[counter] = "4";
					break;
				case 4: cardType[counter] = "5";
					break;
				case 5: cardType[counter] = "6";
					break;
				case 6: cardType[counter] = "7";
					break;
				case 7: cardType[counter] = "8";
					break;
				case 8: cardType[counter] = "9";
					break;
				case 9: cardType[counter] = "10";
					break;
			}
			counter ++;
			if (counter > cardType.length)
				counter =0;
		}
		return cardType;
	}
	
	public String toString(){
		return (name); 
	}
}
