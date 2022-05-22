# cricri-notes-for-master-the-coding
Mes notes pour le cours maîtiser le code

### big O
O(1) < O(log(n)) < O(n) < O(nlog(n)) < O(n^2) < O(2^n) < O(n!)

### Qu'est-ce qui peux causer une complexité en temps dans une fonction
- Operations
- Comparaison
- Boucle
- Appel à fonction

### Règle
1) Toujours le pire cas
2) Ignorer les constantes O(100034n) = O(n)
3) Différentes entrées devrait avoir différentes variables O(n + m)
4) Éliminer les termes non dominants : ex O(n^2 + 3n + 102) = O(n^2)

### Qu'est-ce qui peux causer une complexité en espace dans une fonction
- Variables
- Structures de données
- Appel à fonction
- Allocation