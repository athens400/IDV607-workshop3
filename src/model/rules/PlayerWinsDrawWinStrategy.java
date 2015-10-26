package BlackJack.model.rules;

import BlackJack.model.Player;

public class PlayerWinsDrawWinStrategy implements IWinStrategy {
	
	public boolean isDealerWinner(Player a_player, Player a_dealer) {
		return a_dealer.calcScore() > a_player.calcScore();
	}

}
