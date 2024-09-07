
package pruebatecnica.blog.entity;
import javax.persistence.*;
import java.io.Serializable;

/**
 * @author sipaco
 */
@Entity
@Table(name = "PERSONA")
@Cacheable(false)
public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_PERSONA")
    private Long id;

    @Basic
    @Column(name = "NOMBRES")
    private String nombres;

    @Basic
    @Column(name = "CORREO_ELECTRONICO")
    private String correoElectronico;

    @Basic
    @Column(name = "PAIS_RESIDENCIA")
    private String paisResidencia;

    public Persona(Long id, String nombres, String correoElectronico, String paisResidencia) {
        this.id = id;
        this.nombres = nombres;
        this.correoElectronico = correoElectronico;
        this.paisResidencia = paisResidencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getPaisResidencia() {
        return paisResidencia;
    }

    public void setPaisResidencia(String paisResidencia) {
        this.paisResidencia = paisResidencia;
    }
}



