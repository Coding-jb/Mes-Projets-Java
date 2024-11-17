package goosegame.boards;

import java.util.*;

import goosegame.NoSuchCellException;
import goosegame.cells.*;
/**
 * class for Board
 */
public abstract class Board {
    
    /** The number of Cells of this Board */
    protected final int nbOfCells;

    /** The Array of cells of this Board */
    protected List<Cell> theCells;

    /**
     * Build a Board with given number of Cells 
     * @param nbOfCells the number of cells of this Board
     */
    public Board(int nbOfCells) {
        this.nbOfCells = nbOfCells;
        this.theCells = new ArrayList<Cell>(nbOfCells);
        for(int i = 0; i < nbOfCells; i++) {
            this.getTheCells().add(new Cell(i));
        }
        this.initBoard();
    }

    /**
     * The method to initialise a new Board
     */
    protected abstract void initBoard();

    /**
     * get the Cells of this Board
     * @return the Cells of this Board
     */
    public List<Cell> getTheCells() {
        return this.theCells;
    }

    /**
     * get the number of cells of this Board
     * @return number of cells of this Board
     */
    public int getNbOfCells() {
        return this.nbOfCells;
    }

    /**
     * get the Cell of this Board at given index
     * @param index the cell's index
     * @return the Cell at the index
     * @throws NoSuchCellException if the index is not correct
     */
    public Cell getCell(int index) throws NoSuchCellException {
        try {
            return this.getTheCells().get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchCellException("The Searched Cell doesn't exist !!");
        }
    }
}

