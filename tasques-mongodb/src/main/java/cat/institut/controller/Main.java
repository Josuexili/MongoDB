package cat.institut.controller;

import cat.institut.model.Entrada;
import cat.institut.model.TasquesModel;
import cat.institut.view.View;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        TasquesModel model = new TasquesModel();
        View view = new View();

        int opcio;

        do {
            opcio = view.mostrarMenu();

            switch (opcio) {

                case 1 -> { // Afegir tasca
                    Entrada nova = view.demanarDadesTasca();
                    if (nova != null) {
                        model.inserirTasca(
                                nova.getNom(),
                                nova.getCognom1(),
                                nova.getCognom2(),
                                nova.getDataEntrada(),
                                nova.isCompleta(),
                                nova.getObservacions());
                        view.mostrarMissatge("Tasca afegida correctament.");
                    }
                }

                case 2 -> { // Eliminar tasca
                    List<Entrada> tasques = obtenirLlista(model);
                    view.mostrarTasques(tasques);

                    if (!tasques.isEmpty()) {
                        ObjectId id = view.seleccionarTasca(tasques);
                        model.deleteTasca(id);
                        view.mostrarMissatge("Tasca eliminada.");
                    }
                }

                case 3 -> { // Modificar tasca
                    List<Entrada> tasques = obtenirLlista(model);
                    view.mostrarTasques(tasques);

                    if (!tasques.isEmpty()) {
                        ObjectId id = view.seleccionarTasca(tasques);
                        Entrada nova = view.demanarDadesTasca();

                        if (nova != null) {
                            model.updateTasca(
                                    id,
                                    nova.getNom(),
                                    nova.getCognom1(),
                                    nova.getCognom2(),
                                    nova.getDataEntrada(),
                                    nova.isCompleta(),
                                    nova.getObservacions());
                            view.mostrarMissatge("Tasca modificada.");
                        }
                    }
                }

                case 4 -> { // Llistar totes
                    view.mostrarTasques(obtenirLlista(model));
                }

                case 5 -> { // Llistar entre dates
                    Date inici = view.demanarData("Data inici");
                    Date fi = view.demanarData("Data fi");

                    if (inici != null && fi != null) {
                        view.mostrarTasques(obtenirLlista(model.getTasquesEntreDates(inici, fi)));
                    }
                }

                case 6 -> { // Cercar per nom
                    String nom = view.demanarText("Nom a cercar: ");
                    view.mostrarTasques(obtenirLlista(model.getTasquesByNom(nom)));
                }

                case 0 -> view.mostrarMissatge("Sortint de l'aplicació...");

                default -> view.mostrarMissatge("Opció no vàlida.");
            }

        } while (opcio != 0);
    }

    /**
     * Converteix un FindIterable<Document> a List<Entrada>.
     */
    private static List<Entrada> obtenirLlista(Iterable<Document> documents) {
        List<Entrada> llista = new ArrayList<>();
        for (Document d : documents) {
            llista.add(new Entrada(d));
        }
        return llista;
    }

    /**
     * Sobrecàrrega per obtenir totes les tasques.
     */
    private static List<Entrada> obtenirLlista(TasquesModel model) {
        return obtenirLlista(model.getAllTasques());
    }
}
