package BlackJack.view;

public class SimpleView implements IView 
{

  public void displayWelcomeMessage()
        {
	  	  blankPage();
          System.out.println("Hello Black Jack World");
          System.out.println("Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit\n");
        }

        public Event getInput()
        {
        	int input;
          try {
            input = System.in.read();
            switch(input) {
            case 'p':
            	return Event.NEW_GAME;
            case 'h':
            	return Event.HIT;
            case 's':
            	return Event.STAND;
            case 'q':
            	return Event.QUIT;
            default:
            	return Event.NONE;
            }
          } catch (java.io.IOException e) {
            System.out.println("" + e);
            return Event.NONE;
          }
        }

        public void displayCard(BlackJack.model.Card a_card)
        {
            System.out.println("" + a_card.GetValue() + " of " + a_card.GetColor());
        }

        public void displayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            displayHand("Player", a_hand, a_score);
        }

        public void displayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            displayHand("Dealer", a_hand, a_score);
        }

        private void displayHand(String a_name, Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            System.out.println(a_name + " Has: ");
            for(BlackJack.model.Card c : a_hand)
            {
                displayCard(c);
            }
            System.out.println("Score: " + a_score);
            System.out.println("");
        }

        public void displayGameOver(boolean a_dealerIsWinner)
        {
            System.out.println("GameOver: ");
            if (a_dealerIsWinner)
            {
                System.out.println("Dealer Won!");
            }
            else
            {
                System.out.println("You Won!");
            }
            
        }
        
        public void updatePlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score) {
        	updateHand("Player", a_hand, a_score);
        }
        
        public void updateDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score) {
        	updateHand("Dealer", a_hand, a_score);
        }
        
        private void updateHand(String a_name, Iterable<BlackJack.model.Card> a_hand, int a_score) {
        	blankPage();
        	System.out.println("Dealing card to " + a_name + "...");
        	sleep(1500);
        	blankPage();
        	displayHand(a_name, a_hand, a_score);
        	sleep(2000);
        }
        
        private void blankPage() {
        	for(int i = 0; i < 50; i++) {System.out.print("\n");}; 
        }
        
        private void sleep(int ms) {
        	try {
        		Thread.sleep(ms);
        	}
        	catch(InterruptedException e) {
        		Thread.currentThread().interrupt();
        	}
        }
        
    }