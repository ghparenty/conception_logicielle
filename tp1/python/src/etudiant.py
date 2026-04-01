from personne import Personne
import numpy as np

class Etudiant(Personne):
    def __init__(self, nom, age, numero):
        super().__init__(nom, age)
        self.__numero = numero
        self.__matieres = {}
        self.__moyenne = 0

    @property
    def numero(self):
        return self.__numero
    
    def ajouter_matiere(self, matiere):
        if 
    
    def ajouter_note(self, matiere, note):
        if type(note) == float or type(note) == int:
            self.__notes.append(note)
        else:
            raise TypeError("la note n'est pas au bon format")
        
    @property
    def moyenne(self):
        self.__moyenne = np.mean(self.notes)
        return self.__moyenne