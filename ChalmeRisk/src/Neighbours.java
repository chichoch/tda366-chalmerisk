import java.util.List;


public class Neighbours {
	private Map map = new Map();
	private List <Country> nList;
	
	public Neighbours(int[] id){
		for ( int i = 0; i < id.length; i++ ){
			 nList.add(map.getCountry(id[i]));
		}
	}
	
	public List <Country> getNeighbours(){
		return nList;
	}
}
