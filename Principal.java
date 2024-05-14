import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ConsultaMoneda consultaMoneda = new ConsultaMoneda();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido/a al Conversor de Moneda （＾ω＾）");
        System.out.println("★・・・・・・★・・・・・・★・・・・・・★・・・・・・★・・・・・・★・・・・・・★");

        int opcion = 0;
        while (opcion != 8) {
            mostrarMenu();
            opcion = scanner.nextInt();

            if (opcion >= 1 && opcion <= 7) {
                System.out.println("Ingresa la cantidad a convertir: ");
                double cantidad = scanner.nextDouble();

                String monedaBase;
                String monedaDestino;

                switch (opcion) {
                    case 1:
                        monedaBase = "ARS";
                        monedaDestino = "BOB";
                        break;
                    case 2:
                        monedaBase = "CLP";
                        monedaDestino = "COP";
                        break;
                    case 3:
                        monedaBase = "BRL";
                        monedaDestino = "USD";
                        break;
                    case 4:
                        monedaBase = "USD";
                        monedaDestino = "ARS";
                        break;
                    case 5:
                        monedaBase = "USD";
                        monedaDestino = "BOB";
                        break;
                    case 6:
                        monedaBase = "USD";
                        monedaDestino = "CLP";
                        break;
                    case 7:
                        monedaBase = "USD";
                        monedaDestino = "COP";
                        break;

                    default:
                        System.out.println("Opción no válida.");
                        continue;
                }

                Moneda resultado = consultaMoneda.buscaMoneda(monedaBase, monedaDestino, cantidad);
                if (resultado != null) {
                    System.out.printf("%.2f %s equivalen a %.2f %s\n", cantidad, monedaBase, resultado.conversion_result, monedaDestino);
                    System.out.println("★・・・・・・★・・・・・・★・・・・・・★・・・・・・★・・・・・・★・・・・・・★\n");
                } else {
                    System.out.println("No se pudo obtener el tipo de cambio.");
                }
            } else if (opcion == 8) {
                System.out.println("Gracias por usar el Conversor\n" +
                        "──────▄▀▄─────▄▀▄\n" +
                        "─────▄█░░▀▀▀▀▀░░█▄\n" +
                        "─▄▄──█░░░░░░░░░░░█──▄▄\n" +
                        "█▄▄█─█░░▀░░┬░░▀░░█─█▄▄█");
            } else {
                System.out.println("Ingresa una opción válida.");
            }
        }
        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println("""
                -ˋˏ ༻✿༺ ˎˊ- Escribe el número de la opción deseada -ˋˏ ༻✿༺ ˎˊ-
                1 - Peso argentino [ARS] - Boliviano [BOB]
                2 - Peso chileno [CLP] - Peso colombiano [COP]
                3 - Real brasileño [BRL] - Dólar estadounidense [USD]
                4 - Dólar estadounidense [USD] - Peso argentino [ARS]
                5 - Dólar estadounidense [USD] - Boliviano [BOB]
                6 - Dólar estadounidense [USD] - Peso chileno [CLP]
                7 - Dólar estadounidense [USD] - Peso colombiano [COP]
                8 - Salir
                """);
    }
}