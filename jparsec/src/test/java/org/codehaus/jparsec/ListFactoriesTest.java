package org.codehaus.jparsec;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

/**
 * Unit test for {@link ListFactories}.
 * 
 * @author Ben Yu
 */
public class ListFactoriesTest {

  @Test
  public void testArrayListFactory() {
    ListFactory<Integer> intListFactory = ListFactories.arrayListFactory();
    ListFactory<String> stringListFactory = ListFactories.arrayListFactory();
    ArrayList<Integer> intList = (ArrayList<Integer>) intListFactory.newList();
    ArrayList<String> stringList = (ArrayList<String>) stringListFactory.newList();
    assertNotSame(intList, stringList);
    assertEquals(0, intList.size());
    assertEquals(0, stringList.size());
  }

  @Test
  public void testArrayListFactoryWithFirstElement() {
    ListFactory<Integer> intListFactory = ListFactories.arrayListFactoryWithFirstElement(1);
    ArrayList<Integer> list = (ArrayList<Integer>) intListFactory.newList();
    assertEquals(Arrays.asList(1), list);
  }

}
