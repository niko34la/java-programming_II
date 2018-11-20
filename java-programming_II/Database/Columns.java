import java.util.ArrayList;
public class Columns {
	static ArrayList<String> cols = new ArrayList<String>();
	public static void setCols(String[] col) {
		for (int i=0; i < col.length;i++) {
			cols.add(i,col[i]);
		}
	}
	public static ArrayList<String> getCols(){
		return cols;
	}
}
