package ar.edu.utn.frbb.tup;

import java.util.Scanner;
class BancoMenu {
    private Operaciones operaciones;


    public BancoMenu() {
        this.operaciones = new Operaciones();
        
    }

    public void mostrarMenuPrincipal() {
        // Mostrar opciones del menú principal  
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("=== Menú Principal ===");
            System.out.println("1. Opciones de Clientes");
            System.out.println("2. Opciones de Cuentas Bancarias");
            System.out.println("3. Realizar Operaciones");
            System.out.println("4. Consultar Movimientos");
            System.out.println("0. Salir");
            System.out.println("Seleccione una opción:");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    mostrarMenuClientes();
                    break;
                case 2:
                    mostrarMenuCuentas();
                    break;
                case 3:
                    mostrarMenuOperaciones();
                    break;
                case 4:
                    mostrarMenuMovimientos();
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }
        } while (opcion != 0);
    }

    public void mostrarMenuClientes() {
        // Mostrar opciones del menú de clientes 
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("=== Menú de Clientes ===");
            System.out.println("1. Crear Cliente");
            System.out.println("2. Modificar Cliente");
            System.out.println("0. Volver al Menú Principal");
            System.out.println("Seleccione una opción:");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    operaciones.crearCliente();
                    break;
                case 2:
                    //operaciones.modificarCliente(); FALTA TERMINAR ESTA OPCION DE CLIENTES 
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }
        } while (opcion != 0);
    }

    
    public void mostrarMenuOperaciones() {
    // Mostrar opciones del menú de operaciones
    Scanner scanner = new Scanner(System.in);
    int opcion;
    do {    
    System.out.println("=== MENU OPERACIONES ===");
    System.out.println("1. Realizar Deposito");
    System.out.println("2. Realizar Retiro");
    System.out.println("3. Realizar Transferencia");
    System.out.println("4. Ver saldo de cuenta");
    System.out.println("0. Volver al Menú Principal");
    System.out.print("Seleccione una opción: ");
    opcion = scanner.nextInt();
    switch (opcion) {
            case 1:
                operaciones.realizarDeposito();
                break;
            case 2:
                operaciones.realizarRetiro();
                break;
            case 3:
                operaciones.realizarTransferencia();
                break;
            case 4:
               operaciones.verSaldoCuenta(); 
                break;
            case 0:
                break;
            default:
                System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }
        } while (opcion != 0);
    }

    public void mostrarMenuMovimientos() {
        // Mostrar opciones del menú de movimientos de cuenta
    Scanner scanner = new Scanner(System.in);
    int opcion;
    do {
    System.out.println("=== MENU MOVIMIENTOS DE CUENTA ===");
    System.out.println("1. Consultar Movimientos por Cuenta");
    System.out.println("0. Volver al Menú Principal");
    System.out.print("Seleccione una opción: ");
    opcion = scanner.nextInt();
    switch (opcion) {
        case 1:
            operaciones.mostrarMovimientosDeCuenta();
            break;
        case 0:
            break;
        default:
            System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }
        } while (opcion != 0);
    }


    private void mostrarMenuCuentas() {
        // Mostrar opciones del menú para crear la cuenta
        
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("=== Menú de Cuentas Bancarias ===");
            System.out.println("1. Crear Cuenta Bancaria"); 
            System.out.println("0. Volver al Menú Principal");
            System.out.println("Seleccione una opción:");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    operaciones.crearCuentaBancaria();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }
        } while (opcion != 0);
    }
}