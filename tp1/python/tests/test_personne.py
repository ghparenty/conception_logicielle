import pytest
from src.personne import Personne


def test_creation():
    p = Personne("Alice", 20)
    assert p.nom == "Alice"
    assert p.age == 20


def test_afficher_details(capsys):
    p = Personne("Bob", 30)
    p.afficher_details()
