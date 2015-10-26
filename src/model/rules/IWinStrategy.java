package BlackJack.model.rules;

import BlackJack.model.Player;

public interface IWinStrategy {
	boolean isDealerWinner(Player a_player, Player a_dealer);
}
