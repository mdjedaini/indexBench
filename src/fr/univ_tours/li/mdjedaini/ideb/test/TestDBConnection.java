/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.test;

import fr.univ_tours.li.mdjedaini.ideb.BenchmarkEngine;
import fr.univ_tours.li.mdjedaini.ideb.infrastructure.MonetDB;
import fr.univ_tours.li.mdjedaini.ideb.io.CsvLogLoader;
import fr.univ_tours.li.mdjedaini.ideb.io.SimpleLogLoader;
import fr.univ_tours.li.mdjedaini.ideb.olap.query.Query;
import fr.univ_tours.li.mdjedaini.ideb.params.Parameters;
import fr.univ_tours.li.mdjedaini.ideb.struct.Log;


/**
 * This class allows to test query execution.
 * @author mahfoud
 */
public class TestDBConnection {
    
    /*
    Main function
    */
    public static void main(String[] args) {
        TestDBConnection tdbc   = new TestDBConnection();
        
//        tdbc.testVegaOracle();
        tdbc.testSmartBIOracle();
    }
    
    /**
     * 
     */
    public void testVegaOracle() {
        Parameters params   = new Parameters();
        
        params.driver   = "oracle.jdbc.OracleDriver";
        params.jdbcUrl  = "jdbc:oracle:thin:@127.0.0.1:11521:db01";
        params.user     = "mahfoud";
        params.password = "djedaini";
        params.schemaFilePath   = "res/ipums/ipums500K.xml";
        params.cubeName         = "IPUMS";
        params.rebuildConnectionString();
        
        BenchmarkEngine be  = new BenchmarkEngine(params);
        
        be.initDatasource();
        
        SimpleLogLoader sll = new SimpleLogLoader(be, "res/ipums/logs/BDTLN/0_139191_23-05-2014-04-24-59.txt");
        Log l   = sll.loadLog();
        
        System.out.println(l.logSummary());
        
        System.out.println(be.getParameters().getMondrianConnectionString());
    }
    
    /**
     * 
     */
    public void testSmartBIOracle() {
        Parameters params   = new Parameters();
        
        params.driver   = "oracle.jdbc.OracleDriver";
        params.jdbcUrl  = "jdbc:oracle:thin:@127.0.0.1:11521:db01";
        params.user     = "smartbi";
        params.password = "bismart";
        params.schemaFilePath   = "res/cubeSchemas/smartBI.xml";
        //params.cubeName         = "IPUMS";
        params.rebuildConnectionString();
        
        BenchmarkEngine be  = new BenchmarkEngine(params);
        
        be.initDatasource();
        
        CsvLogLoader sll = new CsvLogLoader(be, "/home/mahfoud/Desktop/IS_ADBIS/logs");
//        CsvLogLoader sll = new CsvLogLoader(be, "/home/mahfoud/Desktop/IS_ADBIS/logs/debug_user-I050648_session-B34FE261C41F1CECA723A22B5D5BB74C4AC140931465D2DA8F3A7033ABC96D46.csv");
        Log l   = sll.loadLog();
        
        //l.execute(Boolean.FALSE);
        
        for(Query q_tmp : l.getQueryList()) {
            System.out.println("Query");
            System.out.println(q_tmp);
        }
        
        System.out.println(l);
        
        //System.out.println(be.getParameters().getMondrianConnectionString());
    }
    
    /**
     * 
     */
    public void testMonetDB() {
        Parameters params   = new Parameters();
        
        params.driver   = "nl.cwi.monetdb.jdbc.MonetDriver";
        params.jdbcUrl  = "jdbc:monetdb://127.0.0.1:50001/SSB";
        params.user     = "root";
        params.password = "motdepasse";
        params.rebuildConnectionString();
        
        BenchmarkEngine be  = new BenchmarkEngine(params);
        
        be.initDatasource();
        
        System.out.println(be.getParameters().getMondrianConnectionString());
    }

    /**
     * 
     */
    public void testMySQL() {
        BenchmarkEngine be  = new BenchmarkEngine();
        
        be.getParameters().driver   = "nl.cwi.monetdb.jdbc.MonetDriver";
        be.getParameters().jdbcUrl  = "jdbc:monetdb://127.0.0.1:50001/SSB";
        be.getParameters().user     = "root";
        be.getParameters().password = "motdepasse";
        be.getParameters().rebuildConnectionString();
        
        MonetDB mdb = new MonetDB(be.getParameters().jdbcUrl, "root", "motdepasse");
        mdb.connect();
        
        //mdb.submit("select * from lineorder limit 10");
        
        System.out.println(be.getParameters().getMondrianConnectionString());
    }
    
    /**
     * 
     */
    public void testSQLServer() {
        Parameters params   = new Parameters();
        
        params.driver           = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        params.jdbcUrl          = "jdbc:sqlserver://10.195.25.10:54027";
        params.user             = "mahfoud";
        params.password         = "AvH4My327-vd";
        params.schemaFilePath   = "res/dopan/dopan_dw3.xml";
        
        BenchmarkEngine be  = new BenchmarkEngine(params);
        
        be.initDatasource();
    }
}
