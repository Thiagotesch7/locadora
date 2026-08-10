package eventos.rental.models;

@Entity
@Table(name = "equipamentos")
public class equipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private categoria categoria;

    @Column
    private String nome;

    @Column
    private String marca;

    @Column
    private String modelo;

    private String potencia;

    private String material;

    private Double peso;

    private String dimensoes;

    private String cor;

    @Column
    private Integer quantidade;

    @Column
    private Integer estoqueMinimo;

    @Column
    private Boolean ativo = true;

    public equipamento () {
        
    }
    public equipamento(Long id, categoria categoria, String nome, String marca, String modelo, String potencia,
            String material, Double peso, String dimensoes, String cor, Integer quantidade, Integer estoqueMinimo,
            Boolean ativo) {
        this.id = id;
        this.categoria = categoria;
        this.nome = nome;
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
        this.material = material;
        this.peso = peso;
        this.dimensoes = dimensoes;
        this.cor = cor;
        this.quantidade = quantidade;
        this.estoqueMinimo = estoqueMinimo;
        this.ativo = ativo;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(categoria categoria) {
        this.categoria = categoria;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getPotencia() {
        return potencia;
    }
    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }
    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    public Double getPeso() {
        return peso;
    }
    public void setPeso(Double peso) {
        this.peso = peso;
    }
    public String getDimensoes() {
        return dimensoes;
    }
    public void setDimensoes(String dimensoes) {
        this.dimensoes = dimensoes;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    public Integer getEstoqueMinimo() {
        return estoqueMinimo;
    }
    public void setEstoqueMinimo(Integer estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }
    public Boolean getAtivo() {
        return ativo;
    }
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    
}
