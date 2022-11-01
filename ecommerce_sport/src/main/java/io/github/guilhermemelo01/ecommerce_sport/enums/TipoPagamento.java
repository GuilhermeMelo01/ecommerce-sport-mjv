package io.github.guilhermemelo01.ecommerce_sport.enums;

public enum TipoPagamento {

    CREDITO(1, "Credito"),
    DEBITO(2, "Debito"),
    PIX(3, "Pix");

    private final Integer cod;
    private final String descricao;

    TipoPagamento(Integer cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public Integer getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoPagamento toEnum(Integer cod){
        if (cod == null) {
            return null;
        }

        for (TipoPagamento tipoPagamento: TipoPagamento.values()){
            if (cod.equals(tipoPagamento.getCod())){
                return tipoPagamento;
            }
        }

        throw new IllegalArgumentException("Value is not invalid! "+ cod);
    }
}
