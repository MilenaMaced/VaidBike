/*MIT License

Copyright (c) 2018 Milena dos Santos Macedo, Carlos André Cordeiro da Silva, Adrielly Calado Sales, Luciano Campos de Lima Júnior.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package dbUnitXml;
/**
 *
 * @author Milena Macedo - milenasantosmcd@gmail.com
 */
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.postgresql.PostgresqlDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;

public class ConexãoDBUnit {

    private Connection conexao;
    private DatabaseConnection conexaoDBUnit;
    private String xmlFolder;

    public ConexãoDBUnit(String xmlFolder) {
        
        this.xmlFolder = xmlFolder;

        try {
            
            Class.forName("org.postgresql.Driver").newInstance();
            conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/VaidBike", "root", "root");
            conexaoDBUnit = new DatabaseConnection(conexao);
            DatabaseConfig config = conexaoDBUnit.getConfig();
            config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new PostgresqlDataTypeFactory());
            
        } catch (Exception e) {
            throw new RuntimeException("Erro inicializando DBUnit", e);
        }
    }

    public void execute(DatabaseOperation operation, String xml) {
        try {
            InputStream is = getClass().getResourceAsStream("/" + xmlFolder + "/" + xml);
            FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
            IDataSet dataSet = builder.build(is);

            operation.execute(conexaoDBUnit, dataSet);
            
        } catch (Exception e) {
            throw new RuntimeException("Erro executando DbUnit", e);
       }
    }

    public void close() {
        try {
            conexaoDBUnit.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
