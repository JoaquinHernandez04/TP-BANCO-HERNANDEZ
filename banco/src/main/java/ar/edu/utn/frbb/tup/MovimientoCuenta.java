package ar.edu.utn.frbb.tup;
import java.util.List;

public class MovimientoCuenta {
    private int idCuentaBancaria;
    private String tipoOperacion;
    private double monto;


    public MovimientoCuenta(int idCuentaBancaria, String tipoOperacion, double monto) {
        this.idCuentaBancaria = idCuentaBancaria;
        this.tipoOperacion = tipoOperacion;
        this.monto = monto;
    }


    public int getIdCuentaBancaria() {
        return idCuentaBancaria;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public double getMonto() {
        return monto;
    }

    // Método estático para mostrar movimientos por cuenta
    public static void mostrarMovimientosPorCuenta(String idCuenta, List<MovimientoCuenta> movimientos) {
        boolean encontrados = false;

        System.out.println("=== MOVIMIENTOS DE LA CUENTA " + idCuenta + " ===");
        for (MovimientoCuenta movimiento : movimientos) {
            String idCuentaBancariaStr = String.valueOf(movimiento.getIdCuentaBancaria());
            if (idCuentaBancariaStr.equals(idCuenta)) {
                System.out.println("Tipo de Operación: " + movimiento.getTipoOperacion());
                System.out.println("Monto: " + movimiento.getMonto());
                System.out.println();
                encontrados = true;
            }
        }

        if (!encontrados) {
            System.out.println("No se encontraron movimientos para la cuenta con ID: " + idCuenta);
        }
    }
}