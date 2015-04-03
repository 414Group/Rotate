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
    for (int i = 0; i < 6; i++) {
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
    
    RotateVector(3, current_frame, infile, fileinfo, outfile, gf);
  }
  
  public static void RotateVector(int vector_num, String current_frame, String infile, int[] fileinfo, String outfile, GetFrame gf)
    throws IOException
  {
    Double[] vector = { Double.valueOf(1.0D), Double.valueOf(2.0D), Double.valueOf(3.0D) };
    Double[] theta = { Double.valueOf(30.0D), Double.valueOf(40.0D), Double.valueOf(50.0D) };
    
    Double[] after = { Double.valueOf(0.0D), Double.valueOf(0.0D), Double.valueOf(0.0D) };
    Write wr = new Write();
    Calculate cal = new Calculate();
    
    theta = gf.gettheta(vector_num, current_frame);
    vector = gf.getvector(vector_num, infile);
    
    after = cal.rotateyzx(vector, theta);
    
    wr.OutWrite(vector_num, after, infile, fileinfo, outfile);
    
    System.out.println("---------");
    System.out.println("vector:");
    for (int i = 0; i < 3; i++) {
      System.out.println(vector[i]);
    }
    System.out.println("---------");
    System.out.println("theta:");
    for (int i = 0; i < 3; i++) {
      System.out.println(theta[i]);
    }
    System.out.println("---------");
    System.out.println("after:");
    for (int i = 0; i < 3; i++) {
      System.out.println(after[i]);
    }
  }
}
