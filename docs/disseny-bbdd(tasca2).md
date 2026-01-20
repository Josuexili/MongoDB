# Disseny de la Base de Dades (MongoDB)

## 1. Introducció

Aquest projecte utilitza una base de dades **NoSQL MongoDB**, allotjada a **MongoDB Atlas**, per gestionar tasques associades a alumnes.
S’ha escollit MongoDB perquè permet una estructura flexible de documents i facilita l’emmagatzematge i consulta de dades sense un esquema rígid, adaptant-se bé a aplicacions en evolució.

La base de dades rep el nom de **Tasques**.

---

## 2. Estructura general

La base de dades està formada per una **única col·lecció principal**:

- **entrades**

Aquesta col·lecció representa les tasques creades pels alumnes.
S’ha decidit utilitzar una sola col·lecció perquè totes les dades fan referència a una mateixa entitat i no cal separar-les en diverses col·leccions.

---

## 3. Col·lecció `entrades`

Cada document de la col·lecció `entrades` representa **una tasca**.

### Camps del document

| Camp | Tipus | Descripció |
|-----|------|------------|
| `_id` | ObjectId | Identificador únic del document (generat automàticament per MongoDB) |
| `nom` | String | Nom de l’alumne |
| `cognom1` | String | Primer cognom de l’alumne |
| `cognom2` | String | Segon cognom de l’alumne |
| `dataEntrada` | Date | Data de creació o entrada de la tasca |
| `completa` | Boolean | Indica si la tasca està completada |
| `observacions` | String | Comentaris o observacions sobre la tasca |

---

## 4. Justificació del camp `dataEntrada`

El camp **`dataEntrada`** és obligatori i imprescindible, ja que permet:

- Ordenar les tasques cronològicament
- Filtrar tasques entre dues dates
- Complir el requisit de l’enunciat que indica que la col·lecció principal ha d’incloure una data que permeti ordenar els registres

Aquest camp s’emmagatzema com a tipus **Date** de MongoDB.

---

## 5. Exemple de document

```json
{
  "nom": "Laura",
  "cognom1": "Garcia",
  "cognom2": "Pérez",
  "dataEntrada": { "$date": "2025-11-15T09:00:00Z" },
  "completa": true,
  "observacions": "Tasca entregada correctament"
}
