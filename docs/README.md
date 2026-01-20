# Projecte Tasques – MongoDB i Java

Aquest projecte forma part de les pràctiques de Bases de Dades NoSQL.
Consisteix en una aplicació Java que permet gestionar tasques d’alumnes mitjançant una base de dades MongoDB allotjada a MongoDB Atlas.

L’aplicació permet crear, consultar, modificar i eliminar tasques, així com realitzar cerques amb filtres, seguint una arquitectura Model-Vista-Controlador (MVC).

---

## Tecnologies utilitzades

- Java 17
- Maven
- MongoDB Atlas
- MongoDB Compass
- MongoDB Shell (mongosh)
- MongoDB Driver Sync

---

## Arquitectura del projecte

El projecte segueix el patró **Model-Vista-Controlador (MVC)**:

- **Model**
  - `ConnectionManager`: gestiona la connexió amb MongoDB Atlas.
  - `TasquesModel`: gestiona les operacions CRUD i les consultes a la base de dades.
  - `Entrada`: representa un document de la col·lecció `entrades`.

- **View**
  - `View`: gestiona la interacció amb l’usuari mitjançant consola (menús, formularis i llistats).

- **Controller**
  - `Main`: coordina la comunicació entre la vista i el model.

---

## Base de dades

- **Nom de la base de dades:** `Tasques`
- **Col·lecció principal:** `entrades`

Cada document de la col·lecció representa una tasca associada a un alumne i conté la informació següent:
- nom i cognoms
- data d’entrada de la tasca
- estat de la tasca (completa o no)
- observacions

---

## Importació de dades

El projecte inclou un fitxer JSON amb **25 registres de prova**, ubicat a:

data/tasques.entrades.json

yaml
Copiar código

Aquest fitxer s’ha importat a MongoDB Atlas mitjançant MongoDB Compass.

---

## Requisits previs

Abans d’executar el projecte cal tenir instal·lat:

- Java 17 o superior
- Maven
- Accés a internet
- Un compte a MongoDB Atlas

---

## Configuració de la connexió

La connexió a MongoDB Atlas es configura a la classe:

cat.institut.model.ConnectionManager

nginx
Copiar código

Cal indicar la URI de connexió proporcionada per MongoDB Atlas:

```java
mongodb+srv://USUARI:PASSWORD@cluster.mongodb.net/
Execució del projecte
Clonar el repositori:

bash
Copiar código
git clone <url-del-repositori>
Accedir a la carpeta del projecte:

bash
Copiar código
cd tasques-mongodb
Compilar el projecte amb Maven:

bash
Copiar código
mvn clean compile
Executar l’aplicació:

Des de l’IDE (executant la classe Main)

O des de terminal:

bash
Copiar código
mvn exec:java
Interactuar amb el menú de consola per gestionar les tasques.

Funcionalitats de l’aplicació
L’aplicació permet:

Afegir una tasca

Eliminar una tasca

Modificar una tasca

Llistar totes les tasques

Llistar tasques entre dues dates

Cercar tasques per nom d’alumne

Documentació
La documentació del projecte es troba a la carpeta docs i inclou:

Proposta inicial de l’aplicació (Tasca 1)

Disseny de la base de dades

Diari del procés del projecte

Captures de MongoDB Compass i mongosh

yaml
Copiar código

---

## ✅ README LLIST
Amb això:
- ✔ explica el projecte
- ✔ explica la BBDD
- ✔ explica com executar-lo
- ✔ queda molt professional

---

# 2️⃣ ARA FEM LA PROVA REAL DEL PROJECTE JAVA

Anem **pas a pas**.

## PAS 1 — Comprovar la URI
Abans d’executar res, obre:

cat.institut.model.ConnectionManager

yaml
Copiar código

I comprova que tens **exactament**:
- base de dades: `Tasques`
- col·lecció: `entrades`
- URI correcta (sense `< >`)

⚠️ Important: **Compass ja connecta**, així que el Java també ho ha de fer.

---

## PAS 2 — Compilar el projecte

### Des de terminal (a l’arrel del projecte):

```bash
mvn clean compile
👉 Digues-me:

si acaba sense errors

o enganxa l’error si en surt algun

PAS 3 — Executar l’aplicació
Opció IDE (recomanada)
Executa la classe:

matlab
Copiar código
cat.institut.controller.Main
Opció terminal
(si tens configurat exec-maven-plugin):

bash
Copiar código
mvn exec:java
RESULTAT ESPERAT
A la consola hauries de veure:

el menú

opcions numerades

i en llistar, les tasques de MongoDB Atlas

📸 AQUESTA CAPTURA ÉS CLAU

Consola amb menú + dades reals

👉 Ara fes PAS 2 (mvn clean compile)
i digues-me què surt.
A partir d’aquí, si cal, arreglem l’últim detall i tanquem el projecte 🔒✅












