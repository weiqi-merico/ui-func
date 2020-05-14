package com.merico.selenium.test.ee.utils;

import java.security.Key;

import javax.crypto.Cipher;

/**
 * Encryption and Decryption helper class
 */
public class Crypt {
    /** The default string keys */
    private static String strDefaultKey = "meituanUIAutomation";
    /** Encryption tools */
    private Cipher encryptCipher = null;
    /** Decryption tool */
    private Cipher decryptCipher = null;
    
	/**
	 * The default constructor, use the default key
	 */
    public Crypt() throws Exception {
        this(strDefaultKey);
    }
    
    /**
     * The constructor using specific key
     * @param strKey  specific key
     * @throws Exception
     */
    public Crypt(String strKey) throws Exception {
        // Security.addProvider(new com.sun.crypto.provider.SunJCE());
        Key key = getKey(strKey.getBytes());
        encryptCipher = Cipher.getInstance("DES");
        encryptCipher.init(Cipher.ENCRYPT_MODE, key);
        decryptCipher = Cipher.getInstance("DES");
        decryptCipher.init(Cipher.DECRYPT_MODE, key);
    }
    
    /**
     * Convert byte array into represented hexadecimal string
     * @param arrB  Need to transform the byte array
     * @return The converted string
     * @throws Exception This method does not handle any exceptions, all the exception is thrown
     */
    public static String byteArr2HexStr(byte[] arrB) throws Exception {
        int iLen = arrB.length;
        // Each byte with two characters to say, so the length of the string is twice the array length
        StringBuffer sb = new StringBuffer(iLen * 2);
        for (int i = 0; i < iLen; i++) {
            int intTmp = arrB[i];
            // Convert negative into a positive
            while (intTmp < 0) {
                intTmp = intTmp + 256;
            }
            // Less than the number of 0F need to fill in the previous 0
            if (intTmp < 16) {
                sb.append("0");
            }
            sb.append(Integer.toString(intTmp, 16));
        }
        return sb.toString();
    }
    
    /**
     * Convert represented hexadecimal string into byte array
     * @param strIn Need to transform the string
     * @return Converted byte array
     */
    public static byte[] hexStr2ByteArr(String strIn) throws Exception {
        byte[] arrB = strIn.getBytes();
        int iLen = arrB.length;
        // Two character represents a byte, so the length of the byte array is the string length divided by 2
        byte[] arrOut = new byte[iLen / 2];
        for (int i = 0; i < iLen; i = i + 2) {
            String strTmp = new String(arrB, i, 2);
            arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
        }
        return arrOut;
    }
    
    /**
     * To encrypt a byte array
     * @param arrB  Need to encrypt a byte array
     * @return The encrypted byte array
     */
    public byte[] encrypt(byte[] arrB) throws Exception {
        return encryptCipher.doFinal(arrB);
    }
    
    /**
     * Encrypted string
     * @param strIn  Need to be encrypted string
     * @return The encrypted string
     */
    public String encrypt(String strIn) throws Exception {
        return byteArr2HexStr(encrypt(strIn.getBytes()));
    }
    
    /**
     * Decrypt the byte array
     * @param arrB  Need to decrypt the byte array
     * @return Decrypted byte array
     */
    public byte[] decrypt(byte[] arrB) throws Exception {
        return decryptCipher.doFinal(arrB);
    }
    
    /**
     * Decrypt the string
     * @param strIn  Need to decrypt the string
     * @return Decrypted string
     */
    public String decrypt(String strIn) throws Exception {
        return new String(decrypt(hexStr2ByteArr(strIn)));
    }
    
    /**
     * Keys which generated from the specified string is needed for 8-bit byte array length
     * Less than eight back fill 0
     * More than eight only take before eight
     * @param arrBTmp  A byte array include string
     * @return Generated key
     */
    private Key getKey(byte[] arrBTmp) throws Exception {
        // Create an empty 8-bit byte array (the default value is 0)
        byte[] arrB = new byte[8];
        // Convert raw byte array into 8 bits
        for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
            arrB[i] = arrBTmp[i];
        }
        // Generate the key
        Key key = new javax.crypto.spec.SecretKeySpec(arrB, "DES");
        return key;
    }
}
