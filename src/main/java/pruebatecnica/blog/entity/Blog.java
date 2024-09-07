
package pruebatecnica.blog.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author sipaco
 */
@Entity
@Table(name = "BLOG")
@Cacheable(false)
@IdClass(BlogPK.class)
public class Blog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_BLOG")
    private Long id;

    @Id
    @Column(name = "CODIGO_BLOG")
    private String codigoBlog;

    @Basic
    @Column(name = "NOMBRE_TITULO")
    private String nombreTitulo;

    @Basic
    @Column(name = "TEMA")
    private String tema;

    @Basic
    @Column(name = "PERIODICIDAD")
    private String periodicidad;

    @Basic
    @Column(name = "ESTADO")
    private String estado;

    @Basic
    @Column(name = "TIENE_COMENTARIO")
    private boolean tieneComentario;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_AUTOR")
    private Autor autor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_DETALLE_CONTENIDO")
    private DetalleContenido detalleContenido;

    @ManyToMany (cascade = CascadeType.ALL, mappedBy = "blog")
    private List<DetalleComentario> detalleComentarios;

    @Transient
    private int minimoPuntuacion;
    @Transient
    private int maximoPuntuacion;
    @Transient
    private int puntuacionPromedio;

    public Blog(Long idBlog, String nombreTitulo, String tema, String periodicidad, String estado, boolean tieneComentario, Autor autor, DetalleContenido detalleContenido) {
        this.id = idBlog;
        this.nombreTitulo = nombreTitulo;
        this.tema = tema;
        this.periodicidad = periodicidad;
        this.estado = estado;
        this.tieneComentario = tieneComentario;
        this.autor = autor;
        this.detalleContenido = detalleContenido;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoBlog() {
        return codigoBlog;
    }

    public void setCodigoBlog(String codigoBlog) {
        this.codigoBlog = codigoBlog;
    }

    public String getNombreTitulo() {
        return nombreTitulo;
    }

    public void setNombreTitulo(String nombreTitulo) {
        this.nombreTitulo = nombreTitulo;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isTieneComentario() {
        return tieneComentario;
    }

    public void setTieneComentario(boolean tieneComentario) {
        this.tieneComentario = tieneComentario;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public DetalleContenido getDetalleContenido() {
        return detalleContenido;
    }

    public void setDetalleContenido(DetalleContenido detalleContenido) {
        this.detalleContenido = detalleContenido;
    }

    public List<DetalleComentario> getDetalleComentarios() {
        return detalleComentarios;
    }

    public void setDetalleComentarios(List<DetalleComentario> detalleComentarios) {
        this.detalleComentarios = detalleComentarios;
    }

    public int getMinimoPuntuacion() {
        return minimoPuntuacion;
    }

    public void setMinimoPuntuacion(int minimoPuntuacion) {
        this.minimoPuntuacion = minimoPuntuacion;
    }

    public int getMaximoPuntuacion() {
        return maximoPuntuacion;
    }

    public void setMaximoPuntuacion(int maximoPuntuacion) {
        this.maximoPuntuacion = maximoPuntuacion;
    }

    public int getPuntuacionPromedio() {
        return puntuacionPromedio;
    }

    public void setPuntuacionPromedio(int puntuacionPromedio) {
        this.puntuacionPromedio = puntuacionPromedio;
    }
}



