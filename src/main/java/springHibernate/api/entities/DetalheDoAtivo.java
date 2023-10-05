package springHibernate.api.entities;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class DetalheDoAtivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalheDoAtivo")
    private Long id;

    private String categoria;
    private String tipo;
    private String subtipo;

    @OneToMany(mappedBy = "detalheDoAtivo")
    private List<Ativo> ativos;
    public DetalheDoAtivo() {
    }

    public DetalheDoAtivo(Long id, String tipo, String subtipo) {
        this.id = id;
        this.tipo = tipo;
        this.subtipo = subtipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSubtipo() {
        return subtipo;
    }

    public void setSubtipo(String subtipo) {
        this.subtipo = subtipo;
    }
}

