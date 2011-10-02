/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.util.crypto;

import gnu.crypto.util.Util;

import net.lilylnx.jcafe.crypto.HashUtilsV1;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: HashCryptor.java,v 1.0 2011/10/02 22:41:05 lilylnx Exp $
 */
public final class HashCryptor {
  
  public static String hash(String plainText, int saltSize, String algor) throws Exception {
    byte[] hashedText = HashUtilsV1.hash(plainText, saltSize, algor);
    return Util.toString(hashedText);
  }
  
  public static boolean verify(String plainText, String hashedText, String algor) throws Exception {
    byte[] plainTextInBytes = plainText.getBytes();
    byte[] hashedTextInBytes = Util.toBytesFromString(hashedText);
    return HashUtilsV1.verifyhash(plainTextInBytes, hashedTextInBytes, algor);
  }

}
