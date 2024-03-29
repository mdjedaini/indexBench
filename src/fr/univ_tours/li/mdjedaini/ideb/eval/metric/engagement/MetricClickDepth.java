/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.eval.metric.engagement;

import fr.univ_tours.li.mdjedaini.ideb.BenchmarkEngine;
import fr.univ_tours.li.mdjedaini.ideb.algo.query.QueryEditionDistance;
import fr.univ_tours.li.mdjedaini.ideb.eval.Exploration;
import fr.univ_tours.li.mdjedaini.ideb.eval.metric.Metric;
import fr.univ_tours.li.mdjedaini.ideb.eval.scoring.MetricScore;
import fr.univ_tours.li.mdjedaini.ideb.neighborhood.I_QueryNeighborhood;
import fr.univ_tours.li.mdjedaini.ideb.neighborhood.QueryNeighborhood;
import fr.univ_tours.li.mdjedaini.ideb.olap.query.Query;
import fr.univ_tours.li.mdjedaini.ideb.olap.query.QueryTriplet;
import fr.univ_tours.li.mdjedaini.ideb.struct.Session;
import fr.univ_tours.li.mdjedaini.ideb.tools.Stats;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * This metric evaluates the evolution of the access area.
 * Access area is defined as all the primary cells (tuples) accessed.
 * It evaluates how rich is the access area provided by the SUT.
 * @author mahfoud
 */
public class MetricClickDepth extends Metric {
    
    I_QueryNeighborhood qn;
    
    /**
     * 
     * @param arg_be 
     */
    public MetricClickDepth(BenchmarkEngine arg_be) {
        super(arg_be);
        this.qn             = new QueryNeighborhood();
        this.name           = "Metric - Click Depth";
        this.description    = "Evaluates the click depth for each query. It is the lenght of the subsequence of queries chained by at most a distance of 1.";
    }

    /**
     * 
     * @param arg_tr
     * @return 
     */
    @Override
    public MetricScore apply(Exploration arg_tr) {
        MetricScore result  = new MetricScore(this, arg_tr);

        QueryEditionDistance qed    = new QueryEditionDistance();
        
        // get the work session
        Session workSession = arg_tr.getWorkSession();

        result.queryScoreList   = new ArrayList<>(Collections.nCopies(workSession.getNumberOfQueries(), 0.));
//        System.out.println("query score list: " + result.queryScoreList);
        
        for(int i = 0; i < arg_tr.getWorkSession().getNumberOfQueries() - 1; i++) {
            
//            System.out.println("je commence a la requete " + i);
            
            Query q_i   = arg_tr.getWorkSession().getQueryByPosition(i);
            Integer cd  = 0;
            
            for(int j = i; j < arg_tr.getWorkSession().getNumberOfQueries() - 1; j++) {
                Query q_j   = arg_tr.getWorkSession().getQueryByPosition(j);
                Query q_jp1 = arg_tr.getWorkSession().getQueryByPosition(j+1);
            
//                System.out.println("je compare les requetes " + j + " et " + (j+1));
//                System.out.println(q_j);
//                System.out.println(q_jp1);
                
                if(qed.distance(q_j, q_jp1) <= 1) {
                    //System.out.println("elles sont focus, donc j'increment cd");
                    cd++;
                    //System.out.println("cd: " + cd);
                } else {
                    //System.out.println("focus fini, distance de " + qed.distance(q_j, q_jp1));
                    //i = j; // be careful, l'iterateur va ajouter +1 a i automatiquement a la fin de la boucle!!!
                    //System.out.println("je reprends a " + (i+1));
                    break;
                }
                
            }
            
            result.queryScoreList.set(i, cd.doubleValue());
            
        }
        
        // last query has always click depth of 0
        //result.queryScoreList.add(0.);
        
        // Click depth of the exploration is the average of click depths for its queries
        result.score    = Stats.average(result.queryScoreList);
        
        return result;
    }
    
}
