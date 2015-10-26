package BlackJack.controller;

import BlackJack.view.IView;
import BlackJack.model.Game;
import java.util.Observer;
import java.util.Observable;

public class PlayGame implements Observer {

	private Game a_game;
	private IView a_view;
	
	public PlayGame(Game a_game, IView a_view) {
		this.a_game = a_game;
		this.a_view = a_view;
	}

  public boolean play() {
    a_view.displayWelcomeMessage();
    
    a_view.displayDealerHand(a_game.getDealerHand(), a_game.getDealerScore());
    a_view.displayPlayerHand(a_game.getPlayerHand(), a_game.getPlayerScore());

    if (a_game.isGameOver())
    {
        a_view.displayGameOver(a_game.isDealerWinner());
    }

    IView.Event input = a_view.getInput();
    
    switch(input) {
    case NEW_GAME:
    	a_game.newGame();
    	break;
    case HIT:
    	a_game.hit();
    	break;
    case STAND:
    	a_game.stand();
    	break;
    case QUIT:
    	return false;
    case NONE:
    	break;
    }
    
    return true;
  }
  
  public void update(Observable subject, Object o) {
	  if(subject instanceof BlackJack.model.Dealer) {
		  a_view.updateDealerHand(a_game.getDealerHand(), a_game.getDealerScore());
	  }
	  else if(subject instanceof BlackJack.model.Player) {
		  a_view.updatePlayerHand(a_game.getPlayerHand(), a_game.getPlayerScore());
	  }
  }
}