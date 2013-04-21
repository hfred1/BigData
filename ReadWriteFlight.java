import java.io.*;
import java.util.ArrayList;
import org.apache.commons.lang3.ArrayUtils;

public class ReadWriteFlight {
	
	ArrayList<String> columnNamesList;
	
	String[] columnNames =  {"Year", "Quarter", "Month", "DayofMonth", "DayOfWeek", "UniqueCarrier", "Origin", "OriginCityName", "OriginState", "Dest", "DestCityName", "DestState", "CRSDepTime", "DepTime", 
			"DepDelay", "DepDelayMinutes", "DepDel15", "DepartureDelayGroups", "TaxiOut", "TaxiIn", "ArrDelay", "ArrDelayMinutes", "ArrDel15", "Cancelled", "ActualElapsedTime", "AirTime", "Distance" 
			};
	
	
	ArrayList<Integer> columnIndicies;
	StringBuilder dataBuilder;
	String filePath  = "C:"+File.pathSeparator+"Users"+File.pathSeparator+"Shawna/Documents/School/_3_Spring Quarter/MSiA 431_Big Data Analytics/HW2/FlightData/"; //using this method so that it is not OS dependant
	
	
	public static void main(String[] args) {
		
	      // The name of the file to open.
		ReadWriteFlight readFlight = new ReadWriteFlight();

		readFlight.setDataBuilder(new StringBuilder());
		readFlight.loadFile(readFlight.getFileDirectory(readFlight.filePath));
		
		
	}
	
	//readfile method
	
	

	private void setColumnIndicies(String line) {
		ArrayList<String> tempStringData = new ArrayList<String>();		
		String[] tempStringArray= line.split(",");			
		
		for(String item : tempStringArray ) {	
			tempStringData.add(item);
		}
		
		for(String column : tempStringData) {
			
				if(getColumnNamesList().contains(column)) {
					if(!getColumnIndicies().contains(getColumnNamesList().indexOf(column)))
						getColumnIndicies().add(getColumnNamesList().indexOf(column));
				}
		}
					
		
			
	}
	
	

	private File getFileDirectory(String directoryName) {
		File directory = new File(directoryName);
		return directory;
	}
	
	//loading the files and starting to build out the arrays
	public void loadFile(File file) {			
		for (File fileName : file.listFiles()){ //read through all the file in the directory
		//ArrayList dataSetArrayList;
			
		int incrementor = 0;
		try {			
			BufferedReader reader = new BufferedReader(new FileReader(file));			
			String row = reader.readLine();				
			/**
			 * looping through the data 
			 */
			while (row != null  ) {								
				if(incrementor==0) {
					setColumnIndicies(row);
				}				
					
				if (incrementor>0) {
					addDataToStringBuilder(row);
				}        		
			}
        
			reader.close();	  
			
		} catch (FileNotFoundException ffe) {
			ffe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}
	
	
}
