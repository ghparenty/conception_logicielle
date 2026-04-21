class Cours:
    def __init__(self, nom, professeur):
        self.nom = nom
        self.professeur = professeur

    def afficher_details(self):
        print(f"Cours : {self.nom}, Professeur : {self.professeur}")


class LegacyCoursSystem:
    def get_cours_string(self):
        return "Mathématiques;Dupont"


class CoursAdapter:
    def __init__(self, legacy_system):
        self._legacy = legacy_system

    def get_cours(self):
        data = self._legacy.get_cours_string()
        nom, professeur = data.split(";")
        return Cours(nom, professeur)
