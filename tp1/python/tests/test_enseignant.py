import pytest
from src.enseignant import Enseignant
from src.personne import Personne


def test_creation():
    e = Enseignant("M. Dupont", 45, 3500)
    assert e.nom == "M. Dupont"
    assert e.age == 45
    assert e.salaire == 3500


def test_est_une_personne():
    e = Enseignant("M. Dupont", 45, 3500)
    assert isinstance(e, Personne)


def test_afficher_details(capsys):
    e = Enseignant("M. Dupont", 45, 3500)
    e.afficher_details()
    output = capsys.readouterr().out
    assert "M. Dupont" in output
    assert "45" in output
    assert "3500" in output
