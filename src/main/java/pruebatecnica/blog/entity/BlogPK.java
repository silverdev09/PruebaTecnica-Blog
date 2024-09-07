package pruebatecnica.blog.entity;

import java.io.Serializable;
import java.util.Objects;

public class BlogPK implements Serializable {

    private Long id;

    private String codigoBlog;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlogPK blogPK = (BlogPK) o;
        return Objects.equals(id, blogPK.id) && Objects.equals(codigoBlog, blogPK.codigoBlog);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigoBlog);
    }
}
