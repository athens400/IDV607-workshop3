package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Player;

class AmericanNewGameStrategy implements INewGameStrategy {

  public boolean newGame(Dealer a_dealer, Player a_player) {
    
    a_dealer.dealCard(a_player, true);
    a_dealer.dealCard(a_dealer, true);
    a_dealer.dealCard(a_player, true);
    a_dealer.dealCard(a_dealer, false);

    return true;
  }
}