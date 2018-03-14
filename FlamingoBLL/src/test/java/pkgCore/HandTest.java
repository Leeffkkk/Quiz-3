package pkgCore;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.Test;

import pkgEnum.eRank;
import pkgEnum.eSuit;

public class HandTest {

	public int[] HandHelper(ArrayList<Card> cards) {

		int[] result = null;

		try {
			
			
			Class<?> c = Class.forName("pkgCore.Hand");

			
			Class[] cArgsAddCard = new Class[1];
			cArgsAddCard[0] = pkgCore.Card.class;

			
			Object inst = c.newInstance();

			
			Method mAddCard = c.getDeclaredMethod("AddCard", cArgsAddCard);
			
			
			mAddCard.setAccessible(true);
			
			
			for (Card card: cards)
			{
				mAddCard.invoke(inst, card);
			}
			
			
			Method mScore = c.getDeclaredMethod("ScoreHand", null);
			
			
			result = (int[]) mScore.invoke(inst, null);

			
			for (int i : result) {
				System.out.println(i);
			}

		} catch (ClassNotFoundException x) {
			x.printStackTrace();
		} catch (IllegalAccessException x) {
			x.printStackTrace();
		} catch (NoSuchMethodException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			
			e.printStackTrace();
		} catch (InstantiationException e) {
			
			e.printStackTrace();
		}

		return result;
	}

	@Test
	public void test1() {
		
		

		ArrayList<Card> cards = new ArrayList<Card>();
		
		
		
		cards.add(new Card(eSuit.CLUBS,eRank.TWO));
		cards.add(new Card(eSuit.CLUBS,eRank.THREE));
		cards.add(new Card(eSuit.CLUBS,eRank.FOUR));
		
		int[] score = HandHelper(cards);
		
		
		assertEquals(score[0],9);		
	}

	@Test
	public void test2() {
		
		ArrayList<Card> cards = new ArrayList<Card>();
		
		cards.add(new Card(eSuit.CLUBS,eRank.TWO));
		cards.add(new Card(eSuit.CLUBS,eRank.THREE));
		cards.add(new Card(eSuit.CLUBS,eRank.JACK));
		
		int[] score = HandHelper(cards);
		
		assertEquals(score[0],15);
	}

	@Test
	public void test3() {
		
		ArrayList<Card> cards = new ArrayList<Card>();
		
		cards.add(new Card(eSuit.CLUBS,eRank.TWO));
		cards.add(new Card(eSuit.CLUBS,eRank.THREE));
		cards.add(new Card(eSuit.CLUBS,eRank.JACK));
		cards.add(new Card(eSuit.CLUBS,eRank.JACK));
		
		int[] score = HandHelper(cards);
		
		assertEquals(score[0],25);
	}

	@Test
	public void test4() {
		
		ArrayList<Card> cards = new ArrayList<Card>();
		
		cards.add(new Card(eSuit.CLUBS,eRank.TWO));
		cards.add(new Card(eSuit.CLUBS,eRank.THREE));
		cards.add(new Card(eSuit.CLUBS,eRank.JACK));
		cards.add(new Card(eSuit.CLUBS,eRank.JACK));
		
		int[] score = HandHelper(cards);
		
		assertEquals(score[0],25);
	}

	@Test
	public void test5() {
		
		ArrayList<Card> cards = new ArrayList<Card>();
		
		cards.add(new Card(eSuit.CLUBS,eRank.JACK));
		cards.add(new Card(eSuit.CLUBS,eRank.ACE));
		cards.add(new Card(eSuit.CLUBS,eRank.ACE));
		
		int[] score = HandHelper(cards);
		
		assertEquals(score[0],12);
	}

	@Test
	public void test6() {
		
		ArrayList<Card> cards = new ArrayList<Card>();
		
		cards.add(new Card(eSuit.CLUBS,eRank.JACK));
		cards.add(new Card(eSuit.CLUBS,eRank.ACE));
		cards.add(new Card(eSuit.CLUBS,eRank.ACE));
		cards.add(new Card(eSuit.CLUBS,eRank.ACE));
		
		int[] score = HandHelper(cards);
		
		assertEquals(score[0],13);
	}
	
	@Test
	public void test7() {
		
		ArrayList<Card> cards = new ArrayList<Card>();
		
		cards.add(new Card(eSuit.CLUBS,eRank.ACE));
		cards.add(new Card(eSuit.CLUBS,eRank.ACE));
		cards.add(new Card(eSuit.CLUBS,eRank.ACE));
		cards.add(new Card(eSuit.CLUBS,eRank.ACE));
		cards.add(new Card(eSuit.CLUBS,eRank.TWO));
		
		int[] score = HandHelper(cards);
		
		assertEquals(score[0],6);
		assertEquals(score[1],16);
	}

}
