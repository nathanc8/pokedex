import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        String fileName = "pokedex.json";
        String keyToGet = "pokemon";
        JSONArray pokemonArr = generateJsonArray(fileName, keyToGet);
        System.out.println(displayLength(pokemonArr));

        JSONArray pokArrSortedByWeight = sortByWeight(pokemonArr);
        System.out.println(pokArrSortedByWeight);

        createPokemon(pokemonArr);
        upTo10kg(pokemonArr);
    }

    //Récupération des informations contenues dans le json de base, pour en faire un JSONArray
    private static JSONArray generateJsonArray(String filepath, String keyToGet) {
        try {
            Object obj = new JSONParser().parse(new FileReader(filepath));
            JSONObject jsonObj = (JSONObject) obj;
            return (JSONArray) jsonObj.get(keyToGet);
        } catch (ParseException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Taille du json.
    private static String displayLength(JSONArray jsonArray) {
        System.out.println("----------------------------------");
        return "There is " + jsonArray.size() + " pokemon in the pokedex. Can you catch'em all ?";
    }

    //Récupération des données inscrites dans le Json
    private static void createPokemon(JSONArray jsonArray) {
        System.out.println("----------------------------------");
        for (Object obj : jsonArray) {
            //récupération de toutes les informations de chaque pokemon
            //Cast de l'obj en cours en JSONObject
            JSONObject currentIteration = (JSONObject) obj;
            System.out.println("Here are the characteristics for " + currentIteration.get("name"));

            for (Object key : currentIteration.keySet()) {
                String keyToString = (String) key;
                Object value = currentIteration.get(keyToString);
                System.out.println(keyToString + " : " + value);
            }
        }
    }

    private static void upTo10kg(JSONArray jsonArray) {
        System.out.println("------------------------------");
        System.out.println("Here is the list of Pokémon that weigh more than 10kg");
        for (int i = 0; i < jsonArray.size(); i++) {
            double weight = convertToDouble(jsonArray, i);
            if (weight >= 10) {
                JSONObject pokemon = (JSONObject) jsonArray.get(i);
                System.out.println(pokemon.get("name") + " weighs exactly " + weight + " kg");
            }
        }
    }

    private static JSONArray sortByWeight(JSONArray jsonArray) {
        System.out.println("----------------------------------");
        System.out.println("Here is the list of Pokemon, sorted by weight :");

        int n = jsonArray.size();

        //bubble sort sur le tableau, en fonction du poids.
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                JSONObject currentPokemon = (JSONObject) jsonArray.get(j);
                double currentWeight = convertToDouble(jsonArray, j);
                JSONObject comparingPokemon = (JSONObject) jsonArray.get(j + 1);
                double comparingWeight = convertToDouble(jsonArray, j + 1);

                //inversion des éléments.
                if (currentWeight > comparingWeight) {
                    jsonArray.set(j, comparingPokemon);
                    jsonArray.set(j + 1, currentPokemon);
                }
            }
        }
        for (Object obj : jsonArray) {
            JSONObject pokemon = (JSONObject) obj;
            System.out.println(pokemon.get("name") + " weighs " + pokemon.get("weight"));
        }
        return jsonArray;
    }

    //permet de récupérer le poids en type double pour l'utiliser dans d'autre méthodes.
    private static Double convertToDouble(JSONArray jsonArray, int i) {
        JSONObject jsonObject = (JSONObject) jsonArray.get(i);
        Object weightObj = jsonObject.get("weight");
        String weightStr = (String) weightObj;
        return Double.parseDouble(weightStr.replace(" kg", ""));
    }

}