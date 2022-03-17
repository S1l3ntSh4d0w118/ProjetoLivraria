package banco;

import dados.Livro;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Arrays;
import javax.swing.JOptionPane;

public class GerenciaCadastro
{
    Conecta objConecta = new Conecta();
    PreparedStatement stmt;
    //novo - criar - Antes criar a classe TabCad para utilizar esta classe!

    //Método para cadastrar os livros.
    public int cadastraLivro(Livro cadLivro) {
        int linha = 0;
        objConecta.conectandoBanco();
        try
        {
            String sql = "insert into tblivro (titulo, autor, genero, anopublicacao) values (?,?,?,?)";
            stmt = objConecta.conn.prepareStatement(sql);
            stmt.setString(1, cadLivro.getTitulo());
            stmt.setString(2, cadLivro.getAutor());
            stmt.setString(3, cadLivro.getGenero());
            stmt.setInt(4, cadLivro.getAnopublicacao());
            stmt.execute();
            stmt.close();
            linha = 1;
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        objConecta.desconecta();
        return linha;
    }

    //Método para alterar o cadastro de um livro.
    public int alterarLivro(Livro altLivro) 
    {
        int escolha = (JOptionPane.showConfirmDialog(null,
                "Deseja realmente editar os dados?", "Editar",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE));
        int res = 0;
        if(escolha == 0)
        {
            objConecta.conectandoBanco();
            String sql = "update tblivro set titulo=?, autor=?, genero=?, anopublicacao=? where codigo=?";
            try{
                stmt = objConecta.conn.prepareStatement(sql);
                
                stmt.setString(1, altLivro.getTitulo());
                stmt.setString(2, altLivro.getAutor());
                stmt.setString(3, altLivro.getGenero());
                stmt.setInt(4, altLivro.getAnopublicacao());
                stmt.setInt(5, altLivro.getCodigo());
                
                res = stmt.executeUpdate();
                
                stmt.close();
            }
            catch (SQLException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
        else
        {
            res = 3;
        }
        objConecta.desconecta();
        return res;
    }

    //Método para a consulta dos livros cadastrados.
    public boolean consultaLivro(Livro conLivro) 
    {
        boolean encontrado = false;
        objConecta.conectandoBanco();
        String sql = "select * from tblivro where titulo = ?";
        try
        {
          stmt = objConecta.conn.prepareStatement(sql);
          stmt.setString(1, conLivro.getTitulo());
          
          objConecta.rs = stmt.executeQuery();
          while (objConecta.rs.next())
          {
              encontrado = true;
          }
          stmt.close();
        }
        catch (SQLException ex)
        {
            System.out.println("Erro ao executar o comando executaSql - SQL! \n" + ex.getMessage());
        }
        objConecta.desconecta();
        return encontrado;
    }

    //Método para excluir o registro de um livro.
    public int excluir(Livro excLivro) {
        int res = 0;
        objConecta.conectandoBanco();
        String sql = "delete from tblivro where codigo = ?";

        try 
        {
            stmt = objConecta.conn.prepareStatement(sql);
            stmt.setInt(1,excLivro.getCodigo());

            res = stmt.executeUpdate();
            stmt.close();
        }
        catch (SQLException ex) 
        {
            System.out.println("Erro ao excluir!\n Erro:" + ex.getMessage());
        }
        objConecta.desconecta();
        return res;
    }
}