import org.json.simple.JSONArray;

import java.util.ArrayList;
import java.util.List;

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

    public String getType() {
        return jsonArrayToString(type);
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

    public String getWeaknesses() {
        return jsonArrayToString(weaknesses);
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

    public static Pokemon findPokemon(List<Pokemon> pokemons, String name) {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getName().equalsIgnoreCase(name)) {
                return pokemon;
            }
        }
        throw new RuntimeException("No pokemon found with this name!");
    }

    public String getCharacteristics() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()).append(" is of type ").append(this.getType()).append(". ");
        if (this.prevEvolution != null) {
            sb.append("It has ").append(this.getPrevEvolution()).append(" as previous evolution");
            if (this.nextEvolution != null) {
                sb.append(" and ").append(this.getNextEvolution()).append("as next evolution");
            } else {
                sb.append(" and is in its final form!");
            }
        } else {
            sb.append(". It has no previous evolution");
            if (this.nextEvolution != null) {
                sb.append(" and ").append(this.getNextEvolution()).append(" as next evolution");
            } else {
                sb.append(" and is in its final form!");
            }
        }
        sb.append(". It's weak to those elements : ").append(this.getWeaknesses()).append(".");
        return sb.toString();
    }

    public String getCharacteristics2() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()).append(" is of type ").append(this.getType()).append(". ");
        if (this.prevEvolution != null) {
            sb.append("It has ").append(this.getPrevEvolution()).append(" as previous evolution");
        } else {
            sb.append(". It has no previous evolution ");
        }
        if (this.nextEvolution != null) {
            sb.append(" and ").append(this.getNextEvolution()).append("as next evolution");
        } else {
            sb.append(" and is in its final form!");
        }
        sb.append(" It's weak to those elements : ").append(this.getWeaknesses()).append(".");
        return sb.toString();
    }

    public String jsonArrayToString(JSONArray property) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < property.size(); i++) {
            if (i > 0) {
                result.append(", ");
            }
            result.append(property.get(i).toString());
        }
        return result.toString();
    }

    public void getEvolutions() {

    }
}
