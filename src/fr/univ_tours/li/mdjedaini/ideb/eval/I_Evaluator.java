/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.eval;

import fr.univ_tours.li.mdjedaini.ideb.algo.suts.I_SUT;

/**
 *
 * @author mahfoud
 */
public interface I_Evaluator {
    
    /**
     * This function undergoes a SUT.
     * It takes a SUt, runs its own protocol and must produce a SUT resolution.
     * @param arg_sut
     * @return 
     */
    public SUTResolution undergoSut(I_SUT arg_sut);
    
}
