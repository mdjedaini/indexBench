/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.io;

import fr.univ_tours.li.mdjedaini.ideb.struct.AbstractDiscovery;

/**
 *
 * @author mahfoud
 */
public interface I_DiscoveryWriter {
    
    /**
     * 
     * @param arg_discovery
     * @return 
     */
    String writeDiscovery(AbstractDiscovery arg_discovery);
    
}
