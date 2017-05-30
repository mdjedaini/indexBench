package fr.univ_tours.li.mdjedaini.ideb.olap.query;

/**
 * The class for fragments (so far only a string)
 */
public abstract class Fragment {

    QueryTriplet q;
    
    /**
     * The fragment under the String format
     */
    private String fragmentText;

    /**
     * 
     */
    public Fragment() {
    }

    /**
     *
     * @return
     */
    public QueryTriplet getQuery() {
        return this.q;
    }
    
    /**
     * 
     * @return 
     */
    public String toMDX() {
        String result   = "";
        
        result  = "Problem, this method should be overriden...";
        
        return result;
    }
    
    /**
     *
     * @return the name of the fragment
     */
    @Override
    public String toString() {
        return this.fragmentText;
    }
    
}
