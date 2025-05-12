import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

   /* consultaPrecio consulta = new consultaPrecio();
    Precio precio = consulta.buscaPrecio();
        System.out.println(precio);
        System.out.println(precio.ARS());
    }

    */

            Scanner scanner = new Scanner(System.in);
            consultaPrecio consulta = new consultaPrecio();
        boolean continuar = true;

            while (continuar) {
                System.out.println("\n=== Conversor de Monedas ===");
                System.out.println("1. Peso Argentino (ARS) a Dólar (USD)");
                System.out.println("2. Dólar (USD) a Peso Argentino (ARS)");
                System.out.println("3. Dólar (USD) a Peso Mexicano (MXN)");
                System.out.println("4. Peso Mexicano (MXN) a Dólar (USD)");
                System.out.println("5. Sol Peruano (PEN) a Dólar (USD)");
                System.out.println("6. Dólar (USD) a Sol Peruano (PEN)");
                System.out.println("7. Salir");
                System.out.print("Seleccione una opción (1-7): ");

                int opcion;
                try {
                    opcion = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, ingrese un número válido.");
                    continue;
                }

                if (opcion == 7) {
                    continuar = false;
                    System.out.println("¡Gracias por usar el conversor!");
                    continue;
                }

                if (opcion < 1 || opcion > 7) {
                    System.out.println("Opción no válida. Por favor, seleccione una opción entre 1 y 7.");
                    continue;
                }

                System.out.print("Ingrese el monto a convertir: ");
                double monto;
                try {
                    monto = Double.parseDouble(scanner.nextLine());
                    if (monto < 0) {
                        System.out.println("El monto no puede ser negativo.");
                        continue;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, ingrese un monto válido.");
                    continue;
                }

                try {
                    Precio precio = consulta.buscaPrecio();

                    double resultado = 0;
                    String monedaOrigen = "";
                    String monedaDestino = "";

                    switch (opcion) {
                        case 1:
                            resultado = monto / precio.ARS();
                            monedaOrigen = "ARS";
                            monedaDestino = "USD";
                            break;
                        case 2:
                            resultado = monto * precio.ARS();
                            monedaOrigen = "USD";
                            monedaDestino = "ARS";
                            break;
                        case 3:
                            resultado = monto * precio.MXN();
                            monedaOrigen = "USD";
                            monedaDestino = "MXN";
                            break;
                        case 4:
                            resultado = monto / precio.MXN();
                            monedaOrigen = "MXN";
                            monedaDestino = "USD";
                            break;
                        case 5:
                            resultado = monto / precio.PEN();
                            monedaOrigen = "PEN";
                            monedaDestino = "USD";
                            break;
                        case 6:
                            resultado = monto * precio.PEN();
                            monedaOrigen = "USD";
                            monedaDestino = "PEN";
                            break;
                    }

                    System.out.println(
                            String.format("%.2f", monto) + " " + monedaOrigen + " = " +
                                    String.format("%.2f", resultado) + " " + monedaDestino
                    );
                } catch (RuntimeException e) {
                    System.out.println("Error al obtener los precios: " + e.getMessage());
                }
            }

            scanner.close();
        }
}