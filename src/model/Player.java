package BlackJack.model;

import java.util.List;
import java.util.LinkedList;
import java.util.Observable;

public class Player extends Observable {

  private List<Card> m_hand;
  protected final int g_maxScore = 21;
  //private List<observer.Observer> observers = new ArrayList<observer.Observer>();

  public Player()
  {
  
    m_hand = new LinkedList<Card>();
    System.out.println("Hello List World");
  }
  
  public void addCard(Card a_addToHand) {
	  m_hand.add(a_addToHand);
	  setChanged();
	  notifyObservers(this);
  }
  
  public Iterable<Card> getHand()
  {
    return m_hand;
  }
  
  public void clearHand()
  {
    m_hand.clear();
  }
  
  public void showHand()
  {
    for(Card c : m_hand)
    {
      c.show(true);
    }
  }
  
  public int calcScore()
  {
    int score = 0;

    for(Card c : getHand()) {
        if (c.GetValue() != Card.Value.Hidden)
        {
            score += valueCard(c);
        }
    }

    if (score > g_maxScore)
    {
        for(Card c : getHand())
        {
            if (c.GetValue() == Card.Value.Ace && score > g_maxScore)
            {
                score -= 10;
            }
        }
    }

    return score;
  }
  
  public int valueCard(Card c) {
	// the number of scores is dependant on the number of scorable values
	    // as it seems there is no way to do this check at compile time in java ?!
	    // cardScores[13] = {...};
	    int cardScores[] = {
	        2, 3, 4, 5, 6, 7, 8, 9, 10, 10 ,10 ,10, 11
	    };
	    assert (cardScores.length == Card.Value.Count.ordinal()) : "Card Scores array size does not match number of card values";
	  
	    
	  return cardScores[c.GetValue().ordinal()];
  }  
  
}