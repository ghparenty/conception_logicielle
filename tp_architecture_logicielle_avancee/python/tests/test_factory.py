import pytest
from factory import PersonneFactory
from utilisateurs import Etudiant, Professeur


def test_creer_etudiant():
    e = PersonneFactory.creer("etudiant", "Alice", "A", 20, numero="E001", moyenne=12.0)
    assert isinstance(e, Etudiant)
    assert e.nom == "Alice"
    assert e.numero == "E001"
    assert e.moyenne == 12.0


def test_creer_professeur():
    p = PersonneFactory.creer("professeur", "Dupont", "D", 45)
    assert isinstance(p, Professeur)
    assert p.nom == "Dupont"


def test_type_inconnu_leve_erreur():
    with pytest.raises(ValueError):
        PersonneFactory.creer("inconnu", "X", "Y", 30)
