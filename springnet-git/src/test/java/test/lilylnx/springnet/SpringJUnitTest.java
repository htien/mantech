/**
 * Written by Tien Nguyen <lilylnx@users.sf.net>
 * FREE FOR ALL BUT DOES NOT MEAN THERE IS NO PRICE.
 */
package test.lilylnx.springnet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Tien Nguyen
 * @version $Id: SpringJUnitTest.java,v 1.0 2011/08/26 3:25:51 lilylnx Exp $
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test/test-context.xml")
public class SpringJUnitTest {

  @Test
  public void test() {
  }

}
