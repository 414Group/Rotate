package rotate.chen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Scan_bvh
{
  public int[] scan(String filename)
    throws FileNotFoundException
  {
    int[] fileinfo = new int[10];
    
    Scanner file = new Scanner(new File(filename));
    Scanner file1 = new Scanner(new File(filename));
    Scanner file2 = new Scanner(new File(filename));
    Scanner file3 = new Scanner(new File(filename));
    
    int offset_num = 0;
    int joint_num = 0;
    int column_num = 0;
    int row_num = 0;
    int motion_start_line = 0;
    
    int[] a_column_num = new int[1024];
    while (file.hasNext())
    {
      String s = file.next();
      if (s.equals("JOINT"))
      {
        joint_num++;
        String str1 = file.next();
      }
    }
    while (file3.hasNext())
    {
      String s = file3.next();
      if (s.equals("OFFSET")) {
        offset_num++;
      }
    }
    while (file1.hasNextLine())
    {
      row_num++;
      file1.nextLine();
    }
    int row_no = 0;
    while (file2.hasNextLine())
    {
      Scanner line = new Scanner(file2.nextLine());
      column_num = 0;
      while (line.hasNext())
      {
        line.next();
        column_num++;
      }
      row_no++;
      a_column_num[row_no] = column_num;
    }
    for (int i = 1; i < row_num + 1; i++) {}
    for (int i = 1; i < row_num + 1; i++) {
      if (a_column_num[i] == column_num)
      {
        motion_start_line = i;
        break;
      }
    }
    Scanner findframenum = new Scanner(new File(filename));
    while (findframenum.hasNext())
    {
      String s = findframenum.next();
      if (s.equals("Frames:")) {
        break;
      }
    }
    int frame_num = Integer.parseInt(findframenum.next());
    
    fileinfo[0] = joint_num;
    fileinfo[1] = column_num;
    fileinfo[2] = row_num;
    fileinfo[3] = motion_start_line;
    fileinfo[4] = frame_num;
    fileinfo[5] = offset_num;
    
    return fileinfo;
  }
}
