/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author Thery Ehrlich
 * 
 * Gère l'affichage et la supression des placeholders fournis en paramètre pour 
 * les champs texte de l'application 
 */
abstract class PlaceholderControl {
    
    public static void addPlaceHolder(JTextField tf, String placeHolder) {
        tf.setText(placeHolder);
        tf.setForeground(Color.GRAY);
    }

    public static void removePlaceHolder(JTextField tf, String placeHolder) {
        if (tf.getText().equals(placeHolder)) {
            tf.setText("");
            tf.setForeground(Color.BLACK);
        }
    }

    public static void controlPlaceHolder(KeyEvent evt, JTextField tf, String ph) {
        if (tf.getText().equals(ph) && evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            evt.consume();
            return;
        }
        if (tf.getText().equals(ph) && evt.getKeyCode() == KeyEvent.VK_DELETE) {
            evt.consume();
            return;
        }
        removePlaceHolder(tf, ph);
    }

    public static void setKeyRelease(JTextField tf, String ph) {
        if (tf.getText().length() == 0) {
            addPlaceHolder(tf, ph);
            tf.setCaretPosition(0);
        }
    }
}
