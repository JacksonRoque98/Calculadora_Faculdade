/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author jacks
 */
public class LimitaCaracteres extends PlainDocument{
    public enum TipoEntrada{
        NUMERODECIMAL;
    }
    
    private int qtdCaracteres;
    private TipoEntrada tpEntrada;
    
    public LimitaCaracteres(int qtdCaracteres, TipoEntrada tpEntrada){
        this.qtdCaracteres = qtdCaracteres;
        this.tpEntrada = tpEntrada;
    }
    
    @Override
    public void insertString(int i, String string, AttributeSet as) throws BadLocationException{
        if(string == null || getLength() == qtdCaracteres){
            return;
        }
        int totalCarac = getLength() + string.length();
        
        String regex = "";
        switch(tpEntrada){
            case NUMERODECIMAL: regex = "[^0-9.]"; break;
        }
        
        string = string.replaceAll(regex,"");
        
        if(totalCarac <= qtdCaracteres){
            super.insertString(i, string, as);
        }
        else{
            String nova = string.substring(0, qtdCaracteres);
            super.insertString(i, string, as);
        }
        
    }
}
