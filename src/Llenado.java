/**
 * Clase que crea objetos de tipo Credencial, esta realiza el llenado de los datos para la clase Credencial, y las
 * va guardando dentro de un Vector de tipo Credencial.
 * 
 * Utiliza File para crear los archivos XML y CSS, y write(); para escribir todo el Vector de credenciales en el 
 * archivo XML con su respectivo formato.
 * 
 * Esta es la parte lógica de la UI
 *
 * @author Omar Arturo Díaz Alarcón Aguilar
 * @version 2.0
 */

import java.util.*;
import java.io.*;

public class Llenado {

    private Credencial ine;
    private Vector<Credencial> credenciales;
    private File fileIne, fileCss;

    //Prepara el programa (solo crea el vector que almacenara los datos)
    public Llenado(){
        credenciales = new Vector<Credencial>(1);
    }
    
    //Verifica que el vector tenga al menos un dato
    public boolean isVectorCredencialesEmpty(){
        if(credenciales.size() == 0){
            return true;
        }else{
            return false;
        }
    }

    public void crearCredencial(){
        // Crear y llenar el objeto INE
        ine = new Credencial();
    }

    public void agregarCredencial(){
        // Agregar la INE al Vector
        credenciales.add(ine);   
    }
    
    // Método que recibe los datos de nombre y los llena en el objeto
    public void setNombre(String ap_p, String ap_m, String nom){
        ine.setApellidoPaterno(ap_p);
        ine.setApellidoMaterno(ap_m);
        ine.setNombre(nom);
    }

    // Método que recibe los datos de direccion y los llena en el objeto
    public void setDireccion(   String calle, String colonia, String estado, 
                                    String municipio, String c_postal, String no_casa){
        ine.setCalle(calle);
        ine.setColonia(colonia);
        ine.setEstado(estado);
        ine.setMunicipio(municipio);
        ine.setCodigoPostal(c_postal);
        ine.setNumeroCasa(no_casa);
    }

    // Método que recibe los datos de informacion y los llena en el objeto
    public void setInformacion( String clave_elector, String curp, String fecha_nac, 
                                    String seccion, String año_registro, String vigencia, String sexo){
        ine.setClaveElector(clave_elector);
        ine.setCURP(curp);
        ine.setFechaNacimiento(fecha_nac);
        ine.setSeccion(seccion);
        ine.setAñoRegistro(año_registro);
        ine.setVigencia(vigencia);
        ine.setSexo(sexo);
    }

    // Método que genera el archivo CSS y llama al método que lo llena
    public void generaCSS(){
        fileCss = new File("inestyle.css");
        if(!fileCss.exists()){
            System.out.println("El archivo no se pudo crear.");
        }else{
            try{
                escribeCSS();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    // Método que escribe el archivo css para el xml
    private void escribeCSS() throws IOException{
        fileCss = new File("inestyle.css");
        if(!fileCss.exists()){
            System.out.println("El archivo no se pudo crear.");
        }
        FileWriter escribe = new FileWriter("inestyle.css");

        //Iniciar el documento
        escribe.write("/* File Name: inestyle.css */\n");

        escribe.write("INE { \n\tdisplay:block;\n\tmargin-top:20pt;\n\tfont-family: Verdana;\n\tfont-size:10pt;\n}\n");
        escribe.write("NOMBRE, DIRECCION { \n\tfont-weight : bold;\n\tmargin-top:5pt;\n}\n");
        escribe.write("clave { \n\tmargin-top:5pt;\n}\n");
        escribe.write("NOMBRE, DIRECCION, clave, curp, fecha, sexo, seccion, ano, vigencia { \n\tdisplay:block;\n}\n");

        // Terminar el documento
        escribe.close();
    }

    // Método que genera el archivo XML y llama al método que lo llena
    public void generaXML(){
        fileIne = new File("INE.xml");
        if(!fileIne.exists()){
            System.out.println("El archivo no se pudo crear.");
        }else{
            try{
                escribeXML();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    // Método write que escribe los datos de todas las Credenciales del vector, en el archivo xml
    private void escribeXML() throws IOException{
        FileWriter escribe = new FileWriter("INE.xml");

        // Iniciar el documento
        escribe.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<?xml-stylesheet type=\"text/css\" href=\"inestyle.css\"?>\n<!-- File Name: INE.xml -->\n"); // NIVEL 0
        escribe.write("<credencial_elector>\n"); // 0
        
        // Recorrer el vector y escribir INEs
        for(int i = 0; i <= credenciales.size() -1; i++){
            escribe.write(  "\t<INE>\n");    // 1

            escribe.write(  "\t\t<number>INE No. " + (i+1) + "</number>\n");    // 2

            // Nombre 
            escribe.write(  "\t\t<NOMBRE>NOMBRE</NOMBRE>\n");   // 2
            escribe.write(  "\t\t<nombre>" + credenciales.get(i).getApellidoPaterno() + 
                            "\n\t\t\t" + credenciales.get(i).getApellidoMaterno() + 
                            "\n\t\t\t" + credenciales.get(i).getNombre() + "</nombre>\n"); // 2

            // Direccion
            escribe.write(  "\t\t<DIRECCION>DOMICILIO</DIRECCION>\n");   // 2
            escribe.write(  "\t\t<direccion>C " + credenciales.get(i).getCalle() + " " + credenciales.get(i).getNumeroCasa() + 
                            "\n\t\t\tCOL " + credenciales.get(i).getColonia() + " " + credenciales.get(i).getCodigoPostal() + 
                            "\n\t\t\t" + credenciales.get(i).getMunicipio() + ", " + credenciales.get(i).getEstado() + "</direccion>\n");    // 2
            
            // Informacion
            escribe.write("\t\t<clave>CLAVE DE ELECTOR: " + credenciales.get(i).getClaveElector() + "</clave>\n");  // 2
            escribe.write("\t\t<curp>CURP: " + credenciales.get(i).getCURP() + "</curp>\n");  // 2
            escribe.write("\t\t<fecha>FECHA DE NACIMIENTO: " + credenciales.get(i).getFechaNacimiento() + "</fecha>\n");  // 2
            escribe.write("\t\t<sexo>SEXO: " + credenciales.get(i).getSexo() + "</sexo>\n");  // 2
            escribe.write("\t\t<seccion>SECCION: " + credenciales.get(i).getSeccion() + "</seccion>\n");  // 2
            escribe.write("\t\t<ano>ANO DE REGISTRO: " + credenciales.get(i).getAñoRegistro() + "</ano>\n");  // 2
            escribe.write("\t\t<vigencia>VIGENCIA: " + credenciales.get(i).getVigencia() + "</vigencia>\n");  // 2
            escribe.write("\t</INE>\n");   // 1
        }

        // Terminar el documento
        escribe.write("</credencial_elector>\n");  // 0
        escribe.close();
    }
}