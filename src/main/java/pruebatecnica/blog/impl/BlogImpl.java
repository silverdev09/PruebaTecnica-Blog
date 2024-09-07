package pruebatecnica.blog.impl;

import pruebatecnica.blog.dao.BlogDao;
import pruebatecnica.blog.entity.*;
import pruebatecnica.blog.serv.BlogServ;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.PersistenceException;
import javax.ws.rs.NotFoundException;
import java.security.InvalidParameterException;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Stateless
@Local(BlogServ.class)
public class BlogImpl implements BlogServ {

    @EJB
    private BlogDao blogDao;

    @Override
    public void registrarAutor(Autor value) {
        Autor autor = blogDao.registrarAutor(value);
        if (autor == null) throw new PersistenceException();
    }

    @Override
    public void registrarBlog(Blog value) {
        Autor autor = blogDao.registrarAutor(value.getAutor());
        if (autor == null) throw new PersistenceException();
        DetalleContenido detalleContenido = blogDao.registrarContenido(value.getDetalleContenido());
        if (detalleContenido == null) throw new PersistenceException();
        value.setAutor(autor);
        value.setDetalleContenido(detalleContenido);
        value.setCodigoBlog(codigoGenerico());
        blogDao.registrarBlog(value);
    }

    @Override
    public void registrarComentario(DetalleComentario value) {
        if (value.getPuntuacion() > 10) throw new InvalidParameterException();
        if (value.getPuntuacion() < 0) throw new InvalidParameterException();
        Persona persona = blogDao.registrarPersona(value.getPersona());
        if (persona == null) throw new PersistenceException();
        value.setPersona(persona);
        blogDao.registrarComentario(value);
    }

    @Override
    public void actualizarBlog(Blog value) {
        Blog blogAntiguo = blogDao.buscarBlog(value.getId());
        blogAntiguo.setEstado("I");
        blogDao.actualizarBlog(blogAntiguo);
        value.setId(null);
        value.setCodigoBlog(blogAntiguo.getCodigoBlog());
        value.setEstado("A");
        blogDao.registrarBlog(value);
    }

    @Override
    public List<Blog> consultarBlog(Long idBlog) {
        List<Blog> listaBlog = blogDao.consultarBlog(idBlog);
        if (idBlog != null && listaBlog.isEmpty()) throw new NotFoundException();
        for (Blog b : listaBlog) {
            List<DetalleComentario> listaComentarios = b.getDetalleComentarios();

            //// Obtiene maximo puntuacion de comentarios del blog
            DetalleComentario maximo = listaComentarios
                    .stream()
                    .max(Comparator.comparing(DetalleComentario::getPuntuacion))
                    .orElseThrow(NotFoundException::new);
            b.setMaximoPuntuacion(maximo.getPuntuacion());

            //// Obtiene minimo puntuacion de comentarios del blog
            DetalleComentario minimo = listaComentarios
                    .stream()
                    .min(Comparator.comparing(DetalleComentario::getPuntuacion))
                    .orElseThrow(NotFoundException::new);
            b.setMinimoPuntuacion(minimo.getPuntuacion());

            //// Obtiene puntuacion promedio de comentarios del blog
            AtomicInteger total = new AtomicInteger(0);
            listaComentarios.forEach(c -> {
                total.set(total.get() + c.getPuntuacion());
            });
            int promedio = total.intValue() / listaComentarios.size();
            b.setPuntuacionPromedio(promedio);

        }
        return listaBlog;
    }

    @Override
    public Blog buscarBlog(Long idBlog) {
        Blog blog = blogDao.buscarBlog(idBlog);
        if (blog == null) throw new NotFoundException();
        return blog;
    }

    private String codigoGenerico() {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 20;
        Random random = new Random();
        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString().toUpperCase();
    }

}
