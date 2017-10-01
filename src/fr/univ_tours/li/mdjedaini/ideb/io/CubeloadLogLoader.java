/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.io;

import fr.univ_tours.li.mdjedaini.ideb.algo.gen.log.CubeloadGenerator;
import fr.univ_tours.li.mdjedaini.ideb.struct.Log;


/**
 * 
 * @author mahfoud
 */
public class CubeloadLogLoader implements I_LogLoader {

    CubeloadGenerator clg;
    
    /**
     * 
     * @param arg_clg 
     */
    public CubeloadLogLoader(CubeloadGenerator arg_clg) {
        this.clg    = arg_clg;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public Log loadLog() {
        return clg.generateLog();
    }
    
}
