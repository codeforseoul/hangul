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
		testRomanization( "æ∆", "ah" );
		testRomanization( "æÓ", "uh" );
		testRomanization( "ø¿", "oh" );
		testRomanization( "øÏ", "oo" );
		testRomanization( "¿∏", "u" );
		testRomanization( "¿Ã", "ee" );
	}

	@Test
	public void testYVowels() {
		testRomanization( "æﬂ", "yah" );
		testRomanization( "ø©", "yuh" );
		testRomanization( "ø‰", "yoh" );
		testRomanization( "¿Ø", "yoo" );
	}

	@Test
	public void testCompoundVowels() {
		testRomanization( "æ÷", "eh" );
		testRomanization( "æÍ", "yeh" );
		testRomanization( "ø°", "ay" );
		testRomanization( "øπ", "yay" );
		testRomanization( "¿«", "uee" );
	}

	@Test
	public void testWVowels() {
		testRomanization( "øÕ", "wah" );
		testRomanization( "ø÷", "weh" );
		testRomanization( "ø‹", "weh" );
		testRomanization( "øˆ", "wuh" );
		testRomanization( "ø˛", "weh" );	//TODO: double check
		testRomanization( "¿ß", "wee" );
	}


	@Test
	public void testNullLead() {
		testRomanization( "æ∆", "ah" );
	}

	@Test
	public void testSingleLead() {
		testRomanization( "∞°", "gah" );
	}

	@Test
	public void testDoubleLead() {
		testRomanization( "±Ó", "kkah" );
	}

	@Test
	public void testNullLeadBasicTrailer() {
		testRomanization( "æ«", "ahk" );
	}

	@Test
	public void testSingleLeadBasicTrailer() {
		testRomanization( "∞¢", "gahk" );
	}

	@Test
	public void testSingleLeadDoubleTrailer() {
		testRomanization( "ÅA", "gahkk" );
	}


	@Test
	public void testHyphens() {
		testRomanization( "æ«æ«æ«", "ahk-ahk-ahk" );
	}


	@Test
	public void testSpacing() {
		testRomanization( "æ« æ«æ« æ«æ«æ«", "ahk ahk-ahk ahk-ahk-ahk" );
	}

	@Test
	public void testNonHangulMixing() {
		testRomanization( "æ«xyz æ«æ«:æ«æ«æ«", "ahkxyz ahk-ahk:ahk-ahk-ahk" );
	}
}
