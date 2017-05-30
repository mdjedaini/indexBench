/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.tools;

import java.util.AbstractMap;
import java.util.Map;

/**
 *
 * @author mahfoud
 */
public class Pair<K, V> {
    
    /**
     * 
     */
    Map.Entry<K, V> internalMapEntry;
    
    /**
     * 
     * @param arg_entry
     * @param arg_value
     */
    public Pair(K arg_entry, V arg_value) {
        this.internalMapEntry   = new AbstractMap.SimpleEntry<K, V>(arg_entry, arg_value);
    }
    
    /**
     * 
     * @return 
     */
    public K getKey() {
        return this.internalMapEntry.getKey();
    }

    /**
     * 
     * @return 
     */
    public V getValue() {
        return this.internalMapEntry.getValue();
    }

    /**
     * 
     * @param arg_value 
     */
    public void setValue(V arg_value) {
        this.internalMapEntry.setValue(arg_value);
    }
        
}
