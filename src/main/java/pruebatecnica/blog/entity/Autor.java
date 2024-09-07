
package pruebatecnica.blog.entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author sipaco
 */
@Entity
@Table(name = "AUTOR")
@Cacheable(false)
public class Autor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_AUTOR")
    private Long id;

    @Basic
    @Column(name = "NOMBRES")
    private String nombres;

    @Basic
    @Column(name = "APELLIDO_PATERNO")
    private String apellidoPaterno;

    @Basic
    @Column(name = "APELLIDO_MATERNO")
    private String apellidoMaterno;

    @Basic
    @Column(name = "FECHA_NACIMIENTO")
    private Date fechaNacimiento;

    @Basic
    @Column(name = "PAIS_RESIDENCIA")
    private String paisResidencia;

    @Basic
    @Column(name = "CORREO_ELECTRONICO")
    private String correoElectronico;

    public Autor(String nombres, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, String paisResidencia, String correoElectronico) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.paisResidencia = paisResidencia;
        this.correoElectronico = correoElectronico;
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

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPaisResidencia() {
        return paisResidencia;
    }

    public void setPaisResidencia(String paisResidencia) {
        this.paisResidencia = paisResidencia;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
}