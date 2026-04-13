class Cours:
    def __init__(self, nom, professeur):
        self.__nom = nom
        self.__professeur = professeur

    @property
    def nom(self):
        return self.__nom

    @property
    def professeur(self):
        return self.__professeur

    def afficher_details(self):
        print(f"  Cours : {self.__nom}, Professeur : {self.__professeur}")
