package analu.restaurantes_api.application.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Endereco {

    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s, %s, %s", logradouro, numero, bairro, cidade, estado, cep);
    }
}
