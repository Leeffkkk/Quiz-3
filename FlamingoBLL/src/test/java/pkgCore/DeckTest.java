package pkgCore;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import pkgEnum.eRank;
import pkgEnum.eSuit;

public class DeckTest {

	@Test
	public void TestDeck() {
		
		
		Deck d1 = new Deck();
		assertEquals(d1.getSize(), 52);
		
		Deck d2 = new Deck(6);
		assertEquals(d2.getSize(), 312);
		
		ArrayList<Card> cards = new ArrayList<Card>();
		
		cards.add(new Card(eSuit.CLUBS, eRank.TWO));
		cards.add(new Card(eSuit.HEARTS, eRank.FOUR));
		cards.add(new Card(eSuit.CLUBS, eRank.ACE));
		cards.add(new Card(eSuit.SPADES, eRank.FOUR));
		
		Deck d3 = new Deck(cards);
		
		System.out.println(d3.getSize());
		
		for (Card card : d3.getDeck()) {
			System.out.println(card.geteSuit() + "  " + card.geteRank());
		}
		
		assertEquals(d3.getRemaining(eSuit.HEARTS), 1);
		assertEquals(d3.getRemaining(eRank.FOUR), 2);
	}

}

