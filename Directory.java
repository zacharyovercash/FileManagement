package com.source;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.handling.Dir;
import com.handling.FileFoundException;

public class Directory implements Dir, Comparator<Directory>{

	
	private String dir;
	private String fileName;
	public Directory() {
		super();
		
	}
	public Directory(String dir, String fileName) {
		super();
		this.dir = dir;
		this.fileName = fileName;
	}

	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	@Override
	public void addFile(Directory d , ArrayList<Directory> al) throws FileFoundException, IOException {

		File f = new File(d.getDir());
		if (!f.exists() && f.getName().endsWith(".txt")) {
			f.createNewFile();
			System.out.println("file created\n");
			al.add(d);	
		} else if(f.exists()){
			System.out.println("File Exists");
		}else if(!f.getName().endsWith(".txt")){
			System.out.println("Wrong file type, accepts .txt only");
		}


	}
	@Override
	public void searchFile(Directory d , ArrayList<Directory> al) {
		boolean found=false;
		for (Directory s : al) {
			if (s.getFileName().equals(d.getFileName())) {
				System.out.println("File " + fileName + " was found\n");
				found = true;
			}
			
	}
		if(found==false){
			System.out.println("File was not found");
		}
	}
	@Override
	public void deleteFile(Directory d, ArrayList<Directory> al) {
		File f = new File(d.getDir());
		if (f.delete()) {
			System.out.println("File deleted\n");
			//al.remove(d);
			al.remove(f);
		} else {
			System.out.println("File not Found");
		}
	}
	
	@Override
	public int compare(Directory o1, Directory o2) {
		return o1.getFileName().compareTo(o2.getFileName());
	}
	
	
	
	
}
	
	
	
	
	

