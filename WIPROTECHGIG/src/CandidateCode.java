import java.util.ArrayList;
import java.util.List;


public class CandidateCode{

	public static int X=0;
	public static int Y=0;
	public static int[][] blocks;
	public static int GetWaterLevel(int input1,int input2,int[] input3)
	{
		X=input1-1;
		Y=input2-1;
		int result =0;
		blocks = new int[input1][input2];
		int count=0;

		for(int i=0;i<input1;i++){
			for(int j=0;j<input2;j++){
				blocks[i][j]=input3[count];
				count++;
			}
		}
		//getLockedCells
		List<Cell> cellsList = new ArrayList<Cell>();
		for(int i=0;i<input1;i++){
			for(int j=0;j<input2;j++){
				Cell cell = new Cell(i,j,blocks[i][j]);
				cellsList.add(cell);
			}
		}
		List<Cell> lockedCells = getLockedCellsAlone(cellsList);

		//getPools
		List<Pool> poolsList = getPools(lockedCells);

		result = getVolumes(poolsList);
		return result;
	}
	public static int getVolumes(List<Pool> poolsList){
		int volume=0;
		
		for(Pool pool : poolsList){
			int lowestneighbour = getLowestNeighbour(pool);
			for(Cell cell : pool.getCellsList()){
				volume+=lowestneighbour-cell.height;
			}
		}
		
		return volume;
	}
	
	public static int getLowestNeighbour(Pool pool){
		int lowest=10;
		for(Cell cell : pool.getCellsList()){
			int x=cell.i;
			int y=cell.j;
			if(blocks[x+1][y]<lowest){
				if(!ispresentinpool(pool,x+1,y)){
				lowest=blocks[x+1][y];
				}
			}
			if(blocks[x-1][y]<lowest){
				if(!ispresentinpool(pool,x-1,y)){
				lowest=blocks[x-1][y];
				}
			}
			if(blocks[x][y+1]<lowest){
				if(!ispresentinpool(pool,x,y+1)){
				lowest=blocks[x][y+1];
				}
			}
			if(blocks[x][y-1]<lowest){
				if(!ispresentinpool(pool,x,y-1)){
				lowest=blocks[x][y-1];
				}
			}
		}
		return lowest;
	}
	public static boolean ispresentinpool(Pool pool, int x,int y){
		
		for(Cell cell : pool.getCellsList()){
			if(cell.i==x && cell.j==y){
				return true;
			}
		}
		return false;
	}
	public static List<Pool> getPools(List<Cell> cells){
		List<Pool> poolsList = new ArrayList<Pool>();

		for(Cell cell : cells){
			if(poolsList.isEmpty()){
				Pool pool = new Pool();
				pool.getCellsList().add(cell);
				poolsList.add(pool);
			}else{
				if(poolContainNeighbour(poolsList, cell)){
					getneighbourPool(poolsList, cell).getCellsList().add(cell);
				}else{
					Pool pool = new Pool();
					pool.getCellsList().add(cell);
					poolsList.add(pool);
				}
			}

		}
		return poolsList;
	}
	
	public static Pool getneighbourPool(List<Pool> poolsList,Cell cell){

		int X=cell.i;
		int Y=cell.j;
		for(Pool pool : poolsList){
			for(Cell thiscell : pool.getCellsList()){
				if(thiscell.i==X && thiscell.j==(Y-1)){
					return pool;
				}else if(thiscell.i==X && thiscell.j==(Y+1)){
					return pool;
				}else if(thiscell.i==(X+1) && thiscell.j==Y){
					return pool;
				}else if(thiscell.i==(X-1) && thiscell.j==Y){
					return pool;
				}
			}
		}
		return null;
	}
	public static boolean poolContainNeighbour(List<Pool> poolsList,Cell cell){
		int X=cell.i;
		int Y=cell.j;
		for(Pool pool : poolsList){
			for(Cell thiscell : pool.getCellsList()){
				if(thiscell.i==X && thiscell.j==(Y-1)){
					return true;
				}else if(thiscell.i==X && thiscell.j==(Y+1)){
					return true;
				}else if(thiscell.i==(X+1) && thiscell.j==Y){
					return true;
				}else if(thiscell.i==(X-1) && thiscell.j==Y){
					return true;
				}
			}
		}
		return false;
	}
	public static boolean poolContain(List<Pool> poolsList,Cell cell){

		for(Pool pool : poolsList){
			if(pool.getCellsList().contains(cell)){
				return true;
			}
		}
		return false;
	}
	public static List<Cell> getLockedCellsAlone(List<Cell> cells){
		List<Cell> temp = new ArrayList<Cell>();

		for(Cell cell : cells){
			if(cell.IsLocked){
				temp.add(cell);
			}
		}
		return temp;
	}
	

	public static class Pool{
		List<Cell> cellsList;
		public List<Cell> getCellsList() {
			return cellsList;
		}
		public void setCellsList(List<Cell> cellsList) {
			this.cellsList = cellsList;
		}
		public Pool(){
			cellsList = new ArrayList<CandidateCode.Cell>();
		}
	}
	public static class Cell{
		public int i;
		public int j;
		public int height;
		boolean IsLocked;
		public Cell(int a,int b,int c){
			this.i=a;
			this.j=b;
			this.height=c;
			IsLocked=setIsLocked(a, b);
		}
		public boolean isBorder(){
			if(i==0 || j==0 || i==X || j==Y){
				return true;
			}
			return false;
		}
		public boolean isBorder(int a,int b){
			if(a==0 || b==0 || a==X || b==Y){
				return true;
			}
			return false;
		}
		public boolean setIsLocked(int i,int j){
			if(!isBorder(i,j)){
				boolean left = true;
				boolean right = true;
				boolean top = true;
				boolean bottom = true;

				if(blocks[i][j]>=blocks[i-1][j]){
					left=false;
					left= setIsLocked(i-1, j);
				}else if(blocks[i][j]>=blocks[i+1][j]){
					right=false;
					right= setIsLocked(i-1, j);
				}else if(blocks[i][j]>=blocks[i][j-1]){
					top=false;
					top=setIsLocked(i, j-1);
				}else if(blocks[i][j]>=blocks[i][j+1]){
					bottom=false;
					bottom=setIsLocked(i,j+1);
				}else{
					return true;
				}
				if(left&&right&&top&&bottom){
					return true;
				}
			}else{
				return false;
			}
			return false;
		}

	}


	public static void main(String[] args) {
		int[] arr = {3,3,4,4,4,2,3,1,3,2,1,4,7,3,1,6,4,1};
		System.out.println(GetWaterLevel(3,6,arr));
	}

}
