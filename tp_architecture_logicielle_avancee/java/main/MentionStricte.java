public class MentionStricte implements StrategieMention {
    @Override
    public String calculerMention(double moyenne) {
        if (moyenne >= 18) return "Tres Bien";
        if (moyenne >= 16) return "Bien";
        if (moyenne >= 14) return "Assez Bien";
        if (moyenne >= 12) return "Passable";
        return "Insuffisant";
    }
}
