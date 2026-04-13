import pytest
from src.personne import Personne


def test_creation():
    p = Personne("Alice", 20)
    assert p.nom == "Alice"
    assert p.age == 20


def test_afficher_details(capsys):
    p = Personne("Bob", 30)
    p.afficher_details()


# TP2 : Validation des données

def test_nom_vide_leve_erreur():
    with pytest.raises(ValueError):
        Personne("", 20)


def test_nom_espaces_leve_erreur():
    with pytest.raises(ValueError):
        Personne("   ", 20)


def test_age_negatif_leve_erreur():
    with pytest.raises(ValueError):
        Personne("Alice", -1)


def test_age_superieur_100_leve_erreur():
    with pytest.raises(ValueError):
        Personne("Alice", 101)


def test_age_limite_valide():
    p = Personne("Alice", 0)
    assert p.age == 0
    p2 = Personne("Bob", 100)
    assert p2.age == 100


def test_modifier_age_valide():
    p = Personne("Alice", 20)
    p.age = 25
    assert p.age == 25


def test_modifier_age_invalide():
    p = Personne("Alice", 20)
    with pytest.raises(ValueError):
        p.age = -5
