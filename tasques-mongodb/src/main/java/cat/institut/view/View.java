package cat.institut.view;

import cat.institut.model.Entrada;

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
        System.out.println("\n=== GESTIÓ DE TASQUES (HTTP) ===");
        System.out.println("1. Afegir tasca");
        System.out.println("2. Eliminar tasca (per ID)");
        System.out.println("3. Modificar tasca (per ID)");
        System.out.println("4. Llistar totes les tasques");
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
     * Mostra una llista de tasques.
     * (Només s'utilitzarà si després parses el JSON)
     */
    public void mostrarTasques(List<Entrada> tasques) {
        if (tasques == null || tasques.isEmpty()) {
            System.out.println("No hi ha tasques.");
            return;
        }

        for (Entrada e : tasques) {
            System.out.println(e);
        }
    }

    /**
     * Demana un text (per exemple ID).
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
