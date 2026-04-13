from src.etudiant import Etudiant
from src.enseignant import Enseignant
from src.cours import Cours

if __name__ == "__main__":
    # Creation des cours
    cours1 = Cours("Mathematiques", "M. Dupont")
    cours2 = Cours("Informatique", "Mme Martin")
    cours3 = Cours("Physique", "M. Bernard")

    # Creation des etudiants
    etudiant1 = Etudiant("Alice", 20, "E001", 15.5)
    etudiant2 = Etudiant("Bob", 22, "E002", 12.0)

    etudiant1.ajouter_cours(cours1)
    etudiant1.ajouter_cours(cours2)

    etudiant2.ajouter_cours(cours2)
    etudiant2.ajouter_cours(cours3)

    # Creation des enseignants
    enseignant1 = Enseignant("M. Dupont", 45, 3500)
    enseignant2 = Enseignant("Mme Martin", 38, 3200)

    # TP2 : Test de modification avec une valeur invalide
    print("TP2 : Test validation")
    try:
        etudiant1.moyenne = 25
    except ValueError as e:
        print(f"Modification refusee : {e}")

    try:
        etudiant1.age = -5
    except ValueError as e:
        print(f"Modification refusee : {e}")

    # TP3 : Polymorphisme - liste de Personne mixte
    print("\nTP3 : Polymorphisme")
    personnes = [etudiant1, etudiant2, enseignant1, enseignant2]

    for p in personnes:
        p.afficher_details()
        print()