package springHibernate.api.entities;

import jakarta.persistence.*;

@Entity
public class Ativo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String url;

    @ManyToOne
    @JoinColumn(name = "id_detalheDoAtivo")
    private DetalheDoAtivo detalheDoAtivo;

    public Ativo() {
    }

    public Ativo(Long id, String nome, String url) {
        this.id = id;
        this.nome = nome;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public DetalheDoAtivo getDetalheDoAtivo() {
        return detalheDoAtivo;
    }

}
