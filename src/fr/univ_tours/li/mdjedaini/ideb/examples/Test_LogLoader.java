/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.examples;

import fr.univ_tours.li.mdjedaini.ideb.BenchmarkEngine;
import fr.univ_tours.li.mdjedaini.ideb.io.SaikuLogLoader;
import fr.univ_tours.li.mdjedaini.ideb.io.SimpleLogLoader;
import fr.univ_tours.li.mdjedaini.ideb.params.Parameters;
import fr.univ_tours.li.mdjedaini.ideb.struct.Log;
import fr.univ_tours.li.mdjedaini.ideb.struct.Session;


/**
 * This class builds graphs for each provided session.
 * Graphs are actually graph of cells composed by all the cells available in the query results for each session...
 * Some measures are also computed...
 * @author mahfoud
 */
public class Test_LogLoader {
    
    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        
        //Test_LogLoader tll  = new Test_LogLoader();
        
        BenchmarkEngine be  = new BenchmarkEngine();
        
        Parameters params   = be.getParameters();
        
        params.schemaFilePath   = "schema.xml";
        params.driver           = "nl.cwi.monetdb.jdbc.MonetDriver";
        params.jdbcUrl          = "jdbc:monetdb://127.0.0.1:50001/SSB";
        params.user             = "root";
        params.password         = "motdepasse";
        params.logFilePath      = "Workload-benchmark.xml";
        
        be.initDatasource();
        be.initCubeList();
        
        SimpleLogLoader sll = new SimpleLogLoader(be, "Sessions.txt");
        Log l   = sll.loadLog();
        
        //tll.saikuLogLoader("");
        
    }
    
    /**
     * 
     * @param arg_logPath 
     */
    public void saikuLogLoader(String arg_logPath) {
        Parameters params   = new Parameters();
        
        params.driver           = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        params.jdbcUrl          = "jdbc:sqlserver://10.195.25.10:54027";
        params.user             = "mahfoud";
        params.password         = "AvH4My327-vd";
        params.schemaFilePath   = "res/dopan/dopan_dw3.xml";
        
        BenchmarkEngine be  = new BenchmarkEngine(params);
        
        // creates and set connection
        be.initDatasource();
        
        // pick a random session from the log and execute it
        SaikuLogLoader  sll = new SaikuLogLoader(be, "res/dopan/cleanLogs/dibstudent03--2016-09-24--23-01.log");
        Log myLog           = sll.loadLog();
        
        System.out.println("Log summary:");
        System.out.println(myLog.logSummary());
        
        for(Session s_tmp : myLog.getSessionList()) {
            
            System.out.println(s_tmp.getSummary());
            
        }
    }
    
    
}
