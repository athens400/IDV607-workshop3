package BlackJack.model.rules;

public class RulesFactory {

  public IHitStrategy getHitRule() {
    return new SoftHitStrategy();
  }

  public INewGameStrategy getNewGameRule() {
    return new AmericanNewGameStrategy();
  }
  
  public IWinStrategy getWinRule() {
	  return new DealerWinsDrawWinStrategy();
  }
}