package com.dragoncrane.hangul;


public class Block {


	public static final int UNICODE_OFFSET = 44032;
	public static final int UNICODE_MAX = 55215;

	public static final String[] leads = {
			"g",	// ㄱ
			"kk",	// ㄲ
			"n",	// ㄴ
			"d",	// ㄷ
			"tt",	// ㄸ
			"r",	// ㄹ
			"m",	// ㅁ
			"b",	// ㅂ
			"pp",	// ㅃ
			"s",	// ㅅ
			"ss",	// ㅆ
			"",	// ㅇ
			"j",	// ㅈ
			"jj",	// ㅉ
			"ch",	// ㅊ
			"q",	// ㅋ
			"t",	// ㅌ
			"p",	// ㅍ
			"h"		// ㅎ
	};
	public static final String[] vowels = {
			"ah",	// ㅏ
			"eh",	// ㅐ
			"yah",	// ㅑ
			"yeh",	// ㅒ
			"uh",	// ㅓ
			"ay",	// ㅔ
			"yuh",	// ㅕ
			"yay",	// ㅖ
			"oh",	// ㅗ
			"wah",	// ㅘ
			"weh",	// ㅙ
			"weh",	// ㅚ
			"yoh",	// ㅛ
			"oo",	// ㅜ
			"wuh",	// ㅝ
			"weh",	// ㅞ
			"wee",	// ㅟ
			"yoo",	// ㅠ
			"u",	// ㅡ
			"uee",	// ㅢ
			"ee"	// ㅣ
	};

	
	public static final String[] trailers = {
			"",	// no jamo
			"k", // ㄱ
			"kk", // ㄲ
			"ks", // ㄳ
			"n", // ㄴ
			"nj", // ㄵ
			"nh", // ㄶ
			"d", // ㄷ
			"l", // ㄹ
			"lg", // ㄺ
			"lm", // ㄻ
			"lb", // ㄼ
			"ls", // ㄽ
			"lt", // ㄾ
			"lp", // ㄿ
			"lh", // ㅀ
			"m", // ㅁ
			"p", // ㅂ
			"ps", // ㅄ
			"s", // ㅅ
			"ss", // ㅆ
			"ng", // ㅇ
			"j", // ㅈ
			"ch", // ㅊ
			"q", // ㅋ
			"t", // ㅌ
			"p", // ㅍ
			"h" // ㅎ
	};

	public boolean isHangul() {
		return isHangul;
	}

	private int iOffset, vOffset, tOffset;
	private String romanization = "";
	private boolean isHangul;


	public Block( char hangul ) {
		isHangul = ( hangul >= Block.UNICODE_OFFSET &&
				hangul < Block.UNICODE_MAX );
		if ( isHangul )
		{
			int unicodeOffset = ( (int) hangul ) - UNICODE_OFFSET;
			int trailerOffset = unicodeOffset % trailers.length;
			unicodeOffset -= trailerOffset;
			unicodeOffset /= trailers.length;
			int vowelOffset = unicodeOffset % vowels.length;
			unicodeOffset -= vowelOffset;
			unicodeOffset /= vowels.length;
			int leadOffset = unicodeOffset;

			StringBuffer buff = new StringBuffer();
			
			buff.append( leads[ leadOffset ] );
			buff.append( vowels[ vowelOffset ] );
			buff.append( trailers[ trailerOffset ] );
			romanization = buff.toString();
		}
		else
		{
			romanization = String.valueOf( hangul );
		}
	}

	@Override
	public String toString() {
		return romanization;
	}
}