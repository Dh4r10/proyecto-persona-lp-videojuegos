package proyecto.personal.dhario.videojuegos.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import proyecto.personal.dhario.videojuegos.Entities.Users;
import proyecto.personal.dhario.videojuegos.Repositories.UsersRepository;

@Service
public class UsersService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepository.findByUsername(username);

        if (user != null) {
            var springUser = User.withUsername(user.getUsername())
                    .password(user.getPassword())
                    .roles(user.getRoles().getAuthority())
                    .build();
            return springUser;
        }

        return null;
    }
}
