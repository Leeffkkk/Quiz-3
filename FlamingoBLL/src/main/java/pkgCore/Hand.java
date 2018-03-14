package pkgCore;

import java.util.ArrayList;
import java.util.Collections;

import pkgEnum.eRank;

public class Hand {

	private int iScore;
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	public Hand()
	{
		
	}
	
	public int[] ScoreHand()
	{
		int [] iScore = new int[2];
		
		iScore[0] = 0;
		
		Collections.sort(cards);
		
		boolean isA = false;
		for (Card c: cards)
		{
			
			iScore[0] = iScore[0] + c.geteRank().getiRankNbr();
			
			if (c.geteRank() == eRank.ACE) {
				isA = true;
			}
		}
		if(isA && iScore[0] + 10 <= 21){
			iScore[1] = iScore[0] + 10;
		}
		
		return iScore;
	}
	
	public void Draw(Deck d)
	{
		
		cards.add(d.draw());
	}
	
	private void AddCard(Card c)
	{
		cards.add(c);
	}
	
}
