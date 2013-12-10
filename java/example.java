// Copyright (c) 2013 Matthew Savage
// Written by Matthew Savage as a part of the competition-code repository (github.com/BluePichu/competition-code)
// This code may be used or modified but the header and copyright must remain.

// ---------------------------------------------------------------------------

// A shell for Java competition file
// To use this code, I suggest doing a find/replace on "example" to replace it with the problem name

// ---------------------------------------------------------------------------

import java.io.*;
import java.util.*;

public class example{
	public static void main(String[] args) throws IOException{
      // use the following two lines for file I/O (e.g., USACO)
		BufferedReader br = new BufferedReader(new FileReader("example.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("example.out")));
		
		// use the following two lines for std I/O (e.g., Codeforces)
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
      // make sure to leave these lines here to ensure that all I/O is flushed when the program terminates
		br.close();
		pw.close();
	}
}