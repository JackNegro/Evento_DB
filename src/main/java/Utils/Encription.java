package Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Encription {

    public static String getSha256(String chain) {
        String encriptedChain = "";

        try {
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            sha256.update(chain.getBytes());
            byte[] keys = sha256.digest();
            encriptedChain = new String(Base64.getEncoder().encodeToString(keys));
        } catch (NoSuchAlgorithmException var4) {
            NoSuchAlgorithmException exception = var4;
            exception.printStackTrace();
        }

        return encriptedChain;
    }
}
