import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import Game.*;

public class TestGame {
	public static void main(String[] args) {
		ArrayList<DealerPlayer> dplayer = new ArrayList<DealerPlayer>();
		int decks = 6;
		int[] cardDeck = new int[52*decks];
		int counter = 0;
		int round = 1;
		Cards cards = new Cards(cardDeck);
		boolean gameBool = false;

		initializePlayer(dplayer);

		while(gameBool == false){
			cards.mixArray();
			bet(dplayer);
			setPlayerCards(dplayer, cards.getCards(),counter, round);
			getWinner(dplayer);
			printData(dplayer);

			System.out.println("");
			System.out.println("New Round? (y/n)");
			if (GetInput().equals("n"))
				gameBool = true;
		}
	}

	//Setzt den Einsatz des Spielers und Lässt nicht zu, dass ein höherer Einsatz als Credits eingesetzt werden.
	public static void bet(ArrayList<DealerPlayer> dplayer){
		for (DealerPlayer dp : dplayer){
			boolean bool = false;
			while (bool == false){
				if (dp instanceof Player){
					System.out.print(dp.getName() +" Bet: ");
					int i = Integer.parseInt(GetInput());
					if(i <= dp.getCredit()){
						((Player) dp).setBetC(i);
						bool = true;
					}
					else
						System.out.println("Error!");
				}
				else 
					break;
			}
		}
	}

	//Gibt aus wer Gewonnen hat und wer Verloren. Setzt außerdem die neu Creditsanzahl.
	public static void getWinner(ArrayList<DealerPlayer> player){
		Value value = new Value();
		value.wins(player);
		value.loses(player);
		value.pushes(player);
	}

	//Erzeugt Spieler und speichert sie in ArrayList.
	public static void initializePlayer(ArrayList<DealerPlayer> player){
		boolean set = false;

		player.add(new Dealer());
		while (set == false){
			System.out.print("Set Players Name: ");
			player.add(new Player(GetInput()));
			System.out.println("Set one more Plyer? (y/n)");
			String input = GetInput();
			if(input.equals("n") || player.size() >= 8)
				set = true;
		}
	}

	//Setzt Karten Für jeden spieler.
	public static void setPlayerCards(ArrayList<DealerPlayer> dplayer,  int[] cardDeck,int counter, int round){
		int playerCount = 0;
		Value value = new Value();
		boolean gameBool = false;

		for (DealerPlayer dp : dplayer)
			dp.getMyCards().clear();			//Setzt Karten zurück.

		while (gameBool == false){
			for (DealerPlayer dp : dplayer){
				if(2*dplayer.size() > counter){
					for(int i = 0; i <= 1; i++){
						dp.setMyCards(cardDeck[counter]);
						counter ++;
					}
				}
				
				if(round >= 2 && value.getValue(dp.getMyCards()) < 21 && dp instanceof Player || value.getAss(dp.getMyCards())){	//Fragt nach noch einer Karte aber erst ab runde 2 und nur wenn der aktuelle Karten wert 21 nicht überschreitet.
					System.out.println(dp.getName() +" One more Card? (y/n)");
					String input = GetInput();
					if (input.equals("y")){
						dp.setMyCards(cardDeck[counter]);
						counter ++;
					}
					if(input.equals("n") || value.getValue(dp.getMyCards()) >= 21){
						playerCount ++;
					}
				}
				if(playerCount == dplayer.size()-1 && dp instanceof Dealer){
					while(value.getValue(dp.getMyCards()) <=16){
						dp.setMyCards(cardDeck[counter]);
						counter ++;
					}
				}
			}

			printData(dplayer);
			System.out.println("");
			if (playerCount == dplayer.size()-1){
				gameBool = true;
			}
			round ++;
		}
	}

	//Giebt Aktuelle Credits anzahl, Name und Karten aus.
	public static void printData(ArrayList<DealerPlayer> dplayer){
		System.out.println("=========================================");
		for(DealerPlayer dp : dplayer)
			System.out.println(dp);
		System.out.println("=========================================");
	}

	public static String GetInput() {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		try {
			return br.readLine();
		} catch (IOException e) {
			e.printStackTrace();

		}
		return null;
	}
}
