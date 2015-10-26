package BlackJack.view;

public class SwedishView implements IView 
    {
        public void displayWelcomeMessage()
        {
         
            for(int i = 0; i < 50; i++) {System.out.print("\n");};

            System.out.println("Hej Black Jack V�rlden");
            System.out.println("----------------------");
            System.out.println("Skriv 'p' f�r att Spela, 'h' f�r nytt kort, 's' f�r att stanna 'q' f�r att avsluta\n");
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
            if (a_card.GetColor() == BlackJack.model.Card.Color.Hidden)
            {
                System.out.println("Dolt Kort");
            }
            else
            {
                String colors[] = 
                    { "Hj�rter", "Spader", "Ruter", "Kl�ver" };
                String values[] =  
                    { "tv�", "tre", "fyra", "fem", "sex", "sju", "�tta", "nio", "tio", "knekt", "dam", "kung", "ess" };
                System.out.println("" + colors[a_card.GetColor().ordinal()] + " " + values[a_card.GetValue().ordinal()]);
            }
        }
        public void displayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            displayHand("Spelare", a_hand, a_score);
        }
        public void displayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            displayHand("Croupier", a_hand, a_score);
        }
        public void displayGameOver(boolean a_dealerIsWinner)
        {
            System.out.println("Slut: ");
            if (a_dealerIsWinner)
            {
                System.out.println("Croupiern Vann!");
            }
            else
            {
                System.out.println("Du vann!");
            }
        }

        private void displayHand(String a_name, Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            System.out.println(a_name + " Har: " + a_score);
            for(BlackJack.model.Card c : a_hand)
            {
                displayCard(c);
            }
            System.out.println("Po�ng: " + a_score);
            System.out.println("");
        }
        
        public void updatePlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score) {
        	updateHand("Spelare", a_hand, a_score);
        }
        
        public void updateDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score) {
        	updateHand("Croupier", a_hand, a_score);
        }
        
        private void updateHand(String a_name, Iterable<BlackJack.model.Card> a_hand, int a_score) {
        	blankPage();
        	System.out.println("Delar ut kort till " + a_name + "...");
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