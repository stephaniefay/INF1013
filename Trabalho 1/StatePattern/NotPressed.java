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
public class NotPressed implements State{

    @Override
    public void doAction(Context context) {
      context.setState(this);	
   }

    @Override
   public String toString(){
      return "NotPressed";
   }
}
