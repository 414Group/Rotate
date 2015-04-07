package rotate.chen;

import java.io.IOException;
import java.io.PrintStream;

public class Rotate
{
  public static void main(String[] args)
    throws IOException
  {
    String infile = "18_01.bvh";
    String outfile = "Frame.bvh";
    int[] fileinfo = new int[6];
    
    int frame_num = 1;
    
    Scan_bvh sc = new Scan_bvh();
    fileinfo = sc.scan(infile);
    
    RotateFrame(infile, fileinfo, outfile, frame_num);
    
    System.out.println("fileinfo:");
    for (int i = 0; i < 7; i++) {
      System.out.println(fileinfo[i]);
    }
  }
  
  public static void RotateFrame(String infile, int[] fileinfo, String outfile, int frame_num)
    throws IOException
  {
    GetFrame gf = new GetFrame();
    String current_frame = null;
    int vector_count = fileinfo[0];
    int vector_num = 2;
    current_frame = gf.getframe(frame_num, fileinfo, infile);
    
    RotateVector(current_frame, infile, fileinfo, outfile, gf);
  }
  
  public static void RotateVector(String current_frame, String infile, int[] fileinfo, String outfile, GetFrame gf)
    throws IOException
  {
    Double[] vector = new Double[90];
    Double[] theta = new Double[90];
    Double[] after = new Double[90];
    Double[] _vector = new Double[3];
    Double[] _theta = new Double[3];
    Double[] _after = new Double[3];
    
    Write wr = new Write();
    Calculate cal = new Calculate();
    
    for(int i=0;i<fileinfo[0];i++)
    {
    	 _theta = gf.gettheta(i+1, current_frame);
    	 _vector = gf.getvector(i+1, infile,fileinfo);
    	 _after = cal.rotateyxz(_vector, _theta);
    	 after[i*3]=_after[0];
    	 after[i*3+1]=_after[1];
    	 after[i*3+2]=_after[2];
    }
   
    
    wr.OutWrite( after, infile, fileinfo, outfile);
    
//    System.out.println("---------");
//    System.out.println("vector:");
//    for (int i = 0; i < 3; i++) {
//      System.out.println(_vector[i]);
//    }
//    System.out.println("---------");
//    System.out.println("theta:");
//    for (int i = 0; i < 3; i++) {
//      System.out.println(_theta[i]);
//    }
//    System.out.println("---------");
//    System.out.println("after:");
//    for (int i = 0; i < 3; i++) {
//      System.out.println(_after[i]);
//    }
  }
}
