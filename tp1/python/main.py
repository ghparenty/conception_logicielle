from src.etudiant import Etudiant
from src.cours import Cours

cours1 = Cours("Mathématiques", "M. Dupont")
cours2 = Cours("Informatique", "Mme Martin")
cours3 = Cours("Physique", "M. Bernard")

etudiant1 = Etudiant("Alice", 20, "E001", 15.5)
etudiant2 = Etudiant("Bob", 22, "E002", 12.0)

etudiant1.ajouter_cours(cours1)
etudiant1.ajouter_cours(cours2)

etudiant2.ajouter_cours(cours2)
etudiant2.ajouter_cours(cours3)

print("=== Liste des étudiants ===")
etudiant1.afficher_details()
print()
etudiant2.afficher_details()