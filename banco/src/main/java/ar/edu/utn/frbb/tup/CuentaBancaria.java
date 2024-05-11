package ar.edu.utn.frbb.tup;



public class CuentaBancaria {
    private int numeroCuenta;
    private Cliente cliente;
    private String tipoCuenta;
    private double saldo;
   

    public CuentaBancaria(int numeroCuenta, Cliente cliente, String tipoCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.cliente = cliente;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
        
    }


    public void depositar(double monto) {
        this.saldo += monto;
    }

    public void retirar(double monto) {
        if (monto <= saldo) {
            this.saldo -= monto;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public double consultarSaldo() {
        return saldo;
    }

    public void transferir(CuentaBancaria destino, double monto) {
        if (monto <= saldo) {
            this.retirar(monto);
            destino.depositar(monto);
        } else {
            System.out.println("Saldo insuficiente para realizar la transferencia.");
        }
    }


    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}
