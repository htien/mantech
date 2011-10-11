/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package net.lilylnx.springnet.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.google.gson.Gson;

/**
 * 
 * @author Tien Nguyen
 * @version $Id: ClientUtils.java,v 1.0 Oct 6, 2011 5:59:35 PM lilylnx Exp $
 */
public class ClientUtils {

  @Autowired
  private SpringConfig config;
  
  @Autowired
  private Gson gson;

  public ResponseEntity<String> createJsonResponse(Object o) {
    HttpHeaders headers = new HttpHeaders();
    headers.set("Content-Type", String.format("application/json; charset=%s", config.getString(ConfigKeys.ENCODING)));
    String json = gson.toJson(o);
    return new ResponseEntity<String>(json, headers, HttpStatus.CREATED);
  }

}
