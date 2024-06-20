package proyecto.personal.dhario.videojuegos.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "resenia")
public class Resenia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "videojuegos_id", referencedColumnName = "id")
    private Videojuegos videojuegos;

    private Integer estrellas;
    private String descripcion;
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

    public Integer getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(Integer estrellas) {
        this.estrellas = estrellas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Resenia{" +
                "id=" + id +
                ", videojuegos=" + videojuegos +
                ", estrellas=" + estrellas +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                '}';
    }
}
