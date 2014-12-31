package com.dragoncrane.hangul;

import static org.junit.Assert.*;

import org.junit.Test;

import com.dragoncrane.hangul.Prototype;


public class HangulUtilTest {
	private Prototype prototype = Prototype.getInstance();
	private String message = "String comparison failed: ";

	

	private void testRomanization( String hangul, String expected ) {
		String actual = prototype.romanizeString( hangul );
		assertEquals(message, expected, actual );
	}


	@Test
	public void testBaseVowels() {
		testRomanization( "��", "ah" );
		testRomanization( "��", "uh" );
		testRomanization( "��", "oh" );
		testRomanization( "��", "oo" );
		testRomanization( "��", "u" );
		testRomanization( "��", "ee" );
	}

	@Test
	public void testYVowels() {
		testRomanization( "��", "yah" );
		testRomanization( "��", "yuh" );
		testRomanization( "��", "yoh" );
		testRomanization( "��", "yoo" );
	}

	@Test
	public void testCompoundVowels() {
		testRomanization( "��", "eh" );
		testRomanization( "��", "yeh" );
		testRomanization( "��", "ay" );
		testRomanization( "��", "yay" );
		testRomanization( "��", "uee" );
	}

	@Test
	public void testWVowels() {
		testRomanization( "��", "wah" );
		testRomanization( "��", "weh" );
		testRomanization( "��", "weh" );
		testRomanization( "��", "wuh" );
		testRomanization( "��", "weh" );	//TODO: double check
		testRomanization( "��", "wee" );
	}


	@Test
	public void testNullLead() {
		testRomanization( "��", "ah" );
	}

	@Test
	public void testSingleLead() {
		testRomanization( "��", "gah" );
	}

	@Test
	public void testDoubleLead() {
		testRomanization( "��", "kkah" );
	}

	@Test
	public void testNullLeadBasicTrailer() {
		testRomanization( "��", "ahk" );
	}

	@Test
	public void testSingleLeadBasicTrailer() {
		testRomanization( "��", "gahk" );
	}

	@Test
	public void testSingleLeadDoubleTrailer() {
		testRomanization( "�A", "gahkk" );
	}


	@Test
	public void testHyphens() {
		testRomanization( "�ǾǾ�", "ahk-ahk-ahk" );
	}


	@Test
	public void testSpacing() {
		testRomanization( "�� �Ǿ� �ǾǾ�", "ahk ahk-ahk ahk-ahk-ahk" );
	}

	@Test
	public void testNonHangulMixing() {
		testRomanization( "��xyz �Ǿ�:�ǾǾ�", "ahkxyz ahk-ahk:ahk-ahk-ahk" );
	}
}
