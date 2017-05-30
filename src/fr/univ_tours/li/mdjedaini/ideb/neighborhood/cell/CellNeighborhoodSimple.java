/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.neighborhood.cell;

import fr.univ_tours.li.mdjedaini.ideb.neighborhood.member.MemberNeighborhood;
import fr.univ_tours.li.mdjedaini.ideb.olap.EAB_Hierarchy;
import fr.univ_tours.li.mdjedaini.ideb.olap.EAB_Member;
import fr.univ_tours.li.mdjedaini.ideb.olap.result.EAB_Cell;

/**
 *
 * @author mahfoud
 */
public class CellNeighborhoodSimple extends CellNeighborhood {
    
    /**
     * 
     */
    public CellNeighborhoodSimple() {
        super(new MemberNeighborhood());
    }
    
    /**
     * 
     * @param arg_mn 
     */
    public CellNeighborhoodSimple(MemberNeighborhood arg_mn) {
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

        // if the basic neighborhood condition is not respected
        if(!super.areNeigbours(arg_c1, arg_c2)) {
            return false;
        }

        // if they are neighbors they differ exactly on one hierarchy h_tmp
        EAB_Hierarchy h_tmp = arg_c1.getDifferentialHierarchyList(arg_c2).iterator().next();
        
        EAB_Member m1   = arg_c1.getMemberByHierarchy(h_tmp);
        EAB_Member m2   = arg_c2.getMemberByHierarchy(h_tmp);
        
        return this.mn.areNeigbours(m1, m2);

    }
    
}
