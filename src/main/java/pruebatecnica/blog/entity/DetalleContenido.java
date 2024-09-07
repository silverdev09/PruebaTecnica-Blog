
package pruebatecnica.blog.entity;
import javax.persistence.*;
import java.io.Serializable;

/**
 * @author sipaco
 */
@Entity
@Table(name = "DETALLE_CONTENIDO")
@Cacheable(false)
public class DetalleContenido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_DETALLE_CONTENIDO")
    private Long id;

    @Basic
    @Column(name = "CONTENIDO")
    private String contenido;

    @Basic
    @Column(name = "IMAGEN")
    private String imagen;

    public DetalleContenido(Long id, String contenido, String imagen) {
        this.id = id;
        this.contenido = contenido;
        this.imagen = imagen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}



