/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StatePattern;

/**
 *
 * @author steph
 */
public class StartButton implements State {
    
    public void doAction (Context context) {
        context.setState(this);
    }
    
    public String toString(){
      return "Pressed";
   }
    
}
