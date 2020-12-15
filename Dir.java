package com.handling;

import java.io.IOException;
import java.util.ArrayList;

import com.source.Directory;

public interface Dir {
	
	public void addFile(Directory d, ArrayList<Directory> al) throws FileFoundException, IOException;
	public void searchFile(Directory d, ArrayList<Directory> al);
	public void deleteFile(Directory d ,ArrayList<Directory> al);

}
