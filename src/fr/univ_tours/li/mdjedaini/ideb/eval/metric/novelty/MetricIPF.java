package fr.univ_tours.li.mdjedaini.ideb.eval.metric.novelty;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package fr.univ_tours.li.mdjedaini.eab.eval.metric.novelty;
//
//import fr.univ_tours.li.mdjedaini.eab.BenchmarkEngine;
//import fr.univ_tours.li.mdjedaini.eab.algo.misc.IPF_Query;
//import fr.univ_tours.li.mdjedaini.eab.algo.misc.KL_Divergence;
//import fr.univ_tours.li.mdjedaini.eab.eval.TaskResolution;
//import fr.univ_tours.li.mdjedaini.eab.eval.metric.Metric;
//import fr.univ_tours.li.mdjedaini.eab.olap.EAB_Hierarchy;
//import fr.univ_tours.li.mdjedaini.eab.olap.query.Query;
//import fr.univ_tours.li.mdjedaini.eab.olap.query.QueryTriplet;
//import fr.univ_tours.li.mdjedaini.eab.olap.result.EAB_Cell;
//import fr.univ_tours.li.mdjedaini.eab.struct.CellList;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
///**
// * This metric evaluates the evolution of the access area.
// * Access area is defined as all the primary cells (tuples) accessed.
// * It evaluates how rich is the access area provided by the SUT.
// * @author mahfoud
// */
//public class MetricIPF extends Metric {
//    
//    TaskResolution taskResolution;
//    
//    KL_Divergence kl    = new KL_Divergence();
//    IPF_Query idfq      = new IPF_Query();
//    
//    /**
//     * 
//     * @param arg_be 
//     */
//    public MetricIPF(BenchmarkEngine arg_be) {
//        super(arg_be);
//        this.name           = "Metric - SaRaWaGi";
//        this.description    = "Computes differences between expected distribution and actual distribution...";
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
//        
//        this.taskResolution = arg_tr;
//        
//        List<Double> entropyList    = new ArrayList<>();
//        
//        for(Query q_tmp : arg_tr.getWorkSession().getQueryList()) {
//            
//            QueryTriplet qt_tmp     = (QueryTriplet)q_tmp;
//            Double currentEntropy   = this.applyForQuery(qt_tmp);
////            Double currentEntropy   = fr.univ_tours.li.mdjedaini.eab.tools.Utils.computeKL(qt_tmp.getResult().getCellList().getCellCollection());
//            if(!currentEntropy.isNaN()) {
//                entropyList.add(currentEntropy);
//            }
//            
//        }
//        
//        Double sum  = 0.;
//        for(Double d_tmp : entropyList) {
//            sum += d_tmp;
//        }
//        
//        result  = sum / entropyList.size();
//        
//        return result;
//    }
//    
//    /**
//     * 
//     * @param arg_q
//     * @return 
//     */
//    public MetricScore applyForQuery(Query arg_q) {
//        Double result   = 0.5;
//        
//        // we execute the queries first t get access to the cells
//        this.taskResolution.getTaskBundle().getCurrentUserLog().execute(Boolean.TRUE);
//        
//        // get the hierarchies that are not All
//        Integer nbHierarchies   = arg_q.getResult().getMultiMemberHierarchy().size();
//        
//        for(EAB_Cell c_tmp : arg_q.getResult().getCellList().getCellCollection()) {
//            
//            List<EAB_Cell> rollupNeighbors  = new ArrayList<>();
//            
//            
//            
//            CellList userLogCellList    = this.taskResolution.getTaskBundle().getCurrentUserLog().getCellList();
//            
//            for(EAB_Cell userLogCell : userLogCellList.getCellCollection()) {
//                
//                if(c_tmp.isDirectChildOfCell(userLogCell)) {
//                    
////                    System.out.print("La cellule:" + System.lineSeparator());
////                    System.out.print(c_tmp + System.lineSeparator());
////                    System.out.print("est la fille de la cellule:" + System.lineSeparator());
////                    System.out.print(userLogCell + System.lineSeparator());
//                    
//                    rollupNeighbors.add(c_tmp);
//                    
//                }
//                
//            }
//            
//            
//            
//        }
//        
//        
//        
//        return result;
//    }
//    
//    /**
//     * 
//     * @param known_cells
//     * @param arg_q
//     * @return 
//     */
//    private Double computeDistanceFromUniform(List<EAB_Cell> known_cells, Query arg_q) {
//        Double result   = 0.;
//        
//        List<EAB_Cell> cellList = new ArrayList<>(arg_q.getResult().getCellList().getCellCollection());
//        
//        List<Double> uniform    = new ArrayList<>();
//        List<Double> actual     = new ArrayList<>();
//        
//        Double sum  = 0.;
//        for(EAB_Cell c_tmp : cellList) {
//            sum += c_tmp.getValue();
//            actual.add(c_tmp.getValue());
//        }
//        
//        // uniformize arrays
//        uniform = new ArrayList<>(Collections.nCopies(cellList.size(), sum / cellList.size()));
//
//        result  = this.kl.computeNormalized(actual, uniform);
//        
//        return result;
//    }
//    
//    
//}
