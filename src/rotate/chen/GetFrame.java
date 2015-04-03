package rotate.chen;

import java.io.File;
import java.io.FileNotFoundException;
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
  
  public Double[] getvector(int vector_num, String filename)
    throws FileNotFoundException
  {
    Double[] vector = new Double[3];
    Scanner file = new Scanner(new File(filename));
    Double[] vectorlist = new Double[1024];
    int count = 0;
    while (file.hasNext())
    {
      String s = file.next();
      if (s.equals("OFFSET"))
      {
        count++;
        vectorlist[(count * 3 + 0)] = Double.valueOf(Double.parseDouble(file.next()));
        vectorlist[(count * 3 + 1)] = Double.valueOf(Double.parseDouble(file.next()));
        vectorlist[(count * 3 + 2)] = Double.valueOf(Double.parseDouble(file.next()));
      }
    }
    vector[0] = vectorlist[((vector_num + 1) * 3 + 0)];
    vector[1] = vectorlist[((vector_num + 1) * 3 + 1)];
    vector[2] = vectorlist[((vector_num + 1) * 3 + 2)];
    
    return vector;
  }
}
