package sql.model;

public class Attribute extends AbstractEntity{
    private String nameAttribut;
    public Attribute( String nameAttribut ) {
        this.nameAttribut = nameAttribut;
    }

    public String getNameAttribut() {
        return nameAttribut;
    }

    public void setNameAttribut(String nameAttribut) {
        this.nameAttribut = nameAttribut;
    }
}
