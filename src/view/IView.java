package BlackJack.view;

public interface IView
{
  enum Event{
    NEW_GAME,
    STAND,
    HIT,
    QUIT,
    NONE
  }
	
  void displayWelcomeMessage();
  Event getInput();
  void displayCard(BlackJack.model.Card a_card);
  void displayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);
  void displayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);
  void updatePlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);
  void updateDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);
  void displayGameOver(boolean a_dealerIsWinner);
}