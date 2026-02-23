package cat.institut.controller;

import cat.institut.model.Entrada;
import cat.institut.model.TasquesModel;
import cat.institut.view.View;

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

                        String resposta = model.inserirTasca(
                                nova.getNom(),
                                nova.getCognom1(),
                                nova.getCognom2(),
                                nova.getDataEntrada(),
                                nova.isCompleta(),
                                nova.getObservacions()).join(); // Esperem el CompletableFuture

                        System.out.println("Resposta servidor:");
                        System.out.println(resposta);
                    }
                }

                case 2 -> { // Eliminar tasca
                    System.out.print("Introdueix ID de la tasca a eliminar: ");
                    String id = view.demanarText("");

                    String resposta = model.deleteTasca(id).join();

                    System.out.println("Resposta servidor:");
                    System.out.println(resposta);
                }

                case 3 -> { // Modificar tasca
                    System.out.print("Introdueix ID de la tasca a modificar: ");
                    String id = view.demanarText("");

                    Entrada nova = view.demanarDadesTasca();

                    if (nova != null) {

                        String resposta = model.updateTasca(
                                id,
                                nova.getNom(),
                                nova.getCognom1(),
                                nova.getCognom2(),
                                nova.getDataEntrada(),
                                nova.isCompleta(),
                                nova.getObservacions()).join();

                        System.out.println("Resposta servidor:");
                        System.out.println(resposta);
                    }
                }

                case 4 -> { // Llistar totes
                    String resposta = model.getAllTasques().join();

                    System.out.println("Tasques del servidor:");
                    System.out.println(resposta);
                }

                case 0 -> System.out.println("Sortint...");

                default -> System.out.println("Opció no vàlida.");
            }

        } while (opcio != 0);
    }
}
