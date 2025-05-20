package br.com.fiap.mototrack_backend_java.model;

public enum DepartamentoType {
    ENTRADA("Entrada"),
    AVALIACAO("Avaliação"),
    MANUTENCAO("Manutenção"),
    PRONTA_PARA_USO("Pronta para Uso"),
    SAIDA("Saída");

    private String descricao;

    DepartamentoType(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
