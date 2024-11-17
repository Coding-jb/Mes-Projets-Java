package battleship;

import battleship.util.Position;

import io.Input;
/**
 * class for Game
 */
public class Game {
    
    /** This Game's Sea */
    private Sea sea;

    /**
     * Build a Game with a given sea 
     * @param sea, this game's sea
     */
    public Game(Sea sea) {
        this.sea = sea;
    }

    /**
     * get the sea of this game
     * @return the sea of this game
     */
    public Sea getSea(){
        return this.sea;
    }

    /**
     * Ask the Player to input the Cell's coordonate to target a Ship
     * @throws IllegalArgumentException, if the given user's input is invalid
     * @return A position given by the player 
     */
    private Position inputPosition() throws IllegalArgumentException {
        System.out.println("Position visée ? ");
        String userInput = Input.readString();
        Position position = new Position(readCoord(userInput)[0],readCoord(userInput)[1]);
        return position;    
    }

    /**
     * Turn user Input into a usable position by the Game 
     * @throws IllegalArgumentException, if the given user's input is invalid
     * @return a usable position for the game
     */
    private int[] readCoord(String userInput) throws IllegalArgumentException {
        int[] coordonates = {-1, -1};
        char[] alpha = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        if(userInput.length() > 2 || userInput.length() == 1 || Character.isLowerCase(userInput.charAt(0))) { 
            throw new IllegalArgumentException();
        }
        for(int i = 0; i < this.getSea().getWidth(); i++) {
            if(userInput.charAt(0) == alpha[i]) {
                coordonates[0] = i;
            }
        }
        for(int j = 0; j < this.getSea().getHeight(); j++){
            if(userInput.charAt(1) - '0' == j){
                coordonates[1] = j;
            }
        }
        if(coordonates[0] == -1 && coordonates[1] == -1){
            throw new IllegalArgumentException();
        }
        return coordonates; 
    }

    /**
     * Play the game
     * @throws InvalidShootException exception raise by shoot
     * @throws IllegalArgumentException exceptions raise by inputPosition
     */
    public void play() throws IllegalArgumentException, InvalidShootException{
        System.out.print("Saisissez les coordonnées de la case visée (Colonne,Ligne) sous la forme \"LR\", par exemple : B2 or D7\n");
        while(this.getSea().getRemainingLifePoints() > 0){
            boolean isValid = false;
            Position position = null;
            while(isValid != true){
                try{
                    this.getSea().display(false);
                    position = this.inputPosition();
                    isValid = true;
                }catch(IllegalArgumentException e){
                    System.out.println("SVP saisissez une position valide (A2 ou E3 ou ...)");
                }
            }   
            Answer answer = this.getSea().Shoot(position);
            System.out.println(answer);
            System.out.println("totalLifePoints : " + this.getSea().getRemainingLifePoints() + "\n"); 
        }
        this.getSea().display(true);
        System.out.println("Good Bye!!");
    }
}
