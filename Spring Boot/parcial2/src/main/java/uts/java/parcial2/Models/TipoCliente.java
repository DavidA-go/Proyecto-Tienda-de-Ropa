package uts.java.parcial2.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tipocliente")
public class TipoCliente {

    @Id
    @Min(value = 1)
    private String CODIGO;

    @NotBlank(message = "El nombre no puede estar en blanco")
	@Size(min = 3, max = 50)
    private String NOMBRE;

    public TipoCliente() {
    }

    public TipoCliente(@Min(1) String cODIGO,
            @NotBlank(message = "El nombre no puede estar en blanco") @Size(min = 3, max = 50) String nOMBRE) {
        CODIGO = cODIGO;
        NOMBRE = nOMBRE;
    }

    public String getCODIGO() {
        return CODIGO;
    }

    public void setCODIGO(String cODIGO) {
        CODIGO = cODIGO;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String nOMBRE) {
        NOMBRE = nOMBRE;
    }

    @Override
    public String toString() {
        return "TipoCliente [CODIGO=" + CODIGO + ", NOMBRE=" + NOMBRE + "]";
    }
}