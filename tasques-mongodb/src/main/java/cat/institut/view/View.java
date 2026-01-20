package cat.institut.view;

import cat.institut.model.Entrada;
import org.bson.types.ObjectId;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class View {

    private final Scanner scanner;
    private final SimpleDateFormat dateFormat;

    public View() {
        scanner = new Scanner(System.in);
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
    }

    /**
     * Mostra el menú principal i retorna l'opció escollida.
     */
    public int mostrarMenu() {
        System.out.println("\n=== GESTIÓ DE TASQUES ===");
        System.out.println("1. Afegir tasca");
        System.out.println("2. Eliminar tasca");
        System.out.println("3. Modificar tasca");
        System.out.println("4. Llistar totes les tasques");
        System.out.println("5. Llistar tasques entre dates");
        System.out.println("6. Cercar tasques per nom");
        System.out.println("0. Sortir");
        System.out.print("Opció: ");

        return Integer.parseInt(scanner.nextLine());
    }

    /**
     * Demana les dades d'una tasca a l'usuari.
     */
    public Entrada demanarDadesTasca() {
        try {
            System.out.print("Nom alumne/a: ");
            String nom = scanner.nextLine();

            System.out.print("Cognom 1: ");
            String cognom1 = scanner.nextLine();

            System.out.print("Cognom 2: ");
            String cognom2 = scanner.nextLine();

            System.out.print("Data entrada (yyyy-MM-dd): ");
            Date data = dateFormat.parse(scanner.nextLine());

            System.out.print("Tasca completada? (true/false): ");
            boolean completa = Boolean.parseBoolean(scanner.nextLine());

            System.out.print("Observacions: ");
            String observacions = scanner.nextLine();

            return new Entrada(nom, cognom1, cognom2, data, completa, observacions);

        } catch (ParseException e) {
            System.out.println("Format de data incorrecte.");
            return null;
        }
    }

    /**
     * Mostra una llista de tasques numerada.
     */
    public void mostrarTasques(List<Entrada> tasques) {
        if (tasques.isEmpty()) {
            System.out.println("No hi ha tasques.");
            return;
        }

        for (int i = 0; i < tasques.size(); i++) {
            System.out.println(i + " - " + tasques.get(i));
        }
    }

    /**
     * Demana a l'usuari que seleccioni una tasca.
     */
    public ObjectId seleccionarTasca(List<Entrada> tasques) {
        System.out.print("Selecciona el número de la tasca: ");
        int index = Integer.parseInt(scanner.nextLine());

        return tasques.get(index).getId();
    }

    /**
     * Demana una data a l'usuari.
     */
    public Date demanarData(String missatge) {
        try {
            System.out.print(missatge + " (yyyy-MM-dd): ");
            return dateFormat.parse(scanner.nextLine());
        } catch (ParseException e) {
            System.out.println("Format de data incorrecte.");
            return null;
        }
    }

    /**
     * Demana un text (per filtres).
     */
    public String demanarText(String missatge) {
        System.out.print(missatge);
        return scanner.nextLine();
    }

    /**
     * Mostra un missatge informatiu.
     */
    public void mostrarMissatge(String missatge) {
        System.out.println(missatge);
    }
}
