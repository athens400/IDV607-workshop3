package BlackJack.model.rules;

import BlackJack.model.Player;
import BlackJack.model.Card;

class SoftHitStrategy implements IHitStrategy {
	private final int g_hitLimit = 17;

	public boolean doHit(Player a_dealer) {
		if(a_dealer.calcScore() == g_hitLimit) {
			boolean hasAce = false;
			int scoreRest = 0;
			for(Card c : a_dealer.getHand()) {
				if(c.GetValue() == Card.Value.Ace) {
					if(!hasAce) {
					hasAce = true;
					continue;
					}
					else {
						scoreRest += 1;
					}
				}
				else {
					scoreRest += a_dealer.valueCard(c);
				}
			}
			if(hasAce) {
				return scoreRest < g_hitLimit -10;
			}
		}
    	return a_dealer.calcScore() < g_hitLimit;
	}
}