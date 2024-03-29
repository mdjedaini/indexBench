/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.algo.clustering;

import fr.univ_tours.li.mdjedaini.ideb.struct.Session;
import java.util.Collection;

/**
 *
 * @author mahfoud
 */
public interface I_SessionClusteringAlgorithm {
    
    /**
     * Clusterizes a list of sessions.
     * Each obtained clusters, for us, represents sessions of a given user.
     * @param arg_sessionList
     * @return 
     */
    Collection<Collection<Session>> clusterizeSessions(Collection<Session> arg_sessionList);
    
}
