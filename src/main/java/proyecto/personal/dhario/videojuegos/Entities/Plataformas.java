package proyecto.personal.dhario.videojuegos.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "plataformas")
public class Plataformas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private Boolean estado;

    @OneToMany (mappedBy = "plataformas", fetch = FetchType.LAZY)
    private List<Disponible> disponible;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<Disponible> getDisponible() {
        return disponible;
    }

    public void setDisponible(List<Disponible> disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Plataformas{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", estado=" + estado +
                ", disponible=" + disponible +
                '}';
    }
}
