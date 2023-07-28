/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab2p2_jorgeramirezz;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Jorge Ramirez
 */
public class LAB2P2_JorgeRamirezz {
    private static Gerente gerente = new Gerente();
    private static ArrayList<Chef> chefs = new ArrayList<>();
    private static ArrayList<Mesero> meseros = new ArrayList<>();
    private static ArrayList<Bartender> bartenders = new ArrayList<>();
    private static ArrayList<Mesa> mesas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Iniciar sesión como gerente
        System.out.print("Ingrese el usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Ingrese la contrasena: ");
        String contrasena = scanner.nextLine();

        if (!gerente.verificarCredenciales(usuario, contrasena)) {
            System.out.println("Credenciales incorrectas. El programa se cerrara.");
            System.exit(0);
        }

        int opcion;
        do {
            // Mostrar el menú
            System.out.println("\n--- Menu ---");
            System.out.println("1. Chefs");
            System.out.println("2. Meseros");
            System.out.println("3. Bartenders");
            System.out.println("4. Mesas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcioon: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    menuChefs(scanner);
                    break;
                case 2:
                    menuMeseros(scanner);
                    break;
                case 3:
                    menuBartenders(scanner);
                    break;
                case 4:
                    menuMesas(scanner);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion invalida. Intente nuevamente.");
                    break;
            }

        } while (opcion != 5);

        scanner.close();
    }
    // Métodos para el menú de Chefs
    private static void menuChefs(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- Menu Chefs ---");
            System.out.println("1. Crear Chef");
            System.out.println("2. Modificar Chef");
            System.out.println("3. Eliminar Chef");
            System.out.println("4. Listar Chefs");
            System.out.println("5. Regresar");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    crearChef(scanner);
                    break;
                case 2:
                    modificarChef(scanner);
                    break;
                case 3:
                    eliminarChef(scanner);
                    break;
                case 4:
                    listarChefs();
                    break;
                case 5:
                    System.out.println("Regresando al menu principal...");
                    break;
                default:
                    System.out.println("Opcion invalida. Intente nuevamente.");
                    break;
            }

        } while (opcion != 5);
    }

    private static void crearChef(Scanner scanner) {
        if (chefs.size() >= 14) {
            System.out.println("Ya se han creado el maximo de chefs permitidos.");
            return;
        }

        System.out.print("Ingrese el nombre del chef: ");
        String nombre = scanner.next();
        System.out.print("Ingrese la edad del chef: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de linea
        System.out.print("Ingrese el turno del chef (matutino/vespertino): ");
        String turno = scanner.nextLine();
        System.out.print("Ingrese el numero de estrellas Michelin del chef: ");
        int numEstrellasMichelin = scanner.nextInt();
        System.out.print("Ingrese el sueldo del chef: ");
        double sueldo = scanner.nextDouble();

        chefs.add(new Chef(nombre, edad, turno, numEstrellasMichelin, sueldo));
        System.out.println("Chef creado exitosamente.");
    }

    private static void modificarChef(Scanner scanner) {
        if (chefs.isEmpty()) {
            System.out.println("No hay chefs para modificar.");
            return;
        }

        System.out.println("Listado de chefs:");
        for (int i = 0; i < chefs.size(); i++) {
            System.out.println((i + 1) + ". " + chefs.get(i).getNombre());
        }

        System.out.print("Seleccione el numero del chef a modificar: ");
        int seleccion = scanner.nextInt();
        if (seleccion < 1 || seleccion > chefs.size()) {
            System.out.println("Seleccion invalida.");
            return;
        }

        Chef chef = chefs.get(seleccion - 1);

        System.out.println("\nDatos actuales del chef seleccionado:");
        System.out.println("Nombre: " + chef.getNombre());
        System.out.println("Edad: " + chef.getEdad());
        System.out.println("Turno: " + chef.getTurno());
        System.out.println("Numero de estrellas Michelin: " + chef.getNumEstrellasMichelin());
        System.out.println("Sueldo: " + chef.getSueldo());

        System.out.print("\nIngrese el nuevo nombre del chef (Enter si no desea cambiarlo): ");
        String nombre = scanner.next();
        if (!nombre.isEmpty()) {
            chef.setNombre(nombre);
        }

        System.out.print("Ingrese la nueva edad del chef (0 si no desea cambiarlo): ");
        int edad = scanner.nextInt();
        if (edad > 0) {
            chef.setEdad(edad);
        }
        scanner.nextLine(); // Consumir el salto de línea

        System.out.print("Ingrese el nuevo turno del chef (Enter si no desea cambiarlo): ");
        String turno = scanner.nextLine();
        if (!turno.isEmpty()) {
            chef.setTurno(turno);
        }

        System.out.print("Ingrese el nuevo numero de estrellas Michelin del chef (0 si no desea cambiarlo): ");
        int numEstrellasMichelin = scanner.nextInt();
        if (numEstrellasMichelin > 0) {
            chef.setNumEstrellasMichelin(numEstrellasMichelin);
        }

        System.out.print("Ingrese el nuevo sueldo del chef (0.0 si no desea cambiarlo): ");
        double sueldo = scanner.nextDouble();
        if (sueldo > 0.0) {
            chef.setSueldo(sueldo);
        }

        System.out.println("Chef modificado exitosamente.");
    }
    
    private static void eliminarChef(Scanner scanner) {
        if (chefs.isEmpty()) {
            System.out.println("No hay chefs para eliminar.");
            return;
        }

        System.out.println("Listado de chefs:");
        for (int i = 0; i < chefs.size(); i++) {
            System.out.println((i + 1) + ". " + chefs.get(i).getNombre());
        }

        System.out.print("Seleccione el nuumero del chef a eliminar: ");
        int seleccion = scanner.nextInt();
        if (seleccion < 1 || seleccion > chefs.size()) {
            System.out.println("Su opcionmn es invalida.");
            return;
        }

        chefs.remove(seleccion - 1);
        System.out.println("Chef eliminado exitosamente.");
    }

    private static void listarChefs() {
        if (chefs.isEmpty()) {
            System.out.println("No hay chefs para listar.");
            return;
        }

        System.out.println("--- Listado de Chefs ---");
        for (Chef chef : chefs) {
            System.out.println("Nombre: " + chef.getNombre());
            System.out.println("Edad: " + chef.getEdad());
            System.out.println("Turno: " + chef.getTurno());
            System.out.println("Numero de estrellas Michelin: " + chef.getNumEstrellasMichelin());
            System.out.println("Sueldo: " + chef.getSueldo());
            System.out.println("------------");
        }
    }

    // Métodos para el menú de Meseros
    private static void menuMeseros(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- Menu Meseros ---");
            System.out.println("1. Crear Mesero");
            System.out.println("2. Modificar Mesero");
            System.out.println("3. Eliminar Mesero");
            System.out.println("4. Listar Meseros");
            System.out.println("5. Regresar");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    crearMesero(scanner);
                    break;
                case 2:
                    modificarMesero(scanner);
                    break;
                case 3:
                    eliminarMesero(scanner);
                    break;
                case 4:
                    listarMeseros();
                    break;
                case 5:
                    System.out.println("Regresando al menu principal...");
                    break;
                default:
                    System.out.println("Opcion invalida. Intente nuevamente.");
                    break;
            }

        } while (opcion != 5);
    }

    private static void crearMesero(Scanner scanner) {
        if (meseros.size() >= 8) {
            System.out.println("Ya se han creado el maximo de meseros permitidos.");
            return;
        }

        System.out.print("Ingrese el nombre del mesero: ");
        String nombre = scanner.next();
        System.out.print("Ingrese la edad del mesero: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Ingrese el turno del mesero (matutino/vespertino): ");
        String turno = scanner.nextLine();
        System.out.print("Ingrese el sueldo del mesero: ");
        double sueldo = scanner.nextDouble();
        System.out.print("Ingrese la propina del mesero: ");
        double propina = scanner.nextDouble();
        meseros.add(new Mesero(nombre, edad, turno, sueldo, propina));
        System.out.println("Mesero creado exitosamente.");
    }

    private static void modificarMesero(Scanner scanner) {
        if (meseros.isEmpty()) {
            System.out.println("No hay meseros para modificar.");
            return;
        }

        System.out.println("Listado de meseros:");
        for (int i = 0; i < meseros.size(); i++) {
            System.out.println((i + 1) + ". " + meseros.get(i).getNombre());
        }

        System.out.print("Seleccione el numero del mesero a modificar: ");
        int seleccion = scanner.nextInt();
        if (seleccion < 1 || seleccion > meseros.size()) {
            System.out.println("Seleccion invalida.");
            return;
        }

        Mesero mesero = meseros.get(seleccion - 1);

        System.out.println("\nDatos actuales del mesero seleccionado:");
        System.out.println("Nombre: " + mesero.getNombre());
        System.out.println("Edad: " + mesero.getEdad());
        System.out.println("Turno: " + mesero.getTurno());
        System.out.println("Sueldo: " + mesero.getSueldo());
        System.out.println("Propina: " + mesero.getPropina());

        System.out.print("\nIngrese el nuevo nombre del mesero (Enter si no desea cambiarlo): ");
        String nombre = scanner.next();
        if (!nombre.isEmpty()) {
            mesero.setNombre(nombre);
        }

        System.out.print("Ingrese la nueva edad del mesero (0 si no desea cambiarlo): ");
        int edad = scanner.nextInt();
        if (edad > 0) {
            mesero.setEdad(edad);
        }
        scanner.nextLine(); // Consumir el salto de línea

        System.out.print("Ingrese el nuevo turno del mesero (Enter si no desea cambiarlo): ");
        String turno = scanner.nextLine();
        if (!turno.isEmpty()) {
            mesero.setTurno(turno);
        }

        System.out.print("Ingrese el nuevo sueldo del mesero (0.0 si no desea cambiarlo): ");
        double sueldo = scanner.nextDouble();
        if (sueldo > 0.0) {
            mesero.setSueldo(sueldo);
        }

        System.out.print("Ingrese la nueva propina del mesero (0.0 si no desea cambiarlo): ");
        double propina = scanner.nextDouble();
        if (propina >= 0.0) {
            mesero.setPropina(propina);
        }

        System.out.println("Mesero modificado exitosamente.");
    }

    private static void eliminarMesero(Scanner scanner) {
        if (meseros.isEmpty()) {
            System.out.println("No hay meseros para eliminar.");
            return;
        }

        System.out.println("Listado de meseros:");
        for (int i = 0; i < meseros.size(); i++) {
            System.out.println((i + 1) + ". " + meseros.get(i).getNombre());
        }

        System.out.print("Seleccione el numero del mesero a eliminar: ");
        int seleccion = scanner.nextInt();
        if (seleccion < 1 || seleccion > meseros.size()) {
            System.out.println("Seleccion invalida.");
            return;
        }

        meseros.remove(seleccion - 1);
        System.out.println("Mesero eliminado exitosamente.");
    }

    private static void listarMeseros() {
        if (meseros.isEmpty()) {
            System.out.println("No hay meseros para listar.");
            return;
        }

        System.out.println("--- Listado de Meseros ---");
        for (Mesero mesero : meseros) {
            System.out.println("Nombre: " + mesero.getNombre());
            System.out.println("Edad: " + mesero.getEdad());
            System.out.println("Turno: " + mesero.getTurno());
            System.out.println("Sueldo: " + mesero.getSueldo());
            System.out.println("Propina: " + mesero.getPropina());
            System.out.println("------------");
        }
    }

    // Métodos para el menú de Bartenders
    private static void menuBartenders(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- Menu Bartenders ---");
            System.out.println("1. Crear Bartender");
            System.out.println("2. Modificar Bartender");
            System.out.println("3. Eliminar Bartender");
            System.out.println("4. Listar Bartenders");
            System.out.println("5. Regresar");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    crearBartender(scanner);
                    break;
                case 2:
                    modificarBartender(scanner);
                    break;
                case 3:
                    eliminarBartender(scanner);
                    break;
                case 4:
                    listarBartenders();
                    break;
                case 5:
                    System.out.println("Regresando al menu principal...");
                    break;
                default:
                    System.out.println("Opcion invalida. Intente nuevamente.");
                    break;
            }

        } while (opcion != 5);
    }
    //metodo para crear un bartender.
    private static void crearBartender(Scanner scanner) {
        if (bartenders.size() >= 4) {
            System.out.println("Ya se han creado el maximo de bartenders permitidos.");
            return;
        }

        System.out.print("Ingrese el nombre del bartender: ");
        String nombre = scanner.next();
        System.out.print("Ingrese la edad del bartender: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Ingrese el turno del bartender (matutino/vespertino): ");
        String turno = scanner.nextLine();
        System.out.print("Ingrese el sueldo del bartender: ");
        double sueldo = scanner.nextDouble();
        System.out.print("Ingrese el numero de licores disponibles del bartender: ");
        int numLicoresDisponibles = scanner.nextInt();

        bartenders.add(new Bartender(nombre, edad, turno, sueldo, numLicoresDisponibles));
        System.out.println("Bartender creado exitosamente.");
    }
    //modifico el bartender con un mertodo, reciclado
    private static void modificarBartender(Scanner scanner) {
        if (bartenders.isEmpty()) {
            System.out.println("No hay bartenders para modificar.");
            return;
        }

        System.out.println("Listado de bartenders:");
        for (int i = 0; i < bartenders.size(); i++) {
            System.out.println((i + 1) + ". " + bartenders.get(i).getNombre());
        }

        System.out.print("Seleccione el numero del bartender a modificar: ");
        int seleccion = scanner.nextInt();
        if (seleccion < 1 || seleccion > bartenders.size()) {
            System.out.println("Seleccion invalida.");
            return;
        }

        Bartender bartender = bartenders.get(seleccion - 1);

        System.out.println("\nDatos actuales del bartender seleccionado:");
        System.out.println("Nombre: " + bartender.getNombre());
        System.out.println("Edad: " + bartender.getEdad());
        System.out.println("Turno: " + bartender.getTurno());
        System.out.println("Sueldo: " + bartender.getSueldo());
        System.out.println("Número de licores disponibles: " + bartender.getNumLicoresDisponibles());

        System.out.print("\nIngrese el nuevo nombre del bartender (Enter si no desea cambiarlo): ");
        String nombre = scanner.next();
        if (!nombre.isEmpty()) {
            bartender.setNombre(nombre);
        }

        System.out.print("Ingrese la nueva edad del bartender (0 si no desea cambiarlo): ");
        int edad = scanner.nextInt();
        if (edad > 0) {
            bartender.setEdad(edad);
        }
        scanner.nextLine(); // Consumir el salto de línea

        System.out.print("Ingrese el nuevo turno del bartender (Ingresa 0 si no desea cambiarlo): ");
        String turno = scanner.nextLine();
        if (!turno.isEmpty()) {
            bartender.setTurno(turno);
        }

        System.out.print("Ingrese el nuevo sueldo del bartender (0.0 si no desea cambiarlo): ");
        double sueldo = scanner.nextDouble();
        if (sueldo > 0.0) {
            bartender.setSueldo(sueldo);
        }

        System.out.print("Ingrese el nuevo numero de licores disponibles del bartender (0 si no desea cambiarlo): ");
        int numLicoresDisponibles = scanner.nextInt();
        if (numLicoresDisponibles >= 0) {
            bartender.setNumLicoresDisponibles(numLicoresDisponibles);
        }

        System.out.println("Bartender modificado exitosamente.");
    }
    //metodo reciclado para elimunar el bartender creado o los que elija eliminar el usuario
    private static void eliminarBartender(Scanner scanner) {
        if (bartenders.isEmpty()) {
            System.out.println("No hay bartenders para eliminar.");
            return;
        }

        System.out.println("Listado de bartenders:");
        for (int i = 0; i < bartenders.size(); i++) {
            System.out.println((i + 1) + ". " + bartenders.get(i).getNombre());
        }

        System.out.print("Seleccione el numero del bartender a eliminar: ");
        int seleccion = scanner.nextInt();
        if (seleccion < 1 || seleccion > bartenders.size()) {
            System.out.println("Seleccion invalida.");
            return;
        }

        bartenders.remove(seleccion - 1);
        System.out.println("Bartender eliminado exitosamente.");
    }

    private static void listarBartenders() {
        if (bartenders.isEmpty()) {
            System.out.println("No hay bartenders para listar.");
            return;
        }

        System.out.println("--- Listado de Bartenders ---");
        for (Bartender bartender : bartenders) {
            System.out.println("Nombre: " + bartender.getNombre());
            System.out.println("Edad: " + bartender.getEdad());
            System.out.println("Turno: " + bartender.getTurno());
            System.out.println("Sueldo: " + bartender.getSueldo());
            System.out.println("Numero de licores disponibles: " + bartender.getNumLicoresDisponibles());
            System.out.println("------------");
        }
    }

    // Métodos para el menu de Mesas
    private static void menuMesas(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- Menu de las Mesas ---");
            System.out.println("1. Crear Mesa");
            System.out.println("2. Modificar Mesa");
            System.out.println("3. Eliminar Mesa");
            System.out.println("4. Listar Mesas");
            System.out.println("5. Imprimir Suma Precio Total Mesas");
            System.out.println("6. Regresar");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    crearMesa(scanner);
                    break;
                case 2:
                    modificarMesa(scanner);
                    break;
                case 3:
                    eliminarMesa(scanner);
                    break;
                case 4:
                    listarMesas();
                    break;
                case 5:
                    imprimirSumaPrecioTotalMesas();
                    break;
                case 6:
                    System.out.println("Regresando al principal");
                    break;
                default:
                    System.out.println("La opcioon invalida. Intente nuevamente.");
                    break;
            }

        } while (opcion != 6);
    }

    private static void crearMesa(Scanner scanner) {
        if (mesas.size() >= 10) {
            System.out.println("Ya se han creado el maximo de mesas permitidas.");
            return;
        }

        System.out.print("Ingrese el numero de platos de la mesa: ");
        int numPlatos = scanner.nextInt();
        System.out.print("Ingrese el numero de utensilios de la mesa: ");
        int numUtensilios = scanner.nextInt();
        System.out.print("Ingrese el precio total de la mesa: ");
        double precioTotal = scanner.nextDouble();

        mesas.add(new Mesa(numPlatos, numUtensilios, precioTotal));
        System.out.println("Mesa creada exitosamente.");
    }

    private static void modificarMesa(Scanner scanner) {
        if (mesas.isEmpty()) {
            System.out.println("No hay mesas para modificar.");
            return;
        }

        System.out.println("Listado de mesas:");
        for (int i = 0; i < mesas.size(); i++) {
            System.out.println((i + 1) + ". Mesa con precio total: " + mesas.get(i).getPrecioTotal());
        }

        System.out.print("Seleccione el numero de la mesa a modificar: ");
        int seleccion = scanner.nextInt();
        if (seleccion < 1 || seleccion > mesas.size()) {
            System.out.println("Seleccion invalida.");
            return;
        }

        Mesa mesa = mesas.get(seleccion - 1);

        System.out.println("\nDatos actuales de la mesa seleccionada:");
        System.out.println("Numero de platos: " + mesa.getNumPlatos());
        System.out.println("Numero de utensilios: " + mesa.getNumUtensilios());
        System.out.println("Precio total: " + mesa.getPrecioTotal());

        System.out.print("\nIngrese el nuevo numero de platos de la mesa (0 si no desea cambiarlo): ");
        int numPlatos = scanner.nextInt();
        if (numPlatos >= 0) {
            mesa.setNumPlatos(numPlatos);
        }

        System.out.print("Ingrese el nuevo numero de utensilios de la mesa (0 si no desea cambiarlo): ");
        int numUtensilios = scanner.nextInt();
        if (numUtensilios >= 0) {
            mesa.setNumUtensilios(numUtensilios);
        }

        System.out.print("Ingrese el nuevo precio total de la mesa (0.0 si no desea cambiarlo): ");
        double precioTotal = scanner.nextDouble();
        if (precioTotal >= 0.0) {
            mesa.setPrecioTotal(precioTotal);
        }

        System.out.println("Mesa modificada exitosamente.");
    }
    //metodo eliminar las mesas creadas
    private static void eliminarMesa(Scanner scanner) {
        if (mesas.isEmpty()) {
            System.out.println("No hay mesas para eliminar.");
            return;
        }

        System.out.println("Listado de mesas:");
        for (int i = 0; i < mesas.size(); i++) {
            System.out.println((i + 1) + ". Mesa con precio total: " + mesas.get(i).getPrecioTotal());
        }

        System.out.print("Seleccione el numero de la mesa a eliminar: ");
        int seleccion = scanner.nextInt();
        if (seleccion < 1 || seleccion > mesas.size()) {
            System.out.println("Seleccion invalida.");
            return;
        }

        mesas.remove(seleccion - 1);
        System.out.println("Mesa eliminada exitosamente.");
    }
    //metofdo para listar las mesas que han sido agregadas
    private static void listarMesas() {
        if (mesas.isEmpty()) {
            System.out.println("No hay mesas para listar.");
            return;
        }

        System.out.println("--- Listado de Mesas ---");
        for (Mesa mesa : mesas) {
            System.out.println("Numero de platos: " + mesa.getNumPlatos());
            System.out.println("Numero de utensilios: " + mesa.getNumUtensilios());
            System.out.println("Precio total: " + mesa.getPrecioTotal());
            System.out.println("------------");
        }
    }
    //metodo para imprimir la suma de las mesas
    private static void imprimirSumaPrecioTotalMesas() {
        if (mesas.isEmpty()) {
            System.out.println("No hay mesas para calcular la suma del precio total.");
            return;
        }

        double sumaPrecioTotal = 0;
        for (Mesa mesa : mesas) {
            sumaPrecioTotal += mesa.getPrecioTotal();
        }

        System.out.println("La suma del precio total de todas las mesas es: " + sumaPrecioTotal);
    }
}//fin class

    
