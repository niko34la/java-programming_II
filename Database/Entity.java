import java.util.ArrayList;
public class Entity {
    ArrayList<String> col = new ArrayList<>();
    static int counter = 0;
    public String primary_key;
    protected static int primarykey_location;
    public void setter(String[] colu) {
    	for (int i =0; i < colu.length; i++) {
    		this.col.add(i, colu[i]);
    		this.counter = counter++;
    	}
    }

    public ArrayList<String> getter() {
		return col;
	}

	public Entity(String[] col){
		setter(col);
	}

	public Entity() {

	}

	public void printEls(ArrayList<String> col) {
		for(String s: col) {
			System.out.print(s );
		}
	}
	public void setPK(String s, int i) {
		primary_key = s;
		primarykey_location = i;
	}

	public static int getPKL() {
		return primarykey_location;
	}

	public String getS(int i) {
		return col.get(i);
	}

}

