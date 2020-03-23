package com.guo.mytest;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * java开发微博自动添加水印系统
 * @author 陈作麟
 * @time 2018/10/01
 */
public class WaterMark {
	
	/**
	 * 
	 * @param srcImgPath		原图片的路径
	 * @param tarImgPath		新图片的路径
	 * @param watermarkContent	水印的内容
	 * @param color		水印的颜色
	 * @param font		水印的字体
	 */
	public void addWatermark(String srcImgPath,String tarImgPath,String watermarkContent,Color color,Font font) {
		
		try {
			// Integer degree = -45;//设置水印文字的旋转角度
			Integer degree = 0;//设置水印文字的旋转角度
			
			//获取图片文件
			File srcImgfile = new File(srcImgPath);
			//把文件转换成图片
			Image srcImg = ImageIO.read(srcImgfile);
			//获取图片的宽和高
			int srcImgwidth = srcImg.getWidth(null);
			int srcImgheight = srcImg.getHeight(null);
			
			//画水印需要一个画板    创建一个画板
			BufferedImage buffImg = new BufferedImage(srcImgwidth,srcImgheight,BufferedImage.TYPE_INT_RGB);
			//创建一个2D的图像
			Graphics2D g = buffImg.createGraphics();
			//画出来
			g.drawImage(srcImg, 0, 0, srcImgwidth, srcImgheight,null);
			
			//设置水印的颜色
			g.setColor(color);
			
			//设置水印的字体
			g.setFont(font);
			
			if (null != degree) {
                g.rotate(Math.toRadians(degree),(double)buffImg.getWidth()*0.5,(double)buffImg.getHeight()*0.5);//设置水印旋转
            }
			
			//设置水印坐标
			int x = srcImgwidth*97/100 -getwaterMarkLength(watermarkContent, g);
			int y = srcImgheight*1/2;
			
			//根据获取的坐标 在相应的位置画出水印
			g.drawString(watermarkContent, x, y);
			
			//释放画板的资源
			g.dispose();
			
			//输出新的图片
			FileOutputStream outputStream = new FileOutputStream(tarImgPath);
			
			//创建新的图片
			ImageIO.write(buffImg, "jpg", outputStream);
			System.out.println("水印添加完成！");
			
			//刷新流
			outputStream.flush();
			//关闭流
			outputStream.close();
			
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	/**
	 * 获取水印的坐标
	 * @param watermarkContent 		水印内容	
	 * @param g		2d图像
	 * @return		水印的长度
	 */
	public int getwaterMarkLength(String watermarkContent,Graphics2D g) {
	
		return	g.getFontMetrics(g.getFont()).charsWidth(watermarkContent.toCharArray(), 0, watermarkContent.length());
				
	}
	
	public static void main(String[] args) {
		
		Font font = new Font("微软雅黑",Font.PLAIN,32);
		
		String srcImgPath = "C:\\Users\\Administrator\\Desktop\\test\\111.jpg";
		String tarImgPath = "C:\\Users\\Administrator\\Desktop\\test\\112.jpg";
		String watermarkContent = "21b40359eada4afaaf5d1732a126dee7";
		Color color = new Color(0, 0, 0,255);
		
		WaterMark aa = new WaterMark();	
		aa.addWatermark(srcImgPath, tarImgPath, watermarkContent, color, font);
		
	}
}