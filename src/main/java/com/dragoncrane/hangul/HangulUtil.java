package com.dragoncrane.hangul;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;


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
		InputStream inputStream = HangulUtil.class.getResourceAsStream( inFileName );
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
