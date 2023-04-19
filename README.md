
# Projet Agenda UML
## Auteur

- [@ThomasLC-Dev](https://github.com/ThomasLC-Dev) (LE CORVEC Thomas)
## Présentation

Ce projet concerne la création d'un système d'agenda, avec la possibilité de créer de nouveaux utilisateurs, des agendas associés, des contacts associés, ainsi que leurs détails (Email, Numéro de téléphone, Adresse et Site web).
Il s'agit ici d'un rendu sous le format d'une API REST.
## Développement

**API:** Java, Spring boot

**Base de données:** PostgreSQL
## Installation

Pour installer le projet, 2 fichiers sont disponibles (un pour Linux, l'autre pour Windows). Le résultat de ces scripts est identique :
- Création d'un containeur Docker avec PostgreSQL
- Lancement du .jar pour démarrer l'API

**Linux :**
```bash
  ./run.sh
```
**Windows :**
```bash
  run.bat
```
## Documenation API

### Utilisateurs

#### Récupérer tous les utilisateurs

```http
  GET /api/users
```

#### Récupérer un utilisateur

```http
  GET /api/users/{userId}
```

| Paramètre | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `userId`  | `long`   | ID de l'utilisateur        |

#### Créer un utilisateur

```http
  POST /api/users
```

| Body      | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `login`   | `string` | Login de l'utilisateur            |
| `password`| `string` | Mot de passe de l'utilisateur     |

#### Modifier un utilisateur

```http
  PUT /api/users/{userId}
```

| Paramètre | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `userId`  | `long`   | ID de l'utilisateur        |

| Body      | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `login`   | `string` | Login de l'utilisateur            |
| `password`| `string` | Mot de passe de l'utilisateur     |

#### Supprimer un utilisateur

```http
  DELETE /api/users/{userId}
```

| Paramètre | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `userId`  | `long`   | ID de l'utilisateur        |

### Agendas

#### Récupérer tous les agendas d'un utilisateur

```http
  GET /api/agendas?user={userId}
```

| Paramètre | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `userId`  | `long`   | ID de l'utilisateur        |

#### Récupérer un agenda

```http
  GET /api/agendas/{agendaId}
```

| Paramètre | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `agendaId`| `long`   | ID de l'agenda        |

#### Créer un agenda

```http
  POST /api/agendas
```

| Body      | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `name`    | `string` | Nom de l'agenda                   |
| `userId`  | `long`   | ID de l'utilisateur               |

#### Modifier un agenda

```http
  PUT /api/agendas/{agendaId}
```

| Paramètre | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `agendaId`  | `long` | ID de l'agenda             |

| Body      | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `name`    | `string` | Nom de l'agenda                   |
| `userId`  | `long`   | ID de l'utilisateur               |

#### Supprimer un agenda

```http
  DELETE /api/agendas/{agendaId}
```

| Paramètre | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `agendaId`  | `long` | ID de l'agenda             |

### Contacts

#### Récupérer tous les contacts d'un agenda

```http
  GET /api/contacts?agenda={agendaId}
```

| Paramètre | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `agendaId`| `long`   | ID de l'agenda             |

#### Récupérer un contact

```http
  GET /api/contacts/{contactId}
```

| Paramètre  | Type     | Description                |
| :--------  | :------- | :------------------------- |
| `contactId`| `long`   | ID du contact              |

#### Créer un contact

```http
  POST /api/contacts
```

| Body        | Type     | Description                       |
| :--------   | :------- | :-------------------------------- |
| `firstName` | `string` | Prénom du contact                 |
| `lastName`  | `string` | Nom du contact                    |
| `agendaId`  | `long`   | ID de l'agenda                    |

#### Modifier un contact

```http
  PUT /api/contacts/{contactId}
```

| Paramètre   | Type     | Description                |
| :--------   | :------- | :------------------------- |
| `contactId` | `long`   | ID du contact              |

| Body        | Type     | Description                       |
| :--------   | :------- | :-------------------------------- |
| `firstName` | `string` | Prénom du contact                 |
| `lastName`  | `string` | Nom du contact                    |
| `agendaId`  | `long`   | ID de l'agenda                    |

#### Supprimer un contact

```http
  DELETE /api/contacts/{contactId}
```

| Paramètre   | Type     | Description                |
| :--------   | :------- | :------------------------- |
| `contactId` | `long`   | ID du contact              |

### Détails contact

#### Récupérer tous les détails d'un contact

```http
  GET /api/contact-details?contact={contactId}
```

| Paramètre   | Type     | Description                |
| :--------   | :------- | :------------------------- |
| `contactId` | `long`   | ID du contact              |

#### Récupérer un détail

```http
  GET /api/contact-details/{contactDetailId}
```

| Paramètre         | Type     | Description                |
| :--------         | :------- | :------------------------- |
| `contactDetailId`| `long`   | ID du détail               |

#### Créer un détail

```http
  POST /api/contact-details
```

| Body        | Type     | Description                       |
| :--------   | :------- | :-------------------------------- |
| `value`     | `string` | Valeur                            |
| `type`      | `string` | Type (email, phone, address, website)                         |
| `contactId` | `long`   | ID de l'utilisateur               |

#### Modifier un détail

```http
  PUT /api/contact-details/{contactDetailId}
```

| Paramètre         | Type     | Description                |
| :--------         | :------- | :------------------------- |
| `contactDetailId`| `long`   | ID du détail               |

| Body        | Type     | Description                       |
| :--------   | :------- | :-------------------------------- |
| `value`     | `string` | Valeur                            |
| `contactId` | `long`   | ID de l'utilisateur               |

#### Supprimer un détail

```http
  DELETE /api/contact-details/{contactDetailId}
```

| Paramètre         | Type     | Description                |
| :--------         | :------- | :------------------------- |
| `contactDetailId`| `long`   | ID du détail               |