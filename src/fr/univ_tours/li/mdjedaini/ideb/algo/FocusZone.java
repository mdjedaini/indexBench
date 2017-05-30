/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.algo;

import fr.univ_tours.li.mdjedaini.ideb.eval.Exploration;
import fr.univ_tours.li.mdjedaini.ideb.struct.CellList;

/**
 *
 * @author 21408782t
 */
public class FocusZone {
    
    public Exploration exp;
    public Integer startPosition;
    public Integer endPosition;
    CellList cellList;
    
    /**
     * 
     */
    public FocusZone() {
        this.cellList   = new CellList();
    }
    
    /**
     * 
     * @param arg_exp
     * @param arg_start
     * @param arg_end 
     */
    public FocusZone(Exploration arg_exp, Integer arg_start, Integer arg_end) {
        this.exp            = arg_exp;
        this.startPosition  = arg_start;
        this.endPosition    = arg_end;
        this.cellList       = new CellList();
    }
    
    /**
     * Retrieves cells contained in the focus zone.
     * Cells are computed on the fly if they have not been computed before...
     * @return 
     */
    public CellList getCellList() {
        if(this.cellList.getCellCollection().isEmpty()) {
            for(int k = this.startPosition; k <= this.endPosition; k++) {
                this.cellList.addCellCollection(this.exp.getWorkSession().getQueryByPosition(k).execute(Boolean.TRUE).getCellList().getCellCollection());
            }
        }
                
        return this.cellList;
    }
    
}
