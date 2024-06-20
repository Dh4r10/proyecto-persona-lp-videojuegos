package proyecto.personal.dhario.videojuegos.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "disponible")
public class Disponible {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "videojuegos_id", referencedColumnName = "id")
    private Videojuegos videojuegos;

    @ManyToOne
    @JoinColumn(name = "plataformas_id", referencedColumnName = "id")
    private Plataformas plataformas;

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

    public Plataformas getPlataformas() {
        return plataformas;
    }

    public void setPlataformas(Plataformas plataformas) {
        this.plataformas = plataformas;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Disponible{" +
                "id=" + id +
                ", videojuegos=" + videojuegos +
                ", plataformas=" + plataformas +
                ", estado=" + estado +
                '}';
    }
}
