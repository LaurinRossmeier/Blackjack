package Game;

import java.util.Random;

public class Cards {

	private int[] cards;

	public Cards(int[] cards){
		this.cards = cards;
		fillArray(cards);
		getRank(cards);
	}
	
	public int[] getCards() {
		return cards;
	}
	
	public void fillArray(int[] cards){	// Befüllt den Array
		for (int i = 0; i < cards.length; i++ )
			cards[i] = i;
	}

	public void getRank(int[] cards) {	//Setzt alle zahlen von 9 -13 auf 9.
		for (int i =0; i < cards.length; i++){
			if (i%13 >=9)
				cards[i] = 9;
			else
				cards[i] = i%13;
		}
	}

	public void mixArray () {	//Mischelt den Array.
		Random rand = new Random(); 
		for (int i = 0; i < cards.length; i++) {
			int randNumber = rand.nextInt(cards.length);
			int sNumber = cards[i]; 
			cards[i] = cards[randNumber];
			cards[randNumber] = sNumber; 
		} 
	}  

}
