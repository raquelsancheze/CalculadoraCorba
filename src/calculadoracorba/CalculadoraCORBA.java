
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
    public int somar(int valor1, int valor2) { //Función de suma de dos valores
        return valor1 + valor2;
    }

    @Override
    public int subtrair(int valor1, int valor2) { //Función de resta de dos valores
        return valor1 - valor2;
    }

    @Override
    public int multiplicar(int valor1, int valor2) { //Función de multiplicacion de dos valores
        return valor1 * valor2;
    }

    @Override
    public double dividir(int valor1, int valor2) { //Función de division entre dos valores
        return valor1 / valor2;
    }
    
    @Override
    public double decimalABinario(int valor){ //La funcion que he implementado es la del paso de un numero decimal a binario
        //Creamos las variables locales que vamos a usar
        int digito, exp;
        double binario; //Es el numero binario que devolvera la funcion
        //El exponente y el binario comenzaran siendo cero
        exp = 0; 
        binario = 0;
        while(valor != 0){ //Se repetiran las siguientes operaciones mientras el numero decimal que entro por parametros sea distinto de cero
            digito = valor % 2; //Se tiene que ir obteniendo el resto de las divisiones del numero decimal entre dos
            binario = binario + digito * Math.pow(10, exp); //El numero binario será el que tengamos guardado hasta el momento mas el nuevo resto que acabamos de 
            //obtener multiplicado por diez eleveado al numero de iteracciones que hayamos hecho en el while hasta el momento
            exp++; //Aumentamos en uno el exponente en cada vuelta
            valor = valor / 2; //El numero decimal lo vamos dividiendo entre dos 
        }
        return binario; //Devolvemos el numero binario que hemos calculado
    }
    
    
    
}
