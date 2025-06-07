package br.com.zeus_api.controller;

import br.com.zeus_api.dto.UserDTO;
import br.com.zeus_api.entity.Users;
import br.com.zeus_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    private UserDTO convertToDTO(Users user) {
        return new UserDTO(
                user.getId(),
                user.getUsuario(),
                user.getCidade()
        );
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserDTO> users = userService.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        Users user = userService.findById(id);
        return ResponseEntity.ok(convertToDTO(user));
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody Users usuario) {
        Users createdUser = userService.create(usuario);
        return ResponseEntity.status(201).body(convertToDTO(createdUser));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody Users usuarioAtualizado) {
        Users updatedUser = userService.update(id, usuarioAtualizado);
        return ResponseEntity.ok(convertToDTO(updatedUser));
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody Users usuario) {
        Users loggedUser = userService.login(usuario.getUsuario(), usuario.getSenha());
        return ResponseEntity.ok(convertToDTO(loggedUser));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}