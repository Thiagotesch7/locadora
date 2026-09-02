package eventos.rental.services;

import java.util.List;

import org.springframework.stereotype.Service;

import eventos.rental.models.Equipamento;
import eventos.rental.repositories.EquipamentoRepository;

@Service
public class EquipamentoService {

    private final EquipamentoRepository repository;

    public EquipamentoService(EquipamentoRepository repository) {
        this.repository = repository;
    }

    public List<Equipamento> listar() {

        return repository.findByAtivoTrueOrderByNomeAsc();
    }

    public List<Equipamento> pesquisar(String termo) {

        return repository
                .findByAtivoTrueAndNomeContainingIgnoreCaseOrderByNomeAsc(
                        termo
                );
    }

    public Equipamento buscarPorId(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Equipamento não encontrado."
                        )
                );
    }

    public Equipamento salvar(Equipamento equipamento) {

        validar(equipamento);

        if (equipamento.getQuantidade() == null) {
            equipamento.setQuantidade(0);
        }

        if (equipamento.getAtivo() == null) {
            equipamento.setAtivo(true);
        }

        return repository.save(equipamento);
    }

    public void excluir(Long id) {

        Equipamento equipamento = buscarPorId(id);

        equipamento.setAtivo(false);

        repository.save(equipamento);
    }

    private void validar(Equipamento equipamento) {

        if (equipamento.getNome() == null ||
                equipamento.getNome().isBlank()) {

            throw new IllegalArgumentException(
                    "O nome do equipamento é obrigatório."
            );
        }

        if (equipamento.getMarca() == null ||
                equipamento.getMarca().isBlank()) {

            throw new IllegalArgumentException(
                    "A marca é obrigatória."
            );
        }

        if (equipamento.getModelo() == null ||
                equipamento.getModelo().isBlank()) {

            throw new IllegalArgumentException(
                    "O modelo é obrigatório."
            );
        }

        if (equipamento.getQuantidade() != null &&
                equipamento.getQuantidade() < 0) {

            throw new IllegalArgumentException(
                    "A quantidade não pode ser negativa."
            );
        }

        if (equipamento.getEstoqueMinimo() == null ||
                equipamento.getEstoqueMinimo() < 0) {

            throw new IllegalArgumentException(
                    "O estoque mínimo não pode ser negativo."
            );
        }
    }
}
