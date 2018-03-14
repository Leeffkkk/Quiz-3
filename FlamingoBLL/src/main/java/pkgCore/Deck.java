package pkgCore;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;

import pkgEnum.eRank;
import pkgEnum.eSuit;

public class Deck {

	
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	Deck(ArrayList<Card> cards) {
		this.cards = cards;
	}
	
	public Deck() {
		BuildDeck(1);
	}
	public Deck(int a) {
		BuildDeck(a);
	}
	public void BuildDeck(int a) {
		do {
			for (eSuit suit : eSuit.values()) {
				for (eRank rank : eRank.values()) {
					cards.add(new Card(suit, rank));
				}
			}
			a--;
		} while (a > 0);
		Collections.shuffle(cards);
	}
	
	public int getSize() {
		return this.cards.size();
	}
	public ArrayList<Card> getDeck() {
		return this.cards;
	}
	
	public Card draw() {
		return this.cards.remove(0);
	}
	
	public int getRemaining(Object eNum) {
		int count = 0;
		
		if (eNum instanceof eRank) {
			for (Card card : cards) {
				if (card.geteRank() == eNum)
					count++;
			}
		}
		else if (eNum instanceof eSuit) {
			for (Card card : cards) {
				if (card.geteSuit() == eNum)
					count++;
			}
		}
		
		return count;
	}
}





