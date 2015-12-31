package math;

import java.io.IOException;

/**
 * 梯度下降
 * @author h154651
 *
 */
public class Demo1 {
	
	public void start(){
		double matrix[][]={{1,4},{2,5},{5,1},{4,2}};  
	    double result[]={19,26,19,20};  
	    double theta[]={0,0};//初始为零向量   
	    double loss=10.0;  
	    for(int i=0;i<100&&loss>0.001;i++)  
	    {  
	        double error_sum=0;  
	        int j=i%4;  
	        {  
	            double h=0;  
	            for(int k=0;k<2;k++)  
	            {  
	                h+=matrix[j][k]*theta[k];  
	            }  
	            error_sum=result[j]-h;  
	             for(int k=0;k<2;k++)  
	             {  
	                 theta[k]+=0.01*(error_sum)*matrix[j][k];//这里是关键   
	             }  
	         }  
	         System.out.println(theta[0]+"-"+theta[1]);
	         loss=0;  
	         for(j=0;j<4;j++)  
	         {  
	             double sum=0;  
	             for(int k=0;k<2;k++)  
	             {  
	                 sum+=matrix[j][k]*theta[k];  
	             }  
	             loss+=(sum-result[j])*(sum-result[j]);  
	         }  
	         System.out.println(loss);
	     }  

		
	}

}
