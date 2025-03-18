public class CuentaBancaria {
    private String titular;
    private double saldo;
    private int numeroCuenta;

    public CuentaBancaria(String titular, double saldo, int numeroCuenta) {
        this.titular = titular;
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void depositarDinero(double monto) {
        if (monto > 0) {
            this.saldo += monto;
            System.out.println("Depósito de " + monto + " realizado.");
        } else {
            System.out.println("El monto a depositar debe ser mayor que cero.");
        }
    }

    public void retirarDinero(double monto) {
        if (monto > 0 && monto <= this.saldo) {
            this.saldo -= monto;
            System.out.println("Retiro de " + monto + " realizado.");
        } else if (monto <= 0) {
            System.out.println("El monto a retirar debe ser mayor que cero.");
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public String obtenerInformacion() {
        return "Titular: " + titular + ", Saldo: " + saldo + ", Número de cuenta: " + numeroCuenta;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "titular='" + titular + '\'' +
                ", saldo=" + saldo +
                ", numeroCuenta=" + numeroCuenta +
                '}';
    }
}