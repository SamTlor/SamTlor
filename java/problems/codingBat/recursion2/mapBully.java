import java.util.Map;

public class mapBully {
    public static void main(String[] args) {

        mapBully({"a": "candy", "b": "dirt"});
        mapBully({"a": "candy"});
        mapBully({"a": "candy", "b": "carrot", "c": "meh"});
    }

    public static Map<String, String> mapBully(Map<String, String> map) {
        if(map.containsKey("a")){
            map.put("b", map.get("a"));
            map.put("a", "");
        }
        return map;
    }
}