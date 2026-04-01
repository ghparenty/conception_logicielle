import unittest
from src.cours import Cours


class TestCours(unittest.TestCase):

    def test_creation(self):
        c = Cours("Mathématiques", "M. Dupont")
        self.assertEqual(c.nom, "Mathématiques")
        self.assertEqual(c.professeur, "M. Dupont")

    def test_afficher_details(self):
        c = Cours("Informatique", "Mme Martin")
        try:
            c.afficher_details()
        except Exception as e:
            self.fail(f"afficher_details() a levé une exception : {e}")


if __name__ == "__main__":
    unittest.main()
