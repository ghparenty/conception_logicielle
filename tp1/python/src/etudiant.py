from src.personne import Personne
from src.cours import Cours

class Etudiant(Personne):
    def __init__(self, nom, age, numero, moyenne):
        super().__init__(nom, age)
        self.__numero = numero
        self.__moyenne = moyenne
        self.__cours = []

    @property
    def numero(self):
        return self.__numero

    @property
    def moyenne(self):
        return self.__moyenne

    def ajouter_cours(self, cours):
        self.__cours.append(cours)

    def afficher_details(self):
        super().afficher_details()
        print(f"Numero etudiant : {self.__numero}, Moyenne : {self.__moyenne}/20")
        if self.__cours:
            print("Cours inscrits :")
            for c in self.__cours:
                c.afficher_details()
