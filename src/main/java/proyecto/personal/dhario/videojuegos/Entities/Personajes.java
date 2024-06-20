package proyecto.personal.dhario.videojuegos.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "personajes")
public class Personajes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "videojuegos_id", referencedColumnName = "id")
    private Videojuegos videojuegos;

    private String tipoPersonaje;
    private String nombre;
    private String descripcion;
    private String imagen;
    private Boolean vivo;
    private Boolean estado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Videojuegos getVideojuegos() {
        return videojuegos;
    }

    public void setVideojuegos(Videojuegos videojuegos) {
        this.videojuegos = videojuegos;
    }

    public String getTipoPersonaje() {
        return tipoPersonaje;
    }

    public void setTipoPersonaje(String tipoPersonaje) {
        this.tipoPersonaje = tipoPersonaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Boolean getVivo() {
        return vivo;
    }

    public void setVivo(Boolean vivo) {
        this.vivo = vivo;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Personajes{" +
                "id=" + id +
                ", videojuegos=" + videojuegos +
                ", tipoPersonaje='" + tipoPersonaje + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", imagen='" + imagen + '\'' +
                ", vivo=" + vivo +
                ", estado=" + estado +
                '}';
    }
}
