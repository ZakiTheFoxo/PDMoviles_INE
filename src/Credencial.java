/**
 * Clase que guarda todos los datos de una credencial de elector (INE) y los guarda en variables de tipo String.
 *
 * @author Omar Arturo Díaz Alarcón Aguilar
 * @version 1.1
 */
public class Credencial
{
    private String nombre, ap_paterno, ap_materno;  // Nombre
    
    private String calle, colonia, estado, municipio, c_postal, no_casa; // Dirección
    
    private String clave_elector, curp, fecha_nac, seccion, año_registro, vigencia, sexo; // Información
    
    public Credencial(){
        
    }
    
    public void setNombre(String nombre, String ap_paterno, String ap_materno){
        this.nombre = new String(nombre);
        this.ap_paterno = new String(ap_paterno);
        this.ap_materno = new String(ap_materno);
    }
    
    public void setDirección(String calle, String colonia, String estado, String municipio, String c_postal, String no_casa){
        this.calle = new String(calle);
        this.colonia = new String(colonia);
        this.estado = new String(estado);
        this.municipio = new String(municipio);
        this.c_postal = new String(c_postal);
        this.no_casa = new String(no_casa);
    }
    
    public void setInformación(String clave_elector, String curp, String fecha_nac, String seccion, String año_registro, String vigencia, String sexo){
        this.clave_elector = new String(clave_elector);
        this.curp = new String(curp);
        this.fecha_nac = new String(fecha_nac);
        this.seccion = new String(seccion);
        this.año_registro = new String(año_registro);
        this.vigencia = new String(vigencia);
        this.sexo = new String(sexo);
    }

    public String getNombre(){  return new String(nombre);  }
    public String getApellidoPaterno(){  return new String(ap_paterno);  }
    public String getApellidoMaterno(){  return new String(ap_materno);  }
    public String getCalle(){  return new String(calle);  }
    public String getColonia(){  return new String(colonia);  }
    public String getEstado(){  return new String(estado);  }
    public String getMunicipio(){  return new String(municipio);  }
    public String getCodigoPostal(){  return new String(c_postal);  }
    public String getNumeroCasa(){  return new String(no_casa);  }
    public String getClaveElector(){  return new String(clave_elector);  }
    public String getCURP(){  return new String(curp);  }
    public String getFechaNacimiento(){  return new String(fecha_nac);  }
    public String getSeccion(){  return new String(seccion);  }
    public String getAñoRegistro(){  return new String(año_registro);  }
    public String getVigencia(){  return new String(vigencia);  }
    public String getSexo(){  return new String(sexo);  }
}
