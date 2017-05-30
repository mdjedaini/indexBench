/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.neighborhood.cell;

import fr.univ_tours.li.mdjedaini.ideb.olap.result.EAB_Cell;

/**
 *
 * @author mahfoud
 */
public interface I_CellNeighborhood {
    
    /**
     * 
     * @param arg_c1
     * @param arg_c2
     * @return 
     */
    public boolean areNeigbours(EAB_Cell arg_c1, EAB_Cell arg_c2);
    
}
