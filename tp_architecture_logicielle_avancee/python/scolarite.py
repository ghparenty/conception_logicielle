from abc import ABC, abstractmethod
from utilisateurs import Observer


class StrategieTriEtudiants(ABC):
    @abstractmethod
    def trier(self, etudiants):
        pass


class TriParMoyenne(StrategieTriEtudiants):
    def trier(self, etudiants):
        return sorted(etudiants, key=lambda e: e.moyenne, reverse=True)


class TriParNom(StrategieTriEtudiants):
    def trier(self, etudiants):
        return sorted(etudiants, key=lambda e: e.nom)


class ScolariteManager(Observer):
    _instance = None

    def __new__(cls):
        if cls._instance is None:
            cls._instance = super().__new__(cls)
            cls._instance._etudiants = []
            cls._instance._moyenne_globale = 0.0
            cls._instance._strategie_tri = TriParNom()
        return cls._instance

    def ajouter_etudiant(self, etudiant):
        self._etudiants.append(etudiant)
        etudiant.ajouter_observateur(self)
        self._mettre_a_jour_statistiques()

    def update(self, etudiant):
        self._mettre_a_jour_statistiques()

    def _mettre_a_jour_statistiques(self):
        if self._etudiants:
            self._moyenne_globale = sum(e.moyenne for e in self._etudiants) / len(self._etudiants)

    def set_strategie_tri(self, strategie):
        self._strategie_tri = strategie

    def get_etudiants_tries(self):
        return self._strategie_tri.trier(self._etudiants)
    