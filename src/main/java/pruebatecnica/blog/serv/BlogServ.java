package pruebatecnica.blog.serv;

import pruebatecnica.blog.entity.Autor;
import pruebatecnica.blog.entity.Blog;
import pruebatecnica.blog.entity.DetalleComentario;

import java.util.List;

public interface BlogServ {

    void registrarAutor(Autor value);

    void registrarBlog(Blog value);

    Blog buscarBlog (Long idBlog);

    void registrarComentario(DetalleComentario value);

    void actualizarBlog(Blog value);

    List<Blog> consultarBlog(Long idBlog);
}
