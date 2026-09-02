package eventos.rental.services;

import org.springframework.stereotype.Service;

import eventos.rental.exceptions.AutenticacaoException;
import eventos.rental.models.Usuario;
import eventos.rental.repositories.UsuarioRepository;

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

    /*
     * Comparacao de senha em texto puro - serve so para o projeto
     * academico atual. Antes de ir para producao, troque por hash
     * (BCryptPasswordEncoder) tanto aqui quanto em salvar().
     */
    public Usuario autenticar(String email, String senha) {

        Usuario usuario;

        try {
            usuario = buscarPorEmail(email);
        } catch (RuntimeException ex) {
            throw new AutenticacaoException("E-mail ou senha inválidos.");
        }

        if (senha == null || !senha.equals(usuario.getSenha())) {
            throw new AutenticacaoException("E-mail ou senha inválidos.");
        }

        return usuario;
    }
}
