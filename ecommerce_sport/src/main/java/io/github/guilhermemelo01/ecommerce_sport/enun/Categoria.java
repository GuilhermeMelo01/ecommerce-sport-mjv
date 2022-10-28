package io.github.guilhermemelo01.ecommerce_sport.enun;

public enum Categoria {

    BASQUETE(1, "Basquete"),
    FUTEBOL(2, "Futebol"),
    NATACAO(3, "Natação"),
    VOLEI(4, "Vôlei"),
    BASEBALL(5, "Baseball"),
    ARTES_MARCIAIS(6, "Artes Marciais");

    private final Integer cod;
    private final String descricao;

    Categoria(Integer cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public Integer getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Categoria toEnum(Integer cod){
        if (cod == null) {
            return null;
        }

        for (Categoria categoria: Categoria.values()){
            if (cod.equals(categoria.getCod())){
                return categoria;
            }
        }
        throw new IllegalArgumentException("Value is not invalid! "+ cod);
    }
}
