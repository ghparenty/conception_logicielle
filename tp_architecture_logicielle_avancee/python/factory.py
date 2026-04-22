from utilisateurs import Etudiant, Professeur


class PersonneFactory:
    @staticmethod
    def creer(type_personne, nom, prenom, age, **kwargs):
        if type_personne == "etudiant":
            return Etudiant(nom, age, kwargs.get("numero", ""), kwargs.get("moyenne", 0))
        elif type_personne == "professeur":
            return Professeur(nom, age)
        else:
            raise ValueError(type_personne)
