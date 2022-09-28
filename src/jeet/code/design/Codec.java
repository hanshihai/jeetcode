package jeet.code.design;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;

public class Codec {

    private Charset charset = Charset.forName("UTF-8");

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (longUrl == null || longUrl.trim().length() <= 0) {
            return longUrl;
        }
        return URLEncoder.encode(longUrl, charset);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if (shortUrl == null || shortUrl.trim().length() <= 0) {
            return shortUrl;
        }
        return URLDecoder.decode(shortUrl, charset);
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        String shortUrl = codec.encode("https://leetcode.com/problems/encode-and-decode-tinyurl/");
        System.out.println("short: "+shortUrl);
        String longUrl = codec.decode(shortUrl);
        System.out.println("long: "+longUrl);
    }
}
