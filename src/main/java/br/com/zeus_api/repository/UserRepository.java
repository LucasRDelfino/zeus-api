package br.com.zeus_api.repository;


import br.com.zeus_api.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUsuario(String usuario);
    boolean existsByUsuario(String usuario);
}
