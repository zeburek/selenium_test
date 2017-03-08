/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selenium.test;

/**
 *
 * @author Root
 */
public class TestFailException extends Exception
{
      //Parameterless Constructor
      public TestFailException() {}

      //Constructor that accepts a message
      public TestFailException(String message)
      {
         super(message);
      }
 }
