from src.personne import Personne


class Enseignant(Personne):
    def __init__(self, nom, age, salaire):
        super().__init__(nom, age)
        self.__salaire = salaire

    @property
    def salaire(self):
        return self.__salaire

    def afficher_details(self):
        super().afficher_details()
        print(f"Salaire : {self.__salaire} EUR")
