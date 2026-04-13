import pytest
from src.cours import Cours


def test_creation():
    c = Cours("Mathématiques", "M. Dupont")
    assert c.nom == "Mathématiques"
    assert c.professeur == "M. Dupont"


def test_afficher_details():
    c = Cours("Informatique", "Mme Martin")
    c.afficher_details()
