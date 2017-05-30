package fr.univ_tours.li.mdjedaini.ideb.algo;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package fr.univ_tours.li.mdjedaini.eab.algo;
//
//import fr.univ_tours.li.mdjedaini.eab.eval.Exploration;
//import fr.univ_tours.li.mdjedaini.eab.olap.query.Query;
//import fr.univ_tours.li.mdjedaini.eab.olap.result.Result;
//import fr.univ_tours.li.mdjedaini.eab.struct.CellList;
//import fr.univ_tours.li.mdjedaini.eab.struct.Session;
//import java.util.Map;
//import java.util.TreeMap;
//import mondrian.olap.Member;
//import mondrian.olap.Position;
//
///**
// *
// * @author mahfoud
// */
//public class MemberFrequencyFocusDetection implements I_FocusDetection {
//
//    /**
//     * 
//     * @param arg_exp
//     * @return 
//     */
//    @Override
//    public CellList computeFocus(Exploration arg_exp) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        
//        for(Session s_tmp : myLog.getSessionList()) {
//            
//            Map<String, Integer> occurrences    = new TreeMap<>();
//            
//            for(Query q_tmp : s_tmp.getQueryList()) {
//                Result res  = q_tmp.execute(Boolean.TRUE);
//                
//                mondrian.olap.Result mr = res.getMondrianResult();
//                
//                for(Position p_tmp : mr.getAxes()[0].getPositions()) {
//                    
//                    for(Member m_tmp : p_tmp) {
//                        
//                        if(!occurrences.containsKey(m_tmp.getName())) {
//                            occurrences.put(m_tmp.getName(), 1);
//                        } else {
//                            occurrences.put(m_tmp.getName(), occurrences.get(m_tmp.getName()) + 1);
//                        }
//                        
//                    }
//                    
//                }
//                
//                if(mr.getAxes().length > 1) {
//                    
//                    for(Position p_tmp : mr.getAxes()[1].getPositions()) {
//                    
//                        for(Member m_tmp : p_tmp) {
//                        
//                            if(!occurrences.containsKey(m_tmp.getName())) {
//                                occurrences.put(m_tmp.getName(), 1);
//                            } else {
//                                occurrences.put(m_tmp.getName(), occurrences.get(m_tmp.getName()) + 1);
//                            }
//                            
//                        }
//                    
//                    }
//                    
//                }
//                
//            }
//            
//            System.out.println("Occurrences:");
//            
//            for(String k_tmp : occurrences.keySet()) {
//                System.out.println(k_tmp + ": " + occurrences.get(k_tmp));
//            }
//    }
//    
//}
