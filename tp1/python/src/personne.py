class Personne:
    def __init__(self, nom, age):
        self.__nom = nom
        self.__age = age

    @property
    def nom(self):
        return self.__nom

    @property
    def age(self):
        return self.__age

    def afficher_details(self):
        print(f"Nom : {self.__nom}, Age : {self.__age}")