package rotate.chen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class GetFrame
{
  public String getframe(int frame_num, int[] fileinfo, String filename)
    throws FileNotFoundException
  {
    int motion_start_line = fileinfo[3];
    String frame = null;
    
    Scanner file = new Scanner(new File(filename));
    for (int i = 0; i < motion_start_line + frame_num - 1 - 1; i++) {
      file.nextLine();
    }
    frame = file.nextLine();
    
    return frame;
  }
  
  public Double[] gettheta(int theta_num, String frame)
  {
    Double[] theta = new Double[3];
    
    Scanner line = new Scanner(frame);
    for (int i = 0; i < 3 + 3 * theta_num; i++) {
      line.next();
    }
    for (int i = 0; i < 3; i++) {
      theta[i] = Double.valueOf(Double.parseDouble(line.next()));
    }
    return theta;
  }
  
  public Double[] getvector(int vector_num, String infile, int[] fileinfo)
    throws NumberFormatException, IOException
  {
	FileReader fr = new FileReader(infile);
	BufferedReader br = new BufferedReader(fr);
	
    Double[] vector = new Double[3];
    Double[] vectorlist = new Double[1024];
    int linenumber=0;
    int offset_count = 0;
    String str=null;
    
    while ((str = br.readLine()) != null )
    {
    	linenumber++;
    	if (linenumber==fileinfo[11+offset_count])
    	{
    		offset_count++;
    		Scanner line = new Scanner(str);
    		line.next();
    		vectorlist[(offset_count * 3 -3)] = Double.valueOf(Double.parseDouble(line.next()));
    	    vectorlist[(offset_count * 3 -2)] = Double.valueOf(Double.parseDouble(line.next()));
    	    vectorlist[(offset_count * 3 -1)] = Double.valueOf(Double.parseDouble(line.next()));
    	    line.close();
    	}
    }
 
    vector[0] = vectorlist[((vector_num) * 3 -3)];
    vector[1] = vectorlist[((vector_num) * 3 -2)];
    vector[2] = vectorlist[((vector_num) * 3 -1)];
    br.close();
    return vector;
  }
}
