package cn.dovahkiin.util;

import cn.dovahkiin.security.RSACoder;

/**
 * Created by loongzhangtao on 2017/9/13.
 */
public class RSAUtil extends RSACoder {
    private static final String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCxCBJfg62AQCOyB+OIdmslIIyCJGP43Pf1hDq78X4Eg9RxFmAoU16xoqCOKdYNrezNojMgvDkCvhUQsOK1PnTZO69Pm5RWa45xFe5pagNbYKhWQZME0ZVW/aYoZcCKp/Y8YO+ax1s2Ot6pxsoJKR5mUPboColwLNpP9y76n8ho9QIDAQAB";
    private static final String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALEIEl+DrYBAI7IH44h2ayUgjIIkY/jc9/WEOrvxfgSD1HEWYChTXrGioI4p1g2t7M2iMyC8OQK+FRCw4rU+dNk7r0+blFZrjnEV7mlqA1tgqFZBkwTRlVb9pihlwIqn9jxg75rHWzY63qnGygkpHmZQ9ugKiXAs2k/3LvqfyGj1AgMBAAECgYEAoP3VL5VhICO0EoAIFJ6UO7RI80VCwRu6R0UT4LzxvAtjE+CkW6fNkr9xQTecmN4VXr/lvRxOwEa6g25JDUgaG7gUfetOQ0eiikb6EOGOx+TrU1NZEUmYE6lZPTSxufp9aciKJ2Nc1D7u2nvJfEqWK36oZJ/PHIQ4GcLaHuX/dHUCQQD3TLLSIAbjGrk1M1Ti7Asms61JCFFUz/bXscNDQN8gb+R6gzqCAwz/Pz8+nWi1ZpHu22Cp5gLe/NbwMA6rRVKDAkEAt0KBKPLErUkfFbrcmoHyylgAnXYEI4dbnWRrmpfm0mIEJiq+OKwOQkwcIC72jolSwP4qGA+Ck+YHe84AtKAdJwJAYIoghMbb6WxVQN95E9zxvXoG+6uzlFhbFHjgsTBx6kfD+c+g14A5YqteFSN97NLNxWD+q1SPal1pyvn3wASf4QJAMt9qXYSvJm+jCnQ6I0YpsRQm749AbOB5hULIQD0k3YhKIJJDBhZ1SuA3+pMu7LigWWT1KIK9u/LiZvLz7TB5hwJAS6SSAslKEXJvqMaaQElDCcibPt21UcVahnjWgg4Ec9uiJxzUFhaav9/SPK995kgDnql9w3Xov3PoxtwVLVSpBA==";

    public String encryptionPri(String source) {
        try {
            if (source != null)
                return RSACoder.encryptBASE64(RSACoder.encryptByPrivateKey(source.getBytes(), privateKey));
        } catch (Exception e) {
        }
        return source;
    }

    public String decryPri(String enPubStr) {
        try {
            return new String(decryptByPrivateKey(decryptBASE64(enPubStr), privateKey));
        } catch (Exception e) {
        }
        return "";
    }

    public String encryptionPub(String source) {
        try {
            if (source != null) return encryptBASE64(encryptByPublicKey(source.getBytes(), publicKey));

        } catch (Exception e) {
        }
        return source;
    }

    public String decryPub(String enPrivStr) {
        try {
            return new String(decryptByPublicKey(decryptBASE64(enPrivStr), publicKey));
        } catch (Exception e) {
        }
        return "";
    }
}
