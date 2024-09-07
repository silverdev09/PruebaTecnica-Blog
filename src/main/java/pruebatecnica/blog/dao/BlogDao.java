package pruebatecnica.blog.dao;

import pruebatecnica.blog.entity.*;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean
public class BlogDao {
    @PersistenceContext(unitName = "unit-blog")
    private EntityManager em;

    public Blog buscarBlog(Long idBlog) {
        return em.find(Blog.class, idBlog);
    }

    public Autor registrarAutor(Autor value) {
        em.persist(value);
        return value;
    }

    public Persona registrarPersona(Persona value) {
        em.persist(value);
        return value;
    }

    public DetalleContenido registrarContenido(DetalleContenido value) {
        em.persist(value);
        return value;
    }

    public void registrarBlog(Blog value) {
        em.persist(value);
    }

    public void registrarComentario(DetalleComentario value) {
        em.persist(value);
    }

    public void actualizarBlog(Blog value) {
        em.merge(value);
    }

    public List<Blog> consultarBlog (Long idBlog) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT o FROM Blog o WHERE o.estado = 'A'");
        if (idBlog != null) sql.append(" AND o.id = :idBlog");
        TypedQuery<Blog> q = em.createQuery(String.valueOf(sql), Blog.class);
        if (idBlog != null) q.setParameter("idBlog", idBlog);
        return q.getResultList();
    }

}
