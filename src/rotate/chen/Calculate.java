package rotate.chen;

public class Calculate
{
  public Double[] zrotate(Double[] vector, Double theta)
  {
    Double[] after = { Double.valueOf(0.0D), Double.valueOf(0.0D), Double.valueOf(0.0D) };
    Double[][] zrotate = {
      { Double.valueOf(Math.cos(theta.doubleValue())), Double.valueOf(Math.sin(theta.doubleValue())), Double.valueOf(0.0D) }, 
      { Double.valueOf(-Math.sin(theta.doubleValue())), Double.valueOf(Math.cos(theta.doubleValue())), Double.valueOf(0.0D) }, 
      { Double.valueOf(0.0D), Double.valueOf(0.0D), Double.valueOf(1.0D) } };
    for (int i = 0; i < 3; i++) {
      after[i] = Double.valueOf(vector[0].doubleValue() * zrotate[i][0].doubleValue() + vector[1].doubleValue() * zrotate[i][1].doubleValue() + vector[2].doubleValue() * zrotate[i][2].doubleValue());
    }
    return after;
  }
  
  public Double[] xrotate(Double[] after2, Double theta)
  {
    Double[] after = { Double.valueOf(0.0D), Double.valueOf(0.0D), Double.valueOf(0.0D) };
    Double[][] zrotate = {
      { Double.valueOf(1.0D), Double.valueOf(0.0D), Double.valueOf(0.0D) }, 
      { Double.valueOf(0.0D), Double.valueOf(Math.cos(theta.doubleValue())), Double.valueOf(Math.sin(theta.doubleValue())) }, 
      { Double.valueOf(0.0D), Double.valueOf(-Math.sin(theta.doubleValue())), Double.valueOf(Math.cos(theta.doubleValue())) } };
    for (int i = 0; i < 3; i++) {
      after[i] = Double.valueOf(after2[0].doubleValue() * zrotate[i][0].doubleValue() + after2[1].doubleValue() * zrotate[i][1].doubleValue() + after2[2].doubleValue() * zrotate[i][2].doubleValue());
    }
    return after;
  }
  
  public Double[] yrotate(Double[] after2, Double theta)
  {
    Double[] after = { Double.valueOf(0.0D), Double.valueOf(0.0D), Double.valueOf(0.0D) };
    Double[][] zrotate = {
      { Double.valueOf(Math.cos(theta.doubleValue())), Double.valueOf(0.0D), Double.valueOf(Math.sin(theta.doubleValue())) }, 
      { Double.valueOf(0.0D), Double.valueOf(1.0D), Double.valueOf(0.0D) }, 
      { Double.valueOf(-Math.sin(theta.doubleValue())), Double.valueOf(0.0D), Double.valueOf(Math.cos(theta.doubleValue())) } };
    for (int i = 0; i < 3; i++) {
      after[i] = Double.valueOf(after2[0].doubleValue() * zrotate[i][0].doubleValue() + after2[1].doubleValue() * zrotate[i][1].doubleValue() + after2[2].doubleValue() * zrotate[i][2].doubleValue());
    }
    return after;
  }
  
  public Double[] rotateyxz(Double[] vectorzyx, Double[] theta)
  {
    Double[] afterxyz = { Double.valueOf(0.0D), Double.valueOf(0.0D), Double.valueOf(0.0D) };
    Double[] vectorxyz=new Double[3];
    Double [] afterzyx=new Double[3];
    Double ztheta = theta[0];
    Double ytheta = theta[2];
    Double xtheta = theta[1];
    
    vectorxyz[0]=vectorzyx[2];
    vectorxyz[1]=vectorzyx[1];
    vectorxyz[2]=vectorzyx[0];
   
    afterxyz = yrotate(vectorxyz, ytheta);
    afterxyz = xrotate(afterxyz, xtheta);
    afterxyz = zrotate(afterxyz, ztheta);
   
    afterzyx[0]=afterxyz[2];
    afterzyx[1]=afterxyz[1];
    afterzyx[2]=afterxyz[0];
    
    return afterzyx;
  }
}
