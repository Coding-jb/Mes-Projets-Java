package goosegame.boards;

import goosegame.cells.*;
/**
 * class for ClassicalBoard
 */
public class ClassicalBoard extends Board {
    
    /** number of cells for a classical board 0 -> 63 */
    public static final int NBCELLS = 64;

    /**
     * Build a classical Board with 63 Cells 
     * @param nbOfCells the number of cells of this Board
     */
    public ClassicalBoard(int nbOfCells)  {
        super(nbOfCells);
    }

    /**
     * The method to initialise a new Classical Board
     */
    protected void initBoard() {
            
        // Ajout des cellules oie
        this.getTheCells().remove(9);
        this.getTheCells().add(9, new GooseCell(9));
        this.getTheCells().remove(18);
        this.getTheCells().add(18, new GooseCell(18));
        this.getTheCells().remove(27);
        this.getTheCells().add(27, new GooseCell(27));
        this.getTheCells().remove(36);
        this.getTheCells().add(36, new GooseCell(36));
        this.getTheCells().remove(45);
        this.getTheCells().add(45, new GooseCell(45));
        this.getTheCells().remove(54);
        this.getTheCells().add(54, new GooseCell(54));

        // Ajout des cellules teleportations
        this.getTheCells().remove(6);
        this.getTheCells().add(6, new TeleportCell(6, this.getTheCells().get(12)));
        this.getTheCells().remove(42);
        this.getTheCells().add(42, new TeleportCell(42, this.getTheCells().get(30)));
        this.getTheCells().remove(58);
        this.getTheCells().add(58, new TeleportCell(58, this.getTheCells().get(1)));

        // Ajout des cellules pieges
        this.getTheCells().remove(31);
        this.getTheCells().add(31, new TrapCell(31));
        this.getTheCells().remove(52);
        this.getTheCells().add(52, new TrapCell(52));

        // Ajout de la cellule d'attente 
        this.getTheCells().remove(19);
        this.getTheCells().add(19, new WaitingCell(19, 2));
        
        
    }
}
