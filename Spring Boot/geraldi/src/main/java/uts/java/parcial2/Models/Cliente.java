package uts.java.parcial2.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @Min(value = 1)
    private float CODIGOCLIENTE;

    @Size(min = 10, max = 15)
    @NotBlank(message = "La cedula no puede estar en blanco")
    private String CEDULA;

    @NotBlank(message = "El nombre no puede estar en blanco")
	@Size(min = 1, max = 50)
    private String NOMBRE;

    private String DIRECCION;

    //Relación con Proveedor muchos a uno, enlazado con el campo nitproveedor
	@ManyToOne
	@JoinColumn(name = "CODIGOTIPOCLIENTE")
    private TipoCliente CODIGOTIPOCLIENTE;

    @ManyToOne
	@JoinColumn(name = "CODIGOESTADO")
    private EstadoCliente CODIGOESTADO;
    
    private int TELEFONO;
    private String FAX;
    private String EMAIL;
    private String FECHANACIMIENTO;
    private String SEXO;

    public Cliente() {
    }

    public Cliente(@Min(1) float cODIGOCLIENTE, @NotBlank(message = "La cedula no puede estar en blanco") String cEDULA,
            @NotBlank(message = "El nombre no puede estar en blanco") @Size(min = 3, max = 50) String nOMBRE,
            String dIRECCION, TipoCliente cODIGOTIPOCLIENTE, EstadoCliente cODIGOESTADO, int tELEFONO, String fAX, String eMAIL,
            String fECHANACIMIENTO, String sEXO) {
        CODIGOCLIENTE = cODIGOCLIENTE;
        CEDULA = cEDULA;
        NOMBRE = nOMBRE;
        DIRECCION = dIRECCION;
        CODIGOTIPOCLIENTE = cODIGOTIPOCLIENTE;
        CODIGOESTADO = cODIGOESTADO;
        TELEFONO = tELEFONO;
        FAX = fAX;
        EMAIL = eMAIL;
        FECHANACIMIENTO = fECHANACIMIENTO;
        SEXO = sEXO;
    }

    public float getCODIGOCLIENTE() {
        return CODIGOCLIENTE;
    }

    public void setCODIGOCLIENTE(float cODIGOCLIENTE) {
        CODIGOCLIENTE = cODIGOCLIENTE;
    }

    public String getCEDULA() {
        return CEDULA;
    }

    public void setCEDULA(String cEDULA) {
        CEDULA = cEDULA;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String nOMBRE) {
        NOMBRE = nOMBRE;
    }

    public String getDIRECCION() {
        return DIRECCION;
    }

    public void setDIRECCION(String dIRECCION) {
        DIRECCION = dIRECCION;
    }

    public TipoCliente getCODIGOTIPOCLIENTE() {
        return CODIGOTIPOCLIENTE;
    }

    public void setCODIGOTIPOCLIENTE(TipoCliente cODIGOTIPOCLIENTE) {
        CODIGOTIPOCLIENTE = cODIGOTIPOCLIENTE;
    }

    public EstadoCliente getCODIGOESTADO() {
        return CODIGOESTADO;
    }

    public void setCODIGOESTADO(EstadoCliente cODIGOESTADO) {
        CODIGOESTADO = cODIGOESTADO;
    }

    public int getTELEFONO() {
        return TELEFONO;
    }

    public void setTELEFONO(int tELEFONO) {
        TELEFONO = tELEFONO;
    }

    public String getFAX() {
        return FAX;
    }

    public void setFAX(String fAX) {
        FAX = fAX;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String eMAIL) {
        EMAIL = eMAIL;
    }

    public String getFECHANACIMIENTO() {
        return FECHANACIMIENTO;
    }

    public void setFECHANACIMIENTO(String fECHANACIMIENTO) {
        FECHANACIMIENTO = fECHANACIMIENTO;
    }

    public String getSEXO() {
        return SEXO;
    }

    public void setSEXO(String sEXO) {
        SEXO = sEXO;
    }

    @Override
    public String toString() {
        return "Cliente [CODIGOCLIENTE=" + CODIGOCLIENTE + ", CEDULA=" + CEDULA + ", NOMBRE=" + NOMBRE + ", DIRECCION="
                + DIRECCION + ", CODIGOTIPOCLIENTE=" + CODIGOTIPOCLIENTE + ", CODIGOESTADO=" + CODIGOESTADO
                + ", TELEFONO=" + TELEFONO + ", FAX=" + FAX + ", EMAIL=" + EMAIL + ", FECHANACIMIENTO="
                + FECHANACIMIENTO + ", SEXO=" + SEXO + "]";
    }
}