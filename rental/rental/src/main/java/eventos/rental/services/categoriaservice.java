package eventos.rental.services;

import eventos.rental.services.Categoria;
import eventos.rental.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public List<Categoria> listar() {
        return repository.findAll();
    }

    public Categoria buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Categoria não encontrada."));
    }

    public Categoria salvar(Categoria categoria) {

        if (categoria.getNome() == null ||
                categoria.getNome().isBlank()) {

            throw new IllegalArgumentException(
                    "O nome da categoria é obrigatório."
            );
        }

        return repository.save(categoria);
    }

    public void excluir(Long id) {

        Categoria categoria = buscarPorId(id);

        repository.delete(categoria);
    }
}