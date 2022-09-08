    
/**
 * Write a description of class ReadFile here.
 *
 * @author Omar Arturo Díaz Alarcón Aguilar
 * @version (a version number or a date)
 */

import java.awt.*;
import java.awt.event.*;
import java.io.*; 

public class LeerINE extends Frame
{
    private TextArea editor;
    private DataInputStream lee;
    
    public LeerINE() throws IOException{
        super("INEs");
        editor = new TextArea();
        add(editor, "Center");
        
        try{
            lee = new DataInputStream(new BufferedInputStream(new FileInputStream("INE.xml")));
            while(true){
                String nom = lee.readUTF();
                editor.append(nom + '\n');
            }
        }catch(FileNotFoundException e){
            System.out.println("El archivo no se encontró");
        }catch(EOFException e){
            System.out.println("Archivo leido");
        }finally{
            if(lee != null){
                lee.close();
            }
        }
        
        addWindowListener(new CW());
        setVisible(true);
        setSize(500, 500);
    }
    
    private class CW extends WindowAdapter{
        public void windowClosing(WindowEvent e){
            setVisible(false);
            dispose();
        }
    }
}
