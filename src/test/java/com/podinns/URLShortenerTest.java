package com.podinns;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import org.apache.commons.validator.routines.UrlValidator;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import java.util.Random;
import sun.misc.BASE64Encoder;

public class URLShortenerTest {
	

	public static void main(String[] args) {
		String sLongUrl = "http://news.sohu.com/20170606/n495830517.shtml?fi&_f=index,cpc_0";
		System.out.println(shortUrl(sLongUrl));
	}

	
	public static String shortUrl (String longUrl) {

		if (longUrl != null && StringUtils.isNotBlank(longUrl)) {
			String url = StringUtils.trimToEmpty(longUrl);
			UrlValidator urlValidator = new UrlValidator(new String[] { "http", "https" });
			if (urlValidator.isValid(url)) {
				String salt = generateSalt();
				String surl = Hashing.murmur3_32().hashString(salt + url, Charsets.UTF_8).toString();
				return surl;
			}
		}
		return null;
	}
	private static String generateSalt() {

		byte[] salt = new byte[8];
	//	Random.nextBytes(salt);
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(salt);
		
	}

}
