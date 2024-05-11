package ar.edu.utn.frbb.tup;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// Clase Operaciones
class Operaciones {
    private List<Cliente> clientes;
    private List<CuentaBancaria> cuentas;
    private List<MovimientoCuenta> movimientos;

    // Constructor
    public Operaciones() {
        this.clientes = new ArrayList<>();
        this.cuentas = new ArrayList<>();
        this.movimientos = new ArrayList<>();
    }
 // ======================= EMPIEZA CLIENTE ======================= 
    public void crearCliente() {
        // Crear cliente (Aun no tiene cuenta a su nombre, solo se registra)
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del cliente:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el apellido del cliente:");
        String apellido = scanner.nextLine();
        System.out.println("Ingrese la dirección del cliente:");
        String direccion = scanner.nextLine();
        System.out.println("Ingrese el DNI del cliente:");
        int DNI = scanner.nextInt();
        Cliente cliente = new Cliente(DNI, nombre, apellido, direccion);
        clientes.add(cliente);
        System.out.println("Cliente creado con éxito.");
    }


    public void modificarCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el DNI del cliente que desea modificar:");
        int dniCliente = scanner.nextInt();
        scanner.nextLine();
        Cliente cliente = null;
        for (Cliente c : clientes) {
            if (c.getDni() == dniCliente) {
                cliente = c;
                break;
            }
        }
        if (cliente != null) {
            System.out.println("Ingrese el nuevo nombre del cliente:");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese el nuevo apellido del cliente:");
            String apellido = scanner.nextLine();
            System.out.println("Ingrese la nueva dirección del cliente:");
            String direccion = scanner.nextLine();

            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setDireccion(direccion);
            System.out.println("Cliente modificado con éxito.");
        }
    }


     // ======================= CIERRA CLIENTE ======================= 



     // ======================= EMPIEZA ASOCIAR CUENTA ======================= 

     public void crearCuentaBancaria() {
        Scanner scanner = new Scanner(System.in);
       
        System.out.println("Ingrese el DNI del cliente para asociar la cuenta:");
        int dniCliente = scanner.nextInt();
        scanner.nextLine();
        Cliente cliente = null;
        for (Cliente c : clientes) {
            if (c.getDni() == dniCliente) {
                cliente = c;
                break;
            }
        }
        if (cliente != null) {

            System.out.println("Ingrese el tipo de cuenta (Corriente/Ahorros):");
            String tipoCuenta = scanner.nextLine();
            System.out.println("Ingrese el saldo inicial:");
            double saldoInicial = scanner.nextDouble();
            scanner.nextLine();

            int numeroCuenta = cuentas.size() + 1;
            CuentaBancaria nuevaCuenta = new CuentaBancaria(numeroCuenta, cliente, tipoCuenta, saldoInicial);
            cuentas.add(nuevaCuenta);

            System.out.println("Cuenta bancaria creada y asociada al cliente con DNI " + dniCliente + ".");
        } else {
            System.out.println("Cliente no encontrado con DNI " + dniCliente + ". Operación cancelada.");
        }
    }
    
     // ======================= CIERRA ASOCIAR CUENTA ======================= 



    // ======================= EMPIEZA MOVIMIENTOS =======================

    public void realizarDeposito() {
        Scanner scanner = new Scanner(System.in);
    

        System.out.println("Ingrese el número de cuenta para realizar el depósito:");
        int numeroCuenta = scanner.nextInt();
        scanner.nextLine(); 
    

        CuentaBancaria cuenta = buscarCuenta(numeroCuenta);
    
        if (cuenta != null) {

            System.out.println("Ingrese el monto a depositar:");
            double monto = scanner.nextDouble();
            scanner.nextLine();
    
            // Actualizar el saldo
            cuenta.depositar(monto);
    

            registrarMovimiento(cuenta, "DEPOSITO", monto);
    
            System.out.println("Deposito realizado correctamente en la cuenta " + cuenta.getNumeroCuenta());
            System.out.println("Nuevo saldo: " + cuenta.getSaldo());
        } else {
            System.out.println("Cuenta bancaria no encontrada con el numero " + numeroCuenta);
        }
    }

    public void realizarRetiro() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el numero de cuenta para realizar el retiro:");
        int numeroCuenta = scanner.nextInt();
        scanner.nextLine();

        CuentaBancaria cuenta = buscarCuenta(numeroCuenta);
    
        if (cuenta != null) {

            System.out.println("Ingrese el monto a retirar:");
            double monto = scanner.nextDouble();
            scanner.nextLine();
    
            // Verificar si el saldo es suficiente
            if (cuenta.getSaldo() >= monto) {

                cuenta.retirar(monto);
    
                // Registrar el movimiento de retiro
                registrarMovimiento(cuenta, "RETIRO", -monto); // El monto es negativo en un retiro
    
                System.out.println("Retiro realizado correctamente en la cuenta " + cuenta.getNumeroCuenta());
                System.out.println("Nuevo saldo: " + cuenta.getSaldo());
            } else {
                System.out.println("Saldo insuficiente para realizar el retiro.");
            }
        } else {
            System.out.println("Cuenta bancaria no encontrada con el numero " + numeroCuenta);
        }
    }


    public void realizarTransferencia() {
        Scanner scanner = new Scanner(System.in);
    
        // Solicitar el número de cuenta de origen
        System.out.println("Ingrese el numero de cuenta de origen:");
        int numeroCuentaOrigen = scanner.nextInt();
        scanner.nextLine();
    
        // Buscar la cuenta bancaria de origen
        CuentaBancaria cuentaOrigen = buscarCuenta(numeroCuentaOrigen);
    
        if (cuentaOrigen != null) {
            // Solicitar el número de cuenta de destino
            System.out.println("Ingrese el número de cuenta de destino:");
            int numeroCuentaDestino = scanner.nextInt();
            scanner.nextLine();
    
            // Buscar la cuenta bancaria de destino
            CuentaBancaria cuentaDestino = buscarCuenta(numeroCuentaDestino);
    
            if (cuentaDestino != null) {

                System.out.println("Ingrese el monto a transferir:");
                double monto = scanner.nextDouble();
                scanner.nextLine();

                if (cuentaOrigen.getSaldo() >= monto) {

                    cuentaOrigen.retirar(monto);
                    cuentaDestino.depositar(monto);
    

                    registrarMovimiento(cuentaOrigen, "TRANSFERENCIA ENVIADA", -monto); // Monto negativo en transferencia enviada
                    registrarMovimiento(cuentaDestino, "TRANSFERENCIA RECIBIDA", monto);
    
                    System.out.println("Transferencia realizada correctamente desde cuenta "
                                       + cuentaOrigen.getNumeroCuenta() + " a cuenta " + cuentaDestino.getNumeroCuenta());
                    System.out.println("Nuevo saldo en cuenta origen: " + cuentaOrigen.getSaldo());
                } else {
                    System.out.println("Saldo insuficiente en la cuenta de origen para realizar la transferencia.");
                
                }
            } else {
                System.out.println("Cuenta bancaria de destino no encontrada con el número " + numeroCuentaDestino);
            }
        } else {
            System.out.println("Cuenta bancaria de origen no encontrada con el número " + numeroCuentaOrigen);
        }
    }


    public void mostrarMovimientosDeCuenta() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el ID de la cuenta bancaria para ver sus movimientos:");
        int idCuenta = scanner.nextInt();
        MovimientoCuenta.mostrarMovimientosPorCuenta(String.valueOf(idCuenta), movimientos);    
    }


    public void verSaldoCuenta() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el ID de la cuenta bancaria para mostrar el saldo:");
        int idCuenta = scanner.nextInt();
    
        
        CuentaBancaria cuenta = buscarCuenta(idCuenta);
    
        if (cuenta != null) {
            System.out.println("======= SALDO =======");
            System.out.println("Cuenta " + idCuenta + ": " + cuenta.getSaldo());
        } else {
            System.out.println("No se encontró la cuenta con ID: " + idCuenta);
        }


    }

    // ======================= CIERRA MOVIMIENTOS =======================



    // ======================= EMPIEZA EXTRAS =======================
   

    private CuentaBancaria buscarCuenta(int numeroCuenta) {
        for (CuentaBancaria cuenta : cuentas) {
            if (Integer.toString(cuenta.getNumeroCuenta()).equals(Integer.toString(numeroCuenta))) {
                return cuenta;
            }
        }
        return null;
    }

    private void registrarMovimiento(CuentaBancaria cuenta, String tipoOperacion, double monto) {
        MovimientoCuenta movimiento = new MovimientoCuenta(cuenta.getNumeroCuenta(), tipoOperacion, monto);
        movimientos.add(movimiento);
    }

    // ======================= CIERRA EXTRAS =======================
}