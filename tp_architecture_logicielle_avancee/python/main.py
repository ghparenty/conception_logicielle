from utilisateurs import MentionSimplifiee, EtudiantBoursier
from scolarite import ScolariteManager, TriParMoyenne
from factory import PersonneFactory
from cours import LegacyCoursSystem, CoursAdapter

manager = ScolariteManager()

alice = PersonneFactory.creer("etudiant", "Alice", "A.", 20, numero="E001", moyenne=14)
bob = PersonneFactory.creer("etudiant", "Bob", "B.", 21, numero="E002", moyenne=11)

manager.ajouter_etudiant(alice)
manager.ajouter_etudiant(bob)

print(f"Moyenne globale : {manager._moyenne_globale:.2f}")

alice.moyenne = 18
print(f"Moyenne globale après update : {manager._moyenne_globale:.2f}")

alice.set_strategie_mention(MentionSimplifiee())
print(f"Mention Alice : {alice.get_mention()}")

manager.set_strategie_tri(TriParMoyenne())
for e in manager.get_etudiants_tries():
    print(f"{e.nom} : {e.moyenne}/20")

EtudiantBoursier(bob).afficher_details()

cours = CoursAdapter(LegacyCoursSystem()).get_cours()
cours.afficher_details()
