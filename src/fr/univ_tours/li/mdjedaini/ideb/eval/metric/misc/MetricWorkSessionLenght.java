package fr.univ_tours.li.mdjedaini.ideb.eval.metric.misc;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package fr.univ_tours.li.mdjedaini.eab.eval.metric.misc;
//
//import fr.univ_tours.li.mdjedaini.eab.BenchmarkEngine;
//import fr.univ_tours.li.mdjedaini.eab.algo.similarity.AligonSimilarity;
//import fr.univ_tours.li.mdjedaini.eab.algo.similarity.I_SessionSimilarity;
//import fr.univ_tours.li.mdjedaini.eab.eval.TaskResolution;
//import fr.univ_tours.li.mdjedaini.eab.eval.metric.Metric;
//import fr.univ_tours.li.mdjedaini.eab.struct.Session;
//import fr.univ_tours.li.mdjedaini.eab.user.User;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// *
// * @author mahfoud
// */
//public class MetricWorkSessionLenght extends Metric {
//    
//    /**
//     * 
//     * @param arg_be 
//     */
//    public MetricWorkSessionLenght(BenchmarkEngine arg_be) {
//        super(arg_be);
//        this.name           = "Work Session Length";
//        this.description    = "Evaluates the similarity of a generated session to previous user sessions...";
//    }
//    
//    /**
//     * Generates a random double, between 0.0 and 1.0.
//     * 
//     * @param arg_tr
//     * @return 
//     */
//    @Override
//    public MetricScore apply(TaskResolution arg_tr) {
//        Double result   = 0.5;
//        User u_tmp      = arg_tr.getTask().getUser();
//
//        List<Double> similarityArray    = new ArrayList<>();
//
//        // @todo there is a problem if the user has no previous sessions...
//        for(Session s_tmp : arg_tr.getTaskBundle().getCurrentUserSessions()) {
//            similarityArray.add(this.i_ss.similarity(arg_tr.getWorkSession(), s_tmp));
//        }
//        
//        Double sum  = 0.;
//        for(Double d_tmp : similarityArray) {
//            sum += d_tmp;
//        }
//        
//        // average similarity between arg_tr and previous user sessions
//        result  = sum / similarityArray.size();
//        
//        return result;
//    }
//    
//}
