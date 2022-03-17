package dados;

public class Livro
{
    private int codigo;
    private String titulo;
    private String autor;
    private String genero;
    private int anopublicacao;

    public int getCodigo()
    {
        return codigo;
    }

    public void setCodigo(int codigo)
    {
        this.codigo = codigo;
    }

    public String getTitulo()
    {
        return titulo;
    }

    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }

    public String getAutor()
    {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero()
    {
        return genero;
    }

    public void setGenero(String genero)
    {
        this.genero = genero;
    }

    public int getAnopublicacao()
    {
        return anopublicacao;
    }

    public void setAnopublicacao(int anopublicacao)
    {
        this.anopublicacao = anopublicacao;
    }
}