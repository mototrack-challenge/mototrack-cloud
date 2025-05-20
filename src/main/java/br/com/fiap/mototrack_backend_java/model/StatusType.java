package br.com.fiap.mototrack_backend_java.model;

public enum StatusType {
    EM_MANUTENCAO("Em Manutenção"),
    PRONTA_PARA_USO("Pronta para Uso"),
    AVALIACAO("Em Avaliação");

    private String descricao;

    StatusType(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
