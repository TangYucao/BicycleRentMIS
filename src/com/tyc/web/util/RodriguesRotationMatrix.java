package com.tyc.web.util;

import java.util.Scanner;

public class RodriguesRotationMatrix {//罗德里格旋转公式
	public static double Vrot_x;//输出
	public static double Vrot_y;//输出
	public static double Vrot_z;//输出
	public static void getNewMatrix(OriginMatrix V,RotationMatrix K,double angle)
	{
		double x=K.getX();
		double y=K.getY();
		double z=K.getZ();
		double u=V.getU();
		double v=V.getV();
		double w=V.getW();
		Vrot_x=u*Math.cos(angle)+(y*w-z*v)*Math.sin(angle)+x*(x*u + y*v + z*w)*( 1- Math.cos(angle));
		Vrot_y=v*Math.cos(angle)+(z*u-x*w)*Math.sin(angle)+y*(x*u + y*v + z*w)*( 1- Math.cos(angle));
		Vrot_z=w*Math.cos(angle)+(x*v-y*u)*Math.sin(angle)+z*(x*u + y*v + z*w)*( 1- Math.cos(angle));
	}
	public static void main(String[] args) 
	{
		System.out.println("罗德里格旋转公式,用于计算给定转轴和旋转角度后的结果。");
		double u,v,w,x,y,z,angle;
		Scanner input=new Scanner(System.in);
		System.out.println("请先输入原矩阵");
		u=input.nextDouble();
		v=input.nextDouble();
		w=input.nextDouble();	
		System.out.println("原矩阵：("+u+","+v+","+w+")");
		OriginMatrix V=new OriginMatrix(u,v,w);
		
		System.out.println("请输入旋转轴");
		x=input.nextDouble();
		y=input.nextDouble();
		z=input.nextDouble();	
		System.out.println("旋转矩阵：("+x+","+y+","+z+")");
		RotationMatrix K=new RotationMatrix(x, y, z);
		
		System.out.println("请输入旋转角度");
		angle=input.nextDouble();
		System.out.println("旋转角度:"+angle);
		getNewMatrix(V,K,angle);
		
		System.out.println("结果：("+String.format("%.2f", Vrot_x)+","+String.format("%.2f", Vrot_y)+","+String.format("%.2f", Vrot_z)+")");
	}
}
class OriginMatrix{//原来地矩阵 (u,v,w)
	private double u,v,w;
	public OriginMatrix(double u,double v,double w){
		this.u=u;
		this.v=v;
		this.w=w;
	}
	public double getU() {
		return u;
	}
	public void setU(double u) {
		this.u = u;
	}
	public double getV() {
		return v;
	}
	public void setV(double v) {
		this.v = v;
	}
	public double getW() {
		return w;
	}
	public void setW(double w) {
		this.w = w;
	}
	
}
class RotationMatrix{//转轴(x,y,z)
	private double x,y,z;
	public RotationMatrix(double x,double y,double z){
		this.x=x;
		this.y=y;
		this.z=z;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getZ() {
		return z;
	}
	public void setZ(double z) {
		this.z = z;
	}
}