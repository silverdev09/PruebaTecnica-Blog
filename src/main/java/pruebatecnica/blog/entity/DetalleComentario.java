
package pruebatecnica.blog.entity;
import javax.persistence.*;
import java.io.Serializable;

/**
 * @author sipaco
 */
@Entity
@Table(name = "DETALLE_COMENTARIO")
@Cacheable(false)
public class DetalleComentario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_DETALLE_COMENTARIO")
    private Long id;

    @Basic
    @Column(name = "COMENTARIO")
    private String comentario;

    @Basic
    @Column(name = "PUNTUACION")
    private int puntuacion;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ID_PERSONA")
    private Persona persona;

    @ManyToMany
    @JoinColumn(name = "CODIGO_BLOG", nullable = false, updatable = false)
    private Blog blog;

    public DetalleComentario(String comentario, int puntuacion, Persona persona, Blog blog) {
        this.comentario = comentario;
        this.puntuacion = puntuacion;
        this.persona = persona;
        this.blog = blog;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}



