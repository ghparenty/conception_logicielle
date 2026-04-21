from abc import ABC, abstractmethod


class Observer(ABC):
    @abstractmethod
    def update(self, etudiant):
        pass


class StrategieCalculMention(ABC):
    @abstractmethod
    def calculer(self, moyenne):
        pass


class MentionStandard(StrategieCalculMention):
    def calculer(self, moyenne):
        if moyenne >= 16:
            return "Très Bien"
        elif moyenne >= 14:
            return "Bien"
        elif moyenne >= 12:
            return "Assez Bien"
        elif moyenne >= 10:
            return "Passable"
        return "Insuffisant"


class MentionSimplifiee(StrategieCalculMention):
    def calculer(self, moyenne):
        if moyenne >= 10:
            return "Admis"
        return "Refusé"


class Personne(ABC):
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


class Etudiant(Personne):
    def __init__(self, nom, age, numero, moyenne):
        super().__init__(nom, age)
        self.__numero = numero
        self.__cours = []
        self._observers = []
        self._strategie_mention = MentionStandard()
        self.moyenne = moyenne

    @property
    def numero(self):
        return self.__numero

    @property
    def moyenne(self):
        return self.__moyenne

    @moyenne.setter
    def moyenne(self, value):
        if value < 0 or value > 20:
            raise ValueError("La moyenne doit être comprise entre 0 et 20")
        self.__moyenne = value
        self._notifier_observateurs()

    def _notifier_observateurs(self):
        for obs in self._observers:
            obs.update(self)

    def ajouter_observateur(self, observer):
        self._observers.append(observer)

    def set_strategie_mention(self, strategie):
        self._strategie_mention = strategie

    def get_mention(self):
        return self._strategie_mention.calculer(self.__moyenne)

    def ajouter_cours(self, cours):
        self.__cours.append(cours)

    def afficher_details(self):
        super().afficher_details()
        print(f"Numero etudiant : {self.__numero}, Moyenne : {self.__moyenne}/20")
        if self.__cours:
            print("Cours inscrits :")
            for c in self.__cours:
                c.afficher_details()


class Professeur(Personne):
    def __init__(self, nom, age):
        super().__init__(nom, age)

    def afficher_details(self):
        super().afficher_details()
        print("Rôle : Professeur")


class EtudiantDecorator:
    def __init__(self, etudiant):
        self._etudiant = etudiant

    def afficher_details(self):
        self._etudiant.afficher_details()


class EtudiantBoursier(EtudiantDecorator):
    def afficher_details(self):
        super().afficher_details()
        print("Statut : Boursier")


class EtudiantDelegue(EtudiantDecorator):
    def afficher_details(self):
        super().afficher_details()
        print("Statut : Délégué")