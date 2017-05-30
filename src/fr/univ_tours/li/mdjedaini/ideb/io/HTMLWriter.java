/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_tours.li.mdjedaini.ideb.io;

import java.io.PrintWriter;

/**
 *
 * @author mahfoud
 */
public class HTMLWriter {

    /**
     * 
     */
    public HTMLWriter() {
    }
    
    /**
     * 
     * @param arg_file
     * @param arg_body
     * @return 
     */
    public String printToFile(String arg_file, String arg_body) {
        String result   = "";
        
        result  += "<!DOCTYPE html>";
        result  += "<html>";
        result  += "<head>";
        result  += "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">";
        result  += "<link rel=\"stylesheet\" type=\"text/css\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\" />";
        result  += "<link rel=\"script\" type=\"text/javascript\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\" />";
        result  += "<title>Exploratory Analysis Benchmark</title>";
        
        result  += "<style> .discovery { border: 1px solid; margin: 15px 0px; background-color: #FFB; } </style>";
        
        result  += "</head>";
        result  += "<body>";
        result  += "<div class=\"container\">";
            
        result  += arg_body;

        result  += "</body>";
        result  += "</html>";
                    
        try {
            
            PrintWriter writer = new PrintWriter(arg_file, "UTF-8");
            writer.print(result);
            
        } catch(Exception e) {
            
            e.printStackTrace();
            
        }
        
        return result;
    }
    
}
