package chapter4;

import chapter3.Rank;
import chapter3.Suit;

import java.util.HashSet;

public class CardEqual {
  /* Code that relies on the equals and hashCode methods */
  public static void main(String[] args) {
    CardEqual card1 = new CardEqual(Rank.ACE, chapter3.Suit.CLUBS);
    CardEqual card2 = new CardEqual(Rank.ACE, Suit.DIAMONDS);
    CardEqual card3 = new CardEqual(Rank.ACE, Suit.CLUBS);
    HashSet<CardEqual> set = new HashSet<>();
    set.add(card1);
    set.add(card2);
    assert card1.equals(card3);
    assert set.size() == 2;
    assert !set.add(card3);
    System.out.println("No errors");
  }

  private Rank aRank;
  private Suit aSuit;

  /**
   * Creates a new card object.
   *
   * @param pRank The rank of the card.
   * @param pSuit The suit of the card.
   * @pre pRank != null
   * @pre pSuit != null
   */
  public CardEqual(Rank pRank, Suit pSuit) {
    assert pRank != null && pSuit != null;
    aRank = pRank;
    aSuit = pSuit;
  }

  /**
   * @return The rank of the card.
   */
  public Rank getRank() {
    return aRank;
  }

  /**
   * @return The suit of the card.
   */
  public Suit getSuit() {
    return aSuit;
  }

  @Override
  public int hashCode() {
    return aSuit.ordinal() * Rank.values().length + aRank.ordinal();
  }

  @Override
  public boolean equals(Object pObject) {
    if (this == pObject) {
      return true;
    }
    if (pObject == null || getClass() != pObject.getClass()) {
      return false;
    }
    CardEqual other = (CardEqual) pObject;
    return aSuit == other.aSuit && aRank == other.aRank;
  }
}
