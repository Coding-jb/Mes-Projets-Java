package goosegame;

import java.util.*;

import goosegame.boards.ClassicalBoard;

/**
 * class for GooseGameMain
 */
public class GooseGameMain {
   
    /**
     * Default constructor for GooseGame
     */
    public GooseGameMain() { }

    /**
     * How to Play a Goose Game 
     */
    public static void usage() {
        System.out.println("Jeu de L'Oie\n\nCe jeu est joué par au moins 2 joueurs, chaque joueur possède un pion situé sur la premiere case au début. A chaque tour le joueur lance deux dés et avance du nombre du case indiqué par les dés. Certaines cases ont des effets spéciaux : la case oie fait avancer du même nombre de case, la case hotel passe 2 tours, le labyrinthe envoie sur une case en arrière alors que le pont envoie sur une case en avant, la case mort renvoie au début, la prison et le puit bloquent un joueur indéfiniement tant qu'un autre joueur ne les libère pas en arrivant sur la même case.Dans notre implementation, l'option de jeu choisie, est de n'avoir qu'un seul joueur par case aucours du jeu : ce qui implique que lorsqu'un joueur arrive sur une case occupée, il echange de case avec le joueur de la case.");
        System.out.println("\nUsage : java -jar oie.jar <nombreDeJoueurs>  [Au moins 2 joueurs] ou ");
        System.out.println("\nUsage : java -jar oie.jar <nombreDeJoueurs> <NomJoeur1> <NomJoeur2>  ....  [Au moins 2 joueurs]\n");
        System.exit(0);
    }

    /**
     * Main Method for GooseGame 
     * @param args params of this game
     * @throws NoSuchCellException no such cell
     */
    public static void main(String[] args) throws NoSuchCellException {
        
        Game game;
        int nbPlayers;
        List<String> playersNames;
        ClassicalBoard classicalBoard = new ClassicalBoard(ClassicalBoard.NBCELLS);

        if(args.length == 0) {
            usage();
        }
        else if (args.length == 1) {

            nbPlayers = Integer.parseInt(args[0]);

            game = new Game(classicalBoard, nbPlayers);

            game.play();
        }
        else {
            
            nbPlayers = Integer.parseInt(args[0]);

            playersNames = new ArrayList<String>(nbPlayers);

            for(int i = 1; i < nbPlayers + 1; i++) {
                playersNames.add(args[i]);
            }

            game = new Game(classicalBoard, nbPlayers, playersNames);
        
            game.play();
        }
    }
}
