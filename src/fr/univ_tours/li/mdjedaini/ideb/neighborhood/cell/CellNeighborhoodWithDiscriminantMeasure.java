/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.neighborhood.cell;

import fr.univ_tours.li.mdjedaini.ideb.neighborhood.member.MemberNeighborhood;
import fr.univ_tours.li.mdjedaini.ideb.olap.result.EAB_Cell;

/**
 *
 * @author mahfoud
 */
public class CellNeighborhoodWithDiscriminantMeasure extends CellNeighborhood {
    
    /**
     * 
     * @param arg_mn 
     */
    public CellNeighborhoodWithDiscriminantMeasure(MemberNeighborhood arg_mn) {
        super(arg_mn);
    }
    
    /**
     * 
     * @param arg_c1
     * @param arg_c2
     * @return 
     */
    @Override
    public boolean areNeigbours(EAB_Cell arg_c1, EAB_Cell arg_c2) {
        
        // if the two cells dont have the same measure they cannot be neighbors
        if(!arg_c1.getMeasure().equals(arg_c2.getMeasure())) {
            return false;
        }
        
        // if the measures are the same, we reuse the logic of neighborhood simple
        CellNeighborhoodSimple ns    = new CellNeighborhoodSimple(this.mn);
        return ns.areNeigbours(arg_c1, arg_c2);

    }
    
}
