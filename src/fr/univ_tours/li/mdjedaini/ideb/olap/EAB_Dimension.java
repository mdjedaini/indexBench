/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.olap;

import mondrian.olap.Dimension;

/**
 *
 * @author mahfoud
 */
public class EAB_Dimension {

    //
    Dimension mondrianDimension;
    
    EAB_Cube cube;
    
    //
    String name;
    String uniqueName;
    
    /**
     * 
     * @param arg_mondrianDimension 
     * @param arg_cube 
     */
    public EAB_Dimension(Dimension arg_mondrianDimension, EAB_Cube arg_cube) {
        this.mondrianDimension  = arg_mondrianDimension;
        this.cube               = arg_cube;
        
        this.name               = this.mondrianDimension.getName();
        this.uniqueName         = this.mondrianDimension.getUniqueName();
    }
    
    /**
     * 
     * @return 
     */
    public String getUniqueName() {
        return this.mondrianDimension.getUniqueName();
    }
    
    /**
     * 
     * @return 
     */
    public boolean isMeasureDimension() {
        return this.mondrianDimension.isMeasures();
    }

    /**
     * 
     * @return 
     */
    public Dimension getMondrianDimension() {
        return this.mondrianDimension;
    }

    /**
     *
     * @return
     */
    public EAB_Cube getCube() {
        return this.cube;
    }
    
    /**
     * 
     * @param arg_o
     * @return 
     */
    @Override
    public boolean equals(Object arg_o) {
        EAB_Dimension arg_dimension = (EAB_Dimension)arg_o;
        return this.mondrianDimension.equals(arg_dimension.mondrianDimension);
    }
    
}
