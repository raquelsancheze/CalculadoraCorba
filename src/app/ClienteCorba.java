
package app;

import corba.Calculadora;
import corba.CalculadoraHelper;
import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

/**
 *
 * @author Izaquiel Cruz
 */
public class ClienteCorba {
    
    static Calculadora calculadora;
    
    public static void main(String[] args) {
        
        try{
            
            ORB orb = ORB.init(args, System.getProperties());
            
            Object objRef = orb.resolve_initial_references("NameService");
            
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            
            String name = "calculadora";
            
            calculadora = CalculadoraHelper.narrow(ncRef.resolve_str(name));
            
            System.out.println(calculadora.somar(2, 4));
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
