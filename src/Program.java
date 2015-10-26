package BlackJack;

import BlackJack.model.Game;
import BlackJack.view.*;
import BlackJack.controller.*;

public class Program
{

  public static void main(String[] a_args)
  {
  
    Game g = new Game();
    IView v = new SwedishView(); //new SwedishView();
    PlayGame ctrl = new PlayGame(g, v);
    g.addObserver(ctrl);
    
    while (ctrl.play());
  }
}