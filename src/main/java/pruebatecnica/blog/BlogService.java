package pruebatecnica.blog;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import pruebatecnica.blog.entity.*;
import pruebatecnica.blog.serv.BlogServ;

import javax.ejb.EJB;
import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Path("/blogService")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BlogService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogService.class);

    @EJB
    private BlogServ serv;

    @PUT
    @Path("/crear/autor")
    public void registrarAutor(@FormParam("nombres") String nombres,
                              @FormParam("apellidoPaterno") String apellidoPaterno,
                              @FormParam("apellidoMaterno") String apellidoMaterno,
                              @FormParam("fechaNacimiento") Date fechaNacimiento,
                              @FormParam("paisResidencia") String paisResidencia,
                              @FormParam("correoElectronico") String correoElectronico,
                              @Context HttpServletResponse servletResponse) throws IOException {
        try {
            Autor autor = new Autor(nombres, apellidoPaterno, apellidoMaterno, fechaNacimiento, paisResidencia, correoElectronico);
            serv.registrarAutor(autor);
        } catch (PersistenceException e) {
            LOGGER.error("No se puede registrar autor: " + e.getCause());
        }
    }

    @PUT
    @Path("/crear/blog")
    public void registrarBlog(@FormParam("nombreTitulo") String nombreTitulo,
                                @FormParam("tema") String tema,
                                @FormParam("periodicidad") String periodicidad,
                                @FormParam("tieneComentario") boolean tieneComentario,
                                @FormParam("autor") Autor autor,
                                @FormParam("contenido") DetalleContenido detalleContenido,
                                @Context HttpServletResponse servletResponse) throws IOException {
        try {
            Blog blog = new Blog(null,nombreTitulo, tema, periodicidad, "A", tieneComentario, autor, detalleContenido);
            serv.registrarBlog(blog);
        } catch (PersistenceException e) {
            LOGGER.error("No se puede registrar blog: " + e.getCause());
        }
    }

    @PUT
    @Path("/agregar/comentario")
    public void registrarComentario(@FormParam("comentario") String comentario,
                              @FormParam("puntuacion") int puntuacion,
                              @FormParam("idBlog") Long idBlog,
                              @FormParam("persona") Persona persona,
                              @Context HttpServletResponse servletResponse) throws IOException {
        try {
            Blog blog = serv.buscarBlog(idBlog);
            if (blog.isTieneComentario()) {
                DetalleComentario detalleComentario = new DetalleComentario(comentario, puntuacion, persona, blog);
                serv.registrarComentario(detalleComentario);
            } else
                LOGGER.warn("El Blog con id: " + blog.getId() + " no admite comentarios.");
        } catch (InvalidParameterException | NotFoundException | PersistenceException  e) {
            LOGGER.error("No se puede registrar comentario:" + e.getCause());
        }
    }

    @POST
    @Path("/actualizar/blog")
    public void actualizarBlog(@FormParam("idBlog") Long idBlog,
                             @FormParam("nombreTitulo") String nombreTitulo,
                             @FormParam("tema") String tema,
                             @FormParam("periodicidad") String periodicidad,
                             @FormParam("estado") String estado,
                             @FormParam("tieneComentario") boolean tieneComentario,
                             @FormParam("autor") Autor autor,
                             @FormParam("contenido") DetalleContenido detalleContenido,
                             @Context HttpServletResponse servletResponse) throws IOException{
        try {
            Blog blog = new Blog(idBlog, nombreTitulo, tema, periodicidad, estado, tieneComentario, autor, detalleContenido);
            serv.actualizarBlog(blog);
        } catch (PersistenceException e) {
            LOGGER.error("No se puede actualizar el blog: " + e.getCause());
        }
    }

    @GET
    @Path("/consultar/blog")
    public List<Blog> consultarBlog(Long idBlog){
        List<Blog> listaBlog = new ArrayList<>();
        try{
            listaBlog = serv.consultarBlog(idBlog);
        } catch (NotFoundException e) {
            LOGGER.error("Error al consultar blog(s): " + e.getCause());
        }
        return listaBlog;
    }
}
