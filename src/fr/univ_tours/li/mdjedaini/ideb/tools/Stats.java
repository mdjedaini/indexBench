/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.tools;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author 21408782t
 */
public class Stats {
    
    /**
     * 
     * @param arg_list
     * @return 
     */
    public static Double average(List<Double> arg_list) {
        Double result   = 0.;
        
        Double num      = 0.;
        Integer denum   = arg_list.size();
        
        for(Double d_tmp : arg_list) {
            num += d_tmp;
        }
        
        result  = num / denum.doubleValue();
        
        return result;
    }
    
    /**
     * 
     * @param arg_list
     * @return 
     */
    public static Object mode(List<Object> arg_list) {
        Double result   = 0.;
        
        Set<Object> setOfList = new HashSet<>(arg_list);
        Map<Integer, Object> map    = new HashMap<>();
        
        for(Object o_tmp : setOfList) {
            Integer frequency   = Collections.frequency(arg_list, o_tmp);
            map.put(frequency, o_tmp);
        }
        
        Integer max = Collections.max(map.keySet());
        return map.get(max);

    }
    
}
