/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.ext.cubeload;

import fr.univ_tours.li.mdjedaini.ideb.algo.gen.log.I_LogGenerator;
import fr.univ_tours.li.mdjedaini.ideb.struct.Log;

/**
 *
 * @author mahfoud
 */
public class CubeLoad implements I_LogGenerator {

    /**
     * 
     */
    String schemaFilePath;
    
    /**
     * 
     */
    String dimensionFolderPath;
    
    /**
     * 
     */
    public CubeLoad() {
        
    }
    
    /**
     * 
     * @return 
     */
    public Log generateLog() {
        
        Log log = new Log();
        
        return log;
        
    }
    
}
