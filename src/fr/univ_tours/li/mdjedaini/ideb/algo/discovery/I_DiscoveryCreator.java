/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.algo.discovery;

import fr.univ_tours.li.mdjedaini.ideb.olap.result.EAB_Cell;
import fr.univ_tours.li.mdjedaini.ideb.struct.AbstractDiscovery;
import fr.univ_tours.li.mdjedaini.ideb.struct.CellList;
import java.util.Collection;

/**
 *
 * @author mahfoud
 */
public interface I_DiscoveryCreator {
        
    /**
     * 
     * @param arg_cellList
     * @return 
     */
    public Collection<AbstractDiscovery> createDiscoveries(Collection<EAB_Cell> arg_cellList);
    
}
