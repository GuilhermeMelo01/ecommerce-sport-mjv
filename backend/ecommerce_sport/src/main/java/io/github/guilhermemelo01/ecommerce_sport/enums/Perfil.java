package io.github.guilhermemelo01.ecommerce_sport.enums;

public enum Perfil {

    ADMIN(1, "ROLE_ADMIN"),
    CLIENTE(2, "ROLE_CLIENTE");

    private final Integer cod;
    private final String descricao;

    Perfil(Integer cod, String descricao){
        this.cod = cod;
        this.descricao = descricao;
    }

    public Integer getCod(){
        return this.cod;
    }
    public String getDescricao(){
        return this.descricao;
    }

    public static Perfil toEnum(Integer cod){

        if (cod == null){
            return null;
        }

        for(Perfil perfil: Perfil.values()){
            if(perfil.getCod().equals(cod)){
                return perfil;
            }
        }

        throw new IllegalArgumentException("Valor invalido "+ cod);

    }



}
