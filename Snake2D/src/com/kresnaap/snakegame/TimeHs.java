package com.kresnaap.snakegame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.ImageIcon;

public class TimeHs {

	File filetext = new File("src/resources/textfile/timeattack.txt");
	private Scanner s;
	private int posY = 380;
	private String[] data = new String[10];
	private Image timehsback;
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
                   new FileWriter("src/resources/textfile/timeattack.txt", true)); 
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
		
		this.posY = 380;
	}
	
	public void renderMenu(Graphics g)
	{
	
		ImageIcon timehs = new ImageIcon("src/resources/menus/timeattackhs.png");
        timehsback = timehs.getImage();
        
        g.drawImage(timehsback, 0, 0, null);
        
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
