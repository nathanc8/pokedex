import java.util.ArrayList;

public class Pokemon {
    private String name;
    private int id;
    private String img;
    private ArrayList<String> type;
    private String height;
    private String weight;
    private ArrayList<String> weaknesses;

    public Pokemon(String name, int id, String img, ArrayList<String> type, String height, String weight, ArrayList<String> weaknesses) {
        this.name = name;
        this.id = id;
        this.img = img;
        this.type = type;
        this.height = height;
        this.weight = weight;
        this.weaknesses = weaknesses;
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

    public ArrayList<String> getType() {
        return type;
    }

    public void setType(ArrayList<String> type) {
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

    public ArrayList<String> getWeaknesses() {
        return weaknesses;
    }

    public void setWeaknesses(ArrayList<String> weaknesses) {
        this.weaknesses = weaknesses;
    }
}
