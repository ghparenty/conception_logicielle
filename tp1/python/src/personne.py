class Personne:
    def __init__(self, nom, age):
        self.nom = nom
        self.age = age

    @property
    def nom(self):
        return self.__nom

    @nom.setter
    def nom(self, value):
        if not value or not value.strip():
            raise ValueError("Le nom ne peut pas être vide")
        self.__nom = value

    @property
    def age(self):
        return self.__age

    @age.setter
    def age(self, value):
        if value < 0 or value > 100:
            raise ValueError("L'âge doit être compris entre 0 et 100")
        self.__age = value

    def afficher_details(self):
        print(f"Nom : {self.__nom}, Age : {self.__age}")