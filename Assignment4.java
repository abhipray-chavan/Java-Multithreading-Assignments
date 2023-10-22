import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Assignment4 {
    private Map<String, String> dictionary;

    public Assignment4() {
        dictionary = new HashMap<>();
    }

    public void addWord(String word, String definition) {
        dictionary.put(word.toLowerCase(), definition);
    }

    public String getDefinition(String word) {
        String definition = dictionary.get(word.toLowerCase());
        if (definition != null) {
            return definition;
        } else {
            return "Definition not found for the word: " + word;
        }
    }

    public List<String> getSuggestions(String word) {
        List<String> suggestions = new ArrayList<>();
        for (String dictWord : dictionary.keySet()) {
            if (dictWord.startsWith(word.toLowerCase())) {
                suggestions.add(dictWord);
            }
        }
        return suggestions;
    }

    public static void main(String[] args) {
        Assignment4 dictionaryApp = new Assignment4();

        // Add some sample words and definitions
        dictionaryApp.addWord("apple", "An apple a day keeps doctor away");
        dictionaryApp.addWord("banana", "Kela bhai kela !!!!");
        dictionaryApp.addWord("cat", "You know it :) yehh boiii ");

        // Test getDefinition method
        System.out.println(dictionaryApp.getDefinition("apple"));  
        System.out.println(dictionaryApp.getDefinition("banana"));
        System.out.println(dictionaryApp.getDefinition("dog"));    

        // Test getSuggestions method
        System.out.println(dictionaryApp.getSuggestions("a"));      
        System.out.println(dictionaryApp.getSuggestions("b"));      
        System.out.println(dictionaryApp.getSuggestions("c"));      
        System.out.println(dictionaryApp.getSuggestions("d"));      

        // Test case-insensitivity
        System.out.println(dictionaryApp.getDefinition("Apple"));   
        System.out.println(dictionaryApp.getSuggestions("A"));      
    }
}