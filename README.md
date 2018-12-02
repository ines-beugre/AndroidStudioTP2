# AndroidStudioTP2
L'objectif de ce deuxième TP est de se familiariser avec les RecyclerView. Dans ce TP, il s'agit de
déveloper une nouvelle Activity dans le projet existant qui affchera sous la forme
d'une RecyclerView les
différentes données saisies dans l'Activity de l'exercice 1.1. Ces données seront ensuite
stockées dans une BDD SQLite via la librairie ROOM.

Exercice 2.1 (RecyclerView et Adapter)
1. Dans un premier temps, créez une nouvelle Activity android qui contient un composant graphique
de type RecyclerView, ainsi qu'un bouton en bas de l'écran ("Nouveau Client") qui permet
d'appeler l'Activity de saisie développée dans l'exercice 1.1.
    -creer une empty activity
    -inserer le composant RecyclerView
    -Dans main2activity créer l'intent qui appelle l'activité1
    -dans manifest, changer le point d'entrée de l'application MainActivity --> Main2Activity

2. Créez ensuite une représentation générique d'un seul item en XML (item.xml) pour chaque entrée
qui permet l'affchage d'un nom, prénom, date de naissance et ville à l'intérieur d'un Layout.
Ajouter des @+id pour les entités dont vous voulez instancier la valeur.

3. Déffnissez un modèle (une structure de données pour stocker votre liste de clients,
e.g. à la manière de l'exemple ListView du cours).

4. Enfn, développez votre propre Adapter ou pour "adapter" les données de votre liste vers un
ensemble d'items dans votre RecyclerView.

5. Pour faciliter les tests, pré-placez des données en dur dans votre structure de données (ce qui évite
de repasser par l'interface pour la saisie).

6. Enfn, connectez les Activty par des Intents et vérifez le bon fonctionnement de l'ensemble (af-
fchage de la liste des clients, création d'un client, et affhage de la nouvelle liste de clients).