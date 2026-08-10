package eventos.rental.services;

import eventos.rental.model.Usuario;
import eventos.rental.repository.usuariorepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario buscarPorEmail(String email) {

        return repository.findByEmailAndAtivoTrue(email)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Usuário não encontrado ou inativo."
                        )
                );
    }

    public Usuario buscarPorId(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Usuário não encontrado."
                        )
                );
    }

    public Usuario salvar(Usuario usuario) {

        if (usuario.getNome() == null ||
                usuario.getNome().isBlank()) {

            throw new IllegalArgumentException(
                    "O nome é obrigatório."
            );
        }

        if (usuario.getEmail() == null ||
                usuario.getEmail().isBlank()) {

            throw new IllegalArgumentException(
                    "O e-mail é obrigatório."
            );
        }

        if (usuario.getSenha() == null ||
                usuario.getSenha().isBlank()) {

            throw new IllegalArgumentException(
                    "A senha é obrigatória."
            );
        }

        return repository.save(usuario);
    }
}