import pytest
from src.etudiant import Etudiant
from src.cours import Cours


@pytest.fixture
def etudiant():
    return Etudiant("Alice", 20, "E001", 15.5)


# Héritage

def test_est_une_personne(etudiant):
    from src.personne import Personne
    assert isinstance(etudiant, Personne)


def test_heritage_nom_age(etudiant):
    assert etudiant.nom == "Alice"
    assert etudiant.age == 20


# Attributs propres

def test_numero(etudiant):
    assert etudiant.numero == "E001"


def test_moyenne(etudiant):
    assert etudiant.moyenne == 15.5


# Composition : liste de cours

def test_liste_cours_vide_au_depart():
    e = Etudiant("Bob", 22, "E002", 12.0)
    e.afficher_details()


def test_ajouter_un_cours(etudiant):
    cours = Cours("Mathématiques", "M. Dupont")
    etudiant.ajouter_cours(cours)
    etudiant.afficher_details()


def test_ajouter_plusieurs_cours(etudiant):
    c1 = Cours("Mathématiques", "M. Dupont")
    c2 = Cours("Informatique", "Mme Martin")
    etudiant.ajouter_cours(c1)
    etudiant.ajouter_cours(c2)
    etudiant.afficher_details()


# Affichage

def test_afficher_details_contient_nom(etudiant, capsys):
    etudiant.afficher_details()
    output = capsys.readouterr().out
    assert "Alice" in output
    assert "E001" in output
    assert "15.5" in output
