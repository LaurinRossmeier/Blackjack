package Game;

import java.util.ArrayList;

public class Value {

	public int getValue(ArrayList<Integer> cards){
		int j = 0;
		for (int i: cards){
			if(i == 0){
				if(j+11 > 21)
					j=j+1;
				else
					j = j + 11;
			}
			else
				j = j+i +1;
		}
		return j;
	}
	
	public boolean getAss(ArrayList<Integer> cards){
		boolean bool = false;
		for (int i: cards){
			if(i==0)
				bool = true;
		}
		
		return bool;
	}

	public boolean getBlackJack(ArrayList<Integer> cards){
		if(getValue(cards) == 21)
			return true;
		else
			return false;
	}

	public void wins(ArrayList<DealerPlayer> player){
		for (DealerPlayer dp : player)
			if(dp instanceof Player && getValue(dp.getMyCards()) > getValue(player.get(0).getMyCards()) && 
					getValue(dp.getMyCards()) < 22 || dp instanceof Player &&  
					getValue(player.get(0).getMyCards()) > 21 && getValue(dp.getMyCards()) < 21){
				System.out.println(dp.getName()+" Win!");
				if(getBlackJack(dp.getMyCards()))
					dp.setCredit((int) (dp.getCredit() + dp.getBetC()*1.5));
				else
					dp.setCredit(dp.getCredit() + dp.getBetC());
			}
	}

	public void loses(ArrayList<DealerPlayer> player){
		for (DealerPlayer dp : player)
			if(dp instanceof Player && getValue(dp.getMyCards()) < getValue(player.get(0).getMyCards()) || 
					dp instanceof Player && getValue(dp.getMyCards()) > 21){
				System.out.println(dp.getName()+" Lose!");
				dp.setCredit(dp.getCredit() - dp.getBetC());
			}
	}

	public void pushes(ArrayList<DealerPlayer> player){
		for (DealerPlayer dp : player)
			if(dp instanceof Player && getValue(dp.getMyCards()) == getValue(player.get(0).getMyCards())){
				System.out.println(dp.getName()+" Push!");
			}
	}
}
