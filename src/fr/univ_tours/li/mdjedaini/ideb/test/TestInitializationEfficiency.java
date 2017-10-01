/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.test;

import fr.univ_tours.li.mdjedaini.ideb.BenchmarkEngine;
import fr.univ_tours.li.mdjedaini.ideb.algo.gen.log.CubeloadGenerator;
import fr.univ_tours.li.mdjedaini.ideb.io.CubeloadLogLoader;
import fr.univ_tours.li.mdjedaini.ideb.params.Parameters;
import fr.univ_tours.li.mdjedaini.ideb.struct.Log;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author mahfoud
 */
public class TestInitializationEfficiency {
    
    /*
    Main function
    */
    public static void main(String[] args) {
        
        
        Parameters params       = new Parameters();
        params.schemaFilePath   = "res/cubeSchemas/ssb.xml";
        params.driver           = "nl.cwi.monetdb.jdbc.MonetDriver";
        params.jdbcUrl          = "jdbc:monetdb://127.0.0.1:50001/SSB";
        params.user             = "root";
        params.password         = "motdepasse";
        params.logFilePath      = "Workload-benchmark.xml";
        
        //be.initLog();
        
        // parameters for the log generation
        List<Integer> nbUsers       = new ArrayList();
        List<String> profiles       = new ArrayList<>();
        
        nbUsers.add(1);
        nbUsers.add(2);
        nbUsers.add(3);
        nbUsers.add(4);
        nbUsers.add(5);
        nbUsers.add(6);
        nbUsers.add(7);
        nbUsers.add(8);
        nbUsers.add(9);
        nbUsers.add(10);
        //nbUsers.add(50);
        
        //profiles.add("res/forCubeload/ssb/profile-10-sessions.xml");
        profiles.add("res/forCubeload/ssb/profile-50-sessions.xml");
        profiles.add("res/forCubeload/ssb/profile-100-sessions.xml");
        profiles.add("res/forCubeload/ssb/profile-250-sessions.xml");
        profiles.add("res/forCubeload/ssb/profile-500-sessions.xml");
        
        String output   = "";
        
        output  += "nbSessions,nbUsers,timeSessions,timeUsers";
                
        for(String profile : profiles) {
            
            for(Integer nbUsers_tmp : nbUsers) {
                BenchmarkEngine be  = new BenchmarkEngine(params);
                
                be.initDefaultModules();
                be.initDatasource();
                
                // -----------------------
                CubeloadGenerator cg    = new CubeloadGenerator(be);
        
                //cg.schemaFilePath       = "cubeload/ssb_for_cubeload/schema.xml";
                cg.setSchemaFilePath(params.schemaFilePath);
                cg.setDataDirectoryPath("res/forCubeload/ssb");
                
                cg.setProfileFilePath(profile);
        
                cg.setMinReportSize((Integer) 1);
                cg.setMaxReportSize((Integer) 2);
                
                be.setLogLoader(new CubeloadLogLoader(cg));
                params.setNbOfUsers(nbUsers_tmp);

                Long time_a = System.currentTimeMillis();
                
                be.initLog();
                
                Long time_b = System.currentTimeMillis();
                
                be.initUsers();
                Long time_c = System.currentTimeMillis();
                
                output  += System.lineSeparator();
                output  += profile + "," + nbUsers_tmp + "," + (time_b - time_a) + "," + (time_c - time_b);
                
                System.out.println("output:");
                System.out.println(output);
                
                //Log l_tmp   = cg.generateLog();
            }
        }
        
        System.out.println("Report on initialization");
        System.out.println(output);
        
    }
    
    
}
