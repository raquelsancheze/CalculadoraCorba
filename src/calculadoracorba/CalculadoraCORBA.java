
package calculadoracorba;

import corba.CalculadoraPOA;
import org.omg.CORBA.ORB;

/**
 *
 * @author Izaquiel Cruz
 */
public class CalculadoraCORBA extends CalculadoraPOA{

    private ORB orb;

    public void setOrb(ORB orb) {
        this.orb = orb;
    }
    
    @Override
    public int somar(int valor1, int valor2) {
        return valor1 + valor2;
    }

    @Override
    public int subtrair(int valor1, int valor2) {
        return valor1 - valor2;
    }

    @Override
    public int multiplicar(int valor1, int valor2) {
        return valor1 * valor2;
    }

    @Override
    public double dividir(int valor1, int valor2) {
        return valor1 / valor2;
    }
    
    
    
}
