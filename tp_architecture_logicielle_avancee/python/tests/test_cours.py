import pytest
from cours import Cours, LegacyCoursSystem, CoursAdapter


def test_creation():
    c = Cours("Mathématiques", "Dupont")
    assert c.nom == "Mathématiques"
    assert c.professeur == "Dupont"


def test_afficher_details(capsys):
    c = Cours("Informatique", "Martin")
    c.afficher_details()
    out = capsys.readouterr().out
    assert "Informatique" in out
    assert "Martin" in out


def test_legacy_cours_string():
    legacy = LegacyCoursSystem()
    assert ";" in legacy.get_cours_string()


def test_adapter_retourne_cours():
    legacy = LegacyCoursSystem()
    adapter = CoursAdapter(legacy)
    c = adapter.get_cours()
    assert isinstance(c, Cours)
    assert c.nom == "Mathématiques"
    assert c.professeur == "Dupont"
