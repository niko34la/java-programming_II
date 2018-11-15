import java.util.ArrayList;

public class Database {
	static ArrayList<Entity> arr1 = new ArrayList<Entity>();
	static int counter = 0;
	public final int pk_loc;

	public Database(Entity en) {
		this.counter = counter;
		pk_loc = Entity.getPKL();
		addEnt(en);
	}

	public void addEnt(Entity en) {
		arr1.add(counter, en);
		counter++;
	}

	public static void printDB() {
		System.out.println(arr1.toArray());
	}

	public void removeEnt(int i) {
		arr1.remove(i);
	}

	public void clearDB() {
		arr1.clear();
	}


	public int getIndex(String name) {
		for(Entity en: arr1) {
			if(name.equals(en.getS(pk_loc))) {
				return arr1.indexOf(en);
			}
		}
		return -1;
	}

	public boolean exists(String name) {
		if(getIndex(name) == -1) {
			return false;
		} else {
			return true;
		}
	}

}
