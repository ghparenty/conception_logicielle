import pytest
from utilisateurs import Etudiant
from scolarite import ScolariteManager, TriParMoyenne, TriParNom


@pytest.fixture(autouse=True)
def reset_singleton():
    ScolariteManager._instance = None
    yield
    ScolariteManager._instance = None


@pytest.fixture
def manager():
    return ScolariteManager()


@pytest.fixture
def etudiants():
    return [
        Etudiant("Zoe", 21, "E003", 17.0),
        Etudiant("Alice", 20, "E001", 12.0),
        Etudiant("Bob", 22, "E002", 15.0),
    ]


# Singleton
def test_singleton():
    m1 = ScolariteManager()
    m2 = ScolariteManager()
    assert m1 is m2


def test_tri_par_nom(manager, etudiants):
    for e in etudiants:
        manager.ajouter_etudiant(e)
    tries = manager.get_etudiants_tries()
    noms = [e.nom for e in tries]
    assert noms == sorted(noms)


def test_tri_par_moyenne(manager, etudiants):
    manager.set_strategie_tri(TriParMoyenne())
    for e in etudiants:
        manager.ajouter_etudiant(e)
    tries = manager.get_etudiants_tries()
    moyennes = [e.moyenne for e in tries]
    assert moyennes == sorted(moyennes, reverse=True)


def test_moyenne_globale_mise_a_jour(manager):
    e1 = Etudiant("Alice", 20, "E001", 10.0)
    e2 = Etudiant("Bob", 22, "E002", 20.0)
    manager.ajouter_etudiant(e1)
    manager.ajouter_etudiant(e2)
    assert manager._moyenne_globale == 15.0


def test_moyenne_globale_apres_modification(manager):
    e = Etudiant("Alice", 20, "E001", 10.0)
    manager.ajouter_etudiant(e)
    e.moyenne = 20.0
    assert manager._moyenne_globale == 20.0
