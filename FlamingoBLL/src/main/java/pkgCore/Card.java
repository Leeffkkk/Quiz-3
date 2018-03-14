package pkgCore;
import pkgEnum.*;
public class Card implements Comparable {

	
	private eSuit eSuit;
	private eRank eRank;
	
	
	
	public Card(eSuit suit, eRank rank) {
		this.eSuit = suit;
		this.eRank = rank;
	}
	public Card(eRank rank, eSuit suit) {
		this.eSuit = suit;
		this.eRank = rank;
	}
	
	
	
	public eSuit geteSuit() {
		return eSuit;
	}

	public eRank geteRank() {
		return eRank;
	}
	
	private void seteSuit(eSuit eSuit) {
		this.eSuit = eSuit;
	}

	private void seteRank(eRank eRank) {
		this.eRank = eRank;
	}
	
	


	@Override
	public int compareTo(Object o) {
		Card c = (Card) o;
		return c.geteRank().getiRankNbr() - this.geteRank().getiRankNbr();
	}


	
}
