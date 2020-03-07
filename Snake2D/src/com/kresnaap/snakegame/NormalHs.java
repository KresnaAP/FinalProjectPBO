package com.kresnaap.snakegame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.*;
import java.util.Scanner;

import javax.swing.ImageIcon; 

public class NormalHs {
	 
	File filetext = new File("src/resources/textfile/normal.txt");
	private Scanner s;
	private int posY = 360;
	private String[] data = new String[10];
	private Image normalhsback;
	private final Font sizeFont = new Font("Courier", Font.BOLD, 25);
	
	public void getData()
	{
		
		try {
			s = new Scanner(filetext);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		int i = 0;
		while(s.hasNextLine())
		{
			
			data[i] = s.nextLine();
//			System.out.println(data[i]);
			i++;
		}
	}

	public void inputData(String str)
	{
		try { 
			  
            // Open given file in append mode. 
            BufferedWriter out = new BufferedWriter( 
                   new FileWriter("src/resources/textfile/normal.txt", true)); 
            out.write(str); 
            out.close(); 
        } 
        catch (IOException e) { 
            System.out.println("exception occoured" + e); 
        } 
	}
	
	public void renderGame(Graphics g)
	{
		
		g.drawString("Highscore :", 130, posY);
		
		int n = 0;
		int k = 0;
		while(data[n] != null && k < 4)
		{
			
			g.drawString(data[n], 250, posY);
			posY += 30;
			n++;
			k++;
		}
	}
	
	public void reset()
	{
		
		this.posY = 360;
	}
	
	public void renderMenu(Graphics g)
	{	
		
		ImageIcon normhs = new ImageIcon("src/resources/menus/normalhs.png");
        normalhsback = normhs.getImage();
        
        g.drawImage(normalhsback, 0, 0, null);
        
        g.setFont(sizeFont);
        g.setColor(new Color(0, 0, 0));
        
        int n=0;
    	int posY2 = 150;
    	while(data[n] != null)
    	{
    		g.drawString(data[n], 100, posY2);
    		posY2 += 40;
    		// System.out.println(data[n]);
    		n++;
    	}
	}
}
