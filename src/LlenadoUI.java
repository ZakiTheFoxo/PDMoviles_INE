/**
 * Clase que crea la interfáz grafica para reemplazar la entrada por consola.
 * 
 * Utiliza swing para crear una UI basica, poder llenar los datos de la credencial, guardar varias credencales
 * y generar el XML.
 *
 * @author Omar Arturo Díaz Alarcón Aguilar
 * @version 1.0
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LlenadoUI extends JFrame{
    private static Llenado llenado;
    private JPanel nomPanel, dirPanel, infoPanel, buttonPanel;
    private JLabel aux;
    private JButton regButton, delButton, genButton;
    private JTextField ap_pTxf, ap_mTxf, nomTxf, calleTxf, no_casaTxf, coloniaTxf, c_pTxf, edoTxf, munTxf, c_elecTxf, curpTxf, seccionTxf;
    private JTextField fecha_nacTxf, sexoTxf, año_registroTxf, vigenciaTxf;

    // Will be used in future versions
    private JComboBox fecha_nacCBox, sexoCBox, año_registroCBox1, año_registroCBox2, vigenciaCBox1, vigenciaCBox2;

    // Creador de la UI
    public LlenadoUI(){
        super("INE");

        // Inicializar los paneles con el GridLayout
        nomPanel = new JPanel(new GridLayout());    dirPanel = new JPanel(new GridLayout());    
        infoPanel = new JPanel(new GridLayout());   buttonPanel = new JPanel(new GridLayout());

        // Crear botón
        regButton = new JButton("Registrar Credencial");    delButton = new JButton("Borrar Campos");   genButton = new JButton("Generar Archivo XML");

        // Inicializar TextFields
        ap_pTxf = new JTextField(); ap_mTxf = new JTextField(); nomTxf = new JTextField();
        calleTxf = new JTextField();    no_casaTxf = new JTextField();  coloniaTxf = new JTextField();
        c_pTxf = new JTextField();  edoTxf = new JTextField();  munTxf = new JTextField();
        c_elecTxf = new JTextField();   curpTxf = new JTextField(); seccionTxf = new JTextField();

        fecha_nacTxf = new JTextField(); sexoTxf = new JTextField();
        año_registroTxf = new JTextField(); vigenciaTxf = new JTextField();

        // Inicializar ComboBoxes
        fecha_nacCBox = new JComboBox<String>();    sexoCBox = new JComboBox<String>(); año_registroCBox1 = new JComboBox<String>();
        año_registroCBox2 = new JComboBox<String>();    vigenciaCBox1 = new JComboBox<String>();    vigenciaCBox2 = new JComboBox<String>();

        // Layout general
        setLayout(new GridLayout(0, 1, 10, 0));

        // Panel de nombre, se agregan los textos y los cuadros de texto
        nomPanel.setLayout(new GridLayout(0, 2, 30, 0));
        aux = new JLabel("");   nomPanel.add(aux);
        aux = new JLabel("");   nomPanel.add(aux);
        aux = new JLabel("NOMBRE"); nomPanel.add(aux);
        aux = new JLabel("");   nomPanel.add(aux);
        // Se crea el texto, se añade el texto y se añade la caja de texto
        aux = new JLabel("Apellido Paterno");   nomPanel.add(aux);
        aux = new JLabel("Apellido Materno");   nomPanel.add(aux);
        nomPanel.add(ap_pTxf);  nomPanel.add(ap_mTxf);
        aux = new JLabel("Nombre"); nomPanel.add(aux);  
        nomPanel.add(aux);  nomPanel.add(nomTxf);
        

        // Panel de direccion, se agregan los textos y los cuadros de texto
        dirPanel.setLayout(new GridLayout(0, 4, 30, 0));
        aux = new JLabel("");   dirPanel.add(aux);
        aux = new JLabel("");   dirPanel.add(aux);
        aux = new JLabel("");   dirPanel.add(aux);
        aux = new JLabel("");   dirPanel.add(aux);
        aux = new JLabel("DIRECCION");  dirPanel.add(aux);  //Titulo del modulo
        aux = new JLabel("");   dirPanel.add(aux);
        aux = new JLabel("");   dirPanel.add(aux);
        aux = new JLabel("");   dirPanel.add(aux);
        // Se crea el texto, se añade el texto y se añade la caja de texto
        aux = new JLabel("Calle:"); dirPanel.add(aux);  dirPanel.add(calleTxf);
        aux = new JLabel("No. Casa:");  dirPanel.add(aux);  dirPanel.add(no_casaTxf);
        aux = new JLabel("Colonia:");   dirPanel.add(aux);  dirPanel.add(coloniaTxf);
        aux = new JLabel("Código Postal:"); dirPanel.add(aux);  dirPanel.add(c_pTxf);
        aux = new JLabel("Estado:");    dirPanel.add(aux);  dirPanel.add(edoTxf);
        aux = new JLabel("Municipio:"); dirPanel.add(aux);  dirPanel.add(munTxf);

        // Panel de Informacion, se agregan los textos y los cuadros de texto
        infoPanel.setLayout(new GridLayout(0, 4, 30, 0));
        aux = new JLabel("");   infoPanel.add(aux);
        aux = new JLabel("");   infoPanel.add(aux);
        aux = new JLabel("");   infoPanel.add(aux);
        aux = new JLabel("");   infoPanel.add(aux);
        aux = new JLabel("DATOS PERSONALES");   infoPanel.add(aux); //Titulo del modulo
        aux = new JLabel("");   infoPanel.add(aux);
        aux = new JLabel("");   infoPanel.add(aux);
        aux = new JLabel("");   infoPanel.add(aux);
        // Se crea el texto, se añade el texto y se añade la caja de texto
        aux = new JLabel("Clave de Elector:");  infoPanel.add(aux); infoPanel.add(c_elecTxf);  
        aux = new JLabel("CURP:");  infoPanel.add(aux); infoPanel.add(curpTxf);
        aux = new JLabel("Fecha de Nacimiento:");   infoPanel.add(aux); infoPanel.add(fecha_nacTxf);
        aux = new JLabel("Sexo:");  infoPanel.add(aux); infoPanel.add(sexoTxf);
        aux = new JLabel("Año de Registro:");   infoPanel.add(aux); infoPanel.add(año_registroTxf);
        aux = new JLabel("Vigencia:");  infoPanel.add(aux); infoPanel.add(vigenciaTxf);
        aux = new JLabel("Sección:");   infoPanel.add(aux); infoPanel.add(seccionTxf);

        // Añadir paneles individuales al general
        add(nomPanel);
        add(dirPanel);
        add(infoPanel);

        // Aadir el botón al Panel general
        buttonPanel.setLayout(new GridLayout(4, 0, 10, 5));
        aux = new JLabel("");
        buttonPanel.add(aux);
        buttonPanel.add(regButton);
        buttonPanel.add(genButton);
        buttonPanel.add(delButton);
        add(buttonPanel);

        // Listeners de los botones
        delButton.addActionListener(new BotonBorrar());
        regButton.addActionListener(new BotonRegistrar());
        genButton.addActionListener(new BotonGenerar());

        // Listener de cierre de ventana
        addWindowListener(new CW());

        // Crear y mostrar la ventana
        setSize(800, 500);
        setVisible(true);
        setResizable(false);
    }

    // listener para cerrar la ventana
    private class CW extends WindowAdapter{     
        public void windowClosing(WindowEvent e){
            setVisible(false);
            dispose();
        }
    }

    // Listener que detecta cuando se presionó el botón de registrar
    private class BotonRegistrar implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //Se crea la credencial
            llenado.crearCredencial();
        
            //Verificar que los campos esten todos llenos
            if( verificarCampos()   ){
                //Llena el objeto credencial
                llenarCredencial();

                //Agrega la credencial al vector en la clase Llenado
                llenado.agregarCredencial();

                //Muestra el mensaje de registrado correctamente
                JOptionPane.showMessageDialog(null, "Se ha registrado la credencial correctamente", "Registrado con Éxito", JOptionPane.INFORMATION_MESSAGE);
                
                //Resetea los campos
                borrarCampos();
            }else{
                //En caso de campos vacios soltar la excepcion
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos antes de registrar una credencial", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Listener que detecta cuando se presionó el botón de borrar
    private class BotonGenerar implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(!llenado.isVectorCredencialesEmpty()){
                llenado.generaCSS();
                llenado.generaXML();

                JOptionPane.showMessageDialog(null, "Se ha generado el archivo XML correctamente", "Archivo generado con Éxito", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "No se ha agregado ninguna credencial", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Listener que detecta cuando se presionó el botón de borrar
    private class BotonBorrar implements ActionListener{
        public void actionPerformed(ActionEvent e){
            borrarCampos();
        }
    }

    //Metodo que elimina los campos
    public void borrarCampos(){
        ap_pTxf.setText("");    ap_mTxf.setText("");    nomTxf.setText(""); 

        calleTxf.setText("");   no_casaTxf.setText(""); coloniaTxf.setText(""); 
        c_pTxf.setText(""); edoTxf.setText(""); munTxf.setText(""); 

        c_elecTxf.setText("");  curpTxf.setText("");    seccionTxf.setText(""); fecha_nacTxf.setText("");   
        sexoTxf.setText("");    año_registroTxf.setText("");    vigenciaTxf.setText("");
    }

    public boolean verificarCampos(){
        if(!(   ap_pTxf.getText().isEmpty()    ||  ap_mTxf.getText().isEmpty() ||  nomTxf.getText().isEmpty()   )){
            llenado.setNombre(  ap_pTxf.getText(), ap_mTxf.getText(), nomTxf.getText()    );
        }else{
            return false;
        }

        // Checa si los campos de la direccion estan llenos
        if(!( calleTxf.getText().isEmpty() ||  no_casaTxf.getText().isEmpty()  ||  coloniaTxf.getText().isEmpty() ||
                    c_pTxf.getText().isEmpty()  ||  edoTxf.getText().isEmpty()  ||  munTxf.getText().isEmpty()  )){
            llenado.setDireccion(   calleTxf.getText(), coloniaTxf.getText(), edoTxf.getText(), 
                                    munTxf.getText(), c_pTxf.getText(), no_casaTxf.getText()    );
        }else{
            return false;
        }

        // Checa si los campos de la informacion estan llenos
        if(!( c_elecTxf.getText().isEmpty()   ||  curpTxf.getText().isEmpty() ||  seccionTxf.getText().isEmpty()  ||
                    fecha_nacTxf.getText().isEmpty()    ||  sexoTxf.getText().isEmpty() ||  año_registroTxf.getText().isEmpty() ||
                    vigenciaTxf.getText().isEmpty() )){
            llenado.setInformacion( c_elecTxf.getText(), curpTxf.getText(), fecha_nacTxf.getText(), 
                                    seccionTxf.getText(), año_registroTxf.getText(), vigenciaTxf.getText(), sexoTxf.getText()   );
            return true;
        }else{
            return false;
        }
    }

    // Llenar los datos de la UI en la credencial
    public void llenarCredencial(){
        llenado.setNombre(ap_pTxf.getText(), ap_mTxf.getText(), nomTxf.getText());

        llenado.setDireccion(   calleTxf.getText(), coloniaTxf.getText(), edoTxf.getText(), 
                                munTxf.getText(), c_pTxf.getText(), no_casaTxf.getText());

        llenado.setInformacion( c_elecTxf.getText(), curpTxf.getText(), fecha_nacTxf.getText(), seccionTxf.getText(), 
                                año_registroTxf.getText(), vigenciaTxf.getText(), sexoTxf.getText());
    }

    //Método principal que solo llama al constructor y crea el objeto de tipo llenado
    public static void main(String args[]){
        LlenadoUI ui = new LlenadoUI();
        llenado = new Llenado();
    }
}

/* 
 * Como se planea que se vea la interfaz (Version 1)
 * 
 * NOMBRE                                                                                  \       \
 * Apeliido Paterno:                        Apellido Materno:                               |       |
 * [                                ]       [                               ]               GRID    |   
 * Nombre:                                                                                  |       |
 * [                                ]                                                      /        |
 *                                                                                                  |
 * DIRECCION                                                                               \        |
 * Calle: [                         ]       No. casa: [             ]                       GRID    |
 * Colonia: [                       ]       Código postal: [        ]                       |       |
 * Estado: [                        ]       Municipio: [            ]                      /        GRID
 *                                                                                                  |
 * DATOS PERSONALES                                                                        \        |
 * Clave de elector: [                  ]   CURP: [                  ]                      |       |
 * Fecha de Nacimiento:  [ v]/[ v]/[   v]   Sexo: [v]                                       GRID    |
 * Año de registro: [   v][ v]              Vigencia: [   v]-[   v]                         |       |
 * Sección: [    ]                                                                         /        |
 *                                                                                                  |
 *                              {Registrar Credencial}                                              /
 */

 /*
ArrayList<String> years_tmp = new ArrayList<String>();
for(int years = 1980; years<=Calendar.getInstance().get(Calendar.YEAR); years++) {
    years_tmp.add(years+"");
}
jComboBox1 = new JComboBox(years_tmp.toArray());
  */