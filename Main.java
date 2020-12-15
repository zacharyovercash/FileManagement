package com.source;

import java.io.File;

import java.io.FilenameFilter;

import java.io.IOException;

import java.util.ArrayList;

import java.util.Collections;

import java.util.Scanner;

import com.handling.FileFoundException;

public class Main {

	public static void main(String[] args) throws FileFoundException, IOException {

		String dir = null;

		File f;

		String fileName;

		Scanner in = new Scanner(System.in);

		ArrayList<Directory> al = new ArrayList<Directory>();

		boolean dirExists = false;

		FilenameFilter filter = new FilenameFilter() {

			@Override

			public boolean accept(File dir, String name) {

				return name.endsWith(".txt");

			}

		};

		while (dirExists == false)

		{

			System.out.println("Enter Directory:");

			dir = in.next();

			File folder = new File(dir);

			if (folder.exists()) {

				File[] list = folder.listFiles(filter);

				for (File file : list) {

					Directory d = new Directory(dir, file.getName());

					al.add(d);

				}

				dirExists = true;

			}

			else {

				System.out.println("Directory does not exist");

			}

			boolean done = false;

			System.out.println("Welcome to the file management system created by Zach Overcash");

			while (done == false) {

				System.out.println("1)Display all files\n2)Manage Current Files\n3)Exit");

				String choice = in.next();

				boolean finish = false;

				switch (choice) {

				case "1":

					Collections.sort(al, new Directory());

					File[] list = folder.listFiles(filter);

					for (File file : list) {

						System.out.println(file.getName());

					}

					System.out.println("");

					break;

				case "2":

					while (finish == false) {

						boolean found = false;

						System.out

								.println(
										"1)Add new file\n2)Delete a file\n3)Search for a file\n4)Return to previous menu");

						String next = in.next();

						switch (next) {

						case "1":

							System.out.println("Enter name of file you would like to add");

							fileName = in.next();

							Directory a = new Directory(dir + "/" + fileName, fileName);

							a.addFile(a, al);

							break;

						case "2":

							System.out.println("enter name of file you want to delete");

							String name = in.next();

							Directory d = new Directory(dir + "/" + name, name);

							d.deleteFile(d, al);

							al.remove(d);

							break;

						case "3":

							System.out.println("Enter name of file you are looking for");

							fileName = in.next();

							Directory s = new Directory(dir + "/" + fileName, fileName);

							s.searchFile(s, al);

							break;

						case "4":

							finish = true;

							break;

						default:

							System.out.println("input not accepted\n");

							break;

						}

					}

					break;

				case "3":

					done = true;

					System.out.println("Thank you for using the file management system");

					break;

				default:

					System.out.println("wrong input try again\n");

					break;

				}

			}

		}
	}
}
