package springHibernate.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AtivoRequestDTO {
    private String nome;
    private String url;
    private String categoria;
    private String tipo;
    private String subtipo;
}



