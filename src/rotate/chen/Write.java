package rotate.chen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Write
{
  public void OutWrite( Double[] after, String infile, int[] fileinfo, String outfile)
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
    int linenumber=0;
    int vector_count=0;
    
    while (((str = br.readLine()) != null) && (motion_start_line > 1))
    {
    	linenumber++;
      //String str;
      if (str.contains("{")) {
        bracket_count++;
      }
      if (str.contains("}")) {
        bracket_count--;
      }
      
	
      if (linenumber==fileinfo[11+offset_count])
      {
    	  offset_count++;

        	 if(1<offset_count&&offset_count<fileinfo[0])
             {
                 for (int i = 0; i < bracket_count; i++) {
                   pw.print("\t");
                 }
                 pw.print("OFFSET ");
                 pw.print(after[offset_count*3-3] + " ");
                 pw.print(after[offset_count*3-2] + " ");
                 pw.println(after[offset_count*3-1] + " ");
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
  
  public void WriteFile(int vector_num, Double[] vector, String infile, int[] fileinfo, String outfile)
		    throws IOException
		    {
	  
		    }
}
