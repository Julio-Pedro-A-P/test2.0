import java.io.File;
import java.util.Scanner;
import java.util.Arrays;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Calendar;
public class CINE_PLANET {
    Scanner sc=new Scanner(System.in);
    public static final String ROJO = "\033[1;91m";
    public static final String AZUL = "\033[1;34m";
    public static final String VERDE = "\033[1;32m";
    public static final String AMARIILO = "\033[1;33m";
    public static final String MORADO = "\033[1;35m";
    int opcion;
    String[]ciudades={VERDE+"Lima ","Huánuco ","Arequipa ","Juliaca ","Cajamarca ","Piura ","Chiclayo ","Tacna ","Cusco ","Puno ","Huancayo ","Trujillo"};
    String[]preciosporci={"ADULTO=20 S/.\n NIÑO=15 S/.","ADULTO=15 S/.\n NIÑO=12 S/.","ADULTO=17 S/.\n NIÑO=14 S/.","ADULTO=15 S/.\n NIÑO=12 S/.","ADULTO=16 S/.\n NIÑO=13 S/.","ADULTO=16 S/.\n NIÑO=13 S/.","ADULTO=15 S/.\n NIÑO=12 S/.","ADULTO=15 S/.\n NIÑO=12 S/.","ADULTO=16 S/.\n NIÑO=13 S/.","ADULTO=15 S/.\n NIÑO=12 S/.","ADULTO=15 S/.\n NIÑO=12 S/.","ADULTO=17 S/.\n NIÑO=14 S/."};
    String[]peliculas={AMARIILO+"INTENSA MENTE \n Género: Animación \n Duración: 1h 40min","Bad Boys:Hasta la Muerte \n Género: Acción \n Duración: 1h 55min ","El último conjuro \n Género: Terror \n Duración: 1h 50min","El Planeta de los Simios: Nuevo Reino \n Género: Drama \n Duración: 2h 30min","Hachiko 2 \n Género: Familiar \n Duración: 2h 5min","Monkey Man: El despertar de la bestia \n Género: Acción \n Duración: 2h 1min","Inmaculada \n Género: Terror \n Duración: 1h 29min","El Club de los Vándalos \n Género: Drama \n Duración: 1h 55min"};
    String[]Speliculacas={"INTENSA MENTE","Bad Boys: Hasta la Muerte","El último conjuro","El Planeta de los Simios: Nuevo Reino","Hachiko 2","Monkey Man: El despertar de la bestia","Inmaculada","El Club de los Vándalos"};
    String[]sinopsis={"Sinopsis:Continúa la historia de las emociones dentro de la mente de una niña, explorando nuevas aventuras y desafíos","Sinopsis:Los detectives Mike Lowrey y Marcus Burnett vuelven a la acción en una nueva misión llena de adrenalina.","Sinopsis: Un nuevo caso de fenómenos paranormales desafía a los protagonistas a enfrentar fuerzas malignas","Sinopsis: Una continuación de la saga donde los simios luchan por su supervivencia en un mundo post-apocalíptico","Sinopsis: La entrañable historia de lealtad de un perro que espera a su dueño en la estación de tren, ahora en una nueva generació","Sinopsis: Un hombre lucha contra su pasado oscuro y sus poderes ocultos en un mundo lleno de crimen y caos","Sinopsis: Una serie de eventos inexplicables y terroríficos afecta a una familia que busca la verdad detrás de las apariciones","Sinopsis: Un grupo de jóvenes enfrenta las consecuencias de sus acciones rebeldes en un viaje de autodescubrimiento y redención"};
    String[] snack_descrip = {"1.- COMBO 2 SALADO + 2 DUOMÁX OL", "2.- COMBO 2 DULCE + 2 DUOMÁX OL", "3.- COMBO 2 MIX + 2 DUOMÁX OL", "4.- COMBO 1 SALADO + B.MOOD 40 OL", "5.- COMBO 1 DULCE + B.MOOD 40 OL", "1.- Combo 2 Dulce OL CC", "2.- Combo 2 Salado OL CC", "3.- Com.2 Mix Dob.Gig. OL", "4.- Combo 1 OL CC", "5.- Combo de Película OL CC", "6.- Combo Familiar", "1.- Canchita Gigante Mix", "2.- Canchita Gigante Dulce", "3.- Canchita Gigante Salado", "4.- Hot Dog Jumbo", "5.- Nachos con queso cheddar", "6.- Queso adicional 1.5 OZ",  "1.- CCBebida Mediana OL", "2.- CCBebida Grande OL", "3.- Agua San Luis sin gas","1.- Chocolate Biscolata Duo Max", "2.- Chocolate Biscolata Mood 40gr"};
    double[] precio_Snack={43.0,46.0,46.0,22.50,25.50,35, 31, 44, 19.50, 22.50, 47,24.50, 24.50, 20.50, 13.50, 13.50, 4.50,10.50, 12, 4,7.50, 7.50};
    int[] carrito = new int[snack_descrip.length];
    double[] todo_subtotal = new double[5];
    double[] subtotalTodo = new double[1];
    String[] imagen_codigo;
    StringBuilder boleta = new StringBuilder();
    String[] menu_Principal = {
            "1.- Promocional",
            "2.- Combos",
            "3.- Canchita/HD/Nachos",
            "4.- Bebidas",
            "5.- Golosinas"
    };
    double precio_Selegido = 0;
    String info_Snack = "";
    private static int opc_dulceria,cant_per_Total,catpagar;
    private static double pago,vuelto;
    String info_pelicula,info_ciudad;
    int catadulto,catniños,tpagarñ,tpagara,total;
    String[] Popcorn = {
            "    ****   ",
            "  *        *  ",
            "*            * ",
            " \\   POPCORN  / ",
            "  \\          /  ",
            "   \\        /   ",
            "    \\__/    ",
            "     \\__/     "
    };
    String[] Gaseosa = {
            "     __     ",
            "    /      \\   ",
            "   /        \\  ",
            "  |          |  ",
            "  |  GASEOSA |  ",
            "  |          |  ",
            "   \\        /  ",
            "    \\__/   ",
            "                "
    };
    String[] Golosina = {
            "|\\    ***   /|",
            "| \\  *** / |",
            "| /  *** \\ |",
            "|/    ***   \\|",
            "                 "
    };
    public String fcomprar_snack() {
        System.out.println("-------* DULCERIA *-------");
        for (String ver_principal : menu_Principal) {
            System.out.println(ver_principal);
        }
        System.out.println("Seleccione una opción...(1-" + menu_Principal.length + ")");
        opc_dulceria = sc.nextInt();
        sc.nextLine();
        if (opc_dulceria >= 1 && opc_dulceria <= 5) {
            switch (opc_dulceria) {
                case 1:
                    elegirtipo(0, 5, "PROMOCIONAL");
                    break;
                case 2:
                    elegirtipo(5, 11, "COMBOS");
                    break;
                case 3:
                    elegirtipo(11, 17, "CANCHITA / HD / NACHOS");
                    break;
                case 4:
                    elegirtipo(17, 20, "BEBIDAS");
                    break;
                case 5:
                    elegirtipo(20, 22, "GOLOSINAS");
                    break;
            }
        } else {
            System.out.println("Ese snack no existe ☹️, revise la información otra vez por favor");
        }
        return null;
    }
    public String elegirtipo(int inicia, int termina, String tipo_snacks) {
        System.out.println("____/// \uD83C\uDF6C\uD83C\uDF7F\uD83E\uDD64 " + tipo_snacks + " \uD83E\uDD64\uD83C\uDF7F\uD83C\uDF6C///____");
        for (int i = inicia; i < termina; i++) {
            System.out.println(snack_descrip[i]);
        }
        System.out.println("Seleccione una opción...(1-" + (termina- inicia) + ")");
        int opcion = sc.nextInt();
        sc.nextLine();

        if (opcion >= 1 && opcion <= (termina - inicia)) {
            info_Snack = snack_descrip[opcion + inicia- 1];
            precio_Selegido = precio_Snack[opcion + inicia - 1];
            System.out.println("Ha elegido el " + info_Snack + " con un precio de " + precio_Selegido);

            System.out.println("¿Cuántos snacks comprará?");
            int cantidadSnacks = sc.nextInt();
            carrito[inicia + opcion - 1] += cantidadSnacks;
            double subtotalSnacks = precio_Selegido * cantidadSnacks;
            todo_subtotal[opc_dulceria - 1] += subtotalSnacks;

            subtotalTodo[0] = Arrays.stream(todo_subtotal).sum();
            sc.nextLine();
            System.out.println("El monto a pagar es: S/ " + todo_subtotal[opc_dulceria - 1]);
            System.out.println("EL SUBTOTAL ES: S/ " + subtotalTodo[0]);

            System.out.println("¿DESEA COMPRAR ALGÚN SNACK MÁS (SI/NO)? ");
            String resp = sc.nextLine();
            if (resp.equalsIgnoreCase("SI")) {
                this.fcomprar_snack();
            } else if (resp.equalsIgnoreCase("NO")) {
                this.fboletadulcería();
            } else {
                System.out.println("Opción no válida ☹️");
            }
        } else {
            System.out.println("Ese snack no existe ☹️, revise la información otra vez por favor");
        }
        return null;
    }
    public String fboletadulcería() {
        int i;
        System.out.println("¿PAGARÁ CON TARJETA💳(1) O CON EFECTIVO💵(2)?");
        int resp_pago = sc.nextInt();
        if (resp_pago == 1) {
            System.out.println("Proceda a deslizar su tarjeta por el dispositivo POS por favor");
            System.out.println("Por favor, digite su clave PIN (4 dígitos)");
            int clave_pin = sc.nextInt();
            sc.nextLine();
            System.out.println("¿Quiere confirmar la compra?....SI/NO");
            String conf_compra = sc.nextLine();

            if (conf_compra.equalsIgnoreCase("SI")) {
                if (opc_dulceria == 1) {
                    for (i = 1; i <= carrito[0]; i++) {
                        System.out.println(" Promocional #" + i);
                        for (String dibujo : Popcorn) {
                            System.out.println(dibujo);
                        }
                        for (String dibujo : Gaseosa) {
                            System.out.println(dibujo);
                        }
                        for (String dibujo : Golosina) {
                            System.out.println(dibujo);
                        }
                    }
                } else if (opc_dulceria == 2) {
                    for (i = 1; i <= carrito[1]; i++) {
                        System.out.println(" Combo #" + i);
                        for (String dibujo : Popcorn) {
                            System.out.println(dibujo);
                        }
                        for (String dibujo : Gaseosa) {
                            System.out.println(dibujo);
                        }
                    }
                } else if (opc_dulceria == 3) {
                    for (i = 1; i <= carrito[2]; i++) {
                        System.out.println(" Canchita #" + i);
                        for (String dibujo : Popcorn) {
                            System.out.println(dibujo);
                        }
                    }
                } else if (opc_dulceria == 4) {
                    for (i = 1; i <= carrito[3]; i++) {
                        System.out.println(" Bebida #" + i);
                        for (String dibujo : Gaseosa) {
                            System.out.println(dibujo);
                        }
                    }
                } else if (opc_dulceria == 5) {
                    for (i = 1; i <= carrito[4]; i++) {
                        System.out.println(" Golosina  #" + i);
                        for (String dibujo : Golosina) {
                            System.out.println(dibujo);
                        }
                    }
                }

                double igv = subtotalTodo[0] * 0.18;
                double totalPagar = subtotalTodo[0] ;

                String boleta = this.imprimir_Boleta(subtotalTodo[0], igv, totalPagar);
                System.out.println(boleta);

                try {
                    File file = new File("E:\\boleta.txt");
                    FileWriter writer = new FileWriter(file);
                    writer.write(boleta);
                    writer.close();
                    System.out.println("Boleta guardada en boleta_dulceria.txt");
                } catch (IOException e) {
                    System.out.println("Error al exportar la factura.");
                    e.printStackTrace();
                }


            } else if (conf_compra.equalsIgnoreCase("NO")) {
                System.out.println("Espero que disfrute la pelicula😊");
            } else {
                System.out.println("Opción no válida");
            }

        } else if (resp_pago == 2) {
            do {
                System.out.println("Ingrese el monto a pagar por favor:");
                pago = sc.nextDouble();
                vuelto = pago - subtotalTodo[0];
                if (vuelto >= 0) {
                    System.out.println("Tu vuelto es s/" + vuelto);
                } else if (vuelto < 0) {
                    System.out.println("El dinero es insuficiente, si quiere comprar tendrá que incrementar más");
                }
            } while (vuelto < 0);

            sc.nextLine();
            if (opc_dulceria == 1) {
                for (i = 1; i <= carrito[0]; i++) {
                    System.out.println(" Promocional #" + i);
                    for (String dibujo : Popcorn) {
                        System.out.println(dibujo);
                    }
                    for (String dibujo : Gaseosa) {
                        System.out.println(dibujo);
                    }
                    for (String dibujo : Golosina) {
                        System.out.println(dibujo);
                    }
                }
            } else if (opc_dulceria == 2) {
                for (i = 1; i <= carrito[1]; i++) {
                    System.out.println(" Combo #" + i);
                    for (String dibujo : Popcorn) {
                        System.out.println(dibujo);
                    }
                    for (String dibujo : Gaseosa) {
                        System.out.println(dibujo);
                    }
                }
            } else if (opc_dulceria == 3) {
                for (i = 1; i <= carrito[2]; i++) {
                    System.out.println(" Canchita #" + i);
                    for (String dibujo : Popcorn) {
                        System.out.println(dibujo);
                    }
                }
            } else if (opc_dulceria == 4) {
                for (i = 1; i <= carrito[3]; i++) {
                    for (String dibujo : Gaseosa) {
                        System.out.println(dibujo);
                    }
                }
            } else if (opc_dulceria == 5) {
                for (i = 1; i <= carrito[4]; i++) {
                    System.out.println(" Golosina  #" + i);
                    for (String dibujo : Golosina) {
                        System.out.println(dibujo);
                    }
                }
            } else {
                System.out.println("Error");
            }

            double igv = subtotalTodo[0] * 0.18;
            double totalPagar = subtotalTodo[0] ;
            String boleta = this.imprimir_Boleta(subtotalTodo[0], igv, totalPagar);
            System.out.println(boleta);

            try {
                File file = new File("E:\\boleta.txt");
                FileWriter escritor = new FileWriter(file);
                escritor.write(boleta);
                escritor.close();
                System.out.println("Boleta guardada en boleta_dulceria.txt");
            } catch (IOException e) {
                System.out.println("Error al exportar la factura.");
                e.printStackTrace();
            }
        }else {
            System.out.println("Opcion no valida ☹️");
        }
        return null;
    }
    public String imprimir_Boleta(double subtotal, double igv, double totalPagar) {

        System.out.println("--------**//  BOLETA DE DULCERÍA  //**-------");
        for (int i = 0; i < snack_descrip.length; i++) {
            if (carrito[i] > 0) {
                boleta.append(snack_descrip[i]).append(" x").append(carrito[i]).append(" - S/ ").append(precio_Snack[i]).append("      S/ ").append(precio_Snack[i] * carrito[i]).append("\n");
            }
        }
        boleta.append(" -- MONTOS SNACKS: S/ ").append(subtotal - igv).append("\n");
        boleta.append(" -- IGV (18%): S/ ").append(igv).append("\n");
        boleta.append(" -- SUBTOTAL A PAGAR: S/ ").append(totalPagar).append("\n");
        boleta.append(" -- MONTO DADO (efectivo): s/").append(pago).append("\n");
        boleta.append(" -- VUELTO (efectivo): s/").append(vuelto).append("\n");
        boleta.append("-----------* ¡GRACIAS POR SU COMPRA! *--------").append("\n");
        return boleta.toString();
    }
    public String COMPRA_BOLETOS(){
        System.out.println(MORADO+"Antes de comprar selecione la ciudad en la que se encuentra");
        for (int i=0; i<ciudades.length;i++){
            System.out.println((i+1)+ ".- " +ciudades[i]);
        }
        info_ciudad="";
        opcion= sc.nextInt();
        switch (opcion) {
            case 1:
                info_ciudad = ciudades[0];
                System.out.println("Muy bien eres de " + ciudades[0]);
                System.out.println("Los precios de las entradas de a acuerdo a tu ciudad son de:\n " + preciosporci[0]);
                this.CARTELERA();
                this.COMPRA_ENTRADAS1();
                break;
            case 2:
                info_ciudad = ciudades[1];
                System.out.println("Muy bien eres de " + ciudades[1]);
                System.out.println("Los precios de las entradas de a acuerdo a tu ciudad son de:\n " + preciosporci[1]);
                this.CARTELERA();
                this.COMPRA_ENTRADAS1();
                break;
            case 3:
                info_ciudad = ciudades[2];
                System.out.println("Muy bien eres de " + ciudades[2]);
                System.out.println("Los precios de las entradas de a acuerdo a tu ciudad son de:\n " + preciosporci[2]);
                this.CARTELERA();
                this.COMPRA_ENTRADAS1();
                break;
            case 4:
                info_ciudad = ciudades[3];
                System.out.println("Muy bien eres de " + ciudades[3]);
                System.out.println("Los precios de las entradas de a acuerdo a tu ciudad son de:\n " + preciosporci[3]);
                this.CARTELERA();
                this.COMPRA_ENTRADAS1();
                break;
            case 5:
                info_ciudad = ciudades[4];
                System.out.println("Muy bien eres de " + ciudades[4]);
                System.out.println("Los precios de las entradas de a acuerdo a tu ciudad son de:\n " + preciosporci[4]);
                this.CARTELERA();
                this.COMPRA_ENTRADAS1();
                break;
            case 6:
                info_ciudad = ciudades[5];
                System.out.println("Muy bien eres de " + ciudades[5]);
                System.out.println("Los precios de las entradas de a acuerdo a tu ciudad son de:\n " + preciosporci[5]);
                this.CARTELERA();
                this.COMPRA_ENTRADAS1();
                break;
            case 7:
                info_ciudad = ciudades[6];
                System.out.println("Muy bien eres de " + ciudades[6]);
                System.out.println("Los precios de las entradas de a acuerdo a tu ciudad son de:\n " + preciosporci[6]);
                this.CARTELERA();
                this.COMPRA_ENTRADAS1();
                break;
            case 8:
                info_ciudad=ciudades[7];
                System.out.println("Muy bien eres de " +ciudades[7]);
                System.out.println("Los precios de las entradas de a acuerdo a tu ciudad son de:\n "+preciosporci[7]);
                this.CARTELERA();
                this.COMPRA_ENTRADAS1();
                break;
            case 9:
                info_ciudad=ciudades[8];
                System.out.println("Muy bien eres de " +ciudades[8]);
                System.out.println("Los precios de las entradas de a acuerdo a tu ciudad son de:\n "+preciosporci[8]);
                this.CARTELERA();
                this.COMPRA_ENTRADAS1();
                break;
            case 10:
                info_ciudad=ciudades[9];
                System.out.println("Muy bien eres de " +ciudades[9]);
                System.out.println("Los precios de las entradas de a acuerdo a tu ciudad son de:\n "+preciosporci[9]);
                this.CARTELERA();
                this.COMPRA_ENTRADAS1();
                break;
            case 11:
                info_ciudad=ciudades[10];
                System.out.println("Muy bien eres de " +ciudades[10]);
                System.out.println("Los precios de las entradas de a acuerdo a tu ciudad son de:\n "+preciosporci[10]);
                this.CARTELERA();
                this.COMPRA_ENTRADAS1();
                break;
            case 12:
                info_ciudad=ciudades[11];
                System.out.println("Muy bien eres de " +ciudades[11]);
                System.out.println("Los precios de las entradas de a acuerdo a tu ciudad son de:\n "+preciosporci[11]);
                this.CARTELERA();
                this.COMPRA_ENTRADAS1();
                break;

            default:
                System.out.println("Opcion no valida");
                break;

        }
        return null;
    }
    public String Login() {
        String nombre, apellidoP, apellidoM, correo, contra, correo2, contra2;
        int dni;
        System.out.println(ROJO + "--------------------------------------------------------");
        System.out.println(" Ingrese sus datos Personales ");
        System.out.println(" Nombre : ");
        nombre = sc.nextLine();
        System.out.println(" Apellido Paterno");
        apellidoP = sc.nextLine();
        System.out.println(" Apellido Materno");
        apellidoM = sc.nextLine();
        System.out.println(" Ingrese su DNI : ");
        dni = sc.nextInt();
        sc.nextLine();
        System.out.println(" Correo Electronico");
        correo = sc.nextLine();
        System.out.println(" Contraseña");
        contra = sc.nextLine();
        System.out.println("           ---> Usuario Registrado <---            ");
        System.out.println("---------------------------------------------------");
        System.out.println(" ");
        System.out.println("----------------- Iniciar Sesion ------------------");
        System.out.println(" ");
        boolean acceso = false;
        while (!acceso) {
            System.out.println(" Correo Electronico");
            correo2 = sc.nextLine();
            System.out.println(" Contraseña");
            contra2 = sc.nextLine();
            if (correo.equals(correo2) && contra.equals(contra2)) {
                System.out.println("Bienvenido " + nombre + " " + apellidoP + " " + apellidoM);
                acceso = true;
            } else {

                System.out.println("       Datos Incorrectos, Intentelo nuevamente     ");
                System.out.println("---------------------------------------------------");
            }
        }
        return null;
    }
    public String MENUPRINCIPAL() {
        int opc = 0;
        boolean condicion = true;
        System.out.println(MORADO+"Ingrese la opcion que desea realizar");
        //CARTELETA:( PREGUNTAR DE QUE CIUDAD ES------lista de peliculas de exhibicion con su descripcion,horarios de funciones,proximamente)
        //COMPRA BOLETOS:(PREGUNTAR DE DONDE ES, SELECCIONAR PELICULA , SALA Y HORARIO ,ELEJIR ASIENTOS,PAGO(TARGETA O EFECTIVO))
        //COMIDAS Y BEBIDAS: (mostar menu de alimentos y bebidas, ofertas y combos,pago,targeta o efectivo)
        //INFORMACION SOBRE EL CINE: (PREGUNTAR DE QUE CIUDAD ES, DE ACUERDO A ESO DAR UBICACION Y DIRECCIONES Y INFORMACION SOBRE INSTALACIONES,POLITICAS DE DEVOLCION Y CAMBIO)
        //RESERVACIONES O EVENTOS:(ALQUILER DE SALAS PARA EVENTOS PRIVADOS, Proyección de eventos especiales (estrenos, festivales, eventos deportivos, etc.).
        System.out.println(ROJO + " 1.-" + VERDE + " CARTELERA \n " + ROJO + "2.-" + VERDE + " COMPRA DE BOLETOS \n " + ROJO + "3.-" + VERDE + " COMPRA SNACKS \n " + ROJO + "4.-" + VERDE + " INFORMACION SOBRE EL CINE \n " + ROJO + "5.-" + VERDE + " RESERVACIONES O EVENTOS \n " + ROJO + "0.-" + VERDE + " SALIR");
        opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                this.CARTELERA1();
                break;
            case 2:
                this.COMPRA_BOLETOS();
                break;
            case 3:
                this.fcomprar_snack();
                break;
            case 4:
                this.INFOCINE();
                break;
            case 5:
                this.AlquilerSala();
                break;
            default:
                System.out.println(ROJO + "OPCION NO VALIDA" + VERDE);
                this.MENUPRINCIPAL();
        }

        return null;
    }
    public String CARTELERA(){
        switch (opcion){
            case 1:
                System.out.println("Las peliculas disponibles en tu ciudad son:\n"+peliculas[0]+"\n"+sinopsis[0]+"\n"+peliculas[1]+"\n"+sinopsis[1]+"\n"+peliculas[3]+"\n"+sinopsis[3]+"\n"+peliculas[7]+"\n"+sinopsis[7]);
                break;
            case 2:
                System.out.println("Las peliculas disponibles en tu ciudad son:\n"+peliculas[3]+"\n"+sinopsis[3]+"\n"+peliculas[4]+"\n"+sinopsis[4]+"\n"+peliculas[6]+"\n"+sinopsis[6]+"\n"+peliculas[7]+"\n"+sinopsis[7]);
                break;
            case 3:
                System.out.println("Las peliculas disponibles en tu ciudad son:\n"+peliculas[1]+"\n"+sinopsis[1]+"\n"+peliculas[2]+"\n"+sinopsis[2]+"\n"+peliculas[5]+"\n"+sinopsis[5]+"\n"+peliculas[0]+"\n"+sinopsis[0]);
                break;
            case 4:
                System.out.println("Las peliculas disponibles en tu ciudad son:\n"+peliculas[1]+"\n"+sinopsis[1]+"\n"+peliculas[0]+"\n"+sinopsis[0]+"\n"+peliculas[3]+"\n"+sinopsis[3]+"\n"+peliculas[4]+"\n"+sinopsis[4]);
                break;
            case 5:
                System.out.println("Las peliculas disponibles en tu ciudad son:\n"+peliculas[7]+"\n"+sinopsis[7]+"\n"+peliculas[5]+"\n"+sinopsis[5]+"\n"+peliculas[3]+"\n"+sinopsis[3]+"\n"+peliculas[1]+"\n"+sinopsis[1]);
                break;
            case 6:
                System.out.println("Las peliculas disponibles en tu ciudad son:\n"+peliculas[6]+"\n"+sinopsis[6]+"\n"+peliculas[4]+"\n"+sinopsis[4]+"\n"+peliculas[5]+"\n"+sinopsis[5]+"\n"+peliculas[0]+"\n"+sinopsis[0]);
                break;
            case 7:
                System.out.println("Las peliculas disponibles en tu ciudad son:\n"+peliculas[0]+"\n"+sinopsis[0]+"\n"+peliculas[1]+"\n"+sinopsis[1]+"\n"+peliculas[2]+"\n"+sinopsis[2]+"\n"+peliculas[6]+"\n"+sinopsis[6]);
                break;
            case 8:
                System.out.println("Las peliculas disponibles en tu ciudad son:\n"+peliculas[2]+"\n"+sinopsis[2]+"\n"+peliculas[4]+"\n"+sinopsis[4]+"\n"+peliculas[6]+"\n"+sinopsis[6]+"\n"+peliculas[0]+"\n"+sinopsis[0]);
                break;
            case 9:
                System.out.println("Las peliculas disponibles en tu ciudad son:\n"+peliculas[0]+"\n"+sinopsis[0]+"\n"+peliculas[4]+"\n"+sinopsis[4]+"\n"+peliculas[6]+"\n"+sinopsis[6]+"\n"+peliculas[0]+"\n"+sinopsis[0]);
                break;
            case 10:
                System.out.println("Las peliculas disponibles en tu ciudad son:\n"+peliculas[4]+"\n"+sinopsis[4]+"\n"+peliculas[4]+"\n"+sinopsis[4]+"\n"+peliculas[7]+"\n"+sinopsis[7]+"\n"+peliculas[3]+"\n"+sinopsis[3]);
                break;
            case 11:
                System.out.println("Las peliculas disponibles en tu ciudad son:\n"+peliculas[0]+"\n"+sinopsis[0]+"\n"+peliculas[4]+"\n"+sinopsis[4]+"\n"+peliculas[6]+"\n"+sinopsis[6]+"\n"+peliculas[2]+"\n"+sinopsis[2]);
                break;
            case 12:
                System.out.println("Las peliculas disponibles en tu ciudad son:\n"+peliculas[6]+"\n"+sinopsis[6]+"\n"+peliculas[4]+"\n"+sinopsis[4]+"\n"+peliculas[7]+"\n"+sinopsis[7]+"\n"+peliculas[0]+"\n"+sinopsis[0]);
                break;
            default:
                System.out.println(" Opcion Invalida");
        }
        return null;
    }
    public String CARTELERA1(){
        System.out.println(AMARIILO+"Para mejorar su experiencia indique la ciuedad en que se ecuentra");
        for (int i=0; i<ciudades.length;i++){
            System.out.println((i+1)+ ".- " +ciudades[i]);
        }
        opcion= sc.nextInt();
        switch (opcion){
            case 1:
                System.out.println("Las peliculas disponibles en tu ciudad son:\n"+peliculas[0]+"\n"+sinopsis[0]+"\n"+peliculas[1]+"\n"+sinopsis[1]+"\n"+peliculas[3]+"\n"+sinopsis[3]+"\n"+peliculas[7]+"\n"+sinopsis[7]);
                break;
            case 2:
                System.out.println("Las peliculas disponibles en tu ciudad son:\n"+peliculas[3]+"\n"+sinopsis[3]+"\n"+peliculas[4]+"\n"+sinopsis[4]+"\n"+peliculas[6]+"\n"+sinopsis[6]+"\n"+peliculas[7]+"\n"+sinopsis[7]);
                break;
            case 3:
                System.out.println("Las peliculas disponibles en tu ciudad son:\n"+peliculas[1]+"\n"+sinopsis[1]+"\n"+peliculas[2]+"\n"+sinopsis[2]+"\n"+peliculas[5]+"\n"+sinopsis[5]+"\n"+peliculas[0]+"\n"+sinopsis[0]);
                break;
            case 4:
                System.out.println("Las peliculas disponibles en tu ciudad son:\n"+peliculas[1]+"\n"+sinopsis[1]+"\n"+peliculas[0]+"\n"+sinopsis[0]+"\n"+peliculas[3]+"\n"+sinopsis[3]+"\n"+peliculas[4]+"\n"+sinopsis[4]);
                break;
            case 5:
                System.out.println("Las peliculas disponibles en tu ciudad son:\n"+peliculas[7]+"\n"+sinopsis[7]+"\n"+peliculas[5]+"\n"+sinopsis[5]+"\n"+peliculas[3]+"\n"+sinopsis[3]+"\n"+peliculas[1]+"\n"+sinopsis[1]);
                break;
            case 6:
                System.out.println("Las peliculas disponibles en tu ciudad son:\n"+peliculas[6]+"\n"+sinopsis[6]+"\n"+peliculas[4]+"\n"+sinopsis[4]+"\n"+peliculas[5]+"\n"+sinopsis[5]+"\n"+peliculas[0]+"\n"+sinopsis[0]);
                break;
            case 7:
                System.out.println("Las peliculas disponibles en tu ciudad son:\n"+peliculas[0]+"\n"+sinopsis[0]+"\n"+peliculas[1]+"\n"+sinopsis[1]+"\n"+peliculas[2]+"\n"+sinopsis[2]+"\n"+peliculas[6]+"\n"+sinopsis[6]);
                break;
            case 8:
                System.out.println("Las peliculas disponibles en tu ciudad son:\n"+peliculas[2]+"\n"+sinopsis[2]+"\n"+peliculas[4]+"\n"+sinopsis[4]+"\n"+peliculas[6]+"\n"+sinopsis[6]+"\n"+peliculas[0]+"\n"+sinopsis[0]);
                break;
            case 9:
                System.out.println("Las peliculas disponibles en tu ciudad son:\n"+peliculas[0]+"\n"+sinopsis[0]+"\n"+peliculas[4]+"\n"+sinopsis[4]+"\n"+peliculas[6]+"\n"+sinopsis[6]+"\n"+peliculas[0]+"\n"+sinopsis[0]);
                break;
            case 10:
                System.out.println("Las peliculas disponibles en tu ciudad son:\n"+peliculas[4]+"\n"+sinopsis[4]+"\n"+peliculas[4]+"\n"+sinopsis[4]+"\n"+peliculas[7]+"\n"+sinopsis[7]+"\n"+peliculas[3]+"\n"+sinopsis[3]);
                break;
            case 11:
                System.out.println("Las peliculas disponibles en tu ciudad son:\n"+peliculas[0]+"\n"+sinopsis[0]+"\n"+peliculas[4]+"\n"+sinopsis[4]+"\n"+peliculas[6]+"\n"+sinopsis[6]+"\n"+peliculas[2]+"\n"+sinopsis[2]);
                break;
            case 12:
                System.out.println("Las peliculas disponibles en tu ciudad son:\n"+peliculas[6]+"\n"+sinopsis[6]+"\n"+peliculas[4]+"\n"+sinopsis[4]+"\n"+peliculas[7]+"\n"+sinopsis[7]+"\n"+peliculas[0]+"\n"+sinopsis[0]);
                break;
            default:
                System.out.println(" Opcion Invalida");
        }
        return null;
    }
    public String COMPRA_ENTRADAS1(){
        System.out.println("Para seguir con la compra de sus entradas indique");
        int catadulto,catniños,tpagarñ,tpagara,total;
        int padulto=20;
        int pniño=15;
        System.out.println("¿Cuantos adultos son? (Entradra=20)");
        catadulto= sc.nextInt();
        System.out.println("¿Cuantos niños son? (Entrada=15)");
        catniños= sc.nextInt();
        cant_per_Total=catniños+catadulto;
        tpagarñ=catniños*pniño;
        tpagara=catadulto*padulto;
        total=tpagarñ+tpagara;
        System.out.println("Muy bien son "+catadulto+" adultos y " +catniños+" niños");
        System.out.println("El total a pagar es de: "+total);
        System.out.println("Desea pagar por (1.-tarjeta💳) o (2.-efectivo💵)");
        int resp_pago= sc.nextInt();
        switch (resp_pago){
            case 1:
                System.out.println("Deslice la tarjeta porfavor");
                System.out.println("Ahora ingrese su clave");
                int clave= sc.nextInt();
                System.out.println("Muy bien tu pago se realizo con exito");
                this.BOLETA_FINAL();

                break;
            case 2:
                System.out.println("Ingrese la cantidad a pagar");
                catpagar=sc.nextInt();
                int cambio;
                if(catpagar>=total){
                    cambio=catpagar-total;
                    System.out.println("Su cambio es de: "+cambio);
                    this.BOLETA_FINAL();
                } else if  (catpagar<=total);{
                System.out.println("Monto insuficiente");}
            break;

        }
        return null;
    }
    public String BOLETA_FINAL(){
        double total_cine=total+subtotalTodo[0],igv=total_cine*0.18;
        LocalDate fechaActual = LocalDate.now();
        System.out.println("--------  //  - //  BOLETA CINEPLANET  // - // ***  -------");
        System.out.println("                    CINEPLANET                                 ");
        System.out.println("                   Cineplex S.A.");
        System.out.println(" CAJA : 3 " + " CAJERO: CRISTHIAN GOMEZ");
        System.out.println(" NRO.REFERENCIA: 135429");
        Calendar Hora = Calendar.getInstance();
        Calendar Fecha = Calendar.getInstance();
        String fecha_actual, hora_actual;
        int hora = Hora.get(Calendar.HOUR_OF_DAY);
        int minutos = Hora.get(Calendar.MINUTE);
        int dia = Fecha.get(Calendar.DATE);
        int mes = Fecha.get(Calendar.MONTH);
        int anno = Fecha.get(Calendar.YEAR);
        hora_actual = hora + ":" + minutos;
        fecha_actual = dia + "/" + mes + "/" + anno;
        System.out.println("FECHA:   " + fecha_actual + " HORA:  " + hora_actual);
        System.out.println("CIUDAD: " + info_ciudad + "       N° BOLETOS:  " + cant_per_Total);
        System.out.println("PELÍCULA ELEGIDA: " + info_pelicula);
        System.out.println("__ SUBTOTAL PELICULAS : s/" + total + "__");
        System.out.println(boleta);
        System.out.println("__ SUBTOTAL DULCERÍA : s/" + subtotalTodo[0] + "__");
        System.out.println("TOTAL: s/" + (total_cine - igv));
        System.out.println("IGV (18%): s/" + igv);
        System.out.println("TOTAL FINAL: s/" + total_cine);
        System.out.println("MONTO DADO (efectivo): s/" + catpagar);
        System.out.println("VUELTO (efectivo): s/" + vuelto);
        System.out.println("-------* GRACIAS POR SU COMPRA *-------");
        try {
            File file = new File("E:\\boleta_Final.txt");
            FileWriter escrib = new FileWriter(file, true);
            escrib.write("--------   //  - //  BOLETA CINEPLANET  // - // ***--\n");
            escrib.write("FECHA:   " + fecha_actual + " HORA:  " + hora_actual);
            escrib.write("CIUDAD: " + info_ciudad + "       N° BOLETOS:  " + cant_per_Total + "\n");
            escrib.write("PELÍCULA ELEGIDA: " + info_pelicula + "\n");
            escrib.write("__ SUBTOTAL PELICULAS : s/" + total + "__\n");
            escrib.write("__ SUBTOTAL DULCERÍA : s/" + subtotalTodo[0] + "__\n");
            escrib.write("TOTAL: s/" + (total_cine - igv) + "\n");
            escrib.write("IGV (18%): s/" + igv + "\n");
            escrib.write("TOTAL FINAL: s/" + total_cine + "\n");
            escrib.write("MONTO DADO (efectivo): s/" + catpagar + "\n");
            escrib.write("VUELTO (efectivo): s/" + vuelto + "\n");
            escrib.write("-------* GRACIAS POR SU COMPRA *-------\n");
            escrib.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public String INFOCINE() {
        System.out.println("Para mejorar su expereciencia seleccione la ciudad en la que se encuentra para poder brindarle informacion sobre ese cine");
        for (int i = 0; i < ciudades.length; i++) {
            System.out.println((i + 1) + ".- " + ciudades[i]);}
        opcion = sc.nextInt();
        String[] mensaje = {"Consulte Google Maps para conocer la ubicación específica más cercana a usted."};
        String[] politicas_cine = {"Reembolsos disponibles hasta 30 minutos antes del horario del espectáculo.", "Las entradas se pueden canjear por otro horario o película si se solicita al menos 30 minutos antes del horario original."};
        switch (opcion) {
            case 1:
                System.out.println("UBICACION:\n Múltiples ubicaciones incluyendo Cineplanet Alcázar, Cineplanet Salaverry, Cineplanet Primavera y más.\n Direcciones: \n " + mensaje[0] + "\n Políticas de reembolso y cambio : \n" + politicas_cine[0] + "\n" + politicas_cine[1]);
                break;
            case 2:
                System.out.println("UBICACION:\n Cineplanet Real Plaza Huánuco. \n Direcciones: \n " + mensaje[0] + "\n Políticas de reembolso y cambio : \n" + politicas_cine[0] + "\n" + politicas_cine[1]);
                break;
            case 3:
                System.out.println("UBICACION:\n Cineplanet Arequipa, Parque Lambramani. \n Direcciones: \n " + mensaje[0] + "\n Políticas de reembolso y cambio : \n" + politicas_cine[0] + "\n" + politicas_cine[1]);
                break;
            case 4:
                System.out.println("UBICACION:\n Cineplanet Real Plaza Juliaca. \n Direcciones: \n " + mensaje[0] + "\n Políticas de reembolso y cambio : \n" + politicas_cine[0] + "\n" + politicas_cine[1]);
                break;
            case 5:
                System.out.println("UBICACION:\n  Cineplanet Real Plaza Cajamarca. \n Direcciones: \n " + mensaje[0] + "\n Políticas de reembolso y cambio : \n" + politicas_cine[0] + "\n" + politicas_cine[1]);

                break;
            case 6:
                System.out.println("UBICACION:\n  Cineplanet Real Plaza Piura \n Direcciones: \n " + mensaje[0] + "\n Políticas de reembolso y cambio : \n" + politicas_cine[0] + "\n" + politicas_cine[1]);

                break;
            case 7:
                System.out.println("UBICACION:\n  Cineplanet Real Plaza Chiclayo. \n Direcciones: \n " + mensaje[0] + "\n Políticas de reembolso y cambio : \n" + politicas_cine[0] + "\n" + politicas_cine[1]);

                break;
            case 8:
                System.out.println("UBICACION:\n  Cineplanet Real Plaza Tacna \n Direcciones: \n " + mensaje[0] + "\n Políticas de reembolso y cambio : \n" + politicas_cine[0] + "\n" + politicas_cine[1]);

                break;
            case 9:
                System.out.println("UBICACION:\n  Cineplanet Real Plaza Cuzco. \n Direcciones: \n " + mensaje[0] + "\n Políticas de reembolso y cambio : \n" + politicas_cine[0] + "\n" + politicas_cine[1]);

                break;
            case 10:
                System.out.println("UBICACION:\n  Cineplanet Real Plaza Puno. \n Direcciones: \n " + mensaje[0] + "\n Políticas de reembolso y cambio : \n" + politicas_cine[0] + "\n" + politicas_cine[1]);

                break;
            case 11:
                System.out.println("UBICACION:\n  Cineplanet Real Plaza Huáncayo. \n Direcciones: \n " + mensaje[0] + "\n Políticas de reembolso y cambio : \n" + politicas_cine[0] + "\n" + politicas_cine[1]);

                break;
            case 12:
                System.out.println("UBICACION:\n  Cineplanet Real Plaza Trujillo. \n Direcciones: \n " + mensaje[0] + "\n Políticas de reembolso y cambio : \n" + politicas_cine[0] + "\n" + politicas_cine[1]);

                break;
        }

        return null;
    }
    public String AlquilerSala(){
        int opcion_2;
        System.out.println("Selecione que tipo de alquier decea\n"+"1.Evento Corporativo y Privado\n"+"2.Cumpleaños y Proyecciones Privadas\n"+"3.Regresar al Menu Pricipal");
        opcion = sc.nextInt();
        switch (opcion){
            case 1:
                System.out.println("¿Que incluye el alquiler para Eventos Corporativos?\n" +
                        "\n" +
                        "- Alquiler de la Sala: Una sala de cine para uso exclusivo durante el evento.\n" +
                        "- Proyección: Uso del sistema de proyección para presentaciones, videos corporativos o películas.\n" +
                        "- Equipamiento Audiovisual: Micrófonos, altavoces, y otros equipos necesarios para presentaciones.\n" +
                        "- Personal de Apoyo: Personal técnico y de asistencia durante el evento.\n" +
                        "- Catering: Opcionalmente, pueden ofrecer servicios de comida y bebida.(Costo adicional)\n" +
                        "- Decoración y Branding: Posibilidad de personalizar el espacio con la marca o elementos decorativos del evento.(Costo adicional)\n" +
                        "COSTO: 1500 s/.\n"+"Selecione que desea");
                System.out.println("1.Alquilar Sala\n"+"2.Regreasar\n"+"3.Regresar al Menu Principal");
                opcion_2= sc.nextInt();
                switch (opcion_2) {
                    case 1:
                        System.out.println("¡Gracias por elegir Cineplanet!");
                        System.out.println("Selecione la ciudad donde decea alquilar la sala");
                        for (int i=0; i<ciudades.length;i++){
                            System.out.println((i+1)+ ".- " +ciudades[i]);}
                        System.out.println("13.- Regresar");
                        opcion = sc.nextInt();
                        if (opcion<13 && opcion>0){
                            String n,nombre, apellidoP, correo, contra, correo2, contra2;
                            int dni;
                            System.out.print(ROJO + " ");
                            System.out.println(" Ingrese sus datos Personales ");
                            n= sc.nextLine();
                            System.out.println(" Nombre : ");
                            nombre = sc.nextLine();
                            System.out.println(" Apellido Paterno: ");
                            apellidoP = sc.nextLine();
                            System.out.println(" Ingrese su DNI : ");
                            dni = sc.nextInt();
                            System.out.println(" Correo Electronico");
                            correo = sc.nextLine();
                            System.out.println("Datos guardados");
                            System.out.println("Seleciona la fecha");

                        }
                        else if (opcion == 13) {
                            this.AlquilerSala();
                        } else System.out.println("Opcion no valida");

                        break;
                    case 2:
                        this.AlquilerSala();
                        break;
                    case 3:
                        this.MENUPRINCIPAL();
                        break;
                    default:
                        System.out.println("Opcion no disponible");
                        this.MENUPRINCIPAL();
                        break;
                }

                break;
            case 2:
                System.out.println("¿Que incluye el alquiler para Proyecciones Privadas?\n" +
                        "\n" +
                        "- Alquiler de la Sala: Uso exclusivo de una sala de cine para ver una película.\n" +
                        "- Proyección: Proyección de una película, ya sea de la cartelera actual o una seleccionada por el cliente.\n" +
                        "- Personal de Apoyo: Personal del cine para asistir con la proyección y el servicio general.\n" +
                        "- Opciones de Comida y Bebida: Acceso a la confitería del cine, con posibilidad de paquetes especiales.(Costo adicional)\n"+
                        "COSTO: 2000 s/.\n"+"Selecione que desea");
                System.out.println("1.Alquilar Sala\n"+"2.Regreasar\n"+"3.Regresar al Menu Principal");
                opcion_2= sc.nextInt();
                switch (opcion_2) {
                    case 1:
                        System.out.println("¡Gracias por elegir Cineplanet!");
                        System.out.println("Selecione la ciudad donde decea alquilar la sala");
                        for (int i=0; i<ciudades.length;i++){
                            System.out.println((i+1)+ ".- " +ciudades[i]);}
                        System.out.println("13.- Regresar");
                        opcion = sc.nextInt();
                        if (opcion<13 && opcion>0){
                            String n,nombre, apellidoP, correo, contra, correo2, contra2;
                            int dni;
                            System.out.print(ROJO + " ");
                            System.out.println(" Ingrese sus datos Personales ");
                            n= sc.nextLine();
                            System.out.println(" Nombre : ");
                            nombre = sc.nextLine();
                            System.out.println(" Apellido Paterno: ");
                            apellidoP = sc.nextLine();
                            System.out.println(" Ingrese su DNI : ");
                            dni = sc.nextInt();
                            System.out.println(" Correo Electronico");
                            correo = sc.nextLine();

                        }
                        else if (opcion == 13) {
                            this.AlquilerSala();
                        } else System.out.println("Opcion no valida");

                        break;
                    case 2:
                        this.AlquilerSala();
                        break;
                    case 3:
                        this.MENUPRINCIPAL();
                        break;
                    default:
                        System.out.println("Opcion no disponible");
                        this.MENUPRINCIPAL();
                        break;
                }
        }

        return null;
    }

    public static void main(String[]args){
        System.out.println(ROJO + "---------------------------------------------------");
        System.out.println(AZUL + "----------!BIENVENIDO A CINE PLANET¡-----------");
        System.out.println(ROJO + "---------------------------------------------------");
        CINE_PLANET sc = new CINE_PLANET();
        sc.MENUPRINCIPAL();
        //Dpersona = datos de las personas

    }
}