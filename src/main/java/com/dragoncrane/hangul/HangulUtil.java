package com.dragoncrane.hangul;

import java.net.URL;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.commons.io.IOUtils;

import java.util.List;
import java.util.ArrayList;


public class HangulUtil {
	private static HangulUtil theInstance;


	public static HangulUtil getInstance() {
		if (theInstance == null)
		{
			theInstance = new HangulUtil();
		}
		return theInstance;
	}

	private HangulUtil() {
	}


	public String romanize( String toRomanize ) {
		StringBuffer buff = new StringBuffer();
		char[] chars = toRomanize.toCharArray();
		boolean isPrevHangul = false;
		for ( int i = 0; i < chars.length; ++i )
		{
			char nextChar = chars[i];
			Block block = new Block( nextChar );

			if ( isPrevHangul && block.isHangul() )
			{
				buff.append( '-' );
			}
			buff.append( block.toString() );

			// last step: prepare for hyphenation of next char
			isPrevHangul = block.isHangul();
		}
		String retVal = buff.toString();
		return retVal;
	}





	public void romanizeFile( String inFileName, String outFileName ) throws IOException {
		// URL url = Prototype.class.getResource( inFile );
		// File file = new File( url.getPath() );


		//http://stackoverflow.com/questions/3844307/how-to-read-text-file-from-relative-path-in-a-project
		//http://stackoverflow.com/questions/309424/read-convert-an-inputstream-to-a-string
		//http://stackoverflow.com/questions/2788080/reading-a-text-file-in-java
		InputStream inputStream = HangulUtil.class.getResourceAsStream( inFileName );
//		OutputStream outputStream = Prototype.class.getResourceAsStream( outFile );
		String hangul = IOUtils.toString( inputStream );
		String romanized = this.romanize( hangul );
		System.out.println( hangul );
		System.out.println( romanized );

		// write out to file
		File outFile = new File( outFileName );
		 
		// if file doesnt exists, then create it
		if (!outFile.exists()) {
			outFile.createNewFile();
		}

		FileWriter fw = new FileWriter(outFile.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write( romanized );
		bw.close();
		
	}

	public static void main( String[] args )
	throws IOException {
		HangulUtil proto = HangulUtil.getInstance();
		String inFile = args[ 0 ];
		String outFile = args[ 1 ];
		proto.romanizeFile( inFile, outFile );
	}
}
