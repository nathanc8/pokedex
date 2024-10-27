import org.json.simple.JSONArray;

import java.util.ArrayList;

public class Pokemon {
    private String name;
    private int id;
    private String img;
    private JSONArray type;
    private String height;
    private String weight;
    private JSONArray weaknesses;
    private JSONArray prevEvolution;
    private JSONArray nextEvolution;

    public Pokemon() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public JSONArray getType() {
        return type;
    }

    public void setType(JSONArray type) {
        this.type = type;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public JSONArray getWeaknesses() {
        return weaknesses;
    }

    public void setWeaknesses(JSONArray weaknesses) {
        this.weaknesses = weaknesses;
    }

    public JSONArray getPrevEvolution() {
        return prevEvolution;
    }

    public void setPrevEvolution(JSONArray prevEvolution) {
        this.prevEvolution = prevEvolution;
    }

    public JSONArray getNextEvolution() {
        return nextEvolution;
    }

    public void setNextEvolution(JSONArray nextEvolution) {
        this.nextEvolution = nextEvolution;
    }

    public String getCharacteristics() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()).append(" est de type ").append(this.getType());
        if (this.prevEvolution != null) {
            sb.append(". Il a comme évolution précédente ").append(this.getPrevEvolution());
            if (this.nextEvolution != null) {
                sb.append(" et comme prochaine évolution ").append(this.getNextEvolution());
            } else {
                sb.append(" et est dans sa forme finale !");
            }
        } else {
            sb.append(". Il n'a pas d'évolution précédente ");
            if (this.nextEvolution != null) {
                sb.append(" et a comme prochaine évolution ").append(this.getNextEvolution());
            } else {
                sb.append(" et est dans sa forme finale !");
            }
        }
        sb.append(". " + "Il est faible aux éléments suivants : ").append(this.getWeaknesses());
        return sb.toString();
    }

    public String getCharacteristics2() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()).append(" est de type ").append(this.getType());
        if (this.prevEvolution != null) {
            sb.append(". Il a comme évolution précédente !").append(this.getPrevEvolution());
        } else {
            sb.append(". Il n'a pas d'évolution précédente !");
        }
        if (this.nextEvolution != null) {
            sb.append(" et a comme prochaine évolution !").append(this.getNextEvolution());
        } else {
            sb.append(" et est dans sa forme finale !");
        }
        sb.append(" Il est faible aux éléments suivants : ").append(this.getWeaknesses());
        return sb.toString();
    }

    public String getEvolutions() {
        
    }
}
