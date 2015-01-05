package com.dragoncrane.hangul;

import static org.junit.Assert.*;

import org.junit.Test;

import com.dragoncrane.hangul.HangulUtil;


public class HangulUtilTest {
	private HangulUtil prototype = HangulUtil.getInstance();
	private String message = "String comparison failed: ";

	

	private void testRomanization( String hangul, String expected ) {
		String actual = prototype.romanize( hangul );
		assertEquals(message, expected, actual );
	}


	@Test
	public void testBaseVowels() {
		testRomanization( "아", "ah" );
		testRomanization( "어", "uh" );
		testRomanization( "오", "oh" );
		testRomanization( "우", "oo" );
		testRomanization( "으", "u" );
		testRomanization( "이", "ee" );
	}

	@Test
	public void testYVowels() {
		testRomanization( "야", "yah" );
		testRomanization( "여", "yuh" );
		testRomanization( "요", "yoh" );
		testRomanization( "유", "yoo" );
	}

	@Test
	public void testCompoundVowels() {
		testRomanization( "애", "eh" );
		testRomanization( "얘", "yeh" );
		testRomanization( "에", "ay" );
		testRomanization( "예", "yay" );
		testRomanization( "의", "uee" );
	}

	@Test
	public void testWVowels() {
		testRomanization( "와", "wah" );
		testRomanization( "왜", "weh" );
		testRomanization( "외", "weh" );
		testRomanization( "워", "wuh" );
		testRomanization( "웨", "weh" );	//TODO: double check
		testRomanization( "위", "wee" );
	}


	@Test
	public void testNullLead() {
		testRomanization( "아", "ah" );
	}

	@Test
	public void testSingleLead() {
		testRomanization( "가", "gah" );
	}

	@Test
	public void testDoubleLead() {
		testRomanization( "까", "kkah" );
	}

	@Test
	public void testNullLeadBasicTrailer() {
		testRomanization( "악", "ahk" );
	}

	@Test
	public void testSingleLeadBasicTrailer() {
		testRomanization( "각", "gahk" );
	}

	@Test
	public void testSingleLeadDoubleTrailer() {
		testRomanization( "갂", "gahkk" );
	}


	@Test
	public void testHyphens() {
		testRomanization( "악악악", "ahk-ahk-ahk" );
	}


	@Test
	public void testSpacing() {
		testRomanization( "악 악악 악악악", "ahk ahk-ahk ahk-ahk-ahk" );
	}

	@Test
	public void testNonHangulMixing() {
		testRomanization( "악XYZ 악악:악악악", "ahkxyz ahk-ahk:ahk-ahk-ahk" );
	}
}
