package br.com.zeus_api.service;

import br.com.zeus_api.entity.Users;
import br.com.zeus_api.repository.UserRepository;
import br.com.zeus_api.util.SimplePasswordHasher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Service
public class UserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<Users> findAll() {
        return repository.findAll();
    }

    public Users findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Usuário não encontrado"));
    }

    public Users create(Users usuario) {
        if (repository.existsByUsuario(usuario.getUsuario())) {
            throw new ResponseStatusException(CONFLICT, "Nome de usuário já está em uso");
        }

        usuario.setSenha(SimplePasswordHasher.hashPassword(usuario.getSenha()));
        return repository.save(usuario);
    }

    public Users update(Long id, Users usuarioAtualizado) {
        return repository.findById(id)
                .map(usuario -> {
                    if (!usuario.getUsuario().equals(usuarioAtualizado.getUsuario())) {
                        if (repository.existsByUsuario(usuarioAtualizado.getUsuario())) {
                            throw new ResponseStatusException(CONFLICT, "Nome de usuário já está em uso");
                        }
                    }

                    usuario.setUsuario(usuarioAtualizado.getUsuario());

                    // Atualiza a senha apenas se foi alterada
                    if (usuarioAtualizado.getSenha() != null && !usuarioAtualizado.getSenha().isEmpty()) {
                        usuario.setSenha(SimplePasswordHasher.hashPassword(usuarioAtualizado.getSenha()));
                    }

                    usuario.setCidade(usuarioAtualizado.getCidade());

                    return repository.save(usuario);
                })
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Usuário não encontrado"));
    }

    public Users login(String usuario, String senha) {
        Users user = repository.findByUsuario(usuario)
                .orElseThrow(() -> new ResponseStatusException(UNAUTHORIZED, "Usuário ou senha inválidos"));

        if (!SimplePasswordHasher.checkPassword(senha, user.getSenha())) {
            throw new ResponseStatusException(UNAUTHORIZED, "Usuário ou senha inválidos");
        }

        return user;
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(NOT_FOUND, "Usuário não encontrado");
        }
        repository.deleteById(id);
    }
}