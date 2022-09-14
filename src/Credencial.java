/**
 * Clase que guarda todos los datos de una credencial de elector (INE) y los guarda en variables de tipo String.
 *
 * @author Omar Arturo Díaz Alarcón Aguilar
 * @version 2.0
 */

public class Credencial
{
    private String nombre, ap_paterno, ap_materno;  // Nombre
    
    private String calle, colonia, estado, municipio, c_postal, no_casa; // Dirección
    
    private String clave_elector, curp, fecha_nac, seccion, año_registro, vigencia, sexo; // Información
    
    public Credencial(){
        
    }
    
    // Setters
    public void setNombre(String nombre){    this.nombre = new String(nombre);   }
    public void setApellidoPaterno(String ap_paterno){  this.ap_paterno = new String(ap_paterno);   }
    public void setApellidoMaterno(String ap_materno){  this.ap_materno = new String(ap_materno);   }

    public void setCalle(String calle){  this.calle = new String(calle);   }
    public void setColonia(String colonia){  this.colonia = new String(colonia);   }
    public void setEstado(String estado){  this.estado = new String(estado);   }
    public void setMunicipio(String municipio){  this.municipio = new String(municipio);   }
    public void setCodigoPostal(String c_postal){  this.c_postal = new String(c_postal);   }
    public void setNumeroCasa(String no_casa){  this.no_casa = new String(no_casa);   }
    
    public void setClaveElector(String clave_elector){  this.clave_elector = new String(clave_elector);   }
    public void setCURP(String curp){  this.curp = new String(curp);   }
    public void setFechaNacimiento(String fecha_nac){  this.fecha_nac = new String(fecha_nac);   }
    public void setSeccion(String seccion){  this.seccion = new String(seccion);   }
    public void setAñoRegistro(String año_registro){  this.año_registro = new String(año_registro);   }
    public void setVigencia(String vigencia){  this.vigencia = new String(vigencia);   }
    public void setSexo(String sexo){  this.sexo = new String(sexo);   }

    //Getters
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
