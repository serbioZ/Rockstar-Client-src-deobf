// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.util;

import org.apache.logging.log4j.LogManager;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.security.PrivateKey;
import java.security.MessageDigest;
import java.security.KeyPairGenerator;
import java.security.KeyPair;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.UnsupportedEncodingException;
import javax.crypto.SecretKey;
import java.security.PublicKey;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import javax.crypto.Cipher;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.security.Key;
import org.apache.logging.log4j.Logger;

public class CryptManager
{
    private static final /* synthetic */ Logger LOGGER;
    
    private static byte[] cipherOperation(final int lllllllllllIIIIlllIllIIIIllIlIll, final Key lllllllllllIIIIlllIllIIIIllIlIlI, final byte[] lllllllllllIIIIlllIllIIIIllIlIIl) {
        try {
            return createTheCipherInstance(lllllllllllIIIIlllIllIIIIllIlIll, lllllllllllIIIIlllIllIIIIllIlIlI.getAlgorithm(), lllllllllllIIIIlllIllIIIIllIlIlI).doFinal(lllllllllllIIIIlllIllIIIIllIlIIl);
        }
        catch (IllegalBlockSizeException lllllllllllIIIIlllIllIIIIllIllIl) {
            lllllllllllIIIIlllIllIIIIllIllIl.printStackTrace();
        }
        catch (BadPaddingException lllllllllllIIIIlllIllIIIIllIllII) {
            lllllllllllIIIIlllIllIIIIllIllII.printStackTrace();
        }
        CryptManager.LOGGER.error("Cipher data failed!");
        return null;
    }
    
    public static byte[] encryptData(final Key lllllllllllIIIIlllIllIIIIllllllI, final byte[] lllllllllllIIIIlllIllIIIIllllIll) {
        return cipherOperation(1, lllllllllllIIIIlllIllIIIIllllllI, lllllllllllIIIIlllIllIIIIllllIll);
    }
    
    private static Cipher createTheCipherInstance(final int lllllllllllIIIIlllIllIIIIlIlllII, final String lllllllllllIIIIlllIllIIIIlIllIll, final Key lllllllllllIIIIlllIllIIIIllIIIIl) {
        try {
            final Cipher lllllllllllIIIIlllIllIIIIllIIIII = Cipher.getInstance(lllllllllllIIIIlllIllIIIIlIllIll);
            lllllllllllIIIIlllIllIIIIllIIIII.init(lllllllllllIIIIlllIllIIIIlIlllII, lllllllllllIIIIlllIllIIIIllIIIIl);
            return lllllllllllIIIIlllIllIIIIllIIIII;
        }
        catch (InvalidKeyException lllllllllllIIIIlllIllIIIIlIlllll) {
            lllllllllllIIIIlllIllIIIIlIlllll.printStackTrace();
        }
        catch (NoSuchAlgorithmException lllllllllllIIIIlllIllIIIIlIllllI) {
            lllllllllllIIIIlllIllIIIIlIllllI.printStackTrace();
        }
        catch (NoSuchPaddingException lllllllllllIIIIlllIllIIIIlIlllIl) {
            lllllllllllIIIIlllIllIIIIlIlllIl.printStackTrace();
        }
        CryptManager.LOGGER.error("Cipher creation failed!");
        return null;
    }
    
    public static byte[] getServerIdHash(final String lllllllllllIIIIlllIllIIIlIlIIllI, final PublicKey lllllllllllIIIIlllIllIIIlIlIIlIl, final SecretKey lllllllllllIIIIlllIllIIIlIlIIlII) {
        try {
            return digestOperation("SHA-1", new byte[][] { lllllllllllIIIIlllIllIIIlIlIIllI.getBytes("ISO_8859_1"), lllllllllllIIIIlllIllIIIlIlIIlII.getEncoded(), lllllllllllIIIIlllIllIIIlIlIIlIl.getEncoded() });
        }
        catch (UnsupportedEncodingException lllllllllllIIIIlllIllIIIlIlIIlll) {
            lllllllllllIIIIlllIllIIIlIlIIlll.printStackTrace();
            return null;
        }
    }
    
    public static Cipher createNetCipherInstance(final int lllllllllllIIIIlllIllIIIIlIlIIIl, final Key lllllllllllIIIIlllIllIIIIlIlIIII) {
        try {
            final Cipher lllllllllllIIIIlllIllIIIIlIlIIll = Cipher.getInstance("AES/CFB8/NoPadding");
            lllllllllllIIIIlllIllIIIIlIlIIll.init(lllllllllllIIIIlllIllIIIIlIlIIIl, lllllllllllIIIIlllIllIIIIlIlIIII, new IvParameterSpec(lllllllllllIIIIlllIllIIIIlIlIIII.getEncoded()));
            return lllllllllllIIIIlllIllIIIIlIlIIll;
        }
        catch (GeneralSecurityException lllllllllllIIIIlllIllIIIIlIlIIlI) {
            throw new RuntimeException(lllllllllllIIIIlllIllIIIIlIlIIlI);
        }
    }
    
    public static KeyPair generateKeyPair() {
        try {
            final KeyPairGenerator lllllllllllIIIIlllIllIIIlIllIIIl = KeyPairGenerator.getInstance("RSA");
            lllllllllllIIIIlllIllIIIlIllIIIl.initialize(1024);
            return lllllllllllIIIIlllIllIIIlIllIIIl.generateKeyPair();
        }
        catch (NoSuchAlgorithmException lllllllllllIIIIlllIllIIIlIllIIII) {
            lllllllllllIIIIlllIllIIIlIllIIII.printStackTrace();
            CryptManager.LOGGER.error("Key pair generation failed!");
            return null;
        }
    }
    
    private static byte[] digestOperation(final String lllllllllllIIIIlllIllIIIlIIlIllI, final byte[]... lllllllllllIIIIlllIllIIIlIIlIlIl) {
        try {
            final MessageDigest lllllllllllIIIIlllIllIIIlIIllIIl = MessageDigest.getInstance(lllllllllllIIIIlllIllIIIlIIlIllI);
            final String lllllllllllIIIIlllIllIIIlIIlIIII = (Object)lllllllllllIIIIlllIllIIIlIIlIlIl;
            for (byte lllllllllllIIIIlllIllIIIlIIlIIIl = (byte)lllllllllllIIIIlllIllIIIlIIlIlIl.length, lllllllllllIIIIlllIllIIIlIIlIIlI = 0; lllllllllllIIIIlllIllIIIlIIlIIlI < lllllllllllIIIIlllIllIIIlIIlIIIl; ++lllllllllllIIIIlllIllIIIlIIlIIlI) {
                final byte[] lllllllllllIIIIlllIllIIIlIIllIII = lllllllllllIIIIlllIllIIIlIIlIIII[lllllllllllIIIIlllIllIIIlIIlIIlI];
                lllllllllllIIIIlllIllIIIlIIllIIl.update(lllllllllllIIIIlllIllIIIlIIllIII);
            }
            return lllllllllllIIIIlllIllIIIlIIllIIl.digest();
        }
        catch (NoSuchAlgorithmException lllllllllllIIIIlllIllIIIlIIlIlll) {
            lllllllllllIIIIlllIllIIIlIIlIlll.printStackTrace();
            return null;
        }
    }
    
    public static SecretKey decryptSharedKey(final PrivateKey lllllllllllIIIIlllIllIIIlIIIIIlI, final byte[] lllllllllllIIIIlllIllIIIlIIIIIll) {
        return new SecretKeySpec(decryptData(lllllllllllIIIIlllIllIIIlIIIIIlI, lllllllllllIIIIlllIllIIIlIIIIIll), "AES");
    }
    
    public static SecretKey createNewSharedKey() {
        try {
            final KeyGenerator lllllllllllIIIIlllIllIIIlIllIlIl = KeyGenerator.getInstance("AES");
            lllllllllllIIIIlllIllIIIlIllIlIl.init(128);
            return lllllllllllIIIIlllIllIIIlIllIlIl.generateKey();
        }
        catch (NoSuchAlgorithmException lllllllllllIIIIlllIllIIIlIllIlII) {
            throw new Error(lllllllllllIIIIlllIllIIIlIllIlII);
        }
    }
    
    public static byte[] decryptData(final Key lllllllllllIIIIlllIllIIIIlllIllI, final byte[] lllllllllllIIIIlllIllIIIIlllIlIl) {
        return cipherOperation(2, lllllllllllIIIIlllIllIIIIlllIllI, lllllllllllIIIIlllIllIIIIlllIlIl);
    }
    
    public static PublicKey decodePublicKey(final byte[] lllllllllllIIIIlllIllIIIlIIIllII) {
        try {
            final EncodedKeySpec lllllllllllIIIIlllIllIIIlIIIlIll = new X509EncodedKeySpec(lllllllllllIIIIlllIllIIIlIIIllII);
            final KeyFactory lllllllllllIIIIlllIllIIIlIIIlIlI = KeyFactory.getInstance("RSA");
            return lllllllllllIIIIlllIllIIIlIIIlIlI.generatePublic(lllllllllllIIIIlllIllIIIlIIIlIll);
        }
        catch (NoSuchAlgorithmException ex) {}
        catch (InvalidKeySpecException ex2) {}
        CryptManager.LOGGER.error("Public key reconstitute failed!");
        return null;
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
}
