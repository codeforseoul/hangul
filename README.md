# Korean Hangul Romanization

### Summary (요약)

Most Westerners in English-speaking world often encounter discrepency with the current Korean Romanization system of Hangul, due to several reasons including: subtlety of specific vowels to the untrained ears, inconsistency within vowels. Our purpose is not to revise the current system but to offer a simple guideline to pronouncing Hangul.

영어권 사람들이 대부분 한글을 처음 접할 때 한글의 로마자 표기법에서 많은 혼동을 느끼는데, 이는 로마자 표기법이 영어권의 사람들에겐 음절의 구분이 명확하지 않아 생깁니다 (예: Seoul (서울) => SEO-ul ("세오-울"), Yeoeuido (여의도) => Ye-o-u-i-do ("예-오-우-이-도")). 이는 기존의 로마자 표기법을 폐지하고 2002년에 새로 국립국어원에서 발표한 국어의 로마자 표기법이 영어권 사람들을 대상으로는 모음의 구분을 명확히 하지 않았던 데에서 일어나는데, 각 음절의 발음법을 조금 변형하여 올바른 발음법을 제시하는 데에 의의를 두고 있습니다. 하지만 이전의 로마자 표기법을 개선하여 새로 적용하였을 때 많은 혼란이 있었던 점을 감안하면, 현재의 로마자 표기법을 새로이 개정하자는 것이 아니라, 영어권 사람들이 한글을 접할 때 발음법의 간단한 가이드라인을 제시하는 데에 의의를 두고 있습니다.


### Reference Information (참고자료):

 - [Hangul Unicode code sample in Perl](http://search.cpan.org/~sadahiro/Lingua-KO-Hangul-Util-0.27/Util.pm) Perl로 제작된 한글 유니코드 예제
 - [Wikipedia Hangul Unicode guide](http://en.wikipedia.org/wiki/Korean_language_and_computers#Hangul_in_Unicode) 위키피디아 한글 유니코드 가이드
 - [Korean government official romanization standard](http://www.korean.go.kr/eng_new/document/roman/roman_01.jsp) 국어의 로마자 표기법


### History of Hangul Romanization

The Hangul writing system is widely praised for its elegance: it is consistent, compact, and easy to learn.

Yet most westerner's first encounter with the Korean language is not with Hangul letters ("서울"), but in Romanized form ("Seoul"). In this form, they tend to mangle the pronunciation, to the dismay of native Koreans.

Why this discrepancy?

The problem lies with the romanization system for Hangul, fundamentally based on the [Mccune-Reischauer](http://en.wikipedia.org/wiki/McCune%E2%80%93Reischauer), developed in 1932.

Although MR was replaced in 2002 by the [Revised Romanization](http://en.wikipedia.org/wiki/Revised_Romanization_of_Korean) system, the changes mostly focused on consonants, e.g.:

```
한글		MR		=> RR
====================
부산		Pusan	=> Busan
대구		Taegu	=> Daegu
```


### Critique of current system

The MR -> RR change did not sufficiently address the vowels.

While Vowels written in Hangul are consistent, unique and comprehensible, they become more difficult in Romanization for a number of reasons:

 1. Hangul vowels differences are subtle to untrained western ears (의, 외, 왜, etc)
 2. Hangul vowels are consistent, but Romanized vowels less so (서 is sometimes "seo", other times "suh")
 3. Hangul makes syllable alignment is clear-cut, but Romanization does not ("Yeouido" mispronounced as "ye-o-u-i-do" vs. "yeo-ui-do")


### Proposed New Solution

For the above reasons, the romanization standard rests on the following features:

 1. each vowel's romanization is optimized for consistent, accurate, and intuitive pronunciation to a contemporary western speaker (아: "a" => "ah")
 2. if 2 different vowels have the same pronunciation, they may have the same romanization. We sacrifice uniqueness to gain simplicity
 3. syllable alignment will be explicitly denoted by hyphenation ("seoul" => "suh-ool")





- - -





# Technical Details of Solution

### Running this Software

 - repository:	Git / GitHub
 - language:	Java
 - build:		Maven
 - main:		com.dragoncrane.hangul.Prototype
 - arg1:		path to hangul input - must be on classpath (eg "/data/input.txt")
 - arg2:		absolute path to romanized output (eg "C:\dave\output.txt")
 - execution:	run "mvn test" on command line (uses exec-maven-plugin)

### Table of Vowels: Hangul vs. RR vs. New

Basic Vowels

```
한글		RR		New
===		===		===
아		a		ah
어		eo		uh
오		o		oh
우		u		oo
으		eu		u		# pronounce very briefly
이		i		ee
```

Basic Y-vowels

```
한글		RR		New
===		===		===
야		ya		yah
여		yeo		yuh
요		yo		yoh
유		yu		yoo
```

Compound Vowels

```
한글		RR		New
===		===		===
애		ae		eh
에		e		ay
외		oe		weh
위		w		wee
```

Compound Y-Vowels

```
한글		RR		New
===		===		===
얘		yae		yeh
예		ye		yay
```

Dipthongs/Tripthongs

```
한글		RR		New
===		===		===
와		wa		wah
왜		wae		weh
워		wo		wuh
웨		we		way
의		ui		uee
```


- - -

# Possible Applications

The underlying romanization standard is a simple engine that takes in Hangul and returns Romainzed text.

This engine can be plugged into a variety of contexts:

### Music
K-Pop is steadily growing in popularity abroad. Moreover, due to streaming services, musicians are disproportionately dependent on overseas sales for sales revenue (e.g. Psy's "Gangnam Style" earned over $10M in the US, but less than $100,000 in the Korean market).

Many of these fans would like to sing along to their favorite K-pop songs but do not wish to invest the time in learning Hangul. An improved romanization system would make the lyrics more accessible, increasing sales volume.


### OCR for tourism and dining
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


# License
[GPL v2.0] (LICENSE)

