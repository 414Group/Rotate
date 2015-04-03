package rotate.chen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Write
{
  public void OutWrite(int vector_num, Double[] vector, String infile, int[] fileinfo, String outfile)
    throws IOException
  {
    FileWriter fw = new FileWriter(outfile);
    PrintWriter pw = new PrintWriter(fw);
    FileReader fr = new FileReader(infile);
    BufferedReader br = new BufferedReader(fr);
    
    int offset_count = 0;
    int bracket_count = 0;
    int motion_start_line = fileinfo[3];
    int joincount = fileinfo[0];
    String str;
    while (((str = br.readLine()) != null) && (motion_start_line > 1))
    {
      //String str;
      if (str.contains("{")) {
        bracket_count++;
      }
      if (str.contains("}")) {
        bracket_count--;
      }
      if (str.contains("OFFSET"))
      {
        offset_count++;
        if (offset_count - 1 == vector_num)
        {
          for (int i = 0; i < bracket_count; i++) {
            pw.print("\t");
          }
          pw.print("OFFSET ");
          pw.print(vector[0] + " ");
          pw.print(vector[1] + " ");
          pw.println(vector[2] + " ");
        }
        else
        {
          pw.println(str);
        }
      }
      else
      {
        pw.println(str);
      }
      motion_start_line--;
    }
    for (int i = 0; i < joincount * 3 + 6; i++) {
      pw.print("0 ");
    }
    pw.println();
    
    br.close();
    pw.close();
  }
}
