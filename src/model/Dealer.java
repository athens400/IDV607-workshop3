package BlackJack.model;

import BlackJack.model.rules.*;

public class Dealer extends Player {

  private Deck m_deck;
  private INewGameStrategy m_newGameRule;
  private IHitStrategy m_hitRule;
  private IWinStrategy m_winRule;

  public Dealer(RulesFactory a_rulesFactory) {
  
    m_newGameRule = a_rulesFactory.getNewGameRule();
    m_hitRule = a_rulesFactory.getHitRule();
    m_winRule = a_rulesFactory.getWinRule();
  }
  
  
  public boolean newGame(Player a_player) {
    if (m_deck == null || isGameOver()) {
      m_deck = new Deck();
      clearHand();
      a_player.clearHand();
      return m_newGameRule.newGame(this, a_player);   
    }
    return false;
  }
  
  public void dealCard(Player to_player, boolean visible) {
	  Card c = m_deck.getCard();
	  c.show(visible);
	  to_player.addCard(c);
  }

  public boolean hit(Player a_player) {
    if (m_deck != null && a_player.calcScore() < g_maxScore && !isGameOver()) {
      dealCard(a_player, true);
      return true;
    }
    return false;
  }
  
  public boolean stand() {
	  if(m_deck != null) {
		  showHand();
		  while(m_hitRule.doHit(this)) {
			  dealCard(this, true);
		  }
		  return true;
	  }
	  return false;
  }

  public boolean isDealerWinner(Player a_player) {
    if (a_player.calcScore() > g_maxScore) {
      return true;
    } else if (calcScore() > g_maxScore) {
      return false;
    }
    return m_winRule.isDealerWinner(a_player, this);
  }

  public boolean isGameOver() {
    if (m_deck != null && m_hitRule.doHit(this) != true) {
        return true;
    }
    return false;
  }
  
}