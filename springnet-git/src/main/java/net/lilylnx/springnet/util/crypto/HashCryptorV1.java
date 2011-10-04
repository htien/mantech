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
 * @version $Id: HashCryptorV1.java,v 1.0 2011/10/02 22:53:28 lilylnx Exp $
 */
public final class HashCryptorV1 {
  
  public static String hash(String plainText, int saltSize, String algor) throws Exception {
    byte[] hashedTextInBytes = HashUtilsV1.hash(plainText, saltSize, algor);
    return Util.toBase64(Util.toBytesFromString(Util.toReversedString(hashedTextInBytes)));
  }
  
  public static boolean verify(String plainText, String hashedText, String algor) throws Exception {
    byte[] plainTextInBytes = plainText.getBytes();
    byte[] hashedTextInBytes = Util.toReversedBytesFromString(Util.toString(Util.fromBase64(hashedText)));
    return HashUtilsV1.verifyhash(plainTextInBytes, hashedTextInBytes, algor);
  }

}
