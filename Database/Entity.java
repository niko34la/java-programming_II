import java.util.ArrayList;
public class Entity {
    ArrayList<String> col = new ArrayList<>();
    static int counter = 0;
    public void setter(String[] colu) {
    	for (int i =0; i < colu.length; i++) {
    		this.col.add(i, colu[i]);
    		this.counter = counter++;
    	}
    }
	public ArrayList<String> getter() {
		return col;
	}
	public Entity(ArrayList<String> col){
		this.col = col;
	}
	public Entity() {

	}
}

