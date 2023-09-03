package Database;
import java.sql.*;
public class CreateDatabase {
    public static Boolean CreaDb(String user, String pwd){
        String url = "jdbc:postgresql://localhost:5432/"; // URL di connessione al database PostgreSQL

        try {
            Connection connection = DriverManager.getConnection(url, user, pwd);
            Statement statement = connection.createStatement();

            String createDatabaseQuery = "CREATE DATABASE" +'"' +"Emo"+'"';

            String queryIfExist = "SELECT datname FROM pg_database WHERE datname = 'Emo';";

            String creaCanzoni="CREATE TABLE IF NOT EXISTS canzoni( codcanz character varying(500) COLLATE pg_catalog.default NOT NULL,titolo character varying(500) COLLATE pg_catalog.default NOT NULL,autore character varying(500) COLLATE pg_catalog.default NOT NULL,anno numeric NOT NULL,CONSTRAINT canzoni_pkey PRIMARY KEY (codcanz))";

            String creaEmozioni = "-- Table: public.emozioni\n" +
                    "\n" +
                    "-- DROP TABLE IF EXISTS public.emozioni;\n" +
                    "\n" +
                    "CREATE TABLE IF NOT EXISTS public.emozioni\n" +
                    "(\n" +
                    "    codcanz character varying(500) COLLATE pg_catalog.\"default\" NOT NULL,\n" +
                    "    emozione character varying(500) COLLATE pg_catalog.\"default\" NOT NULL,\n" +
                    "    voto numeric(2,1) NOT NULL,\n" +
                    "    codf character varying(500) COLLATE pg_catalog.\"default\" NOT NULL,\n" +
                    "    CONSTRAINT emozioni_pkey PRIMARY KEY (codcanz, emozione, codf),\n" +
                    "    CONSTRAINT emozioni_codcanz_fkey FOREIGN KEY (codcanz)\n" +
                    "        REFERENCES public.canzoni (codcanz) MATCH SIMPLE\n" +
                    "        ON UPDATE NO ACTION\n" +
                    "        ON DELETE NO ACTION,\n" +
                    "    CONSTRAINT emozioni_codf_fkey FOREIGN KEY (codf)\n" +
                    "        REFERENCES public.utenti (codf) MATCH SIMPLE\n" +
                    "        ON UPDATE NO ACTION\n" +
                    "        ON DELETE NO ACTION\n" +
                    ")\n" +
                    "\n" +
                    "TABLESPACE pg_default;\n" +
                    "\n" +
                    "ALTER TABLE IF EXISTS public.emozioni\n" +
                    "    OWNER to postgres;";
            String creaPlaylist = "-- Table: public.emozioni\n" +
                    "\n" +
                    "-- DROP TABLE IF EXISTS public.emozioni;\n" +
                    "\n" +
                    "CREATE TABLE IF NOT EXISTS public.emozioni\n" +
                    "(\n" +
                    "    codcanz character varying(500) COLLATE pg_catalog.\"default\" NOT NULL,\n" +
                    "    emozione character varying(500) COLLATE pg_catalog.\"default\" NOT NULL,\n" +
                    "    voto numeric(2,1) NOT NULL,\n" +
                    "    codf character varying(500) COLLATE pg_catalog.\"default\" NOT NULL,\n" +
                    "    CONSTRAINT emozioni_pkey PRIMARY KEY (codcanz, emozione, codf),\n" +
                    "    CONSTRAINT emozioni_codcanz_fkey FOREIGN KEY (codcanz)\n" +
                    "        REFERENCES public.canzoni (codcanz) MATCH SIMPLE\n" +
                    "        ON UPDATE NO ACTION\n" +
                    "        ON DELETE NO ACTION,\n" +
                    "    CONSTRAINT emozioni_codf_fkey FOREIGN KEY (codf)\n" +
                    "        REFERENCES public.utenti (codf) MATCH SIMPLE\n" +
                    "        ON UPDATE NO ACTION\n" +
                    "        ON DELETE NO ACTION\n" +
                    ")\n" +
                    "\n" +
                    "TABLESPACE pg_default;\n" +
                    "\n" +
                    "ALTER TABLE IF EXISTS public.emozioni\n" +
                    "    OWNER to postgres;";
            String creaUtenti = "-- Table: public.utenti\n" +
                    "\n" +
                    "-- DROP TABLE IF EXISTS public.utenti;\n" +
                    "\n" +
                    "CREATE TABLE IF NOT EXISTS public.utenti\n" +
                    "(\n" +
                    "    codf character varying(500) COLLATE pg_catalog.\"default\" NOT NULL,\n" +
                    "    nome character varying(500) COLLATE pg_catalog.\"default\" NOT NULL,\n" +
                    "    cognome character varying(500) COLLATE pg_catalog.\"default\" NOT NULL,\n" +
                    "    datanascita date NOT NULL,\n" +
                    "    email character varying(200) COLLATE pg_catalog.\"default\" NOT NULL,\n" +
                    "    username character varying(50) COLLATE pg_catalog.\"default\" NOT NULL,\n" +
                    "    password character varying(200) COLLATE pg_catalog.\"default\" NOT NULL,\n" +
                    "    CONSTRAINT utenti_pkey PRIMARY KEY (codf),\n" +
                    "    CONSTRAINT utenti_username_key UNIQUE (username),\n" +
                    "    CONSTRAINT utenti_username_key1 UNIQUE (username)\n" +
                    ")\n" +
                    "\n" +
                    "TABLESPACE pg_default;\n" +
                    "\n" +
                    "ALTER TABLE IF EXISTS public.utenti\n" +
                    "    OWNER to postgres;";

            ResultSet rs = statement.executeQuery(queryIfExist);
            String ris="";

            while (rs.next()){
                ris=rs.getString(1);
                System.out.println(ris);
            }
            if(ris.equals("Emo")){
                String ban="CREATE TABLE bananaa (id varchar(20) )";
                statement.execute(ban);
                System.out.println("già presente");
                return true;
            }else{
                String ban="CREATE TABLE bananaa (id varchar(20) )";

                //statement.executeUpdate(createDatabaseQuery);
                //statement.executeUpdate(createDatabaseQuery);
                statement.execute(ban);
                //statement.executeUpdate(creaUtenti);
                //statement.executeUpdate(creaPlaylist);
                //statement.executeUpdate(creaEmozioni);

                System.out.println("Database creato con successo!");
                return false;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

}

