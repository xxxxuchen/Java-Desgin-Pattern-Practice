/*******************************************************************************
 * Companion code for the book "Introduction to Software Design with Java" 
 * by Martin P. Robillard.
 *
 * Copyright (C) 2019 by Martin P. Robillard
 *
 * This code is licensed under a Creative Commons 
 * Attribution-NonCommercial-NoDerivatives 4.0 International License.
 *
 * See http://creativecommons.org/licenses/by-nc-nd/4.0/
 *******************************************************************************/
package chapter6;

import chapter3.Rank;
import chapter3.Suit;
import chapter4.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * Represents a deck of playing cards. In this version, the cards in the
 * deck are stored in a list and the list of cards in the deck can
 * be obtained by client code using an immutable wrapper object.
 * <p>
 * This version of the Deck class also implements {@link CardSource}
 * and is cloneable.
 * <p>
 * The Deck is also iterable: it fulfills the role of ConcreteIterable
 * in the Iterator design pattern.
 */
public class Deck implements CardSource, Iterable<Card>, Cloneable {
  private CardStack aCards = new CardStack();

  /**
   * Creates a new deck of 52 cards, shuffled.
   */
  public Deck() {
    shuffle();
  }

  /**
   * Reinitializes the deck with all 52 cards, and shuffles them.
   */
  public void shuffle() {
    List<Card> cards = new ArrayList<>();
    for (Suit suit : Suit.values()) {
      for (Rank rank : Rank.values()) {
        cards.add(Card.get(rank, suit));
      }
    }
    Collections.shuffle(cards);
    aCards = new CardStack(cards);
  }

  /**
   * Places pCard on top of the deck.
   *
   * @param pCard The card to place on top
   *              of the deck.
   * @pre pCard !=null
   */
  public void push(Card pCard) {
    assert pCard != null;
    aCards.push(pCard);
  }

  /**
   * Draws a card from the deck: removes the card from the top
   * of the deck and returns it.
   *
   * @return The card drawn.
   * @pre !isEmpty()
   */
  public Card draw() {
    assert !isEmpty();
    return aCards.pop();
  }

  /**
   * @return True if and only if there are no cards in the deck.
   */
  public boolean isEmpty() {
    return aCards.isEmpty();
  }

  @Override
  public Iterator<Card> iterator() {
    return aCards.iterator();
  }

  public Deck clone() {
    try {
      Deck clone = (Deck) super.clone();
      clone.aCards = new CardStack(clone.aCards);
      return clone;
    } catch (CloneNotSupportedException e) {
      assert false;
      return null;
    }
  }

  /**
   * Sample command factory method.
   *
   * @return A command to draw a card from the deck.
   */
  public Command createDrawCommand() {
    return new Command() {
      Card aDrawn = null;

      public Optional<Card> execute() {
        aDrawn = Deck.this.draw();
        return Optional.of(aDrawn);
      }

      public void undo() {
        Deck.this.aCards.push(aDrawn);
        aDrawn = null;
      }
    };
  }

  public static void main(String[] args) {
    Deck deck = new Deck();
    Command command = deck.createDrawCommand();
    Card card = command.execute().get();
    command.undo();
    System.out.println(card);
  }
}

