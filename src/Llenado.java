/**
 * Clase que crea objetos de tipo Credencial, esta realiza el llenado de los datos para la clase Credencial, y las
 * va guardando dentro de un Vector de tipo Credencial.
 * 
 * Utiliza File para crear los archivos XML y CSS, y write(); para escribir todo el Vector de credenciales en el 
 * archivo XML con su respectivo formato.
 * 
 * Importante recalcar que todos los System.in del Scanner son de tipo String, para evitar validaciones 
 * ya que es un programa sencillo.
 *
 * @author Omar Arturo Díaz Alarcón Aguilar
 * @version 1.3
 */

import java.util.*;
import java.io.*;

public class Llenado {

    private static Credencial ine;
    private static Vector<Credencial> credenciales;
    private static File fileIne, fileCss;

    public Llenado(){

    }

    // Método que llena los datos para el objeto INE, el cual se crea en el main
    private static void llenarDatos(Scanner sc){
        // Ingresar el Nombre completo 
        String nom, ap_p, ap_m;
            
        System.out.println("Datos de la INE");
        System.out.println("Nombre");

        System.out.println("Ingrese el Apellido Paterno: ");
        ap_p = sc.nextLine();
        System.out.println("Ingrese el Apellido Materno: ");
        ap_m = sc.nextLine();
        System.out.println("Ingrese el Nombre: ");    
        nom = sc.nextLine();

        ine.setNombre(nom, ap_p, ap_m);

        // Ingresar datos de dirección
        String calle, colonia, estado, municipio, c_postal, no_casa;

        System.out.println();
        System.out.println("Dirección");

        System.out.println("Ingrese la Calle: ");    
        calle = sc.nextLine();
        System.out.println("Ingrese el Numero de Casa: ");    
        no_casa = sc.nextLine();
        System.out.println("Ingrese la Colonia: ");    
        colonia = sc.nextLine();
        System.out.println("Ingrese el Codigo Postal: ");    
        c_postal= sc.nextLine();
        System.out.println("Ingrese el Municipio: ");    
        municipio = sc.nextLine();
        System.out.println("Ingrese el Estado: ");    
        estado = sc.nextLine();

        ine.setDirección(calle, colonia, estado, municipio, c_postal, no_casa);

        // Ingresar infomación
        String clave_elector, curp, fecha_nac, seccion, año_registro, vigencia, sexo;
        
        System.out.println();
        System.out.println("Información");

        System.out.println("Ingrese la Clave de Elector: ");
        clave_elector = sc.nextLine();
        System.out.println("Ingrese el CURP: ");
        curp = sc.nextLine();
        System.out.println("Ingrese la Fecha de Nacimiento: ");
        fecha_nac = sc.nextLine();
        System.out.println("Ingrese el Sexo: ");
        sexo = sc.nextLine();
        System.out.println("Ingrese la seccion: ");
        seccion = sc.nextLine();
        System.out.println("Ingrese el Año de Registro: ");
        año_registro = sc.nextLine();
        System.out.println("Ingrese la Vigencia: ");
        vigencia = sc.nextLine();

        ine.setInformación(clave_elector, curp, fecha_nac, seccion, año_registro, vigencia, sexo);
    }

    private static void generaCSS(){
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
    private static void escribeCSS() throws IOException{
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

    private static void generaXML(){
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
    private static void escribeXML() throws IOException{
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

    public static void main(String args[]){
        // Iniciar el vector que contendra todas las INE
        credenciales = new Vector<Credencial>(1);
        Scanner sc = new Scanner(System.in);
        Scanner scmenu = new Scanner(System.in); 

        int menu = 1;

        do{ // Repetir llenado hasta que el usuario se detenga y cree el XML
            // Crear y llenar el objeto INE
            ine = new Credencial();
            llenarDatos(sc);

            // Agregar la INE al Vector
            credenciales.add(ine);           

            System.out.println("Si desea agregar otra INE escriba 1, en caso contrario escriba 2: ");
            menu = scmenu.nextInt();
            System.out.println("\n");
        }while(menu == 1); 

        // Generar el archivo XML y CSS, y escribir en ellos los datos recolectados en el Vector
        generaXML();
        generaCSS();
        
        scmenu.close();
    }
}
