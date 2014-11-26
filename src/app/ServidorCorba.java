package app;

import calc.Calculadora;
import calc.CalculadoraHelper;
import calculadoracorba.CalculadoraCORBA;
import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.CORBA.Object;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

/**
 *
 * @author Izaquiel Cruz
 */
public class ServidorCorba {

    public static void main(String[] args) {

        try {
            ORB orb = ORB.init(args, System.getProperties());

            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));

            CalculadoraCORBA calculadora = new CalculadoraCORBA();

            calculadora.setOrb(orb);

            Object ref = rootPOA.servant_to_reference(calculadora);

            Calculadora href = CalculadoraHelper.narrow(ref);

            Object objRef = orb.resolve_initial_references("CalculadoraService");

            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            String name = "calculadora";

            NameComponent path[] = ncRef.to_name(name);

            ncRef.rebind(path, href);

            rootPOA.the_POAManager().activate();

            System.out.println("Aguardando conexoes..");

            orb.run();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
