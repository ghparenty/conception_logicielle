import pytest
from utilisateurs import (
    Personne, Etudiant, Professeur,
    EtudiantBoursier, EtudiantDelegue,
    MentionStandard, MentionSimplifiee,
)


@pytest.fixture
def etudiant():
    return Etudiant("Alice", 20, "E001", 14.0)


# Personne
def test_nom_vide_leve_erreur():
    with pytest.raises(ValueError):
        Etudiant("", 20, "E001", 10.0)


def test_age_negatif_leve_erreur():
    with pytest.raises(ValueError):
        Etudiant("Alice", -1, "E001", 10.0)


def test_age_trop_grand_leve_erreur():
    with pytest.raises(ValueError):
        Etudiant("Alice", 101, "E001", 10.0)


# Etudiant
def test_numero(etudiant):
    assert etudiant.numero == "E001"


def test_moyenne(etudiant):
    assert etudiant.moyenne == 14.0


def test_moyenne_negative_leve_erreur():
    with pytest.raises(ValueError):
        Etudiant("Alice", 20, "E001", -1)


def test_moyenne_superieure_20_leve_erreur():
    with pytest.raises(ValueError):
        Etudiant("Alice", 20, "E001", 25)


def test_modifier_moyenne(etudiant):
    etudiant.moyenne = 18.0
    assert etudiant.moyenne == 18.0


def test_modifier_moyenne_invalide_leve_erreur(etudiant):
    with pytest.raises(ValueError):
        etudiant.moyenne = 21


def test_ajouter_cours(etudiant):
    from cours import Cours
    etudiant.ajouter_cours(Cours("Maths", "Dupont"))
    etudiant.afficher_details()


def test_mention_standard_tres_bien():
    assert MentionStandard().calculer(16) == "Très Bien"


def test_mention_standard_bien():
    assert MentionStandard().calculer(14) == "Bien"


def test_mention_standard_passable():
    assert MentionStandard().calculer(10) == "Passable"


def test_mention_standard_insuffisant():
    assert MentionStandard().calculer(9) == "Insuffisant"


def test_get_mention_par_defaut(etudiant):
    assert etudiant.get_mention() == "Bien"


def test_changer_strategie_mention(etudiant):
    etudiant.set_strategie_mention(MentionSimplifiee())
    assert etudiant.get_mention() == "Admis"


def test_mention_simplifiee_refuse():
    assert MentionSimplifiee().calculer(9) == "Refusé"


# Professeur

def test_professeur_creation():
    p = Professeur("Dupont", 45)
    assert p.nom == "Dupont"
    assert p.age == 45


def test_professeur_afficher_details(capsys):
    p = Professeur("Dupont", 45)
    p.afficher_details()
    out = capsys.readouterr().out
    assert "Dupont" in out
    assert "Professeur" in out


# Decorator
def test_etudiant_boursier_affiche_statut(etudiant, capsys):
    b = EtudiantBoursier(etudiant)
    b.afficher_details()
    out = capsys.readouterr().out
    assert "Boursier" in out
    assert "Alice" in out


def test_etudiant_delegue_affiche_statut(etudiant, capsys):
    d = EtudiantDelegue(etudiant)
    d.afficher_details()
    out = capsys.readouterr().out
    assert "Délégué" in out
    assert "Alice" in out


# Observer
def test_observateur_notifie_lors_changement_moyenne():
    notifications = []

    class ObsTest:
        def update(self, e):
            notifications.append(e.moyenne)

    e = Etudiant("Bob", 22, "E002", 10.0)
    e.ajouter_observateur(ObsTest())
    e.moyenne = 15.0
    assert 15.0 in notifications
