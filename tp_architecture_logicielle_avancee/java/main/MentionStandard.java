public class MentionStandard implements StrategieMention {
    @Override
    public String calculerMention(double moyenne) {
        if (moyenne >= 16) return "Tres Bien";
        if (moyenne >= 14) return "Bien";
        if (moyenne >= 12) return "Assez Bien";
        if (moyenne >= 10) return "Passable";
        return "Insuffisant";
    }
}
