package Database;

import java.io.Serial;
import java.io.Serializable;

/**
 * Classe che definisce la query
 * @author
 * @author
 */
public class Query implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String query;

    /**
     * Costruttore della classe Database.Database.Database.Query avente un solo parametro
     * @param query Stringa contenente la query
     */
    public Query(String query){
        this.query = query;
    }

    /**
     * Metodo che restituisce la query
     * @return Il metodo ritorna come stringa la query
     */
    public String getQuery() {
        return query;
    }
}