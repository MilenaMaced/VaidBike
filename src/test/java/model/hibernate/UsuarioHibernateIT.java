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
package model.hibernate;

import java.util.ArrayList;
import java.util.List;
import model.classes.Usuario;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Milena Macedo
 */
public class UsuarioHibernateIT {

//  private static ConexãoDBUnit conexao;
//  private static EntityManagerFactory factory;
//   
//  private EntityManager manager;
//  private UsuarioHibernate user;
// 
//  @BeforeClass
//  public static void initClass() {
//    conexao = new ConexãoDBUnit("UsuarioHibernate_DBUnitXml");
//    factory = Persistence.createEntityManagerFactory("aTesteIntegracaoDbunit");
//  }
// 
//  @Before
//  public void init() {
//    conexao.execute(DatabaseOperation.DELETE_ALL, "UsuarioHibernate_DBUnitXml.xml");
// 
//    conexao.execute(DatabaseOperation.INSERT, "UsuarioHibernate_DBUnitXml.xml");
// 
//    manager = factory.createEntityManager();
//    this.user = new UsuarioHibernate(manager);
//  }
//   
//  @After
//  public void end() {
//    this.manager.close();
//  }
    public UsuarioHibernateIT() {
    }

    /**
     * Test of getInstance method, of class UsuarioHibernate.
     */
    @Test
    public void testGetInstance() {

    }

    /**
     * Test of recuperar method, of class UsuarioHibernate.
     */
    @Test
    public void testRecuperar_String() {
    }

    /**
     * Test of recuperar method, of class UsuarioHibernate.
     */
    @Test
    public void testRecuperar_String_String() {

    }

    /**
     * Test of inserir method, of class UsuarioHibernate.
     */
    @Test
    public void testInserir() {

    }

    /**
     * Test of alterar method, of class UsuarioHibernate.
     */
    @Test
    public void testAlterar() {

    }

    /**
     * Test of recuperar method, of class UsuarioHibernate.
     */
    @Test
    public void testRecuperar_int() {

    }

    /**
     * Test of deletar method, of class UsuarioHibernate.
     */
    @Test
    public void testDeletar() {

    }

    /**
     * Test of listarTodos method, of class UsuarioHibernate.
     */
    @Test
    public void testListarTodos() {
        UsuarioHibernate user = new UsuarioHibernate();
        List<Usuario> resultado = user.listarTodos();
        List<Usuario> retuldaoAtual = new ArrayList<>();
        Assert.assertEquals(resultado, retuldaoAtual);

    }

}
