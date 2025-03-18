import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int op;
        double monto;
        boolean estado = true;
        List<CuentaBancaria> lstBanco = new ArrayList<>();

        do {
            System.out.println("""
                    1. CREAR CLIENTE
                    2. MOSTRAR TODAS LAS CUENTAS
                    3. MOSTRAR INFORMACIÓN DE UNA CUENTA ESPECÍFICA
                    4. DEPOSITAR DINERO
                    5. RETIRAR DINERO
                    6. SALIR
                    """);
            try {
                op = teclado.nextInt();
                switch (op) {
                    case 1 -> {
                        System.out.println("INGRESE NOMBRE DEL TITULAR");
                        String titular = teclado.next();
                        System.out.println("INGRESE SALDO DE LA CUENTA");
                        double saldo = teclado.nextDouble();
                        System.out.println("INGRESE NUMERO DE LA CUENTA");
                        int numeroCuenta = teclado.nextInt();
                        lstBanco.add(new CuentaBancaria(titular, saldo, numeroCuenta));
                    }
                    case 2 -> {
                        for (CuentaBancaria cuenta : lstBanco) {
                            System.out.println(cuenta.obtenerInformacion()); // Usar metodo obtenerInformacion()
                        }
                    }
                    case 3 -> {
                        System.out.println("INGRESE NUMERO DE CUENTA");
                        int numeroCuenta = teclado.nextInt();
                        boolean encontrada = false;
                        for (CuentaBancaria cuenta : lstBanco) {
                            if (cuenta.getNumeroCuenta() == numeroCuenta) { // Buscar por número de cuenta
                                System.out.println(cuenta.obtenerInformacion()); // Usar metodo obtenerInformacion()
                                encontrada = true;
                                break;
                            }
                        }
                        if (!encontrada) {
                            System.out.println("Cuenta no encontrada.");
                        }
                    }
                    case 4 -> {
                        System.out.println("INGRESE NUMERO DE CUENTA");
                        int numeroCuenta = teclado.nextInt();
                        System.out.println("DINERO A DEPOSITAR");
                        monto = teclado.nextDouble();
                        for (CuentaBancaria cuenta : lstBanco) {
                            if (cuenta.getNumeroCuenta() == numeroCuenta) {
                                cuenta.depositarDinero(monto); // Usar metodo depositarDinero()
                                System.out.println(cuenta.obtenerInformacion()); // Usar metodo obtenerInformacion()
                                break;
                            }
                        }
                    }
                    case 5 -> {
                        System.out.println("INGRESE NUMERO DE CUENTA");
                        int numeroCuentaRetiro = teclado.nextInt();
                        System.out.println("DINERO A RETIRAR");
                        monto = teclado.nextDouble();
                        for (CuentaBancaria cuenta : lstBanco) {
                            if (cuenta.getNumeroCuenta() == numeroCuentaRetiro) {
                                cuenta.retirarDinero(monto); // Usar metodo retirarDinero()
                                System.out.println(cuenta.obtenerInformacion()); // Usar metodo obtenerInformacion()
                                break;
                            }
                        }
                    }
                    case 6 -> {
                        estado = false;
                        System.out.println("Saliendo...");
                    }
                    default -> System.out.println("NO EXISTE LA OPCION");
                }
            } catch (InputMismatchException e) { // Manejar excepción InputMismatchException
                System.out.println("Error: Entrada inválida. Por favor, ingrese un número entero.");
                teclado.next(); // Limpiar el scanner
            }
        } while (estado);
        teclado.close(); // cerrar el scanner
    }
}
