package proyecto.personal.dhario.videojuegos.Entities;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "videojuegos")
@SQLDelete(sql = "UPDATE videojuegos SET estado = false WHERE id = ?")
@Where(clause = "estado = true")
public class Videojuegos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "desarrolladora_id", referencedColumnName = "id")
    private Desarrolladora desarrolladora;

    @ManyToOne
    @JoinColumn(name = "genero_id", referencedColumnName = "id")
    private Genero genero;

    private String nombre;
    private String descripcion;
    private String portadaUno;
    private String portadaDos;
    private LocalDate fechaLanzamiento;
    private Boolean estado;

    @OneToMany (mappedBy = "videojuegos", fetch = FetchType.LAZY)
    private List<Personajes> personajes;

    @OneToMany (mappedBy = "videojuegos", fetch = FetchType.LAZY)
    private List<Disponible> disponible;

    @OneToMany (mappedBy = "videojuegos", fetch = FetchType.LAZY)
    private List<Resenia> resenia;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Desarrolladora getDesarrolladora() {
        return desarrolladora;
    }

    public void setDesarrolladora(Desarrolladora desarrolladora) {
        this.desarrolladora = desarrolladora;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
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

    public String getPortadaUno() {
        return portadaUno;
    }

    public void setPortadaUno(String portadaUno) {
        this.portadaUno = portadaUno;
    }

    public String getPortadaDos() {
        return portadaDos;
    }

    public void setPortadaDos(String portadaDos) {
        this.portadaDos = portadaDos;
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<Personajes> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(List<Personajes> personajes) {
        this.personajes = personajes;
    }

    public List<Disponible> getDisponible() {
        return disponible;
    }

    public void setDisponible(List<Disponible> disponible) {
        this.disponible = disponible;
    }

    public List<Resenia> getResenia() {
        return resenia;
    }

    public void setResenia(List<Resenia> resenia) {
        this.resenia = resenia;
    }

    @Override
    public String toString() {
        return "Videojuegos{" +
                "id=" + id +
                ", desarrolladora=" + desarrolladora +
                ", genero=" + genero +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", portadaUno='" + portadaUno + '\'' +
                ", portadaDos='" + portadaDos + '\'' +
                ", fechaLanzamiento=" + fechaLanzamiento +
                ", estado=" + estado +
                ", personajes=" + personajes +
                ", disponible=" + disponible +
                ", resenia=" + resenia +
                '}';
    }
}
