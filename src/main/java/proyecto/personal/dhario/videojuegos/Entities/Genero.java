package proyecto.personal.dhario.videojuegos.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "genero")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private Boolean estado;

    @OneToMany (mappedBy = "genero", fetch = FetchType.EAGER)
    private List<Videojuegos> videojuegos;


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

    public List<Videojuegos> getVideojuegos() {
        return videojuegos;
    }

    public void setVideojuegos(List<Videojuegos> videojuegos) {
        this.videojuegos = videojuegos;
    }

    @Override
    public String toString() {
        return "Genero{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", estado=" + estado +
                ", videojuegos=" + videojuegos +
                '}';
    }
}
