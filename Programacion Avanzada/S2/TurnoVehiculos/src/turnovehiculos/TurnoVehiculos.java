package turnovehiculos;

import Clases.Turnos;
import Clases.Vehiculo;
import Logica.TurnosJpaController;
import Logica.VehiculoJpaController;

/**
 *
 * @author LucasJG
 */
public class TurnoVehiculos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vehiculo objVehiculo = new Vehiculo(1997, "Mazda");
        VehiculoJpaController objCtrV = new VehiculoJpaController();
        objCtrV.create(objVehiculo);
        
        Turnos objTurno = new Turnos("3456C", "Reparar Llanta", objVehiculo.getIdVel());
        TurnosJpaController objCtrT = new TurnosJpaController();
        objCtrT.create(objTurno);
    }    
}
