package model;

import jakarta.persistence.*;

import java.util.concurrent.atomic.AtomicInteger;


@Entity
@Table(name = "destinos")
public class Destino {
    private static final AtomicInteger count = new AtomicInteger(0);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "localizacao", nullable = false, length = 100)
    private String localizacao;

    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "media_avaliacoes", columnDefinition = "DOUBLE PRECISION DEFAULT 0")
    private Double mediaAvaliacoes;

    @Column(name = "quantidade_avaliacoes", columnDefinition = "INT DEFAULT 0")
    private int quantidadeAvaliacoes;

    public Destino() {
    }

    public Destino(String nome, String localizacao, String descricao) {
        this.id = count.incrementAndGet();
        this.nome = nome;
        this.localizacao = localizacao;
        this.descricao = descricao;
        this.mediaAvaliacoes = 0.0;
        this.quantidadeAvaliacoes = 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getMediaAvaliacoes() {
        return mediaAvaliacoes;
    }

    public void setMediaAvaliacoes(Double mediaAvaliacoes) {
        this.mediaAvaliacoes = mediaAvaliacoes;
    }

    public int getQuantidadeAvaliacoes() {
        return quantidadeAvaliacoes;
    }

    public void setQuantidadeAvaliacoes(int quantidadeAvaliacoes) {
        this.quantidadeAvaliacoes = quantidadeAvaliacoes;
    }
}