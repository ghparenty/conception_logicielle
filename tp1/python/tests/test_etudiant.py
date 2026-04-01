import unittest
from src.etudiant import Etudiant
from src.cours import Cours


class TestEtudiant(unittest.TestCase):

    def setUp(self):
        self.etudiant = Etudiant("Alice", 20, "E001", 15.5)

    # Héritage

    def test_est_une_personne(self):
        from src.personne import Personne
        self.assertIsInstance(self.etudiant, Personne)

    def test_heritage_nom_age(self):
        self.assertEqual(self.etudiant.nom, "Alice")
        self.assertEqual(self.etudiant.age, 20)

    # Attributs propres

    def test_numero(self):
        self.assertEqual(self.etudiant.numero, "E001")

    def test_moyenne(self):
        self.assertEqual(self.etudiant.moyenne, 15.5)

    # Composition : liste de cours

    def test_liste_cours_vide_au_depart(self):
        e = Etudiant("Bob", 22, "E002", 12.0)
        # Vérifie que afficher_details ne plante pas sans cours
        try:
            e.afficher_details()
        except Exception as ex:
            self.fail(f"afficher_details() a levé une exception : {ex}")

    def test_ajouter_un_cours(self):
        cours = Cours("Mathématiques", "M. Dupont")
        self.etudiant.ajouter_cours(cours)
        # L'affichage doit inclure le cours sans erreur
        try:
            self.etudiant.afficher_details()
        except Exception as ex:
            self.fail(f"afficher_details() a levé une exception : {ex}")

    def test_ajouter_plusieurs_cours(self):
        c1 = Cours("Mathématiques", "M. Dupont")
        c2 = Cours("Informatique", "Mme Martin")
        self.etudiant.ajouter_cours(c1)
        self.etudiant.ajouter_cours(c2)
        try:
            self.etudiant.afficher_details()
        except Exception as ex:
            self.fail(f"afficher_details() a levé une exception : {ex}")

    # Affichage 

    def test_afficher_details_contient_nom(self):
        import io, sys
        captured = io.StringIO()
        sys.stdout = captured
        self.etudiant.afficher_details()
        sys.stdout = sys.__stdout__
        output = captured.getvalue()
        self.assertIn("Alice", output)
        self.assertIn("E001", output)
        self.assertIn("15.5", output)


if __name__ == "__main__":
    unittest.main()
