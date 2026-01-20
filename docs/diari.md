# Diari del procés del projecte

Aquest document recull les diferents accions realitzades durant el desenvolupament de l’aplicació NoSQL amb MongoDB i Java, així com les dates en què s’han dut a terme, principalment durant el període de vacances de Nadal i fins a la data límit de lliurament de la Tasca 3.

---

## 2025-12-20
- Revisió de l’enunciat de les pràctiques.
- Repàs de la proposta inicial de l’aplicació (Tasca 1).
- Decisió definitiva de l’estructura de la base de dades i de l’aplicació.

---

## 2025-12-21
- Creació del projecte Java utilitzant Maven.
- Configuració del fitxer `pom.xml` amb el driver oficial de MongoDB.
- Prova inicial del projecte per verificar que compila correctament.

---

## 2025-12-22
- Creació i configuració del compte a MongoDB Atlas.
- Creació del cluster a MongoDB Atlas.
- Configuració de l’usuari de base de dades i assignació de permisos.
- Configuració de l’accés per IP (Network Access).

---

## 2025-12-23
- Implementació de la connexió a MongoDB Atlas des de Java.
- Creació de la classe `ConnectionManager` per centralitzar la connexió a la base de dades.
- Prova de connexió mitjançant una comanda `ping`.

---

## 2025-12-27
- Disseny de l’arquitectura de l’aplicació seguint el patró Model-Vista-Controlador (MVC).
- Creació de la classe `Entrada` per representar els documents de la col·lecció `entrades`.
- Implementació del mètode `toDocument()`.

---

## 2025-12-28
- Implementació del model `TasquesModel`.
- Desenvolupament de les operacions CRUD (crear, llegir, actualitzar i eliminar tasques).
- Implementació de cerques amb filtres per nom i per dates.

---

## 2025-12-29
- Implementació de la classe `View` per gestionar menús, formularis i llistats per consola.
- Implementació del controlador `Main`.
- Proves parcials del funcionament de l’aplicació Java.

---

## 2025-12-30
- Generació d’un fitxer JSON amb 25 registres coherents i variats.
- Creació de la base de dades `Tasques` i de la col·lecció `entrades` a MongoDB Atlas.
- Importació inicial del fitxer JSON mitjançant MongoDB Compass.
- Verificació de les dades importades.

---

## 2026-01-02
- Execució de consultes i filtres des de MongoDB Compass.
- Execució de consultes bàsiques des de `mongosh`.
- Captura de pantalles de les consultes realitzades.

---

## 2026-01-17
- Ajustos finals del codi Java.
- Proves completes de l’aplicació connectant amb MongoDB Atlas.
- Correcció de petits errors de funcionament.

---

## 2026-01-18
- Revisió de les dades emmagatzemades a la base de dades.
- Execució de consultes avançades i filtres addicionals.
- Captura de pantalles de les consultes finals.

---

## 2026-01-19
- Redacció del document de disseny de la base de dades (`disseny-bbdd.md`).
- Organització de la carpeta `docs` del repositori.
- Revisió general de la documentació del projecte.

---

## 2026-01-20
- Revisió final del projecte.
- Comprovació que el codi compila correctament.
- Verificació final de la connexió amb MongoDB Atlas.
- Preparació del repositori de GitHub per a l’entrega final.
