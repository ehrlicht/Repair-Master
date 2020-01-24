
// TEMPLATE :
// ==========
// new MyFocusTraversalPolicy(new Component[] {tfNom,tfPrenom,tfEmail,tfPhone,tfAddress,tfAddressDetails,tfNPA,tfArea,btnSave})

package presentation;
 
import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;

/**
 *
 * @author Thery Ehrlich
 * 
 * Gère les focus de composant en composant
 */
public class MyFocusTraversalPolicy extends FocusTraversalPolicy{
    
    private static final int NEXT = +1;
    private static final int PREV = -1;
    
    private Component[] comp;
    
    public MyFocusTraversalPolicy(Component[] c){
        comp = c;
    }

    private int getPosition(Component c){
        for (int i=0;i<comp.length;i++){
            if (comp[i] == c){
                return i;
            }
        }
        return 0;
    }
    
    private Component nextComponent(int position, int inc){
        int next_position = (position + comp.length + inc) % comp.length;
        for (int i=0;i<comp.length;i++){
            Component c = comp[next_position];
            if (c.isEnabled()){
                return c;
            }
            next_position = (next_position + comp.length + inc) % comp.length;
        }
        return comp[0];
    }
    
    @Override
    public Component getComponentAfter(Container aContainer, Component aComponent) {
        int pos = getPosition(aComponent);
        return nextComponent(pos, NEXT);
    }

    @Override
    public Component getComponentBefore(Container aContainer, Component aComponent) {
        int pos = getPosition(aComponent);
        return nextComponent(pos, PREV);
    }

    @Override
    public Component getFirstComponent(Container aContainer) {
        return comp[0];
    }

    @Override
    public Component getLastComponent(Container aContainer) {
        return comp[comp.length-1];
    }

    @Override
    public Component getDefaultComponent(Container aContainer) {
        return comp[0];
    }

}
