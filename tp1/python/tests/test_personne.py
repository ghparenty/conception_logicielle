import unittest
from src.personne import Personne


class TestPersonne(unittest.TestCase):

    def test_creation(self):
        p = Personne("Alice", 20)
        self.assertEqual(p.nom, "Alice")
        self.assertEqual(p.age, 20)

    def test_afficher_details(self, capsys=None):
        p = Personne("Bob", 30)
        # Vérifie que la méthode s'exécute sans erreur
        try:
            p.afficher_details()
        except Exception as e:
            self.fail(f"afficher_details() a levé une exception : {e}")


if __name__ == "__main__":
    unittest.main()
