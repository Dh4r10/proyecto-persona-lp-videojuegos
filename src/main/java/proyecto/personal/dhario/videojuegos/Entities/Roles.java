package proyecto.personal.dhario.videojuegos.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String authority;

    @OneToMany (mappedBy = "roles", fetch = FetchType.LAZY)
    private List<Users> users;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", authority='" + authority + '\'' +
                ", users=" + users +
                '}';
    }
}
