#hangul: Korean Hangul Romanization

##Reference Information:

 - [Hangul Unicode code sample in Perl] (http://search.cpan.org/~sadahiro/Lingua-KO-Hangul-Util-0.27/Util.pm)
 - [Wikipedia Hangul Unicode guide](http://en.wikipedia.org/wiki/Korean_language_and_computers#Hangul_in_Unicode)
 - [Korean government official romanization standard](http://www.korean.go.kr/eng_new/document/roman/roman_01.jsp)


##Project Motivation

### History of Hangul Romanization

The Hangul writing system is widely praised for its elegance: it is consistent, compact, and easy to learn.

Yet most westerner's first encounter with the Korean language is not with Hangul letters ("����"), but in Romanized form ("Seoul"). In this form, they tend to mangle the pronunciation, to the dismay of native Koreans.

Why this discrepancy?

The problem lies with the romanization system for Hangul, fundamentally based on the [Mccune-Reischauer](http://en.wikipedia.org/wiki/McCune%E2%80%93Reischauer), developed in 1932.

Although MR was replaced in 2002 by the [Revised Romanization](http://en.wikipedia.org/wiki/Revised_Romanization_of_Korean) system, the changes mostly focused on consonants, e.g.:

```
�ѱ�		MR		=> RR
====================
�λ�		Pusan	=> Busan
�뱸		Taegu	=> Daegu
```


### Critique of current system

The MR -> RR change did not sufficiently address the vowels.

While Vowels written in Hangul are consistent, unique and comprehensible, they become more difficult in Romanization for a number of reasons:

 1. Hangul vowels differences are subtle to untrained western ears (��, ��, ��, etc)
 2. Hangul vowels are consistent, but Romanized vowels less so (�� is sometimes "seo", other times "suh")
 3. Hangul makes syllable alignment is clear-cut, but Romanization does not ("Yeouido" mispronounced as "ye-o-u-i-do" vs. "yeo-ui-do")


### Proposed New Solution

For the above reasons, the romanization standard rests on the following features:

 1. each vowel's romanization is optimized for consistent, accurate, and intuitive pronunciation to a contemporary western speaker (��: "a" => "ah")
 2. if 2 different vowels have the same pronunciation, they may have the same romanization. We sacrifice uniqueness to gain simplicity
 3. syllable alignment will be explicitly denoted by hyphenation ("seoul" => "suh-ool")


## Table of Vowels: Hangul vs. RR vs. New

###Basic Vowels

```
�ѱ�		RR		New
===		===		===
��		a		ah
��		eo		uh
��		o		oh
��		u		oo
��		eu		u		# pronounce very briefly
��		i		ee
```

###Basic Y-vowels

```
�ѱ�		RR		New
===		===		===
��		ya		yah
��		yeo		yuh
��		yo		yoh
��		yu		yoo
```

###Compound Vowels

```
�ѱ�		RR		New
===		===		===
��		ae		eh
��		e		ay
��		oe		weh
��		w		wee
```

###Compound Y-Vowels

```
�ѱ�		RR		New
===		===		===
��		yae		yeh
��		ye		yay
```

###Dipthongs/Tripthongs

```
�ѱ�		RR		New
===		===		===
��		wa		wah
��		wae		weh
��		wo		wuh
��		we		way
��		ui		uee
```


## Possible Applications

The underlying romanization standard is a simple engine that takes in Hangul and returns Romainzed text.

This engine can be plugged into a variety of contexts:

###music
K-Pop is steadily growing in popularity abroad. Moreover, due to streaming services, musicians are disproportionately dependent on overseas sales for sales revenue (e.g. Psy's "Gangnam Style" earned over $10M in the US, but less than $100,000 in the Korean market).

Many of these fans would like to sing along to their favorite K-pop songs but do not wish to invest the time in learning Hangul. An improved romanization system would make the lyrics more accessible, increasing sales volume.


###OCR for tourism and dining
Tourists in Korea trying to read a street sign or building name or dining at a Korean restaurant but unsure how to pronounce a dish, could snap a photo, scan the image into an OCR text converter, and pass that Hangul text into our engine which would return a pronunciation guide.

Free Hangul OCR Readers:
 - [i2OCR](http://www.i2ocr.com/free-online-korean-ocr)
 - [ABBYY](http://finereader.abbyyonline.com/en/Account/Welcome)
 - [FreeOCR](http://freenuts.com/convert-image-to-text-with-free-ocr/)
 - [OCRConvert](http://www.ocrconvert.com/)


### Korean language study
One of the most popular websites for learning Korean is [Talk To Me In Korean](talktomeinkorean.com).

It presents Korean in a very easygoing and casual manner. Moreover, they are not affiliated with any government agency or university, so probably would be flexible and open-minded about an alternative way of romanizing Hangul if it results in better pronunciation results.

If the romanized output is fed into a text-to-voice reader, then students have a new means of generating audio for listening practice from text. Given that TTMIK is entirely free, this enhance the competitiveness of their service relative to the universities which tend to sell expensive audio CDs along with their textbooks for listening practice.


### NOT to be used - 'official' proper nouns (names and locations)
In 2002, the conversion from MR to RR caused tremendous confusion during the world cup as train tickets using the new spelling "Busan" disagreed with old maps reading "Pusan."

Since then, tourism in Korea as steadily grown, and at this point landmark names like "Seoul", "Gangnam", and "Seorak" are more or less set in stone.

The headache of updating the maps yet again from "Seoul" to "suh-ool" and "Gangnam" to "gahng-nahm" is *out of the question*.

Rather, the new romanazation standard could be used as a parenthetical aside *alongside the official spelling* to aide pronunciation.



